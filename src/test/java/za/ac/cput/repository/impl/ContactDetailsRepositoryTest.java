package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.ContactDetails;
import za.ac.cput.factory.ContactDetailsFactory;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/*
ContactDetailsRepositoryTest.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 09 April 2022
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactDetailsRepositoryTest
{
    private static ContactDetailsRepository contactDetailsRepository = ContactDetailsRepository.getContactdetailsRepository();
    private static ContactDetails contact = ContactDetailsFactory.createContactDetails("0784568952");

    @Test
    @Order(1)
    void getContactDetailsRepository()
    {
        ContactDetailsRepository contact = ContactDetailsRepository.getContactdetailsRepository();

        assertEquals(contact.hashCode(), contactDetailsRepository.hashCode());
    }

    @Test
    @Order(2)
    void save()
    {
        ContactDetails savedContactDetails = contactDetailsRepository.save(contact);
        Long patientId = savedContactDetails.getContactId();

        assertEquals(patientId, contact.getContactId());
    }

    @Test
    @Order(3)
    void findById()
    {
        ContactDetails appointment = contactDetailsRepository
                .findById(contact.getContactId())
                .orElseThrow();

        assertNotNull(appointment);
    }

    @Test
    @Order(4)
    void findAll()
    {
        Collection<ContactDetails> appointments = contactDetailsRepository.findAll();
        assertEquals(1, appointments.size());
    }

    @Test
    @Order(5)
    void update()
    {
        Long contactId = contact.getContactId();
        String phoneNumber  = contact.getPhoneNumber();

        contact.setPhoneNumber("0655689521");
        ContactDetails updateContactDetails = contactDetailsRepository.update(contact);

        assertEquals(contactId, updateContactDetails.getContactId());
        assertNotEquals(phoneNumber,updateContactDetails.getPhoneNumber());
        assertEquals(contact, updateContactDetails);
    }

    @Test
    @Order(6)
    void existsById()
    {
        boolean contactExists = contactDetailsRepository.existsById(contact.getContactId());

        assertTrue(contactExists);
    }

    @Test
    @Order(7)
    void deleteById()
    {
        contactDetailsRepository.deleteById(contact.getContactId());

        assertTrue(contactDetailsRepository.findAll().isEmpty());
    }
}

