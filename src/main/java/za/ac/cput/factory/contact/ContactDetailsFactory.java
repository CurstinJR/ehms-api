package za.ac.cput.factory.contact;

/*
CustomerDetailsFactory.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 08 April 2022
 */

import za.ac.cput.entity.contact.ContactDetails;
import za.ac.cput.util.Helper;

public class ContactDetailsFactory {

    public static ContactDetails createContactDetails(String phone) {
        Long contactId = Helper.generateId();

        return new ContactDetails.Builder()
                .contactId(contactId)
                .phoneNumber(phone)
                .build();

    }

}
