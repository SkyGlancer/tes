/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.clevertap.android.sdk.CleverTapAPI
 *  com.clevertap.android.sdk.NotificationInfo
 *  com.google.firebase.messaging.FirebaseMessagingService
 *  com.google.firebase.messaging.RemoteMessage
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.greenrobot.eventbus.EventBus
 */
package app.dukhaan.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import app.dukhaan.app.Constants;
import app.dukhaan.events.AppEvent;
import app.dukhaan.util.CleverTapUtils;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.NotificationInfo;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import timber.log.Timber;

public class FcmListenerService
extends FirebaseMessagingService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        try {
            if (remoteMessage.getData().size() > 0) {
                Bundle bundle = new Bundle();
                for (Map.Entry entry : remoteMessage.getData().entrySet()) {
                    bundle.putString((String)entry.getKey(), (String)entry.getValue());
                }
                if (CleverTapAPI.getNotificationInfo((Bundle)bundle).fromCleverTap) {
                    CleverTapAPI.createNotification((Context)this.getApplicationContext(), (Bundle)bundle);
                    CleverTapAPI.getDefaultInstance((Context)this).pushNotificationViewedEvent(bundle);
                    return;
                }
                String string2 = (String)remoteMessage.getData().get((Object)"type");
                if (!TextUtils.isEmpty((CharSequence)string2) && string2.equals((Object)Constants.PUSH_TYPE_NEW_ORDER)) {
                    AppEvent appEvent = new AppEvent(AppEvent.NEW_ORDER, null);
                    EventBus.getDefault().post((Object)appEvent);
                    AppEvent appEvent2 = new AppEvent(AppEvent.REFRESH_STATS, null);
                    EventBus.getDefault().post((Object)appEvent2);
                    AppEvent appEvent3 = new AppEvent(AppEvent.PLAY_NEW_ORDER_SOUND, null);
                    EventBus.getDefault().post((Object)appEvent3);
                    return;
                }
            }
        }
        catch (Throwable throwable) {
            Timber.e(throwable);
        }
    }

    public void onNewToken(String string2) {
        super.onNewToken(string2);
        Timber.e("onNewToken: %s", string2);
        CleverTapUtils.registerFcmToken(this.getApplicationContext());
    }
}

