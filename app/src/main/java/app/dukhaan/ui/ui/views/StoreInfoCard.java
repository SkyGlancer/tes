package app.dukhaan.ui.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import app.dukhaan.databinding.LayoutStoreInfoCardBinding;

public class StoreInfoCard extends FrameLayout {
   private LayoutStoreInfoCardBinding binding;
   private app.dukhaan.ui.views.StoreInfoCard.StoreInfoCardListener listener;
   private String storeUrl;

   public StoreInfoCard(Context var1) {
      super(var1);
      this.init(var1, (AttributeSet)null, 0);
   }

   public StoreInfoCard(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1, var2, 0);
   }

   public StoreInfoCard(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1, var2, var3);
   }

   private void init(Context var1, AttributeSet var2, int var3) {
      this.binding = LayoutStoreInfoCardBinding.inflate((LayoutInflater)var1.getSystemService("layout_inflater"), this, true);
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.binding.link.setOnClickListener(new _$$Lambda$StoreInfoCard$A0CvHHXu0gDfvjbFdn1cnP_nBxI(this));
      this.binding.copy.setOnClickListener(new _$$Lambda$StoreInfoCard$AVYx1SB6fBwf4gJBGh4ZTZtvaGA(this));
   }

   public void setData(String var1) {
      this.storeUrl = var1;
      this.binding.link.setText(var1.replaceFirst("^(http[s]?://www\\.|http[s]?://|www\\.)", ""));
   }

   public void setListener(app.dukhaan.ui.views.StoreInfoCard.StoreInfoCardListener var1) {
      this.listener = var1;
   }
}
