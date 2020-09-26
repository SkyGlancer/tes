/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package app.dukhaan.src.java.com.jaredrummler.android.colorpicker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class AlphaPatternDrawable
extends Drawable {
    private Bitmap bitmap;
    private int numRectanglesHorizontal;
    private int numRectanglesVertical;
    private Paint paint = new Paint();
    private Paint paintGray = new Paint();
    private Paint paintWhite = new Paint();
    private int rectangleSize = 10;

    AlphaPatternDrawable(int n) {
        this.rectangleSize = n;
        this.paintWhite.setColor(-1);
        this.paintGray.setColor(-3421237);
    }

    private void generatePatternBitmap() {
        if (this.getBounds().width() > 0) {
            if (this.getBounds().height() <= 0) {
                return;
            }
            this.bitmap = Bitmap.createBitmap((int)this.getBounds().width(), (int)this.getBounds().height(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.bitmap);
            Rect rect = new Rect();
            boolean bl = true;
            for (int i = 0; i <= this.numRectanglesVertical; ++i) {
                boolean bl2 = bl;
                for (int j = 0; j <= this.numRectanglesHorizontal; ++j) {
                    rect.top = i * this.rectangleSize;
                    rect.left = j * this.rectangleSize;
                    rect.bottom = rect.top + this.rectangleSize;
                    rect.right = rect.left + this.rectangleSize;
                    Paint paint = bl2 ? this.paintWhite : this.paintGray;
                    canvas.drawRect(rect, paint);
                    bl2 ^= true;
                }
                bl ^= true;
            }
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.bitmap, null, this.getBounds(), this.paint);
        }
    }

    public int getOpacity() {
        return 0;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int n = rect.height();
        this.numRectanglesHorizontal = (int)Math.ceil((double)(rect.width() / this.rectangleSize));
        this.numRectanglesVertical = (int)Math.ceil((double)(n / this.rectangleSize));
        this.generatePatternBitmap();
    }

    public void setAlpha(int n) {
        throw new UnsupportedOperationException("Alpha is not supported by this drawable.");
    }

    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException("ColorFilter is not supported by this drawable.");
    }
}

