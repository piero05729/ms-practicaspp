package upeu.edu.pe.msppp.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PppCreatedEvent {

    private Long pppId;
    private Integer estudianteId;
    private Long tutorId;
    private String estado;
}
