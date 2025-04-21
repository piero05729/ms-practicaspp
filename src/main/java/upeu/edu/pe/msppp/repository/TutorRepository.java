package upeu.edu.pe.msppp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.msppp.domain.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
