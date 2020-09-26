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

public final class ProductCategory
extends Enum<ProductCategory> {
    private static final /* synthetic */ ProductCategory[] $VALUES;
    public static final /* enum */ ProductCategory ANIMALS_AND_PET_SUPPLIES;
    public static final /* enum */ ProductCategory APPAREL_AND_ACCESSORIES;
    public static final /* enum */ ProductCategory ARTS_AND_ENTERTAINMENT;
    public static final /* enum */ ProductCategory BABY_AND_TODDLER;
    public static final /* enum */ ProductCategory BUSINESS_AND_INDUSTRIAL;
    public static final /* enum */ ProductCategory CAMERAS_AND_OPTICS;
    public static final /* enum */ ProductCategory ELECTRONICS;
    public static final /* enum */ ProductCategory FOOD_BEVERAGES_AND_TOBACCO;
    public static final /* enum */ ProductCategory FURNITURE;
    public static final /* enum */ ProductCategory HARDWARE;
    public static final /* enum */ ProductCategory HEALTH_AND_BEAUTY;
    public static final /* enum */ ProductCategory HOME_AND_GARDEN;
    public static final /* enum */ ProductCategory LUGGAGE_AND_BAGS;
    public static final /* enum */ ProductCategory MATURE;
    public static final /* enum */ ProductCategory MEDIA;
    public static final /* enum */ ProductCategory OFFICE_SUPPLIES;
    public static final /* enum */ ProductCategory RELIGIOUS_AND_CEREMONIAL;
    public static final /* enum */ ProductCategory SOFTWARE;
    public static final /* enum */ ProductCategory SPORTING_GOODS;
    public static final /* enum */ ProductCategory TOYS_AND_GAMES;
    public static final /* enum */ ProductCategory VEHICLES_AND_PARTS;
    private String name;

    static {
        ProductCategory productCategory;
        ANIMALS_AND_PET_SUPPLIES = new ProductCategory("Animals & Pet Supplies");
        APPAREL_AND_ACCESSORIES = new ProductCategory("Apparel & Accessories");
        ARTS_AND_ENTERTAINMENT = new ProductCategory("Arts & Entertainment");
        BABY_AND_TODDLER = new ProductCategory("Baby & Toddler");
        BUSINESS_AND_INDUSTRIAL = new ProductCategory("Business & Industrial");
        CAMERAS_AND_OPTICS = new ProductCategory("Cameras & Optics");
        ELECTRONICS = new ProductCategory("Electronics");
        FOOD_BEVERAGES_AND_TOBACCO = new ProductCategory("Food, Beverages & Tobacco");
        FURNITURE = new ProductCategory("Furniture");
        HARDWARE = new ProductCategory("Hardware");
        HEALTH_AND_BEAUTY = new ProductCategory("Health & Beauty");
        HOME_AND_GARDEN = new ProductCategory("Home & Garden");
        LUGGAGE_AND_BAGS = new ProductCategory("Luggage & Bags");
        MATURE = new ProductCategory("Mature");
        MEDIA = new ProductCategory("Media");
        OFFICE_SUPPLIES = new ProductCategory("Office Supplies");
        RELIGIOUS_AND_CEREMONIAL = new ProductCategory("Religious & Ceremonial");
        SOFTWARE = new ProductCategory("Software");
        SPORTING_GOODS = new ProductCategory("Sporting Goods");
        TOYS_AND_GAMES = new ProductCategory("Toys & Games");
        VEHICLES_AND_PARTS = productCategory = new ProductCategory("Vehicles & Parts");
        ProductCategory[] arrproductCategory = new ProductCategory[]{ANIMALS_AND_PET_SUPPLIES, APPAREL_AND_ACCESSORIES, ARTS_AND_ENTERTAINMENT, BABY_AND_TODDLER, BUSINESS_AND_INDUSTRIAL, CAMERAS_AND_OPTICS, ELECTRONICS, FOOD_BEVERAGES_AND_TOBACCO, FURNITURE, HARDWARE, HEALTH_AND_BEAUTY, HOME_AND_GARDEN, LUGGAGE_AND_BAGS, MATURE, MEDIA, OFFICE_SUPPLIES, RELIGIOUS_AND_CEREMONIAL, SOFTWARE, SPORTING_GOODS, TOYS_AND_GAMES, productCategory};
        $VALUES = arrproductCategory;
    }

    private ProductCategory(String string3) {
        this.name = string3;
    }

    public static ProductCategory getValue(String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            for (ProductCategory productCategory : ProductCategory.values()) {
                if (!productCategory.name.equalsIgnoreCase(string2)) continue;
                return productCategory;
            }
        }
        return null;
    }

    public static ProductCategory valueOf(String string2) {
        return (ProductCategory)Enum.valueOf(ProductCategory.class, (String)string2);
    }

    public static ProductCategory[] values() {
        return (ProductCategory[])$VALUES.clone();
    }

    public String getName() {
        return this.name;
    }
}

