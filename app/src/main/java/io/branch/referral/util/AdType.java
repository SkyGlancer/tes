/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.io.branch.referral.util;

public final class AdType
extends Enum<AdType> {
    private static final /* synthetic */ AdType[] $VALUES;
    public static final /* enum */ AdType BANNER;
    public static final /* enum */ AdType INTERSTITIAL;
    public static final /* enum */ AdType NATIVE;
    public static final /* enum */ AdType REWARDED_VIDEO;
    private final String name;

    static {
        AdType adType;
        BANNER = new AdType("BANNER");
        INTERSTITIAL = new AdType("INTERSTITIAL");
        REWARDED_VIDEO = new AdType("REWARDED_VIDEO");
        NATIVE = adType = new AdType("NATIVE");
        AdType[] arradType = new AdType[]{BANNER, INTERSTITIAL, REWARDED_VIDEO, adType};
        $VALUES = arradType;
    }

    private AdType(String string3) {
        this.name = string3;
    }

    public static AdType valueOf(String string2) {
        return (AdType)Enum.valueOf(AdType.class, (String)string2);
    }

    public static AdType[] values() {
        return (AdType[])$VALUES.clone();
    }

    public String getName() {
        return this.name;
    }
}

