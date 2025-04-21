package upeu.edu.pe.msppp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upeu.edu.pe.msppp.domain.Tutor;
import upeu.edu.pe.msppp.repository.TutorRepository;
import upeu.edu.pe.msppp.service.ITutorService;

import java.util.List;
import java.util.Optional;

@Service // Marca esta clase como un servicio gestionado por Spring
public class ITutorServiceImpl implements ITutorService {

    @Autowired // Inyecta el repositorio de Tutor
    private TutorRepository tutorRepository;

    // Método para crear un nuevo tutor
    @Override
    public Tutor create(Tutor tutor) {
        return tutorRepository.save(tutor); // Guarda el tutor en la base de datos
    }

    // Método para actualizar un tutor existente
    @Override
    public Tutor update(Tutor tutor) {
        return tutorRepository.save(tutor); // Guarda los cambios del tutor en la base de datos
    }

    // Método para eliminar un tutor por su ID
    @Override
    public void delete(Long id) {
        tutorRepository.deleteById(id); // Elimina el tutor de la base de datos por su ID
    }

    // Método para obtener un tutor por su ID
    @Override
    public Optional<Tutor> read(Long id) {
        return tutorRepository.findById(id); // Retorna el tutor si existe, de lo contrario, un Optional vacío
    }

    // Método para obtener todos los tutores registrados
    @Override
    public List<Tutor> readAll() {
        return tutorRepository.findAll(); // Retorna una lista de todos los tutores registrados
    }
}
