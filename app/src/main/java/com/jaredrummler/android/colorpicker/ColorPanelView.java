/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.Toast
 *  androidx.core.view.ViewCompat
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 */
package app.dukhaan.src.java.com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.jaredrummler.android.colorpicker.AlphaPatternDrawable;
import com.jaredrummler.android.colorpicker.DrawingUtils;
import com.jaredrummler.android.colorpicker.R;
import java.util.Locale;

public class ColorPanelView
extends View {
    private static final int DEFAULT_BORDER_COLOR = -9539986;
    private Paint alphaPaint;
    private Drawable alphaPattern;
    private int borderColor = -9539986;
    private Paint borderPaint;
    private int borderWidthPx;
    private RectF centerRect = new RectF();
    private int color = -16777216;
    private Paint colorPaint;
    private Rect colorRect;
    private Rect drawingRect;
    private Paint originalPaint;
    private int shape;
    private boolean showOldColor;

    public ColorPanelView(Context context) {
        this(context, null);
    }

    public ColorPanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPanelView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Paint paint;
        boolean bl;
        Paint paint2;
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorPanelView);
        this.shape = typedArray.getInt(R.styleable.ColorPanelView_cpv_colorShape, 1);
        this.showOldColor = bl = typedArray.getBoolean(R.styleable.ColorPanelView_cpv_showOldColor, false);
        if (bl && this.shape != 1) {
            throw new IllegalStateException("Color preview is only available in circle mode");
        }
        this.borderColor = typedArray.getColor(R.styleable.ColorPanelView_cpv_borderColor, -9539986);
        typedArray.recycle();
        if (this.borderColor == -9539986) {
            TypedArray typedArray2 = context.obtainStyledAttributes(new TypedValue().data, new int[]{16842808});
            this.borderColor = typedArray2.getColor(0, this.borderColor);
            typedArray2.recycle();
        }
        this.borderWidthPx = DrawingUtils.dpToPx(context, 1.0f);
        this.borderPaint = paint2 = new Paint();
        paint2.setAntiAlias(true);
        this.colorPaint = paint = new Paint();
        paint.setAntiAlias(true);
        if (this.showOldColor) {
            this.originalPaint = new Paint();
        }
        if (this.shape == 1) {
            Paint paint3;
            Bitmap bitmap = ((BitmapDrawable)context.getResources().getDrawable(R.drawable.cpv_alpha)).getBitmap();
            this.alphaPaint = paint3 = new Paint();
            paint3.setAntiAlias(true);
            BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            this.alphaPaint.setShader((Shader)bitmapShader);
        }
    }

    private void setUpCenterRect() {
        Rect rect = this.drawingRect;
        int n = rect.left + this.borderWidthPx;
        int n2 = rect.top + this.borderWidthPx;
        int n3 = rect.bottom - this.borderWidthPx;
        int n4 = rect.right - this.borderWidthPx;
        this.centerRect = new RectF((float)n, (float)n2, (float)n4, (float)n3);
    }

    private void setUpColorRect() {
        Rect rect = this.drawingRect;
        int n = rect.left + this.borderWidthPx;
        int n2 = rect.top + this.borderWidthPx;
        int n3 = rect.bottom - this.borderWidthPx;
        this.colorRect = new Rect(n, n2, rect.right - this.borderWidthPx, n3);
        AlphaPatternDrawable alphaPatternDrawable = new AlphaPatternDrawable(DrawingUtils.dpToPx(this.getContext(), 4.0f));
        this.alphaPattern = alphaPatternDrawable;
        alphaPatternDrawable.setBounds(Math.round((float)this.colorRect.left), Math.round((float)this.colorRect.top), Math.round((float)this.colorRect.right), Math.round((float)this.colorRect.bottom));
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public int getColor() {
        return this.color;
    }

    public int getShape() {
        return this.shape;
    }

    protected void onDraw(Canvas canvas) {
        this.borderPaint.setColor(this.borderColor);
        this.colorPaint.setColor(this.color);
        int n = this.shape;
        if (n == 0) {
            Drawable drawable2;
            if (this.borderWidthPx > 0) {
                canvas.drawRect(this.drawingRect, this.borderPaint);
            }
            if ((drawable2 = this.alphaPattern) != null) {
                drawable2.draw(canvas);
            }
            canvas.drawRect(this.colorRect, this.colorPaint);
            return;
        }
        if (n == 1) {
            int n2 = this.getMeasuredWidth() / 2;
            if (this.borderWidthPx > 0) {
                canvas.drawCircle((float)(this.getMeasuredWidth() / 2), (float)(this.getMeasuredHeight() / 2), (float)n2, this.borderPaint);
            }
            if (Color.alpha((int)this.color) < 255) {
                canvas.drawCircle((float)(this.getMeasuredWidth() / 2), (float)(this.getMeasuredHeight() / 2), (float)(n2 - this.borderWidthPx), this.alphaPaint);
            }
            if (this.showOldColor) {
                canvas.drawArc(this.centerRect, 90.0f, 180.0f, true, this.originalPaint);
                canvas.drawArc(this.centerRect, 270.0f, 180.0f, true, this.colorPaint);
                return;
            }
            canvas.drawCircle((float)(this.getMeasuredWidth() / 2), (float)(this.getMeasuredHeight() / 2), (float)(n2 - this.borderWidthPx), this.colorPaint);
        }
    }

    protected void onMeasure(int n, int n2) {
        int n3 = this.shape;
        if (n3 == 0) {
            this.setMeasuredDimension(MeasureSpec.getSize((int)n), MeasureSpec.getSize((int)n2));
            return;
        }
        if (n3 == 1) {
            super.onMeasure(n, n);
            this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredWidth());
            return;
        }
        super.onMeasure(n, n2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle)parcelable;
            this.color = bundle.getInt("color");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("color", this.color);
        return bundle;
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        if (this.shape == 0 || this.showOldColor) {
            Rect rect;
            this.drawingRect = rect = new Rect();
            rect.left = this.getPaddingLeft();
            this.drawingRect.right = n - this.getPaddingRight();
            this.drawingRect.top = this.getPaddingTop();
            this.drawingRect.bottom = n2 - this.getPaddingBottom();
            if (this.showOldColor) {
                this.setUpCenterRect();
                return;
            }
            this.setUpColorRect();
        }
    }

    public void setBorderColor(int n) {
        this.borderColor = n;
        this.invalidate();
    }

    public void setColor(int n) {
        this.color = n;
        this.invalidate();
    }

    public void setOriginalColor(int n) {
        Paint paint = this.originalPaint;
        if (paint != null) {
            paint.setColor(n);
        }
    }

    public void setShape(int n) {
        this.shape = n;
        this.invalidate();
    }

    public void showHint() {
        int[] arrn = new int[2];
        Rect rect = new Rect();
        this.getLocationOnScreen(arrn);
        this.getWindowVisibleDisplayFrame(rect);
        Context context = this.getContext();
        int n = this.getWidth();
        int n2 = this.getHeight();
        int n3 = arrn[1] + n2 / 2;
        int n4 = arrn[0] + n / 2;
        if (ViewCompat.getLayoutDirection((View)this) == 0) {
            n4 = context.getResources().getDisplayMetrics().widthPixels - n4;
        }
        StringBuilder stringBuilder = new StringBuilder("#");
        if (Color.alpha((int)this.color) != 255) {
            stringBuilder.append(Integer.toHexString((int)this.color).toUpperCase(Locale.ENGLISH));
        } else {
            Object[] arrobject = new Object[]{16777215 & this.color};
            stringBuilder.append(String.format((String)"%06X", (Object[])arrobject).toUpperCase(Locale.ENGLISH));
        }
        Toast toast = Toast.makeText((Context)context, (CharSequence)stringBuilder.toString(), (int)0);
        if (n3 < rect.height()) {
            toast.setGravity(8388661, n4, n2 + arrn[1] - rect.top);
        } else {
            toast.setGravity(81, 0, n2);
        }
        toast.show();
    }
}

