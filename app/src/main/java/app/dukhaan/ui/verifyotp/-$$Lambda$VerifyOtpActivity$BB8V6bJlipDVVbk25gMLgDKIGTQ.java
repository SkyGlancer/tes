/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  java.lang.Object
 */
package app.dukhaan.ui.verifyotp;

import app.dukhaan.ui.verifyotp.VerifyOtpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class -$$Lambda$VerifyOtpActivity$BB8V6bJlipDVVbk25gMLgDKIGTQ
implements OnCompleteListener {
    public final /* synthetic */ VerifyOtpActivity f$0;

    public /* synthetic */ -$$Lambda$VerifyOtpActivity$BB8V6bJlipDVVbk25gMLgDKIGTQ(VerifyOtpActivity verifyOtpActivity) {
        this.f$0 = verifyOtpActivity;
    }

    public final void onComplete(Task task) {
        this.f$0.lambda$signInWithPhoneAuthCredential$4$VerifyOtpActivity(task);
    }
}

