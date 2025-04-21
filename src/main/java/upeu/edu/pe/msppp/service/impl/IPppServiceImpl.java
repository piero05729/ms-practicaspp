package upeu.edu.pe.msppp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.msppp.domain.Ppp;
import upeu.edu.pe.msppp.repository.PppRepository;
import upeu.edu.pe.msppp.service.IPppService;

import java.util.List;
import java.util.Optional;

@Service // Marca esta clase como un servicio gestionado por Spring
public class IPppServiceImpl implements IPppService {

    @Autowired // Inyecta el repositorio de Ppp
    private PppRepository pppRepository;

    // Método para crear una nueva práctica profesional
    @Override
    public Ppp create(Ppp p) {
        // Verifica que la duración de la práctica esté entre 60 y 180 días
        long dias = java.time.temporal.ChronoUnit.DAYS.between(p.getFechaIn(), p.getFechaFin());
        if (dias < 60 || dias > 180) {
            throw new RuntimeException("La duración de la práctica debe ser entre 60 y 180 días.");
        }

        // Verifica si el estudiante ya tiene una práctica registrada en la misma empresa
        if (pppRepository.existsByEstudianteIdAndEmpresaId(p.getIdEstudi().longValue(), p.getEmpresa().getIdempresa())) {
            throw new RuntimeException("El estudiante ya tiene una práctica registrada en esta empresa.");
        }

        // Guarda la práctica si pasa las validaciones
        return pppRepository.save(p);
    }

    // Método para actualizar una práctica profesional
    @Override
    public Ppp update(Ppp p) {
        // Busca la práctica por su ID
        Optional<Ppp> actual = pppRepository.findById(p.getIdppp());
        // Verifica que no se pueda modificar una práctica que ya fue aprobada
        if (actual.isPresent() && "APROBADA".equalsIgnoreCase(actual.get().getEstado())) {
            throw new RuntimeException("No se puede modificar una práctica que ya fue aprobada.");
        }

        // Verifica si el estudiante tiene más de 2 rechazos y está intentando modificar una práctica rechazada
        long rechazos = pppRepository.countByEstudianteIdAndEstado(p.getIdEstudi().longValue(), "RECHAZADA");
        if (rechazos >= 2 && "RECHAZADA".equalsIgnoreCase(p.getEstado())) {
            throw new RuntimeException("No se permite modificar la práctica: excedió el límite de rechazos.");
        }

        // Guarda los cambios de la práctica
        return pppRepository.save(p);
    }

    // Método para eliminar una práctica profesional por su ID
    @Override
    public void delete(Long id) {
        pppRepository.deleteById(id);
    }

    // Método para obtener una práctica profesional por su ID
    @Override
    public Optional<Ppp> read(Long id) {
        return pppRepository.findById(id);
    }

    // Método para obtener todas las prácticas profesionales
    @Override
    public List<Ppp> readAll() {
        return pppRepository.findAll();
    }
}
