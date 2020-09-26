package app.dukhaan.ui.ui.chagnelanguage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import app.dukhaan.databinding.BottomSheetSelectLanguageBinding;
import app.dukhaan.ui.onboarding.OnBoardingActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetSelectLanguage extends BottomSheetDialogFragment {
   private BottomSheetSelectLanguageBinding binding;
   private app.dukhaan.ui.chagnelanguage.BottomSheetSelectLanguage.OnLanguageSelectListener onLanguageSelectListener;

   public BottomSheetSelectLanguage() {
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setStyle(0, CustomBottomSheetDialogTheme);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      BottomSheetSelectLanguageBinding var4 = (BottomSheetSelectLanguageBinding)DataBindingUtil.inflate(var1, bottom_sheet_select_language, var2, false);
      this.binding = var4;
      var4.idBtnEnglish.setOnClickListener(new _$$Lambda$BottomSheetSelectLanguage$DjohEMbAdk5FwkOVFUTyVId0vYQ(this));
      this.binding.idBtnHindi.setOnClickListener(new _$$Lambda$BottomSheetSelectLanguage$0QV18ABOel_r1eHYVUXGvObURSE(this));
      this.binding.idBtnMarathi.setOnClickListener(new _$$Lambda$BottomSheetSelectLanguage$qrLIL3EQxrEBSn45SxjtH5zBrtQ(this));
      return this.binding.getRoot();
   }

   public void setListener(OnBoardingActivity var1) {
      this.onLanguageSelectListener = var1;
   }
}
