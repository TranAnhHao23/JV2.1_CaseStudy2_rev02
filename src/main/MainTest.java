package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainTest {
    public static void main(String[] args) {
        Date today = Calendar.getInstance().getTime();

        String strToday = convertDateToString(today);
        String dayTest = "3/1/2022";
        Date date1 = convertStringToDate("03/01/2022");
        Date date2 = convertStringToDate(dayTest);
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date1.compareTo(date2));
    }

    public static String convertDateToString(Date date) {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String dateString = df.format(date);
        return dateString;
    }

    public static Date convertStringToDate(String dateString) {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
