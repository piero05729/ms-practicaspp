package upeu.edu.pe.msppp.service;

import upeu.edu.pe.msppp.domain.Ppp;

import java.util.List;
import java.util.Optional;

public interface IPppService {

    // Método para crear una nueva práctica preprofesional
    Ppp create(Ppp p);

    // Método para actualizar una práctica preprofesional existente
    Ppp update(Ppp p);

    // Método para eliminar una práctica preprofesional por su ID
    void delete(Long id);

    // Método para obtener una práctica preprofesional por su ID
    Optional<Ppp> read(Long id);

    // Método para obtener todas las prácticas preprofesionales registradas
    List<Ppp> readAll();
}
