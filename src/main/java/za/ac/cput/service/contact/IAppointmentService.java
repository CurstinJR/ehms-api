package za.ac.cput.service.contact;

import za.ac.cput.entity.contact.Appointment;
import za.ac.cput.service.IService;

/*
IAppointmentService.java
Author: Tarren-Marc Adams - 214041794
Date: 2/10/2022
 */

public interface IAppointmentService extends IService<Appointment, Long> {
    boolean existsById(Long id);
}
