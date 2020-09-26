package app.dukhaan.ui.ui.imagepicker;

import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import app.dukhaan.databinding.ActivityImagePickerBinding;
import app.dukhaan.ui.imagepicker.MultiImagePickerActivity.1;
import app.dukhaan.ui.imagepicker.MultiImagePickerActivity.2;
import com.karumi.dexter.Dexter;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCrop.Options;
import java.io.File;
import java.util.ArrayList;

public class MultiImagePickerActivity extends AppCompatActivity {
   public static final String INTENT_ASPECT_RATIO_X = "aspect_ratio_x";
   public static final String INTENT_ASPECT_RATIO_Y = "aspect_ratio_Y";
   public static final String INTENT_BITMAP_MAX_HEIGHT = "max_height";
   public static final String INTENT_BITMAP_MAX_WIDTH = "max_width";
   public static final String INTENT_IMAGE_COMPRESSION_QUALITY = "compression_quality";
   public static final String INTENT_IMAGE_PICKER_OPTION = "image_picker_option";
   public static final String INTENT_LOCK_ASPECT_RATIO = "lock_aspect_ratio";
   public static final String INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT = "set_bitmap_max_width_height";
   public static final int REQUEST_GALLERY_IMAGE = 1;
   public static final int REQUEST_IMAGE_CAPTURE = 0;
   private static final String TAG = MultiImagePickerActivity.class.getSimpleName();
   public static String fileName;
   private int ASPECT_RATIO_X = 16;
   private int ASPECT_RATIO_Y = 9;
   private int IMAGE_COMPRESSION = 80;
   private int bitmapMaxHeight = 1000;
   private int bitmapMaxWidth = 1000;
   private boolean lockAspectRatio = false;
   private boolean setBitmapMaxWidthHeight = false;

   public MultiImagePickerActivity() {
   }

