/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.viewbinding.ViewBinding
 *  com.ramijemli.percentagechartview.PercentageChartView
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import app.dukhaan.ui.views.PrimaryButton;
import com.ramijemli.percentagechartview.PercentageChartView;

public final class ModalReferBinding
implements ViewBinding {
    public final PrimaryButton btnInvite;
    public final PercentageChartView referChart;
    public final TextView referDesc;
    public final TextView referTitle;
    private final LinearLayout rootView;

    private ModalReferBinding(LinearLayout linearLayout, PrimaryButton primaryButton, PercentageChartView percentageChartView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnInvite = primaryButton;
        this.referChart = percentageChartView;
        this.referDesc = textView;
        this.referTitle = textView2;
    }

    public static ModalReferBinding bind(View view) {
        TextView textView;
        TextView textView2;
        PercentageChartView percentageChartView;
        int n = 2131361920;
        PrimaryButton primaryButton = (PrimaryButton)view.findViewById(n);
        if (primaryButton != null && (percentageChartView = (PercentageChartView)view.findViewById(n = 2131362418)) != null && (textView = (TextView)view.findViewById(n = 2131362419)) != null && (textView2 = (TextView)view.findViewById(n = 2131362420)) != null) {
            ModalReferBinding modalReferBinding = new ModalReferBinding((LinearLayout)view, primaryButton, percentageChartView, textView, textView2);
            return modalReferBinding;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static ModalReferBinding inflate(LayoutInflater layoutInflater) {
        return ModalReferBinding.inflate(layoutInflater, null, false);
    }

    public static ModalReferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558553, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return ModalReferBinding.bind(view);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}

