/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.Toolbar
 *  androidx.databinding.ViewDataBinding
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.databinding.ActivityEditCategoryBinding
 *  app.dukhaan.ui.editcategory.EditCategoriesNavigator
 *  app.dukhaan.ui.editcategory.EditCategoriesViewModel
 *  com.google.android.material.appbar.MaterialToolbar
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.ThreadMode
 */
package app.dukhaan.ui.editcategory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.model.Business;
import app.dukhaan.databinding.ActivityEditCategoryBinding;
import app.dukhaan.events.AppEvent;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.CreateCategoryResonse;
import app.dukhaan.ui.editcategory.-$$Lambda$EditCategoryActivity$vQu-DbK6z8UOs6340dLjE3tuHOo;
import app.dukhaan.ui.editcategory.EditCategoriesNavigator;
import app.dukhaan.ui.editcategory.EditCategoriesViewModel;
import app.dukhaan.ui.editcategory.EditCategoryActivity;
import app.dukhaan.ui.views.PrimaryButton;
import app.dukhaan.util.ModalDialogs;
import com.google.android.material.appbar.MaterialToolbar;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EditCategoryActivity
extends BaseActivity<ActivityEditCategoryBinding, EditCategoriesViewModel>
implements EditCategoriesNavigator {
    static boolean active;
    private ActivityEditCategoryBinding binding;
    private Business business;
    private int categoryId;
    private String categoryName;
    private int position;
    private EditCategoriesViewModel viewModel;

    static /* synthetic */ String access$000(EditCategoryActivity editCategoryActivity) {
        return editCategoryActivity.categoryName;
    }

    static /* synthetic */ int access$100(EditCategoryActivity editCategoryActivity) {
        return editCategoryActivity.categoryId;
    }

    @Override
    public int getLayoutId() {
        return 2131558437;
    }

    @Override
    public Class<EditCategoriesViewModel> getViewModel() {
        return EditCategoriesViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$EditCategoryActivity(View view) {
        this.onBackPressed();
    }

    public void onApiError(ErrorResponse errorResponse) {
        this.binding.btnUpdate.setBusy(false);
        ModalDialogs.showUnknownError((Activity)this);
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onAppEvent(AppEvent appEvent) {
        if (appEvent.type == AppEvent.INTERNET_CONNECTION_CHECK && active) {
            this.binding.btnUpdate.setBusy(false);
        }
    }

    public void onCategoryUpdateResponse(CreateCategoryResonse createCategoryResonse) {
        this.binding.btnUpdate.setBusy(false);
        Intent intent = new Intent();
        intent.putExtra("isUpdated", true);
        intent.putExtra("updatedName", this.binding.idEtCategoryName.getText().toString());
        intent.putExtra("position", this.position);
        this.setResult(-1, intent);
        this.finish();
    }

    @Override
    protected void onCreate(Bundle bundle, EditCategoriesViewModel editCategoriesViewModel, ActivityEditCategoryBinding activityEditCategoryBinding) {
        this.binding = activityEditCategoryBinding;
        this.viewModel = editCategoriesViewModel;
        editCategoriesViewModel.setNavigator((Object)this);
        this.setSupportActionBar((Toolbar)activityEditCategoryBinding.toolbar);
        this.enableToolbarUpNavigation();
        this.categoryId = this.getIntent().getIntExtra("categoryId", 0);
        this.categoryName = this.getIntent().getStringExtra("name");
        this.position = this.getIntent().getIntExtra("position", 0);
        activityEditCategoryBinding.toolbar.setNavigationOnClickListener((View.OnClickListener)new -$$Lambda$EditCategoryActivity$vQu-DbK6z8UOs6340dLjE3tuHOo(this));
        activityEditCategoryBinding.idEtCategoryName.setText((CharSequence)this.categoryName);
        this.business = editCategoriesViewModel.getDataManager().getBusiness();
        activityEditCategoryBinding.idEtCategoryName.addTextChangedListener(new TextWatcher(this, activityEditCategoryBinding){
            final /* synthetic */ EditCategoryActivity this$0;
            final /* synthetic */ ActivityEditCategoryBinding val$binding;
            {
                this.this$0 = editCategoryActivity;
                this.val$binding = activityEditCategoryBinding;
            }

            public void afterTextChanged(Editable editable) {
                String string2 = editable.toString().trim();
                if (string2.length() > 1 && !EditCategoryActivity.access$000(this.this$0).equals((Object)string2)) {
                    this.val$binding.btnUpdate.setEnabled(true);
                    return;
                }
                this.val$binding.btnUpdate.setEnabled(false);
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        });
        activityEditCategoryBinding.btnUpdate.setOnClickListener(new View.OnClickListener(this, activityEditCategoryBinding, editCategoriesViewModel){
            final /* synthetic */ EditCategoryActivity this$0;
            final /* synthetic */ ActivityEditCategoryBinding val$binding;
            final /* synthetic */ EditCategoriesViewModel val$viewModel;
            {
                this.this$0 = editCategoryActivity;
                this.val$binding = activityEditCategoryBinding;
                this.val$viewModel = editCategoriesViewModel;
            }

            public void onClick(View view) {
                String string2 = this.val$binding.idEtCategoryName.getText().toString().trim();
                this.val$binding.btnUpdate.setBusy(true);
                app.dukhaan.network.model.EditCategoryRequest editCategoryRequest = new app.dukhaan.network.model.EditCategoryRequest();
                editCategoryRequest.name = string2;
                this.val$viewModel.updateCategory(editCategoryRequest, EditCategoryActivity.access$100(this.this$0));
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        active = true;
    }

    public void onStop() {
        super.onStop();
        active = false;
    }
}

