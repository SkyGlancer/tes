/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.app;

public class EndPoints {
    public static final String ADD_PRODUCT = "product/{category_id}/";
    public static final String AWARD_STATS = "account/awards-stats/";
    public static final String BUSINESS = "business/";
    public static final String BUSINESS_STATS = "business/{businessId}/";
    public static final String CATEGORY_LIST = "all-category/{business_id}/";
    public static final String CATEGORY_PRODUCTS = "product_by_category/{category_id}/";
    public static final String CREATE_CATEGORY = "category/";
    public static final String CREATE_PRODUCT = "product/";
    public static final String DELETE_CATEGORY = "category/{categoryId}/";
    public static final String DELETE_PRODUCT = "product/{productId}/";
    public static final String EDIT_CATEGORY = "category/{categoryId}/";
    public static final String EDIT_PRODUCT = "product/{productId}/";
    public static final String LOGIN = "sign-in/";
    public static final String ORDERS_LIST = "get-order/{business_id}/";
    public static final String PRODUCTS = "product/{business_id}/";
    public static final String REFRESH_TOKEN = "account/jwt-token-fetch/";
    public static final String SEARCH_PRODUCT = "search/";
    public static final String SYNC_CONTACTS = "sync-phonebook/";
    public static final String TRACK_ORDER = "view-order/{orderId}/";
    public static final String UPDATE_BUSINESS = "business/{business_id}/";
    public static final String UPDATE_ORDER_STATUS = "update-order/{order_id}/";
    public static final String UPLOAD_IMAGE = "upload-image/";
    public static final String VARIANTS = "product/{product_id}/variant/";
}

