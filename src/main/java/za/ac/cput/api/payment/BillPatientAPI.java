package za.ac.cput.api.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.entity.payment.Bill;
import za.ac.cput.entity.user.Patient;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.service.payment.impl.BillServiceImpl;
import za.ac.cput.service.user.impl.PatientServiceImpl;

/**
 * @Author Curstin Rose - 220275408
 * BillPatientAPI.java
 */
@Component
public class BillPatientAPI {

    private final PatientServiceImpl patientService;
    private final BillServiceImpl billService;

    @Autowired
    public BillPatientAPI(PatientServiceImpl patientService, BillServiceImpl billService) {
        this.patientService = patientService;
        this.billService = billService;
    }

    public Bill saveBillWithPatient(Bill bill) {
        Patient patient = patientService.findById(bill.getPatient().getId()).orElseThrow(
                () -> new ResourceNotFoundException(getNotFoundMessage(bill.getPatient().getId())));
        bill.setPatient(patient);
        return billService.save(bill);
    }

    private String getNotFoundMessage(final Long id) {
        final String messageNotFound = "Patient with id: %s not found";
        return String.format(messageNotFound, id);
    }
}
