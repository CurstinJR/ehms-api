package za.ac.cput.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.payment.Bill;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.service.payment.impl.BillServiceImpl;

import java.util.List;

/**
 * @Author Curstin Rose - 220275408
 * BillController.java
 * 2022/10/01
 */
@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillServiceImpl billService;

    @Autowired
    public BillController(BillServiceImpl billService) {
        this.billService = billService;
    }

    /**
     * Handles the request to retrieve all bills and return an array of
     * patient objects.
     *
     * @return List of Bill objects
     */
    @GetMapping
    public ResponseEntity<List<Bill>> getBills() {
        List<Bill> bills = billService.findAll();
        return ResponseEntity.ok(bills);
    }

    /**
     * Handles the request to retrieve a specific Bill object by providing
     * an ID. Throws 404 NOT_FOUND, if Bill object is not in the repository.
     *
     * @param id Long
     * @return 200 and Bill object SUCCESS
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getBillById(@PathVariable final Long id) {
        String notFoundMessage = getNotFoundMessage(id);
        Bill patient = billService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(patient);
    }

    /**
     * Handles the request to create a new Bill object.
     *
     * @param patient Bill JSON payload
     * @return 201 and new Bill object
     */
    @PostMapping
    public ResponseEntity<Bill> addBill(@RequestBody final Bill patient) {
        Bill saveBill = billService.save(patient);
        return new ResponseEntity<>(saveBill, HttpStatus.CREATED);
    }

    /**
     * Handles the request to update a new Bill object.
     *
     * @param id      Long
     * @param patient Bill JSON payload
     * @return 200 and updated Bill object
     */
    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBillById(@PathVariable final Long id,
                                               @RequestBody final Bill patient) {
        String notFoundMessage = getNotFoundMessage(id);
        Bill updateBill = billService.update(id, patient)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(updateBill);
    }

    /**
     * Handles the request to delete a Bill object from the repository.
     * Throws 404 NOT_FOUND, if Bill object is not in the repository.
     *
     * @param id Long
     * @return 204 No content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBillById(@PathVariable final Long id) {
        if (!billService.existsById(id)) {
            String notFoundMessage = getNotFoundMessage(id);
            throw new ResourceNotFoundException(notFoundMessage);
        }
        billService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * @param id Long
     * @return Resource not found error message
     */
    private String getNotFoundMessage(final Long id) {
        final String messageNotFound = "Bill with id: %s not found";
        return String.format(messageNotFound, id);
    }
}
