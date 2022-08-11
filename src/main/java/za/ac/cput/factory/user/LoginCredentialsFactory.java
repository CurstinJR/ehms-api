package za.ac.cput.factory.user;

/*
LoginCredentialsFactory.java
Author:Kevin Lionel Mombo Ndinga(218180500)
Date: 09 April 2022
*/

import za.ac.cput.entity.user.LoginCredentials;
import za.ac.cput.util.Helper;

public class LoginCredentialsFactory {

    public static LoginCredentials createLogin(long id, String email, String password) {
        if (Helper.isNull(id))
            return null;
        if (!Helper.isValidEmail(email))
            return null;
        if (Helper.isNullorEmpty(password))
            return null;

        return new LoginCredentials.Builder().id(id)
                .email(email)
                .password(password)
                .build();
    }
}
