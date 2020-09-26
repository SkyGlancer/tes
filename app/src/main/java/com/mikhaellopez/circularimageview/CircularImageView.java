/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewOutlineProvider
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  androidx.appcompat.widget.AppCompatImageView
 *  com.mikhaellopez.circularimageview.CircularImageView$manageElevation
 *  dalvik.annotation.SourceDebugExtension
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.math.MathKt
 *  kotlin.ranges.RangesKt
 */
package app.dukhaan.src.java.com.mikhaellopez.circularimageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.mikhaellopez.circularimageview.CircularImageView$WhenMappings;
import com.mikhaellopez.circularimageview.R;
import dalvik.annotation.SourceDebugExtension;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@SourceDebugExtension(value="SMAP\nCircularImageView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircularImageView.kt\ncom/mikhaellopez/circularimageview/CircularImageView\n*L\n1#1,504:1\n*E\n")
@Metadata(bv={1, 0, 3}, d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 |2\u00020\u0001:\u0003|}~B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u0002082\u0006\u0010T\u001a\u00020\u0007H\u0002J\u0018\u0010U\u001a\u00020R2\u0006\u0010S\u001a\u0002082\u0006\u0010T\u001a\u00020\u0007H\u0002J \u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u000fH\u0002J\b\u0010[\u001a\u00020\\H\u0002J\u0014\u0010]\u001a\u0004\u0018\u0001082\b\u0010^\u001a\u0004\u0018\u000106H\u0002J\u0018\u0010_\u001a\u00020R2\u0006\u0010S\u001a\u0002082\u0006\u0010T\u001a\u00020\u0007H\u0002J\b\u0010`\u001a\u00020aH\u0016J\"\u0010b\u001a\u00020\\2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010c\u001a\u00020\\H\u0002J\b\u0010d\u001a\u00020\\H\u0002J\b\u0010e\u001a\u00020\\H\u0002J\b\u0010f\u001a\u00020\\H\u0002J\u0010\u0010g\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u0007H\u0002J\u0010\u0010i\u001a\u00020\\2\u0006\u0010j\u001a\u00020kH\u0014J\u0018\u0010l\u001a\u00020\\2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0007H\u0014J(\u0010o\u001a\u00020\\2\u0006\u0010p\u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u0007H\u0014J\u0012\u0010t\u001a\u00020\\2\b\u0010u\u001a\u0004\u0018\u000101H\u0016J\u0010\u0010v\u001a\u00020\\2\u0006\u0010w\u001a\u00020aH\u0016J\b\u0010x\u001a\u00020\\H\u0002J\b\u0010y\u001a\u00020\\H\u0002J\f\u0010z\u001a\u00020\u000f*\u00020\u0007H\u0002J\f\u0010{\u001a\u00020H*\u00020\u0007H\u0002R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u001e@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR$\u0010(\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R*\u0010+\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R*\u0010.\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019R\"\u00102\u001a\u0004\u0018\u0001012\b\u0010\t\u001a\u0004\u0018\u000101@BX\u0082\u000e\u00a2\u0006\b\n\u0000\"\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020;X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020;X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010?\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\f\"\u0004\bA\u0010\u000eR$\u0010C\u001a\u00020B2\u0006\u0010\t\u001a\u00020B@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010I\u001a\u00020H2\u0006\u0010\t\u001a\u00020H@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010N\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u001e@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010!\"\u0004\bP\u0010#\u00a8\u0006"}, d2={"Lcom/mikhaellopez/circularimageview/CircularImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "borderColor", "getBorderColor", "()I", "setBorderColor", "(I)V", "Lcom/mikhaellopez/circularimageview/CircularImageView$GradientDirection;", "borderColorDirection", "getBorderColorDirection", "()Lcom/mikhaellopez/circularimageview/CircularImageView$GradientDirection;", "setBorderColorDirection", "(Lcom/mikhaellopez/circularimageview/CircularImageView$GradientDirection;)V", "borderColorEnd", "getBorderColorEnd", "()Ljava/lang/Integer;", "setBorderColorEnd", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "borderColorStart", "getBorderColorStart", "setBorderColorStart", "", "borderWidth", "getBorderWidth", "()F", "setBorderWidth", "(F)V", "circleCenter", "circleColor", "getCircleColor", "setCircleColor", "circleColorDirection", "getCircleColorDirection", "setCircleColorDirection", "circleColorEnd", "getCircleColorEnd", "setCircleColorEnd", "circleColorStart", "getCircleColorStart", "setCircleColorStart", "Landroid/graphics/ColorFilter;", "civColorFilter", "setCivColorFilter", "(Landroid/graphics/ColorFilter;)V", "civDrawable", "Landroid/graphics/drawable/Drawable;", "civImage", "Landroid/graphics/Bitmap;", "heightCircle", "paint", "Landroid/graphics/Paint;", "paintBackground", "paintBorder", "paintShadow", "shadowColor", "getShadowColor", "setShadowColor", "", "shadowEnable", "getShadowEnable", "()Z", "setShadowEnable", "(Z)V", "Lcom/mikhaellopez/circularimageview/CircularImageView$ShadowGravity;", "shadowGravity", "getShadowGravity", "()Lcom/mikhaellopez/circularimageview/CircularImageView$ShadowGravity;", "setShadowGravity", "(Lcom/mikhaellopez/circularimageview/CircularImageView$ShadowGravity;)V", "shadowRadius", "getShadowRadius", "setShadowRadius", "centerCrop", "Landroid/graphics/Matrix;", "bitmap", "viewSize", "centerInside", "createLinearGradient", "Landroid/graphics/LinearGradient;", "startColor", "endColor", "gradientDirection", "drawShadow", "", "drawableToBitmap", "drawable", "fitCenter", "getScaleType", "Landroid/widget/ImageView$ScaleType;", "init", "loadBitmap", "manageBorderColor", "manageCircleColor", "manageElevation", "measure", "measureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setColorFilter", "colorFilter", "setScaleType", "scaleType", "update", "updateShader", "toGradientDirection", "toShadowGravity", "Companion", "GradientDirection", "ShadowGravity", "circularimageview_release"}, k=1, mv={1, 1, 16})
public final class CircularImageView
extends AppCompatImageView {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final float DEFAULT_BORDER_WIDTH = 4.0f;
    private static final float DEFAULT_SHADOW_RADIUS = 8.0f;
    private int borderColor;
    private GradientDirection borderColorDirection;
    private Integer borderColorEnd;
    private Integer borderColorStart;
    private float borderWidth;
    private int circleCenter;
    private int circleColor;
    private GradientDirection circleColorDirection;
    private Integer circleColorEnd;
    private Integer circleColorStart;
    private ColorFilter civColorFilter;
    private Drawable civDrawable;
    private Bitmap civImage;
    private int heightCircle;
    private final Paint paint;
    private final Paint paintBackground;
    private final Paint paintBorder;
    private final Paint paintShadow;
    private int shadowColor;
    private boolean shadowEnable;
    private ShadowGravity shadowGravity;
    private float shadowRadius;

    public CircularImageView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int n) {
        Intrinsics.checkParameterIsNotNull((Object)context, (String)"context");
        super(context, attributeSet, n);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.paint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        this.paintBorder = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        this.paintShadow = paint3;
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        this.paintBackground = paint4;
        this.circleColor = -1;
        this.circleColorDirection = GradientDirection.LEFT_TO_RIGHT;
        this.borderColor = -16777216;
        this.borderColorDirection = GradientDirection.LEFT_TO_RIGHT;
        this.shadowColor = -16777216;
        this.shadowGravity = ShadowGravity.BOTTOM;
        this.init(context, attributeSet, n);
    }

    public /* synthetic */ CircularImageView(Context context, AttributeSet attributeSet, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            attributeSet = null;
        }
        if ((n2 & 4) != 0) {
            n = 0;
        }
        this(context, attributeSet, n);
    }

    public static final /* synthetic */ int access$getHeightCircle$p(CircularImageView circularImageView) {
        return circularImageView.heightCircle;
    }

    public static final /* synthetic */ void access$setHeightCircle$p(CircularImageView circularImageView, int n) {
        circularImageView.heightCircle = n;
    }

    private final Matrix centerCrop(Bitmap bitmap, int n) {
        float f;
        float f2;
        Matrix matrix = new Matrix();
        int n2 = n * bitmap.getWidth();
        int n3 = n * bitmap.getHeight();
        float f3 = 0.0f;
        if (n2 > n3) {
            float f4 = n;
            f2 = f4 / (float)bitmap.getHeight();
            f3 = 0.5f * (f4 - f2 * (float)bitmap.getWidth());
            f = 0.0f;
        } else {
            float f5 = n;
            f2 = f5 / (float)bitmap.getWidth();
            f = 0.5f * (f5 - f2 * (float)bitmap.getHeight());
        }
        matrix.setScale(f2, f2);
        matrix.postTranslate(f3, f);
        return matrix;
    }

    private final Matrix centerInside(Bitmap bitmap, int n) {
        float f;
        Matrix matrix = new Matrix();
        if (bitmap.getWidth() <= n && bitmap.getHeight() <= n) {
            f = 1.0f;
        } else {
            float f2 = n;
            f = RangesKt.coerceAtMost((float)(f2 / (float)bitmap.getWidth()), (float)(f2 / (float)bitmap.getHeight()));
        }
        float f3 = n;
        float f4 = MathKt.roundToInt((float)(0.5f * (f3 - f * (float)bitmap.getWidth())));
        float f5 = MathKt.roundToInt((float)(0.5f * (f3 - f * (float)bitmap.getHeight())));
        matrix.setScale(f, f);
        matrix.postTranslate(f4, f5);
        return matrix;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final LinearGradient createLinearGradient(int n, int n2, GradientDirection gradientDirection) {
        float f;
        float f2;
        float f3;
        float f4;
        block6 : {
            block0 : {
                block5 : {
                    block4 : {
                        block1 : {
                            block2 : {
                                block3 : {
                                    int n3 = CircularImageView$WhenMappings.$EnumSwitchMapping$0[gradientDirection.ordinal()];
                                    if (n3 == 1) break block0;
                                    if (n3 == 2) break block1;
                                    if (n3 == 3) break block2;
                                    if (n3 == 4) break block3;
                                    f = 0.0f;
                                    break block4;
                                }
                                f4 = this.getHeight();
                                f = 0.0f;
                                break block5;
                            }
                            f3 = this.getHeight();
                            f = 0.0f;
                            f4 = 0.0f;
                            f2 = 0.0f;
                            return new LinearGradient(f, f4, f2, f3, n, n2, Shader.TileMode.CLAMP);
                        }
                        f = this.getWidth();
                    }
                    f4 = 0.0f;
                }
                f2 = 0.0f;
                break block6;
            }
            f2 = this.getWidth();
            f = 0.0f;
            f4 = 0.0f;
        }
        f3 = 0.0f;
        return new LinearGradient(f, f4, f2, f3, n, n2, Shader.TileMode.CLAMP);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void drawShadow() {
        float f;
        float f2;
        block6 : {
            float f3;
            block7 : {
                block1 : {
                    block2 : {
                        block4 : {
                            float f4;
                            block5 : {
                                block3 : {
                                    if (Build.VERSION.SDK_INT < 28) {
                                        this.setLayerType(1, this.paintShadow);
                                    }
                                    ShadowGravity shadowGravity = this.shadowGravity;
                                    int n = CircularImageView$WhenMappings.$EnumSwitchMapping$1[shadowGravity.ordinal()];
                                    f = 0.0f;
                                    if (n == 2) break block1;
                                    if (n == 3) break block2;
                                    if (n == 4) break block3;
                                    f = 0.0f;
                                    if (n != 5) break block4;
                                    f4 = this.shadowRadius;
                                    break block5;
                                }
                                f4 = -this.shadowRadius;
                            }
                            f = f4 / (float)2;
                        }
                        f2 = 0.0f;
                        break block6;
                    }
                    f3 = this.shadowRadius;
                    break block7;
                }
                f3 = -this.shadowRadius;
            }
            f2 = f3 / (float)2;
        }
        this.paintShadow.setShadowLayer(this.shadowRadius, f, f2, this.shadowColor);
    }

    private final Bitmap drawableToBitmap(Drawable drawable2) {
        if (drawable2 != null) {
            if (drawable2 instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable2;
                return Bitmap.createScaledBitmap((Bitmap)bitmapDrawable.getBitmap(), (int)bitmapDrawable.getIntrinsicWidth(), (int)bitmapDrawable.getIntrinsicHeight(), (boolean)false);
            }
            try {
                Bitmap bitmap = Bitmap.createBitmap((int)drawable2.getIntrinsicWidth(), (int)drawable2.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawable2.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable2.draw(canvas);
                return bitmap;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    private final Matrix fitCenter(Bitmap bitmap, int n) {
        Matrix matrix = new Matrix();
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float)bitmap.getWidth(), (float)bitmap.getHeight());
        RectF rectF2 = new RectF();
        float f = n;
        rectF2.set(0.0f, 0.0f, f, f);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        return matrix;
    }

    private final void init(Context context, AttributeSet attributeSet, int n) {
        int n2;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CircularImageView, n, 0);
        this.setCircleColor(typedArray.getColor(R.styleable.CircularImageView_civ_circle_color, -1));
        int n3 = typedArray.getColor(R.styleable.CircularImageView_civ_circle_color_start, 0);
        if (n3 != 0) {
            this.setCircleColorStart(n3);
        }
        if ((n2 = typedArray.getColor(R.styleable.CircularImageView_civ_circle_color_end, 0)) != 0) {
            this.setCircleColorEnd(n2);
        }
        this.setCircleColorDirection(this.toGradientDirection(typedArray.getInteger(R.styleable.CircularImageView_civ_circle_color_direction, this.circleColorDirection.getValue())));
        if (typedArray.getBoolean(R.styleable.CircularImageView_civ_border, true)) {
            int n4;
            Context context2 = this.getContext();
            Intrinsics.checkExpressionValueIsNotNull((Object)context2, (String)"getContext()");
            Resources resources = context2.getResources();
            Intrinsics.checkExpressionValueIsNotNull((Object)resources, (String)"getContext().resources");
            float f = 4.0f * resources.getDisplayMetrics().density;
            this.setBorderWidth(typedArray.getDimension(R.styleable.CircularImageView_civ_border_width, f));
            this.setBorderColor(typedArray.getColor(R.styleable.CircularImageView_civ_border_color, -1));
            int n5 = typedArray.getColor(R.styleable.CircularImageView_civ_border_color_start, 0);
            if (n5 != 0) {
                this.setBorderColorStart(n5);
            }
            if ((n4 = typedArray.getColor(R.styleable.CircularImageView_civ_border_color_end, 0)) != 0) {
                this.setBorderColorEnd(n4);
            }
            this.setBorderColorDirection(this.toGradientDirection(typedArray.getInteger(R.styleable.CircularImageView_civ_border_color_direction, this.borderColorDirection.getValue())));
        }
        this.setShadowEnable(typedArray.getBoolean(R.styleable.CircularImageView_civ_shadow, this.shadowEnable));
        if (this.shadowEnable) {
            this.setShadowGravity(this.toShadowGravity(typedArray.getInteger(R.styleable.CircularImageView_civ_shadow_gravity, this.shadowGravity.getValue())));
            this.setShadowRadius(typedArray.getFloat(R.styleable.CircularImageView_civ_shadow_radius, 8.0f));
            this.setShadowColor(typedArray.getColor(R.styleable.CircularImageView_civ_shadow_color, this.shadowColor));
        }
        typedArray.recycle();
    }

    private final void loadBitmap() {
        Drawable drawable2;
        if (Intrinsics.areEqual((Object)this.civDrawable, (Object)this.getDrawable())) {
            return;
        }
        this.civDrawable = drawable2 = this.getDrawable();
        this.civImage = this.drawableToBitmap(drawable2);
        this.updateShader();
    }

    private final void manageBorderColor() {
        int n = this.borderWidth == 0.0f ? this.circleColor : this.borderColor;
        Paint paint = this.paintBorder;
        Integer n2 = this.borderColorStart;
        int n3 = n2 != null ? n2 : n;
        Integer n4 = this.borderColorEnd;
        if (n4 != null) {
            n = n4;
        }
        paint.setShader((Shader)this.createLinearGradient(n3, n, this.borderColorDirection));
    }

    private final void manageCircleColor() {
        Paint paint = this.paintBackground;
        Integer n = this.circleColorStart;
        int n2 = n != null ? n : this.circleColor;
        Integer n3 = this.circleColorEnd;
        int n4 = n3 != null ? n3 : this.circleColor;
        paint.setShader((Shader)this.createLinearGradient(n2, n4, this.circleColorDirection));
    }

    private final void manageElevation() {
        if (Build.VERSION.SDK_INT >= 21) {
            ViewOutlineProvider viewOutlineProvider = !this.shadowEnable ? (ViewOutlineProvider)new ViewOutlineProvider(this){
                final /* synthetic */ CircularImageView this$0;
                {
                    this.this$0 = circularImageView;
                }

                public void getOutline(View view, android.graphics.Outline outline) {
                    if (outline != null) {
                        outline.setOval(0, 0, CircularImageView.access$getHeightCircle$p(this.this$0), CircularImageView.access$getHeightCircle$p(this.this$0));
                    }
                }
            } : null;
            this.setOutlineProvider(viewOutlineProvider);
        }
    }

    private final int measure(int n) {
        int n2 = MeasureSpec.getMode((int)n);
        int n3 = MeasureSpec.getSize((int)n);
        if (n2 != Integer.MIN_VALUE && n2 != 1073741824) {
            n3 = this.heightCircle;
        }
        return n3;
    }

    private final void setCivColorFilter(ColorFilter colorFilter) {
        if (true ^ Intrinsics.areEqual((Object)this.civColorFilter, (Object)colorFilter)) {
            this.civColorFilter = colorFilter;
            if (colorFilter != null) {
                this.civDrawable = null;
                this.invalidate();
            }
        }
    }

    private final GradientDirection toGradientDirection(int n) {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n == 4) {
                        return GradientDirection.BOTTOM_TO_TOP;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("This value is not supported for GradientDirection: ");
                    stringBuilder.append(n);
                    throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
                }
                return GradientDirection.TOP_TO_BOTTOM;
            }
            return GradientDirection.RIGHT_TO_LEFT;
        }
        return GradientDirection.LEFT_TO_RIGHT;
    }

    private final ShadowGravity toShadowGravity(int n) {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n == 5) {
                            return ShadowGravity.END;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("This value is not supported for ShadowGravity: ");
                        stringBuilder.append(n);
                        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
                    }
                    return ShadowGravity.START;
                }
                return ShadowGravity.BOTTOM;
            }
            return ShadowGravity.TOP;
        }
        return ShadowGravity.CENTER;
    }

    private final void update() {
        int n;
        if (this.civImage != null) {
            this.updateShader();
        }
        this.heightCircle = n = Math.min((int)(this.getWidth() - (this.getPaddingLeft() + this.getPaddingRight())), (int)(this.getHeight() - (this.getPaddingTop() + this.getPaddingBottom())));
        this.circleCenter = (int)((float)n - this.borderWidth * (float)2) / 2;
        this.manageCircleColor();
        this.manageBorderColor();
        this.manageElevation();
        this.invalidate();
    }

    private final void updateShader() {
        Bitmap bitmap = this.civImage;
        if (bitmap != null) {
            BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            ScaleType scaleType = this.getScaleType();
            int n = CircularImageView$WhenMappings.$EnumSwitchMapping$2[scaleType.ordinal()];
            Matrix matrix = n != 1 ? (n != 2 ? (n != 3 ? new Matrix() : this.fitCenter(bitmap, this.heightCircle)) : this.centerInside(bitmap, this.heightCircle)) : this.centerCrop(bitmap, this.heightCircle);
            bitmapShader.setLocalMatrix(matrix);
            this.paint.setShader((Shader)bitmapShader);
            this.paint.setColorFilter(this.civColorFilter);
        }
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final GradientDirection getBorderColorDirection() {
        return this.borderColorDirection;
    }

    public final Integer getBorderColorEnd() {
        return this.borderColorEnd;
    }

    public final Integer getBorderColorStart() {
        return this.borderColorStart;
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final int getCircleColor() {
        return this.circleColor;
    }

    public final GradientDirection getCircleColorDirection() {
        return this.circleColorDirection;
    }

    public final Integer getCircleColorEnd() {
        return this.circleColorEnd;
    }

    public final Integer getCircleColorStart() {
        return this.circleColorStart;
    }

    public ScaleType getScaleType() {
        ScaleType scaleType = super.getScaleType();
        if (scaleType != null) {
            return scaleType;
        }
        return ScaleType.CENTER_CROP;
    }

    public final int getShadowColor() {
        return this.shadowColor;
    }

    public final boolean getShadowEnable() {
        return this.shadowEnable;
    }

    public final ShadowGravity getShadowGravity() {
        return this.shadowGravity;
    }

    public final float getShadowRadius() {
        return this.shadowRadius;
    }

    protected void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull((Object)canvas, (String)"canvas");
        this.loadBitmap();
        if (this.civImage == null) {
            return;
        }
        float f = (float)this.circleCenter + this.borderWidth;
        float f2 = this.shadowEnable ? this.shadowRadius * (float)2 : 0.0f;
        if (this.shadowEnable) {
            this.drawShadow();
            canvas.drawCircle(f, f, f - f2, this.paintShadow);
        }
        canvas.drawCircle(f, f, f - f2, this.paintBorder);
        canvas.drawCircle(f, f, (float)this.circleCenter - f2, this.paintBackground);
        canvas.drawCircle(f, f, (float)this.circleCenter - f2, this.paint);
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        this.heightCircle = n3 = Math.min((int)(this.measure(n) - (this.getPaddingLeft() + this.getPaddingRight())), (int)(this.measure(n2) - (this.getPaddingTop() + this.getPaddingBottom())));
        this.setMeasuredDimension(n3, n3);
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        this.update();
    }

    public final void setBorderColor(int n) {
        this.borderColor = n;
        this.manageBorderColor();
        this.invalidate();
    }

    public final void setBorderColorDirection(GradientDirection gradientDirection) {
        Intrinsics.checkParameterIsNotNull((Object)((Object)gradientDirection), (String)"value");
        this.borderColorDirection = gradientDirection;
        this.manageBorderColor();
        this.invalidate();
    }

    public final void setBorderColorEnd(Integer n) {
        this.borderColorEnd = n;
        this.manageBorderColor();
        this.invalidate();
    }

    public final void setBorderColorStart(Integer n) {
        this.borderColorStart = n;
        this.manageBorderColor();
        this.invalidate();
    }

    public final void setBorderWidth(float f) {
        this.borderWidth = f;
        this.update();
    }

    public final void setCircleColor(int n) {
        this.circleColor = n;
        this.manageCircleColor();
        this.invalidate();
    }

    public final void setCircleColorDirection(GradientDirection gradientDirection) {
        Intrinsics.checkParameterIsNotNull((Object)((Object)gradientDirection), (String)"value");
        this.circleColorDirection = gradientDirection;
        this.manageCircleColor();
        this.invalidate();
    }

    public final void setCircleColorEnd(Integer n) {
        this.circleColorEnd = n;
        this.manageCircleColor();
        this.invalidate();
    }

    public final void setCircleColorStart(Integer n) {
        this.circleColorStart = n;
        this.manageCircleColor();
        this.invalidate();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.setCivColorFilter(colorFilter);
    }

    public void setScaleType(ScaleType scaleType) {
        Intrinsics.checkParameterIsNotNull((Object)scaleType, (String)"scaleType");
        Object[] arrobject = new ScaleType[]{ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE, ScaleType.FIT_CENTER};
        if (CollectionsKt.listOf((Object[])arrobject).contains((Object)scaleType)) {
            super.setScaleType(scaleType);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScaleType ");
        stringBuilder.append((Object)scaleType);
        stringBuilder.append(" not supported. Just ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE & ScaleType.FIT_CENTER are available for this library.");
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public final void setShadowColor(int n) {
        this.shadowColor = n;
        this.paintShadow.setColor(n);
        this.invalidate();
    }

    public final void setShadowEnable(boolean bl) {
        this.shadowEnable = bl;
        if (bl && this.shadowRadius == 0.0f) {
            this.setShadowRadius(8.0f);
        }
        this.update();
    }

    public final void setShadowGravity(ShadowGravity shadowGravity) {
        Intrinsics.checkParameterIsNotNull((Object)((Object)shadowGravity), (String)"value");
        this.shadowGravity = shadowGravity;
        this.invalidate();
    }

    public final void setShadowRadius(float f) {
        this.shadowRadius = f;
        boolean bl = f > 0.0f;
        this.setShadowEnable(bl);
    }

}

