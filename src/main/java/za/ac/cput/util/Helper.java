package za.ac.cput.util;

import org.apache.commons.validator.EmailValidator;

public class Helper {

    public static boolean isNullorEmpty(String k) {
        return (k == null || k.equals("") || k.isEmpty() || k.equalsIgnoreCase("null"));

    }
        public static boolean isValidEmail(String email) {
            EmailValidator ev = EmailValidator.getInstance();
            return ev.isValid(email);
        }

}
