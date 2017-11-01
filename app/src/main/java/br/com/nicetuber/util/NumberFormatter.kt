package br.com.nicetuber.util

/**
 * Created by thiagozg on 25/10/2017.
 */

object NumberFormatter {

    fun formatThousand(number: String?): String {
        return if (number != null && !number.isEmpty())
            String.format("%,d", Integer.valueOf(number))
                    .replace(",", ".")
        else "0"
    }

}
