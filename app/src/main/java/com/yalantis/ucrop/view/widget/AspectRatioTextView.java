/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package app.dukhaan.src.java.com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

public class AspectRatioTextView
extends TextView {
    private float mAspectRatio;
    private String mAspectRatioTitle;
    private float mAspectRatioX;
    private float mAspectRatioY;
    private final Rect mCanvasClipBounds = new Rect();
    private Paint mDotPaint;
    private int mDotSize;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.init(context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_AspectRatioTextView));
    }

    private void applyActiveColor(int n) {
        Paint paint = this.mDotPaint;
        if (paint != null) {
            paint.setColor(n);
        }
        int[][] arrarrn = new int[][]{{16842913}, {0}};
        int[] arrn = new int[]{n, ContextCompat.getColor((Context)this.getContext(), (int)R.color.ucrop_color_widget)};
        this.setTextColor(new ColorStateList((int[][])arrarrn, arrn));
    }

    private void init(TypedArray typedArray) {
        Paint paint;
        float f;
        this.setGravity(1);
        this.mAspectRatioTitle = typedArray.getString(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.mAspectRatioX = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        this.mAspectRatioY = f = typedArray.getFloat(R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        float f2 = this.mAspectRatioX;
        this.mAspectRatio = f2 != 0.0f && f != 0.0f ? f2 / f : 0.0f;
        this.mDotSize = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_size_dot_scale_text_view);
        this.mDotPaint = paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.setTitle();
        this.applyActiveColor(this.getResources().getColor(R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    private void setTitle() {
        if (!TextUtils.isEmpty((CharSequence)this.mAspectRatioTitle)) {
            this.setText((CharSequence)this.mAspectRatioTitle);
            return;
        }
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{(int)this.mAspectRatioX, (int)this.mAspectRatioY};
        this.setText((CharSequence)String.format((Locale)locale, (String)"%d:%d", (Object[])arrobject));
    }

    private void toggleAspectRatio() {
        if (this.mAspectRatio != 0.0f) {
            float f;
            float f2 = this.mAspectRatioX;
            this.mAspectRatioX = f = this.mAspectRatioY;
            this.mAspectRatioY = f2;
            this.mAspectRatio = f / f2;
        }
    }

    public float getAspectRatio(boolean bl) {
        if (bl) {
            this.toggleAspectRatio();
            this.setTitle();
        }
        return this.mAspectRatio;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isSelected()) {
            canvas.getClipBounds(this.mCanvasClipBounds);
            float f = (float)(this.mCanvasClipBounds.right - this.mCanvasClipBounds.left) / 2.0f;
            int n = this.mCanvasClipBounds.bottom;
            int n2 = this.mDotSize;
            canvas.drawCircle(f, (float)(n - n2), (float)(n2 / 2), this.mDotPaint);
        }
    }

    public void setActiveColor(int n) {
        this.applyActiveColor(n);
        this.invalidate();
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        float f;
        this.mAspectRatioTitle = aspectRatio.getAspectRatioTitle();
        this.mAspectRatioX = aspectRatio.getAspectRatioX();
        this.mAspectRatioY = f = aspectRatio.getAspectRatioY();
        float f2 = this.mAspectRatioX;
        this.mAspectRatio = f2 != 0.0f && f != 0.0f ? f2 / f : 0.0f;
        this.setTitle();
    }
}

