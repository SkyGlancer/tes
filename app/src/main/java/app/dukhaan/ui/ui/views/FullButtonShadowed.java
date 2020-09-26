package app.dukhaan.ui.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import app.dukhaan.R.styleable;
import app.dukhaan.databinding.BtnFullShadowedBinding;

public class FullButtonShadowed extends FrameLayout {
   private BtnFullShadowedBinding binding;
   private boolean enabled;
   private OnClickListener listener;
   private String text;

   public FullButtonShadowed(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public FullButtonShadowed(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public FullButtonShadowed(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void applyStyle() {
      this.binding.label.setEnabled(this.enabled);
      if (this.enabled) {
         this.binding.label.setTextColor(ContextCompat.getColor(R.color.this.getContext(), browser_actions_title_color));
         this.binding.label.setBackgroundResource(bg_btn_primary_enabled);
      } else {
         this.binding.label.setTextColor(ContextCompat.getColor(R.color.this.getContext(), browser_actions_text_color));
         this.binding.label.setBackgroundResource(bg_btn_primary_disabled);
      }

   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = BtnFullShadowedBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
      TypedArray var4 = var1.getTheme().obtainStyledAttributes(var2, styleable.PrimaryButton, 0, 0);
      this.enabled = var4.getBoolean(0, true);
      this.text = var4.getString(R.string.1);
      this.binding.label.setEnabled(this.enabled);
      this.binding.label.setText(this.text);
      this.applyStyle();
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      if (var1.getAction() == 1 && (var1.getKeyCode() == 23 || var1.getKeyCode() == 66)) {
         OnClickListener var2 = this.listener;
         if (var2 != null) {
            var2.onClick(this);
         }
      }

      return super.dispatchKeyEvent(var1);
   }

   public boolean dispatchTouchEvent(MotionEvent var1) {
      if (var1.getAction() == 1 && this.listener != null && this.binding.label.isEnabled()) {
         this.listener.onClick(this);
      }

      return super.dispatchTouchEvent(var1);
   }

   public void setEnabled(boolean var1) {
      this.enabled = var1;
      this.applyStyle();
   }

   public void setOnClickListener(OnClickListener var1) {
      this.listener = var1;
   }

   public void setText(String var1) {
      if (!TextUtils.isEmpty(var1)) {
         this.binding.label.setText(var1);
      }

   }
}
