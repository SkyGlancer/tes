/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.Toast
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.core.content.ContextCompat
 *  androidx.core.content.FileProvider
 *  app.dukhaan.databinding.ActivityImagePickerBinding
 *  app.dukhaan.ui.imagepicker.MultiImagePickerActivity$1
 *  app.dukhaan.ui.imagepicker.MultiImagePickerActivity$2
 *  com.karumi.dexter.Dexter
 *  java.io.File
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 */
package app.dukhaan.ui.imagepicker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import app.dukhaan.databinding.ActivityImagePickerBinding;
import app.dukhaan.ui.imagepicker.-$$Lambda$MultiImagePickerActivity$WRqyO78ecqW3GSo-bAWoKuy6JPg;
import app.dukhaan.ui.imagepicker.MultiImagePickerActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class MultiImagePickerActivity
extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String INTENT_ASPECT_RATIO_X = "aspect_ratio_x";
    public static final String INTENT_ASPECT_RATIO_Y = "aspect_ratio_Y";
    public static final String INTENT_BITMAP_MAX_HEIGHT = "max_height";
    public static final String INTENT_BITMAP_MAX_WIDTH = "max_width";
    public static final String INTENT_IMAGE_COMPRESSION_QUALITY = "compression_quality";
    public static final String INTENT_IMAGE_PICKER_OPTION = "image_picker_option";
    public static final String INTENT_LOCK_ASPECT_RATIO = "lock_aspect_ratio";
    public static final String INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT = "set_bitmap_max_width_height";
    public static final int REQUEST_GALLERY_IMAGE = 1;
    public static final int REQUEST_IMAGE_CAPTURE;
    private static final String TAG;
    public static String fileName;
    private int ASPECT_RATIO_X = 16;
    private int ASPECT_RATIO_Y = 9;
    private int IMAGE_COMPRESSION = 80;
    private int bitmapMaxHeight = 1000;
    private int bitmapMaxWidth = 1000;
    private boolean lockAspectRatio = false;
    private boolean setBitmapMaxWidthHeight = false;

    static {
        TAG = MultiImagePickerActivity.class.getSimpleName();
    }

    static /* synthetic */ Uri access$000(MultiImagePickerActivity multiImagePickerActivity, String string2) {
        return multiImagePickerActivity.getCacheImagePath(string2);
    }

    private void chooseImageFromGallery() {
        Dexter.withActivity((Activity)this).withPermissions("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE").withListener((MultiplePermissionsListener)new 2(this)).check();
    }

    public static void clearCache(Context context) {
        File file = new File(context.getExternalCacheDir(), "camera");
        if (file.exists() && file.isDirectory()) {
            File[] arrfile = file.listFiles();
            int n = arrfile.length;
            for (int i = 0; i < n; ++i) {
                arrfile[i].delete();
            }
        }
    }

    private void cropImage(Uri uri) {
        Uri uri2 = Uri.fromFile((File)new File(this.getCacheDir(), MultiImagePickerActivity.queryName(this.getContentResolver(), uri)));
        UCrop.Options options = new UCrop.Options();
        options.setCompressionQuality(this.IMAGE_COMPRESSION);
        options.setToolbarColor(ContextCompat.getColor((Context)this, (int)2131099728));
        options.setStatusBarColor(ContextCompat.getColor((Context)this, (int)2131099728));
        options.setActiveWidgetColor(ContextCompat.getColor((Context)this, (int)2131099728));
        if (this.lockAspectRatio) {
            options.withAspectRatio(this.ASPECT_RATIO_X, this.ASPECT_RATIO_Y);
        }
        if (this.setBitmapMaxWidthHeight) {
            options.withMaxResultSize(this.bitmapMaxWidth, this.bitmapMaxHeight);
        }
        UCrop.of(uri, uri2).withOptions(options).start((Activity)this);
    }

    private Uri getCacheImagePath(String string2) {
        File file = new File(this.getExternalCacheDir(), "camera");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, string2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getPackageName());
        stringBuilder.append(".provider");
        return FileProvider.getUriForFile((Context)this, (String)stringBuilder.toString(), (File)file2);
    }

    private void handleUCropResult(Intent intent) {
        if (intent == null) {
            this.setResultCancelled();
            return;
        }
        Uri uri = UCrop.getOutput(intent);
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)uri);
        this.setResultOk((ArrayList<Uri>)arrayList);
    }

    static /* synthetic */ void lambda$showImagePickerOptions$0(PickerOptionListener pickerOptionListener, DialogInterface dialogInterface, int n) {
        if (n != 0) {
            if (n != 1) {
                return;
            }
            pickerOptionListener.onChooseGallerySelected();
            return;
        }
        pickerOptionListener.onTakeCameraSelected();
    }

    private static String queryName(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        int n = cursor.getColumnIndex("_display_name");
        cursor.moveToFirst();
        String string2 = cursor.getString(n);
        cursor.close();
        return string2;
    }

    private void setResultCancelled() {
        this.setResult(0, new Intent());
        this.finish();
    }

    private void setResultOk(ArrayList<Uri> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("path", arrayList);
        this.setResult(-1, intent);
        this.finish();
    }

    public static void showImagePickerOptions(Context context, PickerOptionListener pickerOptionListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle((CharSequence)context.getString(2131951820));
        CharSequence[] arrcharSequence = new String[]{context.getString(2131951821), context.getString(2131951811)};
        builder.setItems(arrcharSequence, (DialogInterface.OnClickListener)new -$$Lambda$MultiImagePickerActivity$WRqyO78ecqW3GSo-bAWoKuy6JPg(pickerOptionListener));
        builder.create().show();
    }

    private void takeCameraImage() {
        Dexter.withActivity((Activity)this).withPermissions("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE").withListener((MultiplePermissionsListener)new 1(this)).check();
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n != 0) {
            if (n != 1) {
                if (n != 69) {
                    if (n != 96) {
                        this.setResultCancelled();
                        return;
                    }
                    Throwable throwable = UCrop.getError(intent);
                    String string2 = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Crop error: ");
                    stringBuilder.append((Object)throwable);
                    Log.e((String)string2, (String)stringBuilder.toString());
                    this.setResultCancelled();
                    return;
                }
                if (n2 == -1) {
                    this.handleUCropResult(intent);
                    return;
                }
                this.setResultCancelled();
                return;
            }
            if (n2 == -1) {
                ArrayList arrayList = new ArrayList();
                if (intent.getClipData() != null) {
                    int n3 = intent.getClipData().getItemCount();
                    if (n3 > 8) {
                        n3 = 8;
                    }
                    for (int i = 0; i < n3; ++i) {
                        arrayList.add((Object)intent.getClipData().getItemAt(i).getUri());
                    }
                } else {
                    arrayList.add((Object)intent.getData());
                }
                this.setResultOk((ArrayList<Uri>)arrayList);
                return;
            }
            this.setResultCancelled();
            return;
        }
        if (n2 == -1) {
            this.cropImage(this.getCacheImagePath(fileName));
            return;
        }
        this.setResultCancelled();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView((View)ActivityImagePickerBinding.inflate((LayoutInflater)this.getLayoutInflater()).getRoot());
        Intent intent = this.getIntent();
        if (intent == null) {
            Toast.makeText((Context)this.getApplicationContext(), (CharSequence)this.getString(2131952000), (int)1).show();
            return;
        }
        this.ASPECT_RATIO_X = intent.getIntExtra(INTENT_ASPECT_RATIO_X, this.ASPECT_RATIO_X);
        this.ASPECT_RATIO_Y = intent.getIntExtra(INTENT_ASPECT_RATIO_Y, this.ASPECT_RATIO_Y);
        this.IMAGE_COMPRESSION = intent.getIntExtra(INTENT_IMAGE_COMPRESSION_QUALITY, this.IMAGE_COMPRESSION);
        this.lockAspectRatio = intent.getBooleanExtra(INTENT_LOCK_ASPECT_RATIO, false);
        this.setBitmapMaxWidthHeight = intent.getBooleanExtra(INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT, false);
        this.bitmapMaxWidth = intent.getIntExtra(INTENT_BITMAP_MAX_WIDTH, this.bitmapMaxWidth);
        this.bitmapMaxHeight = intent.getIntExtra(INTENT_BITMAP_MAX_HEIGHT, this.bitmapMaxHeight);
        if (intent.getIntExtra(INTENT_IMAGE_PICKER_OPTION, -1) == 0) {
            this.takeCameraImage();
            return;
        }
        this.chooseImageFromGallery();
    }

}

