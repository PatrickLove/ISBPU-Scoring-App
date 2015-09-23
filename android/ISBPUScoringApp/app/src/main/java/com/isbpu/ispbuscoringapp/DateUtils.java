package com.isbpu.ispbuscoringapp;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Patrick Love on 9/23/2015.
 */
public class DateUtils {
    public static Date begin(Date d){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date end(Date d){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 1);
        return begin(c.getTime());
    }
}
