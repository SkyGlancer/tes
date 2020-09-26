/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.io.branch.referral.util;

import android.text.TextUtils;

public final class BranchContentSchema
extends Enum<BranchContentSchema> {
    private static final /* synthetic */ BranchContentSchema[] $VALUES;
    public static final /* enum */ BranchContentSchema COMMERCE_AUCTION;
    public static final /* enum */ BranchContentSchema COMMERCE_BUSINESS;
    public static final /* enum */ BranchContentSchema COMMERCE_OTHER;
    public static final /* enum */ BranchContentSchema COMMERCE_PRODUCT;
    public static final /* enum */ BranchContentSchema COMMERCE_RESTAURANT;
    public static final /* enum */ BranchContentSchema COMMERCE_SERVICE;
    public static final /* enum */ BranchContentSchema COMMERCE_TRAVEL_FLIGHT;
    public static final /* enum */ BranchContentSchema COMMERCE_TRAVEL_HOTEL;
    public static final /* enum */ BranchContentSchema COMMERCE_TRAVEL_OTHER;
    public static final /* enum */ BranchContentSchema GAME_STATE;
    public static final /* enum */ BranchContentSchema MEDIA_IMAGE;
    public static final /* enum */ BranchContentSchema MEDIA_MIXED;
    public static final /* enum */ BranchContentSchema MEDIA_MUSIC;
    public static final /* enum */ BranchContentSchema MEDIA_OTHER;
    public static final /* enum */ BranchContentSchema MEDIA_VIDEO;
    public static final /* enum */ BranchContentSchema OTHER;
    public static final /* enum */ BranchContentSchema TEXT_ARTICLE;
    public static final /* enum */ BranchContentSchema TEXT_BLOG;
    public static final /* enum */ BranchContentSchema TEXT_OTHER;
    public static final /* enum */ BranchContentSchema TEXT_RECIPE;
    public static final /* enum */ BranchContentSchema TEXT_REVIEW;
    public static final /* enum */ BranchContentSchema TEXT_SEARCH_RESULTS;
    public static final /* enum */ BranchContentSchema TEXT_STORY;
    public static final /* enum */ BranchContentSchema TEXT_TECHNICAL_DOC;

    static {
        BranchContentSchema branchContentSchema;
        COMMERCE_AUCTION = new BranchContentSchema();
        COMMERCE_BUSINESS = new BranchContentSchema();
        COMMERCE_OTHER = new BranchContentSchema();
        COMMERCE_PRODUCT = new BranchContentSchema();
        COMMERCE_RESTAURANT = new BranchContentSchema();
        COMMERCE_SERVICE = new BranchContentSchema();
        COMMERCE_TRAVEL_FLIGHT = new BranchContentSchema();
        COMMERCE_TRAVEL_HOTEL = new BranchContentSchema();
        COMMERCE_TRAVEL_OTHER = new BranchContentSchema();
        GAME_STATE = new BranchContentSchema();
        MEDIA_IMAGE = new BranchContentSchema();
        MEDIA_MIXED = new BranchContentSchema();
        MEDIA_MUSIC = new BranchContentSchema();
        MEDIA_OTHER = new BranchContentSchema();
        MEDIA_VIDEO = new BranchContentSchema();
        OTHER = new BranchContentSchema();
        TEXT_ARTICLE = new BranchContentSchema();
        TEXT_BLOG = new BranchContentSchema();
        TEXT_OTHER = new BranchContentSchema();
        TEXT_RECIPE = new BranchContentSchema();
        TEXT_REVIEW = new BranchContentSchema();
        TEXT_SEARCH_RESULTS = new BranchContentSchema();
        TEXT_STORY = new BranchContentSchema();
        TEXT_TECHNICAL_DOC = branchContentSchema = new BranchContentSchema();
        BranchContentSchema[] arrbranchContentSchema = new BranchContentSchema[]{COMMERCE_AUCTION, COMMERCE_BUSINESS, COMMERCE_OTHER, COMMERCE_PRODUCT, COMMERCE_RESTAURANT, COMMERCE_SERVICE, COMMERCE_TRAVEL_FLIGHT, COMMERCE_TRAVEL_HOTEL, COMMERCE_TRAVEL_OTHER, GAME_STATE, MEDIA_IMAGE, MEDIA_MIXED, MEDIA_MUSIC, MEDIA_OTHER, MEDIA_VIDEO, OTHER, TEXT_ARTICLE, TEXT_BLOG, TEXT_OTHER, TEXT_RECIPE, TEXT_REVIEW, TEXT_SEARCH_RESULTS, TEXT_STORY, branchContentSchema};
        $VALUES = arrbranchContentSchema;
    }

    public static BranchContentSchema getValue(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            for (BranchContentSchema branchContentSchema : BranchContentSchema.values()) {
                if (!branchContentSchema.name().equalsIgnoreCase(string2)) continue;
                return branchContentSchema;
            }
        }
        return null;
    }

    public static BranchContentSchema valueOf(String string2) {
        return (BranchContentSchema)Enum.valueOf(BranchContentSchema.class, (String)string2);
    }

    public static BranchContentSchema[] values() {
        return (BranchContentSchema[])$VALUES.clone();
    }
}

