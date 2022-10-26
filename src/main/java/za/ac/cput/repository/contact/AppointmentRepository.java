package za.ac.cput.repository.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.contact.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
