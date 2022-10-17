package za.ac.cput.controller.medical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.medical.Vitals;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.service.medical.Impl.VitalsServiceImpl;

import java.util.List;

/*
VitalsController.java
Author: Tarren-Marc Adams - 214041794
Date: 6/10/2022
 */

@RestController
@RequestMapping("/api/vitals")
public class VitalsController {
    private final VitalsServiceImpl vitalsService;

    @Autowired
    public VitalsController(VitalsServiceImpl vitalsService){this.vitalsService=vitalsService;}

    @GetMapping
    public ResponseEntity<List<Vitals>> getVitals() {
        List<Vitals> vitals = vitalsService.findAll();
        return ResponseEntity.ok(vitals);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getVitalsById(@PathVariable final Long id) {
        String notFoundMessage = getNotFoundMessage(id);
        Vitals vitals = vitalsService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(vitals);
    }
    @PostMapping
    public ResponseEntity<Vitals> addVitals(@RequestBody final Vitals vitals) {
        Vitals saveVitals = vitalsService.save(vitals);
        return new ResponseEntity<>(saveVitals, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Vitals> updateVitalsById(@PathVariable final Long id,
                                                             @RequestBody final Vitals patient) {
        String notFoundMessage = getNotFoundMessage(id);
        Vitals updateVitals = vitalsService.update(id, patient)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(updateVitals);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVitalsById(@PathVariable final Long id) {
        if (!vitalsService.existsById(id)) {
            String notFoundMessage = getNotFoundMessage(id);
            throw new ResourceNotFoundException(notFoundMessage);
        }
        vitalsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private String getNotFoundMessage(final Long id) {
        final String messageNotFound = "Vitals with id: %s not found";
        return String.format(messageNotFound, id);
    }
}
