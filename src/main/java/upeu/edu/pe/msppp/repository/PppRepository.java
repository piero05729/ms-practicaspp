package upeu.edu.pe.msppp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.msppp.domain.Ppp;

@Repository
public interface PppRepository extends JpaRepository<Ppp, Long> {
}