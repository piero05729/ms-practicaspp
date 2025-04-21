package upeu.edu.pe.msppp.service;

import upeu.edu.pe.msppp.domain.Tutor;

import java.util.List;
import java.util.Optional;

public interface ITutorService {
    Tutor create(Tutor tutor);
    Tutor update(Tutor tutor);
    void delete(Long id);
    Optional<Tutor> read(Long id);
    List<Tutor> readAll();
}
