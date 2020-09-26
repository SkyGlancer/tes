/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  androidx.viewbinding.ViewBinding
 *  com.google.android.material.card.MaterialCardView
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.databinding;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;

public final class PopupOrdersSortBinding
implements ViewBinding {
    public final RadioButton Accepted;
    public final RadioButton All;
    public final RadioButton Cancelled;
    public final RadioButton Declined;
    public final RadioButton Delivered;
    public final RadioButton Pending;
    public final RadioButton Shipped;
    public final RadioGroup radioButton;
    private final MaterialCardView rootView;

    private PopupOrdersSortBinding(MaterialCardView materialCardView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioGroup radioGroup) {
        this.rootView = materialCardView;
        this.Accepted = radioButton;
        this.All = radioButton2;
        this.Cancelled = radioButton3;
        this.Declined = radioButton4;
        this.Delivered = radioButton5;
        this.Pending = radioButton6;
        this.Shipped = radioButton7;
        this.radioButton = radioGroup;
    }

    public static PopupOrdersSortBinding bind(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        RadioButton radioButton4;
        RadioGroup radioGroup;
        RadioButton radioButton5;
        RadioButton radioButton6;
        int n = 2131361793;
        RadioButton radioButton7 = (RadioButton)view.findViewById(n);
        if (radioButton7 != null && (radioButton6 = (RadioButton)view.findViewById(n = 2131361794)) != null && (radioButton = (RadioButton)view.findViewById(n = 2131361798)) != null && (radioButton5 = (RadioButton)view.findViewById(n = 2131361799)) != null && (radioButton4 = (RadioButton)view.findViewById(n = 2131361800)) != null && (radioButton3 = (RadioButton)view.findViewById(n = 2131361803)) != null && (radioButton2 = (RadioButton)view.findViewById(n = 2131361806)) != null && (radioGroup = (RadioGroup)view.findViewById(n = 2131362410)) != null) {
            PopupOrdersSortBinding popupOrdersSortBinding = new PopupOrdersSortBinding((MaterialCardView)view, radioButton7, radioButton6, radioButton, radioButton5, radioButton4, radioButton3, radioButton2, radioGroup);
            return popupOrdersSortBinding;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    public static PopupOrdersSortBinding inflate(LayoutInflater layoutInflater) {
        return PopupOrdersSortBinding.inflate(layoutInflater, null, false);
    }

    public static PopupOrdersSortBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl) {
        View view = layoutInflater.inflate(2131558603, viewGroup, false);
        if (bl) {
            viewGroup.addView(view);
        }
        return PopupOrdersSortBinding.bind(view);
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }
}

