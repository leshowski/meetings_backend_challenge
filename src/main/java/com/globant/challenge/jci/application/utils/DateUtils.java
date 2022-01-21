package com.globant.challenge.jci.application.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

  static final long ONE_MINUTE_IN_MILLIS = 60000;

  public static Date addMinutesToDate(int minutes, Date beforeTime) {

    long curTimeInMs = beforeTime.getTime();
    Date afterAddingMins = new Date(curTimeInMs
        + (minutes * ONE_MINUTE_IN_MILLIS));
    return afterAddingMins;
  }

  public static Date todayAtMidnight(){
    Calendar c = new GregorianCalendar();
    c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    return c.getTime();
  }

}
