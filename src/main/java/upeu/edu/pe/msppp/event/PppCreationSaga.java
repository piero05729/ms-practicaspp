package upeu.edu.pe.msppp.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import upeu.edu.pe.msppp.service.IPppService;

@Component
public class PppCreationSaga {

    @Autowired
    private IPppService pppService;

    @EventListener
    public void handlePppCreated(PppCreatedEvent event) {
        try {
            if (event.getEstudianteId() == null || event.getEstudianteId() <= 0) {
                throw new IllegalArgumentException("Estudiante inválido");
            }

            if (event.getTutorId() == null || event.getTutorId() <= 0) {
                throw new IllegalArgumentException("Tutor inválido");
            }

            System.out.println("Saga completada correctamente.");

        } catch (Exception e) {
            System.out.println("Error en saga: " + e.getMessage());
            pppService.delete(event.getPppId());
            System.out.println("Compensación: PPP eliminada.");
        }
    }
}
