/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.navigation.NavController
 *  androidx.navigation.NavController$OnDestinationChangedListener
 *  androidx.navigation.NavDestination
 *  java.lang.Object
 */
package app.dukhaan.ui.main;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import app.dukhaan.ui.main.MainActivity;

public final class -$$Lambda$MainActivity$8YMg7eQo_y4GUN9lTujYjcyNH0w
implements NavController.OnDestinationChangedListener {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ -$$Lambda$MainActivity$8YMg7eQo_y4GUN9lTujYjcyNH0w(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        this.f$0.lambda$initBottomNavigation$1$MainActivity(navController, navDestination, bundle);
    }
}

