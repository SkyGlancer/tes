/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.base;

import app.dukhaan.base.BaseActivity;
import app.dukhaan.ui.views.networkcheck.NoNetworkFullscreenDialog;

public final class -$$Lambda$BaseActivity$azFD-SYPb-FCcQZAFyxASdWPv7w
implements NoNetworkFullscreenDialog.TryAgainClick {
    public static final /* synthetic */ -$$Lambda$BaseActivity$azFD-SYPb-FCcQZAFyxASdWPv7w INSTANCE;

    static /* synthetic */ {
        INSTANCE = new -$$Lambda$BaseActivity$azFD-SYPb-FCcQZAFyxASdWPv7w();
    }

    private /* synthetic */ -$$Lambda$BaseActivity$azFD-SYPb-FCcQZAFyxASdWPv7w() {
    }

    @Override
    public final void tryAgain() {
        BaseActivity.lambda$handleNoInternetConnection$1();
    }
}

