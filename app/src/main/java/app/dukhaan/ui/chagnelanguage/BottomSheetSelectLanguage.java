/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.databinding.DataBindingUtil
 *  com.google.android.material.bottomsheet.BottomSheetDialogFragment
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.ui.chagnelanguage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import app.dukhaan.databinding.BottomSheetSelectLanguageBinding;
import app.dukhaan.ui.chagnelanguage.-$$Lambda$BottomSheetSelectLanguage$0QV18ABOel-r1eHYVUXGvObURSE;
import app.dukhaan.ui.chagnelanguage.-$$Lambda$BottomSheetSelectLanguage$DjohEMbAdk5FwkOVFUTyVId0vYQ;
import app.dukhaan.ui.chagnelanguage.-$$Lambda$BottomSheetSelectLanguage$qrLIL3EQxrEBSn45SxjtH5zBrtQ;
import app.dukhaan.ui.onboarding.OnBoardingActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetSelectLanguage
extends BottomSheetDialogFragment {
    private BottomSheetSelectLanguageBinding binding;
    private OnLanguageSelectListener onLanguageSelectListener;

    public /* synthetic */ void lambda$onCreateView$0$BottomSheetSelectLanguage(View view) { (view) -> {
        this.onLanguageSelectListener.onLanguageSelected("en");
        this.dismiss();
    }

    public /* synthetic */ void lambda$onCreateView$1$BottomSheetSelectLanguage(View view) { (view) -> {
        this.onLanguageSelectListener.onLanguageSelected("hi");
        this.dismiss();
    }

    public /* synthetic */ void lambda$onCreateView$2$BottomSheetSelectLanguage(View view) { (view) -> {
        this.onLanguageSelectListener.onLanguageSelected("mr");
        this.dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setStyle(0, 2132017389);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BottomSheetSelectLanguageBinding bottomSheetSelectLanguageBinding;
        this.binding = bottomSheetSelectLanguageBinding = (BottomSheetSelectLanguageBinding)DataBindingUtil.inflate((LayoutInflater)layoutInflater, (int)2131558457, (ViewGroup)viewGroup, (boolean)false);
        bottomSheetSelectLanguageBinding.idBtnEnglish.setOnClickListener((View.OnClickListener)new -$$Lambda$BottomSheetSelectLanguage$DjohEMbAdk5FwkOVFUTyVId0vYQ(this));
        this.binding.idBtnHindi.setOnClickListener((View.OnClickListener)new -$$Lambda$BottomSheetSelectLanguage$0QV18ABOel-r1eHYVUXGvObURSE(this));
        this.binding.idBtnMarathi.setOnClickListener((View.OnClickListener)new -$$Lambda$BottomSheetSelectLanguage$qrLIL3EQxrEBSn45SxjtH5zBrtQ(this));
        return this.binding.getRoot();
    }

    public void setListener(OnBoardingActivity onBoardingActivity) {
        this.onLanguageSelectListener = onBoardingActivity;
    }

}

