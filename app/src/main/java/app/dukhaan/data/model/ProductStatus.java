/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.data.model;

public final class ProductStatus
extends Enum<ProductStatus> {
    private static final /* synthetic */ ProductStatus[] $VALUES;
    public static final /* enum */ ProductStatus LISTED;
    public static final /* enum */ ProductStatus NOTLISTED;

    static {
        ProductStatus productStatus;
        LISTED = new ProductStatus();
        NOTLISTED = productStatus = new ProductStatus();
        ProductStatus[] arrproductStatus = new ProductStatus[]{LISTED, productStatus};
        $VALUES = arrproductStatus;
    }

    public static ProductStatus valueOf(String string2) {
        return (ProductStatus)Enum.valueOf(ProductStatus.class, (String)string2);
    }

    public static ProductStatus[] values() {
        return (ProductStatus[])$VALUES.clone();
    }
}

