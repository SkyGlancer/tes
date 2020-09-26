/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.format.DateUtils
 *  java.lang.Object
 *  java.lang.String
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package app.dukhaan.util;

import android.content.Context;
import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtils {
    public static String getTimestamp(Context context, Date date) {
        SimpleDateFormat simpleDateFormat;
        int n;
        if (date == null) {
            return "";
        }
        if (DateTimeUtils.isToday(date)) {
            simpleDateFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
            n = 2131951737;
        } else if (DateTimeUtils.isYesterday(date)) {
            simpleDateFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
            n = 2131951738;
        } else {
            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy, hh:mm a", Locale.ENGLISH);
            n = 2131951736;
        }
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        Object[] arrobject = new Object[]{simpleDateFormat.format(date)};
        return context.getString(n, arrobject);
    }

    public static boolean isToday(Date date) {
        return DateUtils.isToday((long)date.getTime());
    }

    public static boolean isYesterday(Date date) {
        return DateUtils.isToday((long)(86400000L + date.getTime()));
    }
}

