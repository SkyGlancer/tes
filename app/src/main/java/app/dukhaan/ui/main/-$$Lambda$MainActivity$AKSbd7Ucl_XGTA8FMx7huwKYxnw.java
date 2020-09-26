/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 *  app.dukhaan.ui.main.MainActivity
 *  java.lang.Object
 */
package app.dukhaan.ui.main;

import android.widget.PopupWindow;
import android.widget.RadioGroup;
import app.dukhaan.ui.main.MainActivity;

public final class -$$Lambda$MainActivity$AKSbd7Ucl_XGTA8FMx7huwKYxnw
implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ PopupWindow f$1;

    public /* synthetic */ -$$Lambda$MainActivity$AKSbd7Ucl_XGTA8FMx7huwKYxnw(MainActivity mainActivity, PopupWindow popupWindow) {
        this.f$0 = mainActivity;
        this.f$1 = popupWindow;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int n) {
        this.f$0.lambda$showFilterDropDown$2$MainActivity(this.f$1, radioGroup, n);
    }
}

