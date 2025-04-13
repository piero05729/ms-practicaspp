package upeu.edu.pe.msppp.domain;


import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "id_estudi")
    private Integer idEstudi;

    @Column(name = "nombre_estudi")
    private String nombreEstudi;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "tutor")
    private String tutor;

    @Column(name = "fecha_in")
    private LocalDate fechaIn;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "estado")
    private String estado;
=======
public class ppp {
>>>>>>> 0f47dfd13f5478dabb2ff879428148ce9b163243
}
