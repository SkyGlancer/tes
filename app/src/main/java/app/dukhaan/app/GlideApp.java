/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  app.dukhaan.app.GlideRequests
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.GlideBuilder
 *  java.io.File
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import app.dukhaan.app.GlideRequests;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import java.io.File;

public final class GlideApp {
    private GlideApp() {
    }

    public static Glide get(Context context) {
        return Glide.get((Context)context);
    }

    public static File getPhotoCacheDir(Context context) {
        return Glide.getPhotoCacheDir((Context)context);
    }

    public static File getPhotoCacheDir(Context context, String string2) {
        return Glide.getPhotoCacheDir((Context)context, (String)string2);
    }

    public static void init(Context context, GlideBuilder glideBuilder) {
        Glide.init((Context)context, (GlideBuilder)glideBuilder);
    }

    @Deprecated
    public static void init(Glide glide) {
        Glide.init((Glide)glide);
    }

    public static void tearDown() {
        Glide.tearDown();
    }

    public static GlideRequests with(Activity activity) {
        return (GlideRequests)Glide.with((Activity)activity);
    }

    @Deprecated
    public static GlideRequests with(Fragment fragment) {
        return (GlideRequests)Glide.with((Fragment)fragment);
    }

    public static GlideRequests with(Context context) {
        return (GlideRequests)Glide.with((Context)context);
    }

    public static GlideRequests with(View view) {
        return (GlideRequests)Glide.with((View)view);
    }

    public static GlideRequests with(androidx.fragment.app.Fragment fragment) {
        return (GlideRequests)Glide.with((androidx.fragment.app.Fragment)fragment);
    }

    public static GlideRequests with(FragmentActivity fragmentActivity) {
        return (GlideRequests)Glide.with((FragmentActivity)fragmentActivity);
    }
}

