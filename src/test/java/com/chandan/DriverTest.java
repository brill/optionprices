package com.chandan;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DriverTest {

    @Test
    public void testGetDate()throws Exception{
        String date = "2020-06-19";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf1.parse(date);
        Date d2 = Driver.getDate(date);
        System.out.println(d);
        System.out.println(d2);
    }

    @Test
    public void testGetDateString() throws Exception{
      String dateString = "Fri Jun 26 00:00:00 PDT 2020";
      Date d = Calendar.getInstance().getTime();
      System.out.println(d);
      SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
      String strDate = formatter.format(d);
      System.out.println("Date Format with MM-dd-yyyy : "+strDate);

    }
}
