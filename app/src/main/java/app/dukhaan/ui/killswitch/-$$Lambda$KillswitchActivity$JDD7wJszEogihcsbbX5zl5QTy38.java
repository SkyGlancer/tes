/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnFailureListener
 *  java.lang.Exception
 *  java.lang.Object
 */
package app.dukhaan.ui.killswitch;

import app.dukhaan.ui.killswitch.KillswitchActivity;
import com.google.android.gms.tasks.OnFailureListener;

public final class -$$Lambda$KillswitchActivity$JDD7wJszEogihcsbbX5zl5QTy38
implements OnFailureListener {
    public static final /* synthetic */ -$$Lambda$KillswitchActivity$JDD7wJszEogihcsbbX5zl5QTy38 INSTANCE;

    static /* synthetic */ {
        INSTANCE = new -$$Lambda$KillswitchActivity$JDD7wJszEogihcsbbX5zl5QTy38();
    }

    private /* synthetic */ -$$Lambda$KillswitchActivity$JDD7wJszEogihcsbbX5zl5QTy38() {
    }

    public final void onFailure(Exception exception) {
        KillswitchActivity.lambda$checkForRemoteConfig$1(exception);
    }
}

