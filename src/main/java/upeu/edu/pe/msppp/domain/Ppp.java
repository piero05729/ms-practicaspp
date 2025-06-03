package upeu.edu.pe.msppp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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

    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_estudi")
    private String nombreEstudi;

    @Column(name = "id_estudi")
    private Integer idEstudi;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @Column(name = "fecha_in")
    private LocalDate fechaIn;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "estado")
    private String estado;
}