package app.dukhaan.ui.ui.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import app.dukhaan.databinding.SpinnerViewBinding;
import app.dukhaan.ui.views.SpinnerImage.1;

public class SpinnerImage extends FrameLayout {
   private SpinnerViewBinding binding;
   private Context mContext;
   int rotationAngle = 0;

   public SpinnerImage(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public SpinnerImage(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public SpinnerImage(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.mContext = var1;
      this.binding = SpinnerViewBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   public void rotate() {
      ImageView var1 = this.binding.imgSpinner;
      int var2 = this.rotationAngle;
      ObjectAnimator var3 = ObjectAnimator.ofFloat(var1, "rotation", new float[]{(float)var2, (float)(var2 + 180)});
      var3.setDuration(300L);
      var3.start();
      var2 = this.rotationAngle + 180;
      this.rotationAngle = var2;
      this.rotationAngle = var2 % 360;
      var3.addListener(new 1(this));
   }
}
