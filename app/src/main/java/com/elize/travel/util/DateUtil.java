package com.elize.travel.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtil {

    private static final String DAY_AND_MONTH = "dd/MM";

    public static String formatDatePeriodToText(int days) {
        Calendar checkInDate = Calendar.getInstance();
        Calendar checkoutDate = Calendar.getInstance();
        checkoutDate.add(Calendar.DATE, days);
        SimpleDateFormat brazilianDateFormat = new SimpleDateFormat(DAY_AND_MONTH,
                Locale.getDefault());
        String checkinDateFormatted = brazilianDateFormat.format(checkInDate.getTime());
        String checkoutDateFormatted = brazilianDateFormat.format(checkoutDate.getTime());
        return checkinDateFormatted + " - "
                + checkoutDateFormatted + " from "
                + checkoutDate.get(Calendar.YEAR);
    }
}
