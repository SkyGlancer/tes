/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  androidx.core.content.ContextCompat
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;

public class HorizontalProgressWheelView
extends View {
    private final Rect mCanvasClipBounds = new Rect();
    private float mLastTouchedPosition;
    private int mMiddleLineColor;
    private int mProgressLineHeight;
    private int mProgressLineMargin;
    private Paint mProgressLinePaint;
    private int mProgressLineWidth;
    private boolean mScrollStarted;
    private ScrollingListener mScrollingListener;
    private float mTotalScrollDistance;

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
    }

    private void init() {
        Paint paint;
        this.mMiddleLineColor = ContextCompat.getColor((Context)this.getContext(), (int)R.color.ucrop_color_progress_wheel_line);
        this.mProgressLineWidth = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.mProgressLineHeight = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.mProgressLineMargin = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        this.mProgressLinePaint = paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        this.mProgressLinePaint.setStrokeWidth((float)this.mProgressLineWidth);
    }

    private void onScrollEvent(MotionEvent motionEvent, float f) {
        this.mTotalScrollDistance -= f;
        this.postInvalidate();
        this.mLastTouchedPosition = motionEvent.getX();
        ScrollingListener scrollingListener = this.mScrollingListener;
        if (scrollingListener != null) {
            scrollingListener.onScroll(-f, this.mTotalScrollDistance);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mCanvasClipBounds);
        int n = this.mCanvasClipBounds.width();
        int n2 = this.mProgressLineWidth;
        int n3 = this.mProgressLineMargin;
        int n4 = n / (n2 + n3);
        float f = this.mTotalScrollDistance % (float)(n3 + n2);
        this.mProgressLinePaint.setColor(this.getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        for (int i = 0; i < n4; ++i) {
            int n5 = n4 / 4;
            if (i < n5) {
                this.mProgressLinePaint.setAlpha((int)(255.0f * ((float)i / (float)n5)));
            } else if (i > n4 * 3 / 4) {
                this.mProgressLinePaint.setAlpha((int)(255.0f * ((float)(n4 - i) / (float)n5)));
            } else {
                this.mProgressLinePaint.setAlpha(255);
            }
            float f2 = -f;
            canvas.drawLine(f2 + (float)this.mCanvasClipBounds.left + (float)(i * (this.mProgressLineWidth + this.mProgressLineMargin)), (float)this.mCanvasClipBounds.centerY() - (float)this.mProgressLineHeight / 4.0f, f2 + (float)this.mCanvasClipBounds.left + (float)(i * (this.mProgressLineWidth + this.mProgressLineMargin)), (float)this.mCanvasClipBounds.centerY() + (float)this.mProgressLineHeight / 4.0f, this.mProgressLinePaint);
        }
        this.mProgressLinePaint.setColor(this.mMiddleLineColor);
        canvas.drawLine((float)this.mCanvasClipBounds.centerX(), (float)this.mCanvasClipBounds.centerY() - (float)this.mProgressLineHeight / 2.0f, (float)this.mCanvasClipBounds.centerX(), (float)this.mCanvasClipBounds.centerY() + (float)this.mProgressLineHeight / 2.0f, this.mProgressLinePaint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getAction();
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    return true;
                }
                float f = motionEvent.getX() - this.mLastTouchedPosition;
                if (f != 0.0f) {
                    if (!this.mScrollStarted) {
                        this.mScrollStarted = true;
                        ScrollingListener scrollingListener = this.mScrollingListener;
                        if (scrollingListener != null) {
                            scrollingListener.onScrollStart();
                        }
                    }
                    this.onScrollEvent(motionEvent, f);
                    return true;
                }
            } else {
                ScrollingListener scrollingListener = this.mScrollingListener;
                if (scrollingListener != null) {
                    this.mScrollStarted = false;
                    scrollingListener.onScrollEnd();
                    return true;
                }
            }
        } else {
            this.mLastTouchedPosition = motionEvent.getX();
        }
        return true;
    }

    public void setMiddleLineColor(int n) {
        this.mMiddleLineColor = n;
        this.invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.mScrollingListener = scrollingListener;
    }

    public static interface ScrollingListener {
        public void onScroll(float var1, float var2);

        public void onScrollEnd();

        public void onScrollStart();
    }

}

