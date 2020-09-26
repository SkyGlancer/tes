/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  com.mikhaellopez.circularimageview.CircularImageView
 *  java.lang.Object
 *  kotlin.Metadata
 */
package app.dukhaan.src.java.com.mikhaellopez.circularimageview;

import android.widget.ImageView;
import com.mikhaellopez.circularimageview.CircularImageView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class CircularImageView$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static /* synthetic */ {
        int[] arrn = new int[CircularImageView.GradientDirection.values().length];
        $EnumSwitchMapping$0 = arrn;
        arrn[CircularImageView.GradientDirection.LEFT_TO_RIGHT.ordinal()] = 1;
        CircularImageView$WhenMappings.$EnumSwitchMapping$0[CircularImageView.GradientDirection.RIGHT_TO_LEFT.ordinal()] = 2;
        CircularImageView$WhenMappings.$EnumSwitchMapping$0[CircularImageView.GradientDirection.TOP_TO_BOTTOM.ordinal()] = 3;
        CircularImageView$WhenMappings.$EnumSwitchMapping$0[CircularImageView.GradientDirection.BOTTOM_TO_TOP.ordinal()] = 4;
        int[] arrn2 = new int[CircularImageView.ShadowGravity.values().length];
        $EnumSwitchMapping$1 = arrn2;
        arrn2[CircularImageView.ShadowGravity.CENTER.ordinal()] = 1;
        CircularImageView$WhenMappings.$EnumSwitchMapping$1[CircularImageView.ShadowGravity.TOP.ordinal()] = 2;
        CircularImageView$WhenMappings.$EnumSwitchMapping$1[CircularImageView.ShadowGravity.BOTTOM.ordinal()] = 3;
        CircularImageView$WhenMappings.$EnumSwitchMapping$1[CircularImageView.ShadowGravity.START.ordinal()] = 4;
        CircularImageView$WhenMappings.$EnumSwitchMapping$1[CircularImageView.ShadowGravity.END.ordinal()] = 5;
        int[] arrn3 = new int[ImageView.ScaleType.values().length];
        $EnumSwitchMapping$2 = arrn3;
        arrn3[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
        CircularImageView$WhenMappings.$EnumSwitchMapping$2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
        CircularImageView$WhenMappings.$EnumSwitchMapping$2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
    }
}

