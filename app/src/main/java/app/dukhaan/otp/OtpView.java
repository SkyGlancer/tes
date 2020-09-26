/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.text.Editable
 *  android.text.InputFilter
 *  android.text.InputFilter$LengthFilter
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.method.MovementMethod
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.animation.DecelerateInterpolator
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.core.content.res.ResourcesCompat
 *  androidx.core.view.ViewCompat
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package app.dukhaan.otp;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import app.dukhaan.R;
import app.dukhaan.otp.DefaultMovementMethod;
import app.dukhaan.otp.OnOtpCompletionListener;
import app.dukhaan.otp.OtpView;

public class OtpView
extends AppCompatEditText {
    private static final int BLINK = 500;
    private static final boolean DBG = false;
    private static final int DEFAULT_COUNT = 4;
    private static final int[] FILLED_STATE;
    private static final InputFilter[] NO_FILTERS;
    private static final int[] SELECTED_STATE;
    private static final int VIEW_TYPE_LINE = 1;
    private static final int VIEW_TYPE_RECTANGLE;
    private final TextPaint animatorTextPaint = new TextPaint();
    private Blink blink;
    private int cursorColor;
    private float cursorHeight;
    private int cursorLineColor = -16777216;
    private int cursorWidth;
    private ValueAnimator defaultAddAnimator;
    private boolean drawCursor;
    private boolean hideLineWhenFilled;
    private boolean isAnimationEnable = false;
    private boolean isCursorVisible;
    private Drawable itemBackground;
    private int itemBackgroundResource;
    private final RectF itemBorderRect = new RectF();
    private final PointF itemCenterPoint = new PointF();
    private final RectF itemLineRect = new RectF();
    private ColorStateList lineColor;
    private int lineWidth;
    private String maskingChar;
    private OnOtpCompletionListener onOtpCompletionListener;
    private int otpViewItemCount;
    private int otpViewItemHeight;
    private int otpViewItemRadius;
    private int otpViewItemSpacing;
    private int otpViewItemWidth;
    private final Paint paint;
    private final Path path = new Path();
    private boolean rtlTextDirection;
    private final Rect textRect = new Rect();
    private int viewType;

    static {
        NO_FILTERS = new InputFilter[0];
        SELECTED_STATE = new int[]{16842913};
        FILLED_STATE = new int[]{2130969396};
    }

    public OtpView(Context context) {
        this(context, null);
    }

    public OtpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130969227);
    }

    public OtpView(Context context, AttributeSet attributeSet, int n) {
        Paint paint;
        super(context, attributeSet, n);
        Resources resources = this.getResources();
        this.paint = paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        this.animatorTextPaint.set(this.getPaint());
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.OtpView, n, 0);
        this.viewType = typedArray.getInt(15, 0);
        this.otpViewItemCount = typedArray.getInt(5, 4);
        this.otpViewItemHeight = (int)typedArray.getDimension(6, (float)resources.getDimensionPixelSize(2131165659));
        this.otpViewItemWidth = (int)typedArray.getDimension(9, (float)resources.getDimensionPixelSize(2131165659));
        this.otpViewItemSpacing = typedArray.getDimensionPixelSize(8, resources.getDimensionPixelSize(2131165660));
        this.otpViewItemRadius = (int)typedArray.getDimension(7, 0.0f);
        this.lineWidth = (int)typedArray.getDimension(11, (float)resources.getDimensionPixelSize(2131165657));
        this.lineColor = typedArray.getColorStateList(10);
        this.isCursorVisible = typedArray.getBoolean(1, true);
        this.cursorColor = typedArray.getColor(2, this.getCurrentTextColor());
        this.cursorWidth = typedArray.getDimensionPixelSize(3, resources.getDimensionPixelSize(2131165656));
        this.itemBackground = typedArray.getDrawable(0);
        this.hideLineWhenFilled = typedArray.getBoolean(4, false);
        this.rtlTextDirection = typedArray.getBoolean(13, false);
        this.maskingChar = typedArray.getString(12);
        typedArray.recycle();
        ColorStateList colorStateList = this.lineColor;
        if (colorStateList != null) {
            this.cursorLineColor = colorStateList.getDefaultColor();
        }
        this.updateCursorHeight();
        this.checkItemRadius();
        this.setMaxLength(this.otpViewItemCount);
        this.paint.setStrokeWidth((float)this.lineWidth);
        this.setupAnimator();
        super.setCursorVisible(false);
        this.setTextIsSelectable(false);
    }

    static /* synthetic */ TextPaint access$000(OtpView otpView) {
        return otpView.animatorTextPaint;
    }

    private void checkItemRadius() {
        int n = this.viewType;
        if (n == 1) {
            float f = (float)this.lineWidth / 2.0f;
            if (!((float)this.otpViewItemRadius > f)) {
                return;
            }
            throw new IllegalArgumentException("The itemRadius can not be greater than lineWidth when viewType is line");
        }
        if (n == 0) {
            float f = (float)this.otpViewItemWidth / 2.0f;
            if (!((float)this.otpViewItemRadius > f)) {
                return;
            }
            throw new IllegalArgumentException("The itemRadius can not be greater than itemWidth");
        }
    }

    private int dpToPx() {
        return (int)(0.5f + 2.0f * this.getResources().getDisplayMetrics().density);
    }

    private void drawAnchorLine(Canvas canvas) {
        float f = this.itemCenterPoint.x;
        float f2 = this.itemCenterPoint.y;
        this.paint.setStrokeWidth(1.0f);
        float f3 = f - this.paint.getStrokeWidth() / 2.0f;
        float f4 = f2 - this.paint.getStrokeWidth() / 2.0f;
        this.path.reset();
        this.path.moveTo(f3, this.itemBorderRect.top);
        this.path.lineTo(f3, this.itemBorderRect.top + Math.abs((float)this.itemBorderRect.height()));
        canvas.drawPath(this.path, this.paint);
        this.path.reset();
        this.path.moveTo(this.itemBorderRect.left, f4);
        this.path.lineTo(this.itemBorderRect.left + Math.abs((float)this.itemBorderRect.width()), f4);
        canvas.drawPath(this.path, this.paint);
        this.path.reset();
        this.paint.setStrokeWidth((float)this.lineWidth);
    }

    private void drawCircle(Canvas canvas, int n) {
        Paint paint = this.getPaintByIndex(n);
        float f = this.itemCenterPoint.x;
        float f2 = this.itemCenterPoint.y;
        if (this.rtlTextDirection) {
            if (this.otpViewItemCount - n - this.getHint().length() <= 0) {
                canvas.drawCircle(f, f2, paint.getTextSize() / 2.0f, paint);
                return;
            }
        } else {
            canvas.drawCircle(f, f2, paint.getTextSize() / 2.0f, paint);
        }
    }

    private void drawCursor(Canvas canvas) {
        if (this.drawCursor) {
            float f = this.itemCenterPoint.x;
            float f2 = this.itemCenterPoint.y - this.cursorHeight / 2.0f;
            int n = this.paint.getColor();
            float f3 = this.paint.getStrokeWidth();
            this.paint.setColor(this.cursorColor);
            this.paint.setStrokeWidth((float)this.cursorWidth);
            canvas.drawLine(f, f2, f, f2 + this.cursorHeight, this.paint);
            this.paint.setColor(n);
            this.paint.setStrokeWidth(f3);
        }
    }

    private void drawHint(Canvas canvas, int n) {
        Paint paint = this.getPaintByIndex(n);
        paint.setColor(this.getCurrentHintTextColor());
        if (this.rtlTextDirection) {
            int n2 = this.otpViewItemCount - n - this.getHint().length();
            if (n2 <= 0) {
                this.drawTextAtBox(canvas, paint, this.getHint(), Math.abs((int)n2));
                return;
            }
        } else {
            this.drawTextAtBox(canvas, paint, this.getHint(), n);
        }
    }

    private void drawInput(Canvas canvas, int n) {
        if (this.maskingChar != null && (OtpView.isNumberInputType(this.getInputType()) || OtpView.isPasswordInputType(this.getInputType()))) {
            this.drawMaskingText(canvas, n, Character.toString((char)this.maskingChar.charAt(0)));
            return;
        }
        if (OtpView.isPasswordInputType(this.getInputType())) {
            this.drawCircle(canvas, n);
            return;
        }
        this.drawText(canvas, n);
    }

    private void drawItemBackground(Canvas canvas, int[] arrn) {
        if (this.itemBackground == null) {
            return;
        }
        float f = (float)this.lineWidth / 2.0f;
        int n = Math.round((float)(this.itemBorderRect.left - f));
        int n2 = Math.round((float)(this.itemBorderRect.top - f));
        int n3 = Math.round((float)(f + this.itemBorderRect.right));
        int n4 = Math.round((float)(f + this.itemBorderRect.bottom));
        this.itemBackground.setBounds(n, n2, n3, n4);
        Drawable drawable = this.itemBackground;
        if (arrn == null) {
            arrn = this.getDrawableState();
        }
        drawable.setState(arrn);
        this.itemBackground.draw(canvas);
    }

    private void drawMaskingText(Canvas canvas, int n, String string) {
        Paint paint = this.getPaintByIndex(n);
        paint.setColor(this.getCurrentTextColor());
        if (this.rtlTextDirection) {
            int n2 = this.otpViewItemCount - n;
            if (this.getText() != null) {
                n2 -= this.getText().length();
            }
            if (n2 <= 0 && this.getText() != null) {
                this.drawTextAtBox(canvas, paint, this.getText().toString().replaceAll(".", string), Math.abs((int)n2));
                return;
            }
        } else if (this.getText() != null) {
            this.drawTextAtBox(canvas, paint, this.getText().toString().replaceAll(".", string), n);
        }
    }

    private void drawOtpBox(Canvas canvas, int n) {
        if (this.getText() != null && this.hideLineWhenFilled && n < this.getText().length()) {
            return;
        }
        canvas.drawPath(this.path, this.paint);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void drawOtpLine(Canvas canvas, int n) {
        boolean bl;
        boolean bl2;
        block6 : {
            block5 : {
                block1 : {
                    block3 : {
                        block4 : {
                            int n2;
                            block2 : {
                                if (this.getText() != null && this.hideLineWhenFilled && n < this.getText().length()) {
                                    return;
                                }
                                if (this.otpViewItemSpacing != 0 || (n2 = this.otpViewItemCount) <= 1) break block1;
                                if (n != 0) break block2;
                                bl = true;
                                break block3;
                            }
                            if (n != n2 - 1) break block4;
                            bl = false;
                            break block5;
                        }
                        bl = false;
                    }
                    bl2 = false;
                    break block6;
                }
                bl = true;
            }
            bl2 = true;
        }
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth((float)this.lineWidth / 10.0f);
        float f = (float)this.lineWidth / 2.0f;
        this.itemLineRect.set(this.itemBorderRect.left - f, this.itemBorderRect.bottom - f, f + this.itemBorderRect.right, f + this.itemBorderRect.bottom);
        RectF rectF = this.itemLineRect;
        int n3 = this.otpViewItemRadius;
        this.updateRoundRectPath(rectF, n3, n3, bl, bl2);
        canvas.drawPath(this.path, this.paint);
    }

    private void drawOtpView(Canvas canvas) {
        int n = this.rtlTextDirection ? this.otpViewItemCount - 1 : (this.getText() != null ? this.getText().length() : 0);
        for (int i = 0; i < this.otpViewItemCount; ++i) {
            int[] arrn;
            int n2;
            boolean bl = this.isFocused() && n == i;
            boolean bl2 = i < n;
            if (bl2) {
                arrn = FILLED_STATE;
            } else {
                arrn = null;
                if (bl) {
                    arrn = SELECTED_STATE;
                }
            }
            Paint paint = this.paint;
            int n3 = arrn != null ? this.getLineColorForState(arrn) : this.cursorLineColor;
            paint.setColor(n3);
            this.updateItemRectF(i);
            this.updateCenterPoint();
            canvas.save();
            if (this.viewType == 0) {
                this.updateOtpViewBoxPath(i);
                canvas.clipPath(this.path);
            }
            this.drawItemBackground(canvas, arrn);
            canvas.restore();
            if (bl) {
                this.drawCursor(canvas);
            }
            if ((n2 = this.viewType) == 0) {
                this.drawOtpBox(canvas, i);
            } else if (n2 == 1) {
                this.drawOtpLine(canvas, i);
            }
            if (this.rtlTextDirection) {
                int n4 = this.otpViewItemCount - i;
                if (this.getText().length() >= n4) {
                    this.drawInput(canvas, i);
                    continue;
                }
                if (TextUtils.isEmpty((CharSequence)this.getHint()) || this.getHint().length() != this.otpViewItemCount) continue;
                this.drawHint(canvas, i);
                continue;
            }
            if (this.getText().length() > i) {
                this.drawInput(canvas, i);
                continue;
            }
            if (TextUtils.isEmpty((CharSequence)this.getHint()) || this.getHint().length() != this.otpViewItemCount) continue;
            this.drawHint(canvas, i);
        }
        if (this.isFocused() && this.getText() != null && this.getText().length() != this.otpViewItemCount && this.viewType == 0) {
            int n5 = this.getText().length();
            this.updateItemRectF(n5);
            this.updateCenterPoint();
            this.updateOtpViewBoxPath(n5);
            this.paint.setColor(this.getLineColorForState(SELECTED_STATE));
            this.drawOtpBox(canvas, n5);
        }
    }

    private void drawText(Canvas canvas, int n) {
        Paint paint = this.getPaintByIndex(n);
        paint.setColor(this.getCurrentTextColor());
        if (this.rtlTextDirection) {
            int n2 = this.otpViewItemCount - n;
            if (this.getText() != null) {
                n2 -= this.getText().length();
            }
            if (n2 <= 0 && this.getText() != null) {
                this.drawTextAtBox(canvas, paint, (CharSequence)this.getText(), Math.abs((int)n2));
                return;
            }
        } else if (this.getText() != null) {
            this.drawTextAtBox(canvas, paint, (CharSequence)this.getText(), n);
        }
    }

    private void drawTextAtBox(Canvas canvas, Paint paint, CharSequence charSequence, int n) {
        String string = charSequence.toString();
        int n2 = n + 1;
        paint.getTextBounds(string, n, n2, this.textRect);
        float f = this.itemCenterPoint.x;
        float f2 = this.itemCenterPoint.y;
        canvas.drawText(charSequence, n, n2, f - Math.abs((float)this.textRect.width()) / 2.0f - (float)this.textRect.left, f2 + Math.abs((float)this.textRect.height()) / 2.0f - (float)this.textRect.bottom, paint);
    }

    private /* varargs */ int getLineColorForState(int ... arrn) {
        ColorStateList colorStateList = this.lineColor;
        if (colorStateList != null) {
            return colorStateList.getColorForState(arrn, this.cursorLineColor);
        }
        return this.cursorLineColor;
    }

    private Paint getPaintByIndex(int n) {
        if (this.getText() != null && this.isAnimationEnable && n == -1 + this.getText().length()) {
            this.animatorTextPaint.setColor(this.getPaint().getColor());
            return this.animatorTextPaint;
        }
        return this.getPaint();
    }

    private void invalidateCursor(boolean bl) {
        if (this.drawCursor != bl) {
            this.drawCursor = bl;
            this.invalidate();
        }
    }

    private static boolean isNumberInputType(int n) {
        return n == 2;
    }

    private static boolean isPasswordInputType(int n) {
        int n2 = n & 4095;
        return n2 == 129 || n2 == 225 || n2 == 18;
        {
        }
    }

    private void makeBlink() {
        if (this.shouldBlink()) {
            if (this.blink == null) {
                this.blink = new Runnable(){
                    private boolean cancelled;

                    private void cancel() {
                        if (!this.cancelled) {
                            OtpView.this.removeCallbacks((Runnable)this);
                            this.cancelled = true;
                        }
                    }

                    private void unCancel() {
                        this.cancelled = false;
                    }

                    public void run() {
                        if (this.cancelled) {
                            return;
                        }
                        OtpView.this.removeCallbacks((Runnable)this);
                        if (OtpView.this.shouldBlink()) {
                            OtpView otpView = OtpView.this;
                            otpView.invalidateCursor(true ^ otpView.drawCursor);
                            OtpView.this.postDelayed((Runnable)this, 500L);
                        }
                    }
                };
            }
            this.removeCallbacks((Runnable)this.blink);
            this.drawCursor = false;
            this.postDelayed((Runnable)this.blink, 500L);
            return;
        }
        Blink blink = this.blink;
        if (blink != null) {
            this.removeCallbacks((Runnable)blink);
        }
    }

    private void moveSelectionToEnd() {
        if (this.getText() != null) {
            this.setSelection(this.getText().length());
        }
    }

    private void resumeBlink() {
        Blink blink = this.blink;
        if (blink != null) {
            blink.unCancel();
            this.makeBlink();
        }
    }

    private void setMaxLength(int n) {
        InputFilter[] arrinputFilter = n >= 0 ? new InputFilter[]{new InputFilter.LengthFilter(n)} : NO_FILTERS;
        this.setFilters(arrinputFilter);
    }

    private void setupAnimator() {
        ValueAnimator valueAnimator;
        this.defaultAddAnimator = valueAnimator = ValueAnimator.ofFloat((float[])new float[]{0.5f, 1.0f});
        valueAnimator.setDuration(150L);
        this.defaultAddAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
        this.defaultAddAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this){
            final /* synthetic */ OtpView this$0;
            {
                this.this$0 = otpView;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                int n = (int)(255.0f * f);
                OtpView.access$000(this.this$0).setTextSize(f * this.this$0.getTextSize());
                OtpView.access$000(this.this$0).setAlpha(n);
                this.this$0.postInvalidate();
            }
        });
    }

    private boolean shouldBlink() {
        return this.isCursorVisible() && this.isFocused();
    }

    private void suspendBlink() {
        Blink blink = this.blink;
        if (blink != null) {
            blink.cancel();
            this.invalidateCursor(false);
        }
    }

    private void updateCenterPoint() {
        float f = this.itemBorderRect.left + Math.abs((float)this.itemBorderRect.width()) / 2.0f;
        float f2 = this.itemBorderRect.top + Math.abs((float)this.itemBorderRect.height()) / 2.0f;
        this.itemCenterPoint.set(f, f2);
    }

    private void updateColors() {
        ColorStateList colorStateList = this.lineColor;
        int n = colorStateList != null ? colorStateList.getColorForState(this.getDrawableState(), 0) : this.getCurrentTextColor();
        int n2 = this.cursorLineColor;
        boolean bl = false;
        if (n != n2) {
            this.cursorLineColor = n;
            bl = true;
        }
        if (bl) {
            this.invalidate();
        }
    }

    private void updateCursorHeight() {
        float f;
        int n = 2 * this.dpToPx();
        float f2 = (float)this.otpViewItemHeight - this.getTextSize();
        float f3 = f2 > (f = (float)n) ? f + this.getTextSize() : this.getTextSize();
        this.cursorHeight = f3;
    }

    private void updateItemRectF(int n) {
        float f = (float)this.lineWidth / 2.0f;
        int n2 = this.getScrollX() + ViewCompat.getPaddingStart((View)this);
        int n3 = this.otpViewItemSpacing;
        float f2 = f + (float)(n2 + n * (n3 + this.otpViewItemWidth));
        if (n3 == 0 && n > 0) {
            f2 -= (float)(n * this.lineWidth);
        }
        float f3 = f2 + (float)this.otpViewItemWidth - (float)this.lineWidth;
        float f4 = f + (float)(this.getScrollY() + this.getPaddingTop());
        float f5 = f4 + (float)this.otpViewItemHeight - (float)this.lineWidth;
        this.itemBorderRect.set(f2, f4, f3, f5);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void updateOtpViewBoxPath(int var1_1) {
        block2 : {
            if (this.otpViewItemSpacing == 0) break block2;
            var3_2 = true;
            ** GOTO lbl8
        }
        var2_4 = var1_1 == 0 && var1_1 != this.otpViewItemCount - 1;
        if (var1_1 == this.otpViewItemCount - 1 && var1_1 != 0) {
            var3_2 = var2_4;
lbl8: // 2 sources:
            var4_3 = true;
        } else {
            var3_2 = var2_4;
            var4_3 = false;
        }
        var5_5 = this.itemBorderRect;
        var6_6 = this.otpViewItemRadius;
        this.updateRoundRectPath(var5_5, var6_6, var6_6, var3_2, var4_3);
    }

    private void updatePaints() {
        this.paint.setColor(this.cursorLineColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth((float)this.lineWidth);
        this.getPaint().setColor(this.getCurrentTextColor());
    }

    private void updateRoundRectPath(RectF rectF, float f, float f2, boolean bl, boolean bl2) {
        this.updateRoundRectPath(rectF, f, f2, bl, bl2, bl2, bl);
    }

    private void updateRoundRectPath(RectF rectF, float f, float f2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.path.reset();
        float f3 = rectF.left;
        float f4 = rectF.top;
        float f5 = rectF.right;
        float f6 = rectF.bottom;
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        float f9 = f7 - f * 2.0f;
        float f10 = f8 - 2.0f * f2;
        this.path.moveTo(f3, f4 + f2);
        if (bl) {
            Path path = this.path;
            float f11 = -f2;
            path.rQuadTo(0.0f, f11, f, f11);
        } else {
            this.path.rLineTo(0.0f, -f2);
            this.path.rLineTo(f, 0.0f);
        }
        this.path.rLineTo(f9, 0.0f);
        if (bl2) {
            this.path.rQuadTo(f, 0.0f, f, f2);
        } else {
            this.path.rLineTo(f, 0.0f);
            this.path.rLineTo(0.0f, f2);
        }
        this.path.rLineTo(0.0f, f10);
        if (bl3) {
            this.path.rQuadTo(0.0f, f2, -f, f2);
        } else {
            this.path.rLineTo(0.0f, f2);
            this.path.rLineTo(-f, 0.0f);
        }
        this.path.rLineTo(-f9, 0.0f);
        if (bl4) {
            Path path = this.path;
            float f12 = -f;
            path.rQuadTo(f12, 0.0f, f12, -f2);
        } else {
            this.path.rLineTo(-f, 0.0f);
            this.path.rLineTo(0.0f, -f2);
        }
        this.path.rLineTo(0.0f, -f10);
        this.path.close();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.lineColor;
        if (colorStateList == null || colorStateList.isStateful()) {
            this.updateColors();
        }
    }

    public int getCurrentLineColor() {
        return this.cursorLineColor;
    }

    public int getCursorColor() {
        return this.cursorColor;
    }

    public int getCursorWidth() {
        return this.cursorWidth;
    }

    protected MovementMethod getDefaultMovementMethod() {
        return DefaultMovementMethod.getInstance();
    }

    public int getItemCount() {
        return this.otpViewItemCount;
    }

    public int getItemHeight() {
        return this.otpViewItemHeight;
    }

    public int getItemRadius() {
        return this.otpViewItemRadius;
    }

    public int getItemSpacing() {
        return this.otpViewItemSpacing;
    }

    public int getItemWidth() {
        return this.otpViewItemWidth;
    }

    public ColorStateList getLineColors() {
        return this.lineColor;
    }

    public int getLineWidth() {
        return this.lineWidth;
    }

    public String getMaskingChar() {
        return this.maskingChar;
    }

    public int getOtpMaxCount() {
        return this.otpViewItemCount;
    }

    public boolean isCursorVisible() {
        return this.isCursorVisible;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.resumeBlink();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.suspendBlink();
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        this.updatePaints();
        this.drawOtpView(canvas);
        canvas.restore();
    }

    protected void onFocusChanged(boolean bl, int n, Rect rect) {
        super.onFocusChanged(bl, n, rect);
        if (bl) {
            this.moveSelectionToEnd();
            this.makeBlink();
        }
    }

    protected void onMeasure(int n, int n2) {
        int n3 = MeasureSpec.getMode((int)n);
        int n4 = MeasureSpec.getMode((int)n2);
        int n5 = MeasureSpec.getSize((int)n);
        int n6 = MeasureSpec.getSize((int)n2);
        int n7 = this.otpViewItemHeight;
        if (n3 != 1073741824) {
            int n8 = this.otpViewItemCount;
            n5 = (n8 - 1) * this.otpViewItemSpacing + n8 * this.otpViewItemWidth + ViewCompat.getPaddingEnd((View)this) + ViewCompat.getPaddingStart((View)this);
            if (this.otpViewItemSpacing == 0) {
                n5 -= (-1 + this.otpViewItemCount) * this.lineWidth;
            }
        }
        if (n4 != 1073741824) {
            n6 = n7 + this.getPaddingTop() + this.getPaddingBottom();
        }
        this.setMeasuredDimension(n5, n6);
    }

    public void onScreenStateChanged(int n) {
        super.onScreenStateChanged(n);
        if (n == 1) {
            this.resumeBlink();
            return;
        }
        if (n == 0) {
            this.suspendBlink();
        }
    }

    protected void onSelectionChanged(int n, int n2) {
        super.onSelectionChanged(n, n2);
        if (this.getText() != null && n2 != this.getText().length()) {
            this.moveSelectionToEnd();
        }
    }

    protected void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        OnOtpCompletionListener onOtpCompletionListener;
        ValueAnimator valueAnimator;
        boolean bl;
        OnOtpCompletionListener onOtpCompletionListener2;
        if (n != charSequence.length()) {
            this.moveSelectionToEnd();
        }
        if (charSequence.length() == this.otpViewItemCount && (onOtpCompletionListener2 = this.onOtpCompletionListener) != null) {
            onOtpCompletionListener2.onOtpCompleted(charSequence.toString());
        }
        if ((onOtpCompletionListener = this.onOtpCompletionListener) != null) {
            onOtpCompletionListener.onOtpChanged(charSequence.toString());
        }
        this.makeBlink();
        if (this.isAnimationEnable && (bl = n3 - n2 > 0) && (valueAnimator = this.defaultAddAnimator) != null) {
            valueAnimator.end();
            this.defaultAddAnimator.start();
        }
    }

    public void setAnimationEnable(boolean bl) {
        this.isAnimationEnable = bl;
    }

    public void setCursorColor(int n) {
        this.cursorColor = n;
        if (this.isCursorVisible()) {
            this.invalidateCursor(true);
        }
    }

    public void setCursorVisible(boolean bl) {
        if (this.isCursorVisible != bl) {
            this.isCursorVisible = bl;
            this.invalidateCursor(bl);
            this.makeBlink();
        }
    }

    public void setCursorWidth(int n) {
        this.cursorWidth = n;
        if (this.isCursorVisible()) {
            this.invalidateCursor(true);
        }
    }

    public void setHideLineWhenFilled(boolean bl) {
        this.hideLineWhenFilled = bl;
    }

    public void setItemBackground(Drawable drawable) {
        this.itemBackgroundResource = 0;
        this.itemBackground = drawable;
        this.invalidate();
    }

    public void setItemBackgroundColor(int n) {
        Drawable drawable = this.itemBackground;
        if (drawable instanceof ColorDrawable) {
            ((ColorDrawable)drawable.mutate()).setColor(n);
            this.itemBackgroundResource = 0;
            return;
        }
        this.setItemBackground((Drawable)new ColorDrawable(n));
    }

    public void setItemBackgroundResources(int n) {
        Drawable drawable;
        if (n != 0 && this.itemBackgroundResource != n) {
            return;
        }
        this.itemBackground = drawable = ResourcesCompat.getDrawable((Resources)this.getResources(), (int)n, (Resources.Theme)this.getContext().getTheme());
        this.setItemBackground(drawable);
        this.itemBackgroundResource = n;
    }

    public void setItemCount(int n) {
        this.otpViewItemCount = n;
        this.setMaxLength(n);
        this.requestLayout();
    }

    public void setItemHeight(int n) {
        this.otpViewItemHeight = n;
        this.updateCursorHeight();
        this.requestLayout();
    }

    public void setItemRadius(int n) {
        this.otpViewItemRadius = n;
        this.checkItemRadius();
        this.requestLayout();
    }

    public void setItemSpacing(int n) {
        this.otpViewItemSpacing = n;
        this.requestLayout();
    }

    public void setItemWidth(int n) {
        this.otpViewItemWidth = n;
        this.checkItemRadius();
        this.requestLayout();
    }

    public void setLineColor(int n) {
        this.lineColor = ColorStateList.valueOf((int)n);
        this.updateColors();
    }

    public void setLineColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.lineColor = colorStateList;
            this.updateColors();
            return;
        }
        throw new IllegalArgumentException("Color cannot be null");
    }

    public void setLineWidth(int n) {
        this.lineWidth = n;
        this.checkItemRadius();
        this.requestLayout();
    }

    public void setMaskingChar(String string) {
        this.maskingChar = string;
        this.requestLayout();
    }

    public void setOtpCompletionListener(OnOtpCompletionListener onOtpCompletionListener) {
        this.onOtpCompletionListener = onOtpCompletionListener;
    }

    public void setTextSize(float f) {
        super.setTextSize(f);
        this.updateCursorHeight();
    }

    public void setTextSize(int n, float f) {
        super.setTextSize(n, f);
        this.updateCursorHeight();
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        TextPaint textPaint = this.animatorTextPaint;
        if (textPaint != null) {
            textPaint.set(this.getPaint());
        }
    }

    public void setTypeface(Typeface typeface, int n) {
        super.setTypeface(typeface, n);
    }

}

