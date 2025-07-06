package upeu.edu.pe.msppp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
// import java.util.List; // ❌ Ya no se necesita

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ppp")
public class Ppp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idppp")
    private Long idppp;

    @Column(name = "nombre_estudi", nullable = false)
    private String nombreEstudi;

    @Column(name = "id_estudi", nullable = false)
    private Integer idEstudi;


    // ✅ Reemplazo: solo se guarda el nombre del tutor
    @Column(name = "nombre_tutor", nullable = false)
    private String nombreTutor;

    @Column(name = "fecha_in", nullable = false)
    private LocalDate fechaIn;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "estado", nullable = false)
    private String estado;
}
