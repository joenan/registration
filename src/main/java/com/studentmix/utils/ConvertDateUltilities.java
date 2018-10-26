/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nandom Gusen
 */
public class ConvertDateUltilities {

    public static String getCurrentDateTime() {
        String finalDatetime = formatDDMMYYYYHHMMSS.get().format(new Date()).replace("-", "");// dateFormat.format(cal.getTime()).replace("-", "");
        finalDatetime = finalDatetime.replace(":", "");
        finalDatetime = finalDatetime.replace(" ", "");
        return finalDatetime;
    }

    public static String getCurrentDateTimeWithDash() {
        return formatDDMMYYYYHHMMSS.get().format(new Date());// dateFormat.format(cal.getTime()).replace("-", "");

    }

    public static String convertDateForm(Date sDate, int flag) {
        String dateReturn = "";

        try {
            if (flag >= 11) {
                dateReturn = String.valueOf(formatDDMMMYYYY.get().format(sDate));
            } else {
                if (flag > 0) {
                    dateReturn = String.valueOf(formatDDMMYYYY.get().format(sDate));
                } else {
                    dateReturn = String.valueOf(formatYYYYMMDD.get().format(sDate));
                }
            }
        } catch (RuntimeException ex) {
            return "000-00-00";
        }
        return dateReturn;
    }

    public static Date convertdbDate(Date passDate) {
        try {
            String dateReturn = formatYYYYMMDD.get().format(passDate);
            Date returnDate = formatYYYYMMDD.get().parse(dateReturn);
            return returnDate;
        } catch (ParseException ex) {

        }
        return passDate;
    }
    
     public static Date convertdbDateTwo(Date passDate) {
        try {
            String dateReturn = formatYYYYMMDD.get().format(passDate);
            Date returnDate = formatYYYYMMDD.get().parse(dateReturn);
            return returnDate;
        } catch (ParseException ex) {

        }
        return passDate;
    }

    public static Date convertdbDateIsomsg(Date passDate) throws ParseException {
        String dateReturn = formatDDMMYYYYHHMMSS.get().format(passDate);
        Date returnDate = formatDDMMYYYYHHMMSS.get().parse(dateReturn);
        return returnDate;
    }
    private static final ThreadLocal<SimpleDateFormat> formatYYYYMMDD = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);

            return df;
        }
    };

    private static final ThreadLocal<SimpleDateFormat> formatDDMMMYYYY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            df.setLenient(false);

            return df;
        }
    };
    private static final ThreadLocal<SimpleDateFormat> formatDDMMYYYY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);

            return df;
        }
    };

    private static final ThreadLocal<SimpleDateFormat> formatDDMMYYYYHHMMSS = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.setLenient(false);

            return df;
        }
    };

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static boolean isSucess(List<String> results) {

        Iterator<String> iterator = results.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
        return false;
    }

    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH)
                || (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public static int getYears(Date datepass) {
        Calendar a = getCalendar(datepass);

        return a.get(YEAR);

    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    public static int getYearsBetweenDates(Date first, Date second) {
        Calendar firstCal = GregorianCalendar.getInstance();
        Calendar secondCal = GregorianCalendar.getInstance();

        firstCal.setTime(first);
        secondCal.setTime(second);

        secondCal.add(Calendar.DAY_OF_YEAR, -firstCal.get(Calendar.DAY_OF_YEAR));

        return secondCal.get(Calendar.YEAR) - firstCal.get(Calendar.YEAR);

    }

    public static Date getDateFromString(String datepass) {
        try {
            Date date = formatYYYYMMDD.get().parse(datepass);
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(ConvertDateUltilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static  String convertDate(Date d, String newFormat)  {
        try{
        SimpleDateFormat sdf = new SimpleDateFormat(newFormat);
        return sdf.format(d);
        } catch (Exception ex) {
            Logger.getLogger(ConvertDateUltilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
