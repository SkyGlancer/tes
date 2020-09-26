package app.dukhaan.ui.ui.chagnelanguage;

import android.os.Bundle;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.databinding.ActivityChangeLanguageBinding;
import app.dukhaan.ui.account.AccountViewModel;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity.1;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter.OnLanguageChangeListener;
import java.util.ArrayList;

public class ChangeLanguageActivity extends BaseActivity<ActivityChangeLanguageBinding, AccountViewModel> implements OnLanguageChangeListener {
   private app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter adapter;
   private ActivityChangeLanguageBinding binding;
   private ArrayList<String> language = new ArrayList();
   private String selectedLanguage;

   public ChangeLanguageActivity() {
   }

   public int getLayoutId() {
      return activity_change_language;
   }

   public Class<AccountViewModel> getViewModel() {
      return AccountViewModel.class;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
   }

   protected void onCreate(Bundle var1, AccountViewModel var2, ActivityChangeLanguageBinding var3) {
      this.binding = var3;
      this.setSupportActionBar(var3.toolbar);
      this.enableToolbarUpNavigation();
      var3.toolbar.setNavigationOnClickListener(new _$$Lambda$ChangeLanguageActivity$LHFMbfnsgRuxfX0pJKL7PNgP7HY(this));
      this.language.add(this.getResources().getString(R.string.str_english));
      this.language.add(this.getResources().getString(R.string.str_hindi));
      this.language.add(this.getResources().getString(R.string.str_marathi));
      this.adapter = new ChangeLanguageAdapter(this, this.language, new _$$Lambda$AAfvLlVQGI_vC3ONu_H8f1M_2oU(this));
      var3.recyclerview.setAdapter(this.adapter);
      if (AppPref.getInstance().getLocale().equals("en")) {
         this.selectedLanguage = this.getResources().getString(R.string.str_english);
         this.adapter.checkedPosition = 0;
      } else if (AppPref.getInstance().getLocale().equals("hi")) {
         this.selectedLanguage = this.getResources().getString(R.string.str_hindi);
         this.adapter.checkedPosition = 1;
      } else if (AppPref.getInstance().getLocale().equals("mr")) {
         this.selectedLanguage = this.getResources().getString(R.string.str_english);
         this.adapter.checkedPosition = 2;
      }

      this.adapter.notifyDataSetChanged();
      var3.btnSave.setOnClickListener(new 1(this));
   }

   public void onLanguageChanged(String var1) {
      this.selectedLanguage = var1;
   }
}
