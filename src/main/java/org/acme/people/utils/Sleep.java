package org.acme.people.utils;

import java.lang.Thread;

public class Sleep
{
    public static void pause(long t)
    {
        try
        {
            Thread.sleep(t);
        }
        catch (Exception e)
        {

        }
    }
}
