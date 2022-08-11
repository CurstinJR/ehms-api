package za.ac.cput.util;

import org.apache.commons.validator.EmailValidator;

import java.util.UUID;

public class Helper {
    public static Long generateId() {
        return UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
    }

    public static boolean isNull(Long m) {
        return (m == null || m.equals(""));
    }

    public static boolean isNullorEmpty(String k) {
        return (k == null || k.equals("") || k.isEmpty() || k.equalsIgnoreCase("null"));
    }

    public static boolean isValidEmail(String email) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }
}
