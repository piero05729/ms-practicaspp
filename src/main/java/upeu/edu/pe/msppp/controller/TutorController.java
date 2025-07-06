package upeu.edu.pe.msppp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.msppp.domain.Tutor;
import upeu.edu.pe.msppp.service.ITutorService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutor")
@CrossOrigin(origins = "http://localhost:5173/")
public class TutorController {

    @Autowired
    private ITutorService tutorService;

    @GetMapping("/combo")
    public ResponseEntity<List<Map<String, String>>> listarParaCombo() {
        List<Map<String, String>> tutores = tutorService.readAll().stream()
                .map(t -> Map.of(
                        "value", t.getNombre(), // o t.getId().toString() si prefieres
                        "label", t.getNombre()
                ))
                .toList();

        return new ResponseEntity<>(tutores, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Tutor>> listarTutores() {
        return new ResponseEntity<>(tutorService.readAll(), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Tutor> guardar(@RequestBody Tutor tutor) {
        return new ResponseEntity<>(tutorService.create(tutor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscar(@PathVariable Long id) {
        Optional<Tutor> tutor = tutorService.read(id);
        return tutor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> actualizar(@PathVariable Long id, @RequestBody Tutor tutor) {
        Optional<Tutor> actual = tutorService.read(id);
        if (actual.isPresent()) {
            tutor.setIdtutor(id);
            return new ResponseEntity<>(tutorService.update(tutor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tutorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
