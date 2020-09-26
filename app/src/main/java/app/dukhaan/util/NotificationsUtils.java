/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.content.res.Resources
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  app.dukhaan.app.MyApplication
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package app.dukhaan.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import app.dukhaan.app.MyApplication;
import app.dukhaan.util.-$$Lambda$NotificationsUtils$33SxeZr2t8hwpS22wdYvUl0MXBc;

public class NotificationsUtils {
    private static MediaPlayer mediaPlayer;

    private static AudioAttributes createAudioAttributes() {
        return new AudioAttributes.Builder().setUsage(4).setContentType(2).build();
    }

    public static void createClevertapNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            int n = context.getResources().getColor(2131099728);
            long[] arrl = new long[]{0L, 500L};
            String string2 = context.getString(2131951884);
            String string3 = context.getString(2131951886);
            String string4 = context.getString(2131951885);
            NotificationChannel notificationChannel = new NotificationChannel(string2, (CharSequence)string3, 4);
            notificationChannel.setDescription(string4);
            notificationChannel.setLightColor(n);
            notificationChannel.setVibrationPattern(arrl);
            notificationChannel.enableVibration(true);
            NotificationManager notificationManager = (NotificationManager)context.getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    public static void createOrdersNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            int n = context.getResources().getColor(2131099728);
            Uri uri = Uri.parse((String)"android.resource://com.dukaan.app/2131886081");
            long[] arrl = new long[]{0L, 500L};
            String string2 = context.getString(2131951888);
            String string3 = context.getString(2131951889);
            String string4 = context.getString(2131951887);
            NotificationChannel notificationChannel = new NotificationChannel(string2, (CharSequence)string3, 4);
            notificationChannel.setDescription(string4);
            notificationChannel.setSound(uri, NotificationsUtils.createAudioAttributes());
            notificationChannel.setLightColor(n);
            notificationChannel.setVibrationPattern(arrl);
            notificationChannel.enableVibration(true);
            NotificationManager notificationManager = (NotificationManager)context.getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    public static void init(Context context) {
        NotificationsUtils.createOrdersNotificationChannel(context);
        NotificationsUtils.createClevertapNotificationChannel(context);
    }

    static /* synthetic */ void lambda$playNewOrderSound$0() {
        MediaPlayer mediaPlayer = NotificationsUtils.mediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            NotificationsUtils.mediaPlayer.stop();
            NotificationsUtils.mediaPlayer = null;
        }
    }

    public static void playNewOrderSound() {
        -$$Lambda$NotificationsUtils$33SxeZr2t8hwpS22wdYvUl0MXBc -$$Lambda$NotificationsUtils$33SxeZr2t8hwpS22wdYvUl0MXBc = -$$Lambda$NotificationsUtils$33SxeZr2t8hwpS22wdYvUl0MXBc.INSTANCE;
        try {
            if (mediaPlayer == null) {
                MediaPlayer mediaPlayer;
                NotificationsUtils.mediaPlayer = mediaPlayer = MediaPlayer.create((Context)MyApplication.getInstance().getApplicationContext(), (int)2131886081);
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){

                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                    }
                });
            }
            new Handler().postDelayed((Runnable)-$$Lambda$NotificationsUtils$33SxeZr2t8hwpS22wdYvUl0MXBc, 2800L);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

}

