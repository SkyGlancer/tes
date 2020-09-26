/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  java.lang.Object
 */
package app.dukhaan.ui.views.steps;

import android.view.View;
import app.dukhaan.ui.views.steps.StepInstructionCard;

public final class -$$Lambda$StepInstructionCard$ngfapG6LLarXJlHrJJOLlhbS4k0
implements View.OnClickListener {
    public final /* synthetic */ StepInstructionCard.StepInstructionCardListener f$0;

    public /* synthetic */ -$$Lambda$StepInstructionCard$ngfapG6LLarXJlHrJJOLlhbS4k0(StepInstructionCard.StepInstructionCardListener stepInstructionCardListener) {
        this.f$0 = stepInstructionCardListener;
    }

    public final void onClick(View view) {
        StepInstructionCard.lambda$setListener$1(this.f$0, view);
    }
}

