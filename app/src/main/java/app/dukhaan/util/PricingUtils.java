/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.text.DecimalFormat
 *  java.util.Locale
 */
package app.dukhaan.util;

import java.text.DecimalFormat;
import java.util.Locale;

public class PricingUtils {
    public static String formatPrice(Double d) {
        try {
            String string2 = new DecimalFormat("#.##").format((Object)d);
            return string2;
        }
        catch (Exception exception) {
            return String.format((Locale)Locale.ENGLISH, (String)"%1$.2f", (Object[])new Object[]{d});
        }
    }

    public static String formatPriceWithCurrency(Double d) {
        try {
            String string2 = new DecimalFormat("\u20b9#.##").format((Object)d);
            return string2;
        }
        catch (Exception exception) {
            return String.format((Locale)Locale.ENGLISH, (String)"\u20b9%1$.2f", (Object[])new Object[]{d});
        }
    }
}

