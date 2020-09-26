/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  androidx.collection.LongSparseArray
 *  androidx.collection.SparseArrayCompat
 *  com.airbnb.lottie.TextDelegate
 *  com.airbnb.lottie.animation.content.ContentGroup
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
 *  com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation
 *  com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation
 *  com.airbnb.lottie.model.DocumentData
 *  com.airbnb.lottie.model.DocumentData$Justification
 *  com.airbnb.lottie.model.Font
 *  com.airbnb.lottie.model.FontCharacter
 *  com.airbnb.lottie.model.animatable.AnimatableColorValue
 *  com.airbnb.lottie.model.animatable.AnimatableFloatValue
 *  com.airbnb.lottie.model.animatable.AnimatableTextFrame
 *  com.airbnb.lottie.model.animatable.AnimatableTextProperties
 *  com.airbnb.lottie.model.content.ShapeGroup
 *  com.airbnb.lottie.model.layer.BaseLayer
 *  com.airbnb.lottie.model.layer.Layer
 *  com.airbnb.lottie.model.layer.TextLayer$1
 *  com.airbnb.lottie.model.layer.TextLayer$2
 *  com.airbnb.lottie.model.layer.TextLayer$3
 *  com.airbnb.lottie.utils.Utils
 *  com.airbnb.lottie.value.LottieValueCallback
 *  java.lang.Character
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package app.dukhaan.src.java.com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.TextLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextLayer
extends BaseLayer {
    private final LongSparseArray<String> codePointCache = new LongSparseArray();
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<Integer, Integer> colorCallbackAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter = new HashMap();
    private final Paint fillPaint = new 1(this, 1);
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix = new Matrix();
    private final RectF rectF = new RectF();
    private final StringBuilder stringBuilder = new StringBuilder(2);
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    private BaseKeyframeAnimation<Integer, Integer> strokeColorCallbackAnimation;
    private final Paint strokePaint = new 2(this, 1);
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    private BaseKeyframeAnimation<Float, Float> strokeWidthCallbackAnimation;
    private final TextKeyframeAnimation textAnimation;
    private BaseKeyframeAnimation<Float, Float> textSizeAnimation;
    private BaseKeyframeAnimation<Float, Float> textSizeCallbackAnimation;
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;
    private BaseKeyframeAnimation<Float, Float> trackingCallbackAnimation;

    TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        TextKeyframeAnimation textKeyframeAnimation;
        super(lottieDrawable, layer);
        this.lottieDrawable = lottieDrawable;
        this.composition = layer.getComposition();
        this.textAnimation = textKeyframeAnimation = layer.getText().createAnimation();
        textKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
        this.addAnimation((BaseKeyframeAnimation)this.textAnimation);
        AnimatableTextProperties animatableTextProperties = layer.getTextProperties();
        if (animatableTextProperties != null && animatableTextProperties.color != null) {
            BaseKeyframeAnimation baseKeyframeAnimation;
            this.colorAnimation = baseKeyframeAnimation = animatableTextProperties.color.createAnimation();
            baseKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.addAnimation(this.colorAnimation);
        }
        if (animatableTextProperties != null && animatableTextProperties.stroke != null) {
            BaseKeyframeAnimation baseKeyframeAnimation;
            this.strokeColorAnimation = baseKeyframeAnimation = animatableTextProperties.stroke.createAnimation();
            baseKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.addAnimation(this.strokeColorAnimation);
        }
        if (animatableTextProperties != null && animatableTextProperties.strokeWidth != null) {
            BaseKeyframeAnimation baseKeyframeAnimation;
            this.strokeWidthAnimation = baseKeyframeAnimation = animatableTextProperties.strokeWidth.createAnimation();
            baseKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.addAnimation(this.strokeWidthAnimation);
        }
        if (animatableTextProperties != null && animatableTextProperties.tracking != null) {
            BaseKeyframeAnimation baseKeyframeAnimation;
            this.trackingAnimation = baseKeyframeAnimation = animatableTextProperties.tracking.createAnimation();
            baseKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.addAnimation(this.trackingAnimation);
        }
    }

    private void applyJustification(DocumentData.Justification justification, Canvas canvas, float f) {
        int n = 3.$SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[justification.ordinal()];
        if (n != 2) {
            if (n != 3) {
                return;
            }
            canvas.translate(-f / 2.0f, 0.0f);
            return;
        }
        canvas.translate(-f, 0.0f);
    }

    private String codePointToString(String string2, int n) {
        int n2;
        int n3;
        int n4 = string2.codePointAt(n);
        for (n2 = n + Character.charCount((int)n4); n2 < string2.length() && this.isModifier(n3 = string2.codePointAt(n2)); n2 += Character.charCount((int)n3)) {
            n4 = n3 + n4 * 31;
        }
        LongSparseArray<String> longSparseArray = this.codePointCache;
        long l = n4;
        if (longSparseArray.containsKey(l)) {
            return (String)this.codePointCache.get(l);
        }
        this.stringBuilder.setLength(0);
        while (n < n2) {
            int n5 = string2.codePointAt(n);
            this.stringBuilder.appendCodePoint(n5);
            n += Character.charCount((int)n5);
        }
        String string3 = this.stringBuilder.toString();
        this.codePointCache.put(l, (Object)string3);
        return string3;
    }

    private void drawCharacter(String string2, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(string2, 0, string2.length(), 0.0f, 0.0f, paint);
    }

    private void drawCharacterAsGlyph(FontCharacter fontCharacter, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<ContentGroup> list = this.getContentsForCharacter(fontCharacter);
        for (int i = 0; i < list.size(); ++i) {
            Path path = ((ContentGroup)list.get(i)).getPath();
            path.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, -documentData.baselineShift * Utils.dpScale());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (documentData.strokeOverFill) {
                this.drawGlyph(path, this.fillPaint, canvas);
                this.drawGlyph(path, this.strokePaint, canvas);
                continue;
            }
            this.drawGlyph(path, this.strokePaint, canvas);
            this.drawGlyph(path, this.fillPaint, canvas);
        }
    }

    private void drawCharacterFromFont(String string2, DocumentData documentData, Canvas canvas) {
        if (documentData.strokeOverFill) {
            this.drawCharacter(string2, this.fillPaint, canvas);
            this.drawCharacter(string2, this.strokePaint, canvas);
            return;
        }
        this.drawCharacter(string2, this.strokePaint, canvas);
        this.drawCharacter(string2, this.fillPaint, canvas);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void drawFontTextLine(String string2, DocumentData documentData, Canvas canvas, float f) {
        int n = 0;
        do {
            float f2;
            float f3;
            block7 : {
                float f4;
                block6 : {
                    block5 : {
                        if (n >= string2.length()) {
                            return;
                        }
                        String string3 = this.codePointToString(string2, n);
                        n += string3.length();
                        this.drawCharacterFromFont(string3, documentData, canvas);
                        f3 = this.fillPaint.measureText(string3, 0, 1);
                        f2 = (float)documentData.tracking / 10.0f;
                        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingCallbackAnimation;
                        if (baseKeyframeAnimation == null) break block5;
                        f4 = ((Float)baseKeyframeAnimation.getValue()).floatValue();
                        break block6;
                    }
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingAnimation;
                    if (baseKeyframeAnimation == null) break block7;
                    f4 = ((Float)baseKeyframeAnimation.getValue()).floatValue();
                }
                f2 += f4;
            }
            canvas.translate(f3 + f2 * f, 0.0f);
        } while (true);
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void drawGlyphTextLine(String string2, DocumentData documentData, Matrix matrix, Font font, Canvas canvas, float f, float f2) {
        int n = 0;
        do {
            block5 : {
                float f3;
                float f4;
                block8 : {
                    float f5;
                    block7 : {
                        block6 : {
                            if (n >= string2.length()) {
                                return;
                            }
                            int n2 = FontCharacter.hashFor((char)string2.charAt(n), (String)font.getFamily(), (String)font.getStyle());
                            FontCharacter fontCharacter = (FontCharacter)this.composition.getCharacters().get(n2);
                            if (fontCharacter == null) break block5;
                            this.drawCharacterAsGlyph(fontCharacter, matrix, f2, documentData, canvas);
                            f4 = f * (f2 * (float)fontCharacter.getWidth() * Utils.dpScale());
                            f3 = (float)documentData.tracking / 10.0f;
                            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingCallbackAnimation;
                            if (baseKeyframeAnimation == null) break block6;
                            f5 = ((Float)baseKeyframeAnimation.getValue()).floatValue();
                            break block7;
                        }
                        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingAnimation;
                        if (baseKeyframeAnimation == null) break block8;
                        f5 = ((Float)baseKeyframeAnimation.getValue()).floatValue();
                    }
                    f3 += f5;
                }
                canvas.translate(f4 + f3 * f, 0.0f);
            }
            ++n;
        } while (true);
    }

    private void drawTextGlyphs(DocumentData documentData, Matrix matrix, Font font, Canvas canvas) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.textSizeCallbackAnimation;
        float f = baseKeyframeAnimation2 != null ? ((Float)baseKeyframeAnimation2.getValue()).floatValue() : ((baseKeyframeAnimation = this.textSizeAnimation) != null ? ((Float)baseKeyframeAnimation.getValue()).floatValue() : documentData.size);
        float f2 = f / 100.0f;
        float f3 = Utils.getScale((Matrix)matrix);
        String string2 = documentData.text;
        float f4 = documentData.lineHeight * Utils.dpScale();
        List<String> list = this.getTextLines(string2);
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            String string3 = (String)list.get(n2);
            float f5 = this.getTextLineWidthForGlyphs(string3, font, f2, f3);
            canvas.save();
            this.applyJustification(documentData.justification, canvas, f5);
            float f6 = f4 * (float)(n - 1) / 2.0f;
            canvas.translate(0.0f, f4 * (float)n2 - f6);
            int n3 = n2;
            this.drawGlyphTextLine(string3, documentData, matrix, font, canvas, f3, f2);
            canvas.restore();
            n2 = n3 + 1;
        }
    }

    private void drawTextWithFont(DocumentData documentData, Font font, Matrix matrix, Canvas canvas) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        float f = Utils.getScale((Matrix)matrix);
        Typeface typeface = this.lottieDrawable.getTypeface(font.getFamily(), font.getStyle());
        if (typeface == null) {
            return;
        }
        String string2 = documentData.text;
        TextDelegate textDelegate = this.lottieDrawable.getTextDelegate();
        if (textDelegate != null) {
            string2 = textDelegate.getTextInternal(string2);
        }
        this.fillPaint.setTypeface(typeface);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.textSizeCallbackAnimation;
        float f2 = baseKeyframeAnimation2 != null ? ((Float)baseKeyframeAnimation2.getValue()).floatValue() : ((baseKeyframeAnimation = this.textSizeAnimation) != null ? ((Float)baseKeyframeAnimation.getValue()).floatValue() : documentData.size);
        this.fillPaint.setTextSize(f2 * Utils.dpScale());
        this.strokePaint.setTypeface(this.fillPaint.getTypeface());
        this.strokePaint.setTextSize(this.fillPaint.getTextSize());
        float f3 = documentData.lineHeight * Utils.dpScale();
        List<String> list = this.getTextLines(string2);
        int n = list.size();
        for (int i = 0; i < n; ++i) {
            String string3 = (String)list.get(i);
            float f4 = this.strokePaint.measureText(string3);
            this.applyJustification(documentData.justification, canvas, f4);
            float f5 = f3 * (float)(n - 1) / 2.0f;
            canvas.translate(0.0f, f3 * (float)i - f5);
            this.drawFontTextLine(string3, documentData, canvas, f);
            canvas.setMatrix(matrix);
        }
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter fontCharacter) {
        if (this.contentsForCharacter.containsKey((Object)fontCharacter)) {
            return (List)this.contentsForCharacter.get((Object)fontCharacter);
        }
        List list = fontCharacter.getShapes();
        int n = list.size();
        ArrayList arrayList = new ArrayList(n);
        for (int i = 0; i < n; ++i) {
            ShapeGroup shapeGroup = (ShapeGroup)list.get(i);
            arrayList.add((Object)new ContentGroup(this.lottieDrawable, (BaseLayer)this, shapeGroup));
        }
        this.contentsForCharacter.put((Object)fontCharacter, (Object)arrayList);
        return arrayList;
    }

    private float getTextLineWidthForGlyphs(String string2, Font font, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < string2.length(); ++i) {
            int n = FontCharacter.hashFor((char)string2.charAt(i), (String)font.getFamily(), (String)font.getStyle());
            FontCharacter fontCharacter = (FontCharacter)this.composition.getCharacters().get(n);
            if (fontCharacter == null) continue;
            double d = f3;
            double d2 = fontCharacter.getWidth();
            double d3 = f;
            Double.isNaN((double)d3);
            double d4 = d2 * d3;
            double d5 = Utils.dpScale();
            Double.isNaN((double)d5);
            double d6 = d4 * d5;
            double d7 = f2;
            Double.isNaN((double)d7);
            double d8 = d6 * d7;
            Double.isNaN((double)d);
            f3 = (float)(d + d8);
        }
        return f3;
    }

    private List<String> getTextLines(String string2) {
        return Arrays.asList((Object[])string2.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private boolean isModifier(int n) {
        return Character.getType((int)n) == 16 || Character.getType((int)n) == 27 || Character.getType((int)n) == 6 || Character.getType((int)n) == 28 || Character.getType((int)n) == 19;
        {
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                this.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            valueCallbackKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.addAnimation(this.colorCallbackAnimation);
            return;
        }
        if (t == LottieProperty.STROKE_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.strokeColorCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                this.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.strokeColorCallbackAnimation = null;
                return;
            }
            this.strokeColorCallbackAnimation = valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            valueCallbackKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.addAnimation(this.strokeColorCallbackAnimation);
            return;
        }
        if (t == LottieProperty.STROKE_WIDTH) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.strokeWidthCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                this.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.strokeWidthCallbackAnimation = null;
                return;
            }
            this.strokeWidthCallbackAnimation = valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            valueCallbackKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.addAnimation(this.strokeWidthCallbackAnimation);
            return;
        }
        if (t == LottieProperty.TEXT_TRACKING) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                this.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.trackingCallbackAnimation = null;
                return;
            }
            this.trackingCallbackAnimation = valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            valueCallbackKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.addAnimation(this.trackingCallbackAnimation);
            return;
        }
        if (t == LottieProperty.TEXT_SIZE) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.textSizeCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                this.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.textSizeCallbackAnimation = null;
                return;
            }
            this.textSizeCallbackAnimation = valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            valueCallbackKeyframeAnimation.addUpdateListener((BaseKeyframeAnimation.AnimationListener)this);
            this.addAnimation(this.textSizeCallbackAnimation);
        }
    }

    void drawLayer(Canvas canvas, Matrix matrix, int n) {
        canvas.save();
        if (!this.lottieDrawable.useTextGlyphs()) {
            canvas.setMatrix(matrix);
        }
        DocumentData documentData = (DocumentData)this.textAnimation.getValue();
        Font font = (Font)this.composition.getFonts().get((Object)documentData.fontName);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
        if (baseKeyframeAnimation != null) {
            this.fillPaint.setColor(((Integer)baseKeyframeAnimation.getValue()).intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.colorAnimation;
            if (baseKeyframeAnimation2 != null) {
                this.fillPaint.setColor(((Integer)baseKeyframeAnimation2.getValue()).intValue());
            } else {
                this.fillPaint.setColor(documentData.color);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.strokeColorCallbackAnimation;
        if (baseKeyframeAnimation3 != null) {
            this.strokePaint.setColor(((Integer)baseKeyframeAnimation3.getValue()).intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.strokeColorAnimation;
            if (baseKeyframeAnimation4 != null) {
                this.strokePaint.setColor(((Integer)baseKeyframeAnimation4.getValue()).intValue());
            } else {
                this.strokePaint.setColor(documentData.strokeColor);
            }
        }
        int n2 = this.transform.getOpacity() == null ? 100 : (Integer)this.transform.getOpacity().getValue();
        int n3 = n2 * 255 / 100;
        this.fillPaint.setAlpha(n3);
        this.strokePaint.setAlpha(n3);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.strokeWidthCallbackAnimation;
        if (baseKeyframeAnimation5 != null) {
            this.strokePaint.setStrokeWidth(((Float)baseKeyframeAnimation5.getValue()).floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.strokeWidthAnimation;
            if (baseKeyframeAnimation6 != null) {
                this.strokePaint.setStrokeWidth(((Float)baseKeyframeAnimation6.getValue()).floatValue());
            } else {
                float f = Utils.getScale((Matrix)matrix);
                this.strokePaint.setStrokeWidth(f * (documentData.strokeWidth * Utils.dpScale()));
            }
        }
        if (this.lottieDrawable.useTextGlyphs()) {
            this.drawTextGlyphs(documentData, matrix, font, canvas);
        } else {
            this.drawTextWithFont(documentData, font, matrix, canvas);
        }
        canvas.restore();
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean bl) {
        super.getBounds(rectF, matrix, bl);
        rectF.set(0.0f, 0.0f, (float)this.composition.getBounds().width(), (float)this.composition.getBounds().height());
    }
}

