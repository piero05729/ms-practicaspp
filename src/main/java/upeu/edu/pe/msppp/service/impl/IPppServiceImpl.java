package upeu.edu.pe.msppp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.msppp.domain.Ppp;
import upeu.edu.pe.msppp.repository.PppRepository;
import upeu.edu.pe.msppp.service.IPppService;

import java.util.List;
import java.util.Optional;

@Service
public class IPppServiceImpl implements IPppService {

    @Autowired
    private PppRepository pppRepository;

    @Override
    public Ppp create(Ppp p) {
        // Verifica que la duración de la práctica esté entre 60 y 180 días.
        long dias = java.time.temporal.ChronoUnit.DAYS.between(p.getFechaIn(), p.getFechaFin());
        if (dias < 60 || dias > 180) {
            throw new RuntimeException("La duración de la práctica debe ser entre 60 y 180 días.");
        }

        // Validación de existencia de la práctica del estudiante (ya no depende de la empresa).
        if (pppRepository.existsByIdEstudi(Long.valueOf(p.getIdEstudi()))) {
            throw new RuntimeException("El estudiante ya tiene una práctica registrada.");
        }

        return pppRepository.save(p);
    }

    @Override
    public Ppp update(Ppp p) {
        Optional<Ppp> actual = pppRepository.findById(p.getIdppp());
        if (actual.isPresent() && "APROBADA".equalsIgnoreCase(actual.get().getEstado())) {
            throw new RuntimeException("No se puede modificar una práctica que ya fue aprobada.");
        }

        // Validación de rechazos (ya no depende de la empresa).
        long rechazos = pppRepository.countByIdEstudiAndEstado(p.getIdEstudi(), "RECHAZADA");
        if (rechazos >= 2 && "RECHAZADA".equalsIgnoreCase(p.getEstado())) {
            throw new RuntimeException("No se permite modificar la práctica: excedió el límite de rechazos.");
        }

        return pppRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        pppRepository.deleteById(id);
    }

    @Override
    public Optional<Ppp> read(Long id) {
        return pppRepository.findById(id);
    }

    @Override
    public List<Ppp> readAll() {
        return pppRepository.findAll();
    }
}
