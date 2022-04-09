package za.ac.cput.util;

import java.util.UUID;

public class Helper
{
    public static Long generateId()
    {
        return UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
    }
}