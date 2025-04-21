package upeu.edu.pe.msppp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.msppp.domain.Ppp;

@Repository // Marca la interfaz como un repositorio de Spring
public interface PppRepository extends JpaRepository<Ppp, Long> {

    // Cuenta las prácticas de un estudiante que tienen un estado específico (por ejemplo, rechazadas)
    long countByEstudianteIdAndEstado(Long estudianteId, String estado);

    // Verifica si el estudiante ya tiene una práctica en la misma empresa
    boolean existsByEstudianteIdAndEmpresaId(Long estudianteId, Long empresaId);
}
