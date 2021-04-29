package com.elize.travel.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    private static final String PT = "pt";
    private static final String BR = "br";
    private static final String BRAZILIAN_CURRENCY_TEXT = "R$";
    private static final String BRAZILIAN_CURRENCY_TEXT_FORMATTED = "R$";

    public static String formatToBrazilianCurrency(BigDecimal value) {
        NumberFormat brazilianFormat =
                DecimalFormat.getCurrencyInstance(new Locale(PT, BR));
        return brazilianFormat.format(value)
                .replace(BRAZILIAN_CURRENCY_TEXT, BRAZILIAN_CURRENCY_TEXT_FORMATTED);
    }
}
