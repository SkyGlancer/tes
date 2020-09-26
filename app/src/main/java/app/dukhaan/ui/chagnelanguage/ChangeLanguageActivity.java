/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.ViewDataBinding
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.databinding.ActivityChangeLanguageBinding
 *  app.dukhaan.ui.account.AccountViewModel
 *  app.dukhaan.ui.chagnelanguage.-$
 *  app.dukhaan.ui.chagnelanguage.-$$Lambda
 *  app.dukhaan.ui.chagnelanguage.-$$Lambda$AAfvLlVQGI_vC3ONu_H8f1M_2oU
 *  app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package app.dukhaan.ui.chagnelanguage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.databinding.ActivityChangeLanguageBinding;
import app.dukhaan.ui.account.AccountViewModel;
import app.dukhaan.ui.chagnelanguage.-$;
import app.dukhaan.ui.chagnelanguage.-$$Lambda$ChangeLanguageActivity$LHFMbfnsgRuxfX0pJKL7PNgP7HY;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter;
import app.dukhaan.ui.views.PrimaryButton;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;

public class ChangeLanguageActivity
extends BaseActivity<ActivityChangeLanguageBinding, AccountViewModel>
implements ChangeLanguageAdapter.OnLanguageChangeListener {
    private ChangeLanguageAdapter adapter;
    private ActivityChangeLanguageBinding binding;
    private ArrayList<String> language = new ArrayList();
    private String selectedLanguage;

    static /* synthetic */ String access$000(ChangeLanguageActivity changeLanguageActivity) { (view) -> {
        return changeLanguageActivity.selectedLanguage;
    }

    @Override
    public int getLayoutId() {
        return 2131558434;
    }

    @Override
    public Class<AccountViewModel> getViewModel() {
        return AccountViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$ChangeLanguageActivity(View view) { (view) -> {
        this.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    protected void onCreate(Bundle bundle, AccountViewModel accountViewModel, ActivityChangeLanguageBinding activityChangeLanguageBinding) {
        this.binding = activityChangeLanguageBinding;
        this.setSupportActionBar((Toolbar)activityChangeLanguageBinding.toolbar);
        this.enableToolbarUpNavigation();
        activityChangeLanguageBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$ChangeLanguageActivity$LHFMbfnsgRuxfX0pJKL7PNgP7HY(this));
        this.language.add((Object)this.getResources().getString(2131951968));
        this.language.add((Object)this.getResources().getString(2131951970));
        this.language.add((Object)this.getResources().getString(2131951976));
        this.adapter = new ChangeLanguageAdapter((Context)this, this.language, (ChangeLanguageAdapter.OnLanguageChangeListener)new -$.Lambda.AAfvLlVQGI_vC3ONu_H8f1M_2oU(this));
        activityChangeLanguageBinding.recyclerview.setAdapter((RecyclerView.Adapter)this.adapter);
        if (AppPref.getInstance().getLocale().equals((Object)"en")) {
            this.selectedLanguage = this.getResources().getString(2131951968);
            this.adapter.checkedPosition = 0;
        } else if (AppPref.getInstance().getLocale().equals((Object)"hi")) {
            this.selectedLanguage = this.getResources().getString(2131951970);
            this.adapter.checkedPosition = 1;
        } else if (AppPref.getInstance().getLocale().equals((Object)"mr")) {
            this.selectedLanguage = this.getResources().getString(2131951968);
            this.adapter.checkedPosition = 2;
        }
        this.adapter.notifyDataSetChanged();
        activityChangeLanguageBinding.btnSave.setOnClickListener(new View.OnClickListener(this){
            final /* synthetic */ ChangeLanguageActivity this$0; (view) -> {
            {
                this.this$0 = changeLanguageActivity;
            }

            public void onClick(View view) {
                if (ChangeLanguageActivity.access$000(this.this$0).equals((Object)this.this$0.getResources().getString(2131951968))) {
                    AppPref.getInstance().setLocale("en");
                } else if (ChangeLanguageActivity.access$000(this.this$0).equals((Object)this.this$0.getResources().getString(2131951970))) {
                    AppPref.getInstance().setLocale("hi");
                } else {
                    AppPref.getInstance().setLocale("mr");
                }
                ChangeLanguageActivity changeLanguageActivity = this.this$0;
                changeLanguageActivity.updateBaseContextLocale((Context)changeLanguageActivity);
                this.this$0.startActivity(new android.content.Intent((Context)this.this$0, app.dukhaan.ui.splash.SplashActivity.class).addFlags(67141632));
            }
        });
    }

    @Override
    public void onLanguageChanged(String string2) {
        this.selectedLanguage = string2;
    }
}

