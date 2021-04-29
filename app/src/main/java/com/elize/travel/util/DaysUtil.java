package com.elize.travel.util;

public class DaysUtil {
    private static final String DAY = " day";
    private static final String DAYS = DAY + "s";

    public static String formatDaysToText(int daysQuantity) {
        if (daysQuantity > 1) {
            return daysQuantity + DAYS;
        } else {
            return daysQuantity + DAY;
        }
    }


}