   private void chooseImageFromGallery() {
      Dexter.withActivity(this).withPermissions(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}).withListener(new 2(this)).check();
   }

   public static void clearCache(Context var0) {
      File var3 = new File(var0.getExternalCacheDir(), "camera");
      if (var3.exists() && var3.isDirectory()) {
         File[] var4 = var3.listFiles();
         int var1 = var4.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            var4[var2].delete();
         }
      }

   }

   private void cropImage(Uri var1) {
      Uri var2 = Uri.fromFile(new File(this.getCacheDir(), queryName(this.getContentResolver(), var1)));
      Options var3 = new Options();
      var3.setCompressionQuality(this.IMAGE_COMPRESSION);
      var3.setToolbarColor(ContextCompat.getColor(R.color.this, colorPrimary));
      var3.setStatusBarColor(ContextCompat.getColor(R.color.this, colorPrimary));
      var3.setActiveWidgetColor(R.color.ContextCompat.getColor(R.color.this, colorPrimary));
      if (this.lockAspectRatio) {
         var3.withAspectRatio((float)this.ASPECT_RATIO_X, (float)this.ASPECT_RATIO_Y);
      }

      if (this.setBitmapMaxWidthHeight) {
         var3.withMaxResultSize(this.bitmapMaxWidth, this.bitmapMaxHeight);
      }

      UCrop.of(var1, var2).withOptions(var3).start(this);
   }

   private Uri getCacheImagePath(String var1) {
      File var2 = new File(this.getExternalCacheDir(), "camera");
      if (!var2.exists()) {
         var2.mkdirs();
      }

      var2 = new File(var2, var1);
      StringBuilder var3 = new StringBuilder();
      var3.append(this.getPackageName());
      var3.append(".provider");
      return FileProvider.getUriForFile(this, var3.toString(), var2);
   }

   private void handleUCropResult(Intent var1) {
      if (var1 == null) {
         this.setResultCancelled();
      } else {
         Uri var2 = UCrop.getOutput(var1);
         ArrayList var3 = new ArrayList();
         var3.add(var2);
         this.setResultOk(var3);
      }
   }

   private static String queryName(ContentResolver var0, Uri var1) {
      Cursor var4 = var0.query(var1, (String[])null, (String)null, (String[])null, (String)null);
      int var2 = var4.getColumnIndex("_display_name");
      var4.moveToFirst();
      String var3 = var4.getString(R.string.var2);
      var4.close();
      return var3;
   }

   private void setResultCancelled() {
      this.setResult(0, new Intent());
      this.finish();
   }

   private void setResultOk(ArrayList<Uri> var1) {
      Intent var2 = new Intent();
      var2.putExtra("path", var1);
      this.setResult(-1, var2);
      this.finish();
   }

   public static void showImagePickerOptions(Context var0, app.dukhaan.ui.imagepicker.MultiImagePickerActivity.PickerOptionListener var1) {
      Builder var2 = new Builder(var0);
      var2.setTitle(var0.getString(R.string.lbl_set_profile_photo));
      String var3 = var0.getString(R.string.lbl_take_camera_picture);
      String var4 = var0.getString(R.string.lbl_choose_from_gallery);
      _$$Lambda$MultiImagePickerActivity$WRqyO78ecqW3GSo_bAWoKuy6JPg var5 = new _$$Lambda$MultiImagePickerActivity$WRqyO78ecqW3GSo_bAWoKuy6JPg(var1);
      var2.setItems(new String[]{var3, var4}, var5);
      var2.create().show();
   }

   private void takeCameraImage() {
      Dexter.withActivity(this).withPermissions(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}).withListener(new 1(this)).check();
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 != 0) {
         if (var1 != 1) {
            if (var1 != 69) {
               if (var1 != 96) {
                  this.setResultCancelled();
               } else {
                  Throwable var4 = UCrop.getError(var3);
                  String var6 = TAG;
                  StringBuilder var5 = new StringBuilder();
                  var5.append("Crop error: ");
                  var5.append(var4);
                  Log.e(var6, var5.toString());
                  this.setResultCancelled();
               }
            } else if (var2 == -1) {
               this.handleUCropResult(var3);
            } else {
               this.setResultCancelled();
            }
         } else if (var2 == -1) {
            ArrayList var7 = new ArrayList();
            if (var3.getClipData() != null) {
               var2 = var3.getClipData().getItemCount();
               var1 = var2;
               if (var2 > 8) {
                  var1 = 8;
               }

               for(var2 = 0; var2 < var1; ++var2) {
                  var7.add(var3.getClipData().getItemAt(var2).getUri());
               }
            } else {
               var7.add(var3.getData());
            }

            this.setResultOk(var7);
         } else {
            this.setResultCancelled();
         }
      } else if (var2 == -1) {
         this.cropImage(this.getCacheImagePath(fileName));
      } else {
         this.setResultCancelled();
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(ActivityImagePickerBinding.inflate(this.getLayoutInflater()).getRoot());
      Intent var2 = this.getIntent();
      if (var2 == null) {
         Toast.makeText(this.getApplicationContext(), this.getString(R.string.toast_image_intent_null), 1).show();
      } else {
         this.ASPECT_RATIO_X = var2.getIntExtra("aspect_ratio_x", this.ASPECT_RATIO_X);
         this.ASPECT_RATIO_Y = var2.getIntExtra("aspect_ratio_Y", this.ASPECT_RATIO_Y);
         this.IMAGE_COMPRESSION = var2.getIntExtra("compression_quality", this.IMAGE_COMPRESSION);
         this.lockAspectRatio = var2.getBooleanExtra("lock_aspect_ratio", false);
         this.setBitmapMaxWidthHeight = var2.getBooleanExtra("set_bitmap_max_width_height", false);
         this.bitmapMaxWidth = var2.getIntExtra("max_width", this.bitmapMaxWidth);
         this.bitmapMaxHeight = var2.getIntExtra("max_height", this.bitmapMaxHeight);
         if (var2.getIntExtra("image_picker_option", -1) == 0) {
            this.takeCameraImage();
         } else {
            this.chooseImageFromGallery();
         }

      }
   }
}
