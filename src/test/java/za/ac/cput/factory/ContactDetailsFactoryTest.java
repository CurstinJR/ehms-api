package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactDetails;


import static org.junit.jupiter.api.Assertions.*;

/*
ContactDetailsFactoryTest.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 09 April 2022
 */

class ContactDetailsFactoryTest
{

    @Test
    public void addContactDetails(){
        ContactDetails contactdetails = ContactDetailsFactory.createContactDetails("0784568952");
        assertNotNull(contactdetails);
    }
}