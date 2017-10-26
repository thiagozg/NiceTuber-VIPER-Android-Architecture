package br.com.nicetuber.util;

/**
 * Created by thiagozg on 25/10/2017.
 */

public final class NumberFormatter {

    public static String formatThousand(String number) {
        if (number != null && !number.isEmpty())
            return String.format("%,d", Integer.valueOf(number))
                            .replace(",", ".");
        else
            return "0";
    }

}
