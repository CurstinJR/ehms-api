package za.ac.cput.util;
/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */
import java.util.UUID;

public class Helper {

    public static Long generateID()
    {
        return UUID.randomUUID().getMostSignificantBits();
    }
}
