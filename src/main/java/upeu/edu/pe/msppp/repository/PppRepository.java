package upeu.edu.pe.msppp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.msppp.domain.Ppp;

import java.util.List;

@Repository
public interface PppRepository extends JpaRepository<Ppp, Long> {
    // Método para verificar si existe una práctica registrada para un estudiante
    boolean existsByIdEstudi(Long idEstudi);
    long countByIdEstudiAndEstado(Integer idEstudi, String estado);
    List<Ppp> findByIdEstudi(Integer idEstudi);


}
