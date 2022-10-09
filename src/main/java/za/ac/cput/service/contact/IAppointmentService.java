package za.ac.cput.service.contact;

import za.ac.cput.entity.contact.Appointment;
import za.ac.cput.service.IService;

public interface IAppointmentService extends IService<Appointment, Long> {
    boolean existsById(Long id);
}
