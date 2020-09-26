/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextWatcher
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.ViewDataBinding
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.databinding.ActivityCreateCategoryBinding
 *  app.dukhaan.network.model.Category
 *  app.dukhaan.ui.createcategory.CreateCategoriesNavigator
 *  app.dukhaan.ui.createcategory.CreateCategoriesViewModel
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.ui.createcategory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.ActivityCreateCategoryBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.CreateCategoryResonse;
import app.dukhaan.ui.createcategory.-$$Lambda$CreateCategoryActivity$UzUJWQX_vMnQClcG507gs9MHzBo;
import app.dukhaan.ui.createcategory.CreateCategoriesNavigator;
import app.dukhaan.ui.createcategory.CreateCategoriesViewModel;
import app.dukhaan.ui.createcategory.CreateCategoryActivity;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.appbar.MaterialToolbar;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CreateCategoryActivity
extends BaseActivity<ActivityCreateCategoryBinding, CreateCategoriesViewModel>
implements CreateCategoriesNavigator {
    private ActivityCreateCategoryBinding binding;
    private Business business;
    private CreateCategoriesViewModel viewModel;

    static /* synthetic */ Business access$000(CreateCategoryActivity createCategoryActivity) {
        return createCategoryActivity.business;
    }

    @Override
    public int getLayoutId() {
        return 2131558435;
    }

    @Override
    public Class<CreateCategoriesViewModel> getViewModel() {
        return CreateCategoriesViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$CreateCategoryActivity(View view) {
        this.onBackPressed();
    }

    public void onApiError(ErrorResponse errorResponse) {
        this.binding.btnCreate.setBusy(false);
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
    }

    @Override
    protected void onCreate(Bundle bundle, CreateCategoriesViewModel createCategoriesViewModel, ActivityCreateCategoryBinding activityCreateCategoryBinding) {
        this.binding = activityCreateCategoryBinding;
        this.viewModel = createCategoriesViewModel;
        createCategoriesViewModel.setNavigator((Object)this);
        this.setSupportActionBar((Toolbar)activityCreateCategoryBinding.toolbar);
        this.enableToolbarUpNavigation();
        activityCreateCategoryBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$CreateCategoryActivity$UzUJWQX_vMnQClcG507gs9MHzBo(this));
        this.business = createCategoriesViewModel.getDataManager().getBusiness();
        activityCreateCategoryBinding.idEtCategoryName.addTextChangedListener(new TextWatcher(this, activityCreateCategoryBinding){
            final /* synthetic */ CreateCategoryActivity this$0;
            final /* synthetic */ ActivityCreateCategoryBinding val$binding;
            {
                this.this$0 = createCategoryActivity;
                this.val$binding = activityCreateCategoryBinding;
            }

            public void afterTextChanged(android.text.Editable editable) {
                if (editable.toString().trim().length() >= 1) {
                    this.val$binding.btnCreate.setEnabled(true);
                    return;
                }
                this.val$binding.btnCreate.setEnabled(false);
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        });
        activityCreateCategoryBinding.btnCreate.setOnClickListener(new View.OnClickListener(this, activityCreateCategoryBinding, createCategoriesViewModel){
            final /* synthetic */ CreateCategoryActivity this$0;
            final /* synthetic */ ActivityCreateCategoryBinding val$binding;
            final /* synthetic */ CreateCategoriesViewModel val$viewModel;
            {
                this.this$0 = createCategoryActivity;
                this.val$binding = activityCreateCategoryBinding;
                this.val$viewModel = createCategoriesViewModel;
            }

            public void onClick(View view) {
                String string2 = this.val$binding.idEtCategoryName.getText().toString().trim();
                this.val$binding.btnCreate.setBusy(true);
                app.dukhaan.network.model.CreateCategoryRequest createCategoryRequest = new app.dukhaan.network.model.CreateCategoryRequest();
                createCategoryRequest.setName(string2);
                createCategoryRequest.setBusinessId(CreateCategoryActivity.access$000(this.this$0).realmGet$id());
                this.val$viewModel.createCategory(createCategoryRequest);
            }
        });
    }

    public void onCreateCategorySuccess(CreateCategoryResonse createCategoryResonse) {
        if (createCategoryResonse.getCategory() != null) {
            this.viewModel.getDataManager().saveCategory(createCategoryResonse.getCategory());
        }
        this.binding.btnCreate.setBusy(false);
        Intent intent = new Intent();
        intent.putExtra("isCreated", true);
        this.setResult(-1, intent);
        this.finish();
    }
}

