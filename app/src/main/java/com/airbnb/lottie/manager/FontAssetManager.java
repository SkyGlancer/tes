/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.view.View
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 */
package app.dukhaan.src.java.com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class FontAssetManager {
    private final AssetManager assetManager;
    private String defaultFontFileExtension = ".ttf";
    private FontAssetDelegate delegate;
    private final Map<String, Typeface> fontFamilies = new HashMap();
    private final Map<MutablePair<String>, Typeface> fontMap = new HashMap();
    private final MutablePair<String> tempPair = new MutablePair();

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View)callback).getContext().getAssets();
    }

    private Typeface getFontFamily(String string2) {
        String string3;
        FontAssetDelegate fontAssetDelegate;
        Typeface typeface = (Typeface)this.fontFamilies.get((Object)string2);
        if (typeface != null) {
            return typeface;
        }
        FontAssetDelegate fontAssetDelegate2 = this.delegate;
        Typeface typeface2 = null;
        if (fontAssetDelegate2 != null) {
            typeface2 = fontAssetDelegate2.fetchFont(string2);
        }
        if ((fontAssetDelegate = this.delegate) != null && typeface2 == null && (string3 = fontAssetDelegate.getFontPath(string2)) != null) {
            typeface2 = Typeface.createFromAsset((AssetManager)this.assetManager, (String)string3);
        }
        if (typeface2 == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fonts/");
            stringBuilder.append(string2);
            stringBuilder.append(this.defaultFontFileExtension);
            String string4 = stringBuilder.toString();
            typeface2 = Typeface.createFromAsset((AssetManager)this.assetManager, (String)string4);
        }
        this.fontFamilies.put((Object)string2, (Object)typeface2);
        return typeface2;
    }

    private Typeface typefaceForStyle(Typeface typeface, String string2) {
        boolean bl = string2.contains((CharSequence)"Italic");
        boolean bl2 = string2.contains((CharSequence)"Bold");
        int n = bl && bl2 ? 3 : (bl ? 2 : (bl2 ? 1 : 0));
        if (typeface.getStyle() == n) {
            return typeface;
        }
        return Typeface.create((Typeface)typeface, (int)n);
    }

    public Typeface getTypeface(String string2, String string3) {
        this.tempPair.set(string2, string3);
        Typeface typeface = (Typeface)this.fontMap.get(this.tempPair);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = this.typefaceForStyle(this.getFontFamily(string2), string3);
        this.fontMap.put(this.tempPair, (Object)typeface2);
        return typeface2;
    }

    public void setDefaultFontFileExtension(String string2) {
        this.defaultFontFileExtension = string2;
    }

    public void setDelegate(FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
    }
}

