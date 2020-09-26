/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.model.content.ShapeGroup
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.src.java.com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

public class FontCharacter {
    private final char character;
    private final String fontFamily;
    private final List<ShapeGroup> shapes;
    private final double size;
    private final String style;
    private final double width;

    public FontCharacter(List<ShapeGroup> list, char c, double d, double d2, String string2, String string3) {
        this.shapes = list;
        this.character = c;
        this.size = d;
        this.width = d2;
        this.style = string2;
        this.fontFamily = string3;
    }

    public static int hashFor(char c, String string2, String string3) {
        return 31 * (31 * ('\u0000' + c) + string2.hashCode()) + string3.hashCode();
    }

    public List<ShapeGroup> getShapes() {
        return this.shapes;
    }

    double getSize() {
        return this.size;
    }

    String getStyle() {
        return this.style;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return FontCharacter.hashFor(this.character, this.fontFamily, this.style);
    }
}

