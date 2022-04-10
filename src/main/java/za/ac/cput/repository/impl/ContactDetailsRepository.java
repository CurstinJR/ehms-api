package za.ac.cput.repository.impl;

import za.ac.cput.entity.ContactDetails;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


/*
ContactDetailsRepository.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 09 April 2022
 */
public class ContactDetailsRepository implements IContactDetailsRepository

{
    private static ContactDetailsRepository contactdetailsRepository = null;


    private Collection<ContactDetails> contactdetailsDB = null;

    private ContactDetailsRepository()
    {
        contactdetailsDB = new ArrayList<>();
    }

    public static final ContactDetailsRepository getContactdetailsRepository()
    {
        return  contactdetailsRepository == null ?
                contactdetailsRepository = new ContactDetailsRepository() :
                contactdetailsRepository;
    }

    @Override
    public ContactDetails save(ContactDetails contactdetails)
    {
        contactdetailsDB.add(contactdetails);
        return contactdetails;
    }

    @Override
    public Optional<ContactDetails> findById(Long contactId)
    {
        ContactDetails contactDetails = contactdetailsDB.stream()
                .filter(p -> p.getContactId().equals(contactId))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(contactDetails);
    }

    @Override
    public Collection<ContactDetails> findAll()
    {
        return contactdetailsDB;
    }



    @Override
    public ContactDetails update(ContactDetails contactdetails)
    {
        Long contactId = contactdetails.getContactId();
        ContactDetails oldContactDetails = findById(contactId).orElseThrow();
        contactdetailsDB.remove(oldContactDetails);
        contactdetailsDB.add(contactdetails);

        return contactdetails;
    }

    @Override
    public boolean deleteById(Long contactId)
    {
        ContactDetails contactdetails = contactdetailsRepository.findById(contactId).orElseThrow();
        return contactdetailsDB.remove(contactdetails);
    }

    @Override
    public boolean existsById(Long contactId)
    {
        return contactdetailsDB.stream()
                .anyMatch(contactdetails -> contactdetails.getContactId().equals(contactId));
    }
}
