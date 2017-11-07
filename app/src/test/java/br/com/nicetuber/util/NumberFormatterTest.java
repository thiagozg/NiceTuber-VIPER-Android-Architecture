package br.com.nicetuber.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by thiagozg on 25/10/2017.
 */

public final class NumberFormatterTest {

    @Test
    public void testFormatThousand_shouldBeTrue() {
        assertEquals(NumberFormatter.INSTANCE.formatThousand("54321"), "54.321");
    }

    @Test
    public void testFormatThousand_shouldReturn0() {
        assertEquals(NumberFormatter.INSTANCE.formatThousand(null), "0");
    }

}
