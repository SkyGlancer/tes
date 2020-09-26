/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.main;

import app.dukhaan.ui.main.MainActivityViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class -$$Lambda$MainActivityViewModel$H5096Hvzo3Mma8dHG2OmZ2swDwc
implements OnCompleteListener {
    public final /* synthetic */ String f$0;

    public /* synthetic */ -$$Lambda$MainActivityViewModel$H5096Hvzo3Mma8dHG2OmZ2swDwc(String string2) {
        this.f$0 = string2;
    }

    public final void onComplete(Task task) {
        MainActivityViewModel.lambda$subscribeToFcmTopics$0(this.f$0, task);
    }
}

