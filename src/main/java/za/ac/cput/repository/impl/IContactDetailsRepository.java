package za.ac.cput.repository.impl;

import za.ac.cput.entity.ContactDetails;
import za.ac.cput.repository.IRepository;

/*
ICustomerDetailsRepository.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 09 April 2022
 */

public interface IContactDetailsRepository  extends  IRepository< ContactDetails,Long>

{

    ContactDetails update(ContactDetails contactdetails);

    boolean deleteById(Long contactId);
}
