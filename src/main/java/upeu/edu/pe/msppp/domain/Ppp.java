package upeu.edu.pe.msppp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "ppp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ppp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
