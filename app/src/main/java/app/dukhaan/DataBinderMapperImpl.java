/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.View
 *  androidx.databinding.DataBinderMapper
 *  androidx.databinding.DataBindingComponent
 *  androidx.databinding.ViewDataBinding
 *  androidx.databinding.library.baseAdapters.DataBinderMapperImpl
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.List
 */
package app.dukhaan;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.databinding.ActivityAddBusinessBindingImpl;
import app.dukhaan.databinding.ActivityAddVariantBindingImpl;
import app.dukhaan.databinding.ActivityAddressSelectBindingImpl;
import app.dukhaan.databinding.ActivityBusinessDetailsEditBindingImpl;
import app.dukhaan.databinding.ActivityCategoryDetailBindingImpl;
import app.dukhaan.databinding.ActivityChangeLanguageBindingImpl;
import app.dukhaan.databinding.ActivityCreateCategoryBindingImpl;
import app.dukhaan.databinding.ActivityDeliveryChargesBindingImpl;
import app.dukhaan.databinding.ActivityEditCategoryBindingImpl;
import app.dukhaan.databinding.ActivityEditProductBindingImpl;
import app.dukhaan.databinding.ActivityKillswitchBindingImpl;
import app.dukhaan.databinding.ActivityMainBindingImpl;
import app.dukhaan.databinding.ActivityMobileNumberBindingImpl;
import app.dukhaan.databinding.ActivityOnboardingBindingImpl;
import app.dukhaan.databinding.ActivityOrderDetailsBindingImpl;
import app.dukhaan.databinding.ActivityPrivacyPolicyBindingImpl;
import app.dukhaan.databinding.ActivityReportIssueBindingImpl;
import app.dukhaan.databinding.ActivitySelectCountryBindingImpl;
import app.dukhaan.databinding.ActivitySplashBindingImpl;
import app.dukhaan.databinding.ActivitySyncContactsBindingImpl;
import app.dukhaan.databinding.ActivityVerifyMobileBindingImpl;
import app.dukhaan.databinding.ActivityVerifyOtpBindingImpl;
import app.dukhaan.databinding.ActivityVideoTutorialsBindingImpl;
import app.dukhaan.databinding.AddProductCameraIconBindingImpl;
import app.dukhaan.databinding.BottomSheetPlacesSearchBindingImpl;
import app.dukhaan.databinding.BottomSheetSelectLanguageBindingImpl;
import app.dukhaan.databinding.BtnPrimaryBindingImpl;
import app.dukhaan.databinding.BtnPrimaryShadowedBindingImpl;
import app.dukhaan.databinding.BtnPrimaryWhiteBindingImpl;
import app.dukhaan.databinding.FragmentAccountBindingImpl;
import app.dukhaan.databinding.FragmentCategoriesBindingImpl;
import app.dukhaan.databinding.FragmentHomeBindingImpl;
import app.dukhaan.databinding.FragmentOnboardingStepsBindingImpl;
import app.dukhaan.databinding.FragmentOrdersBindingImpl;
import app.dukhaan.databinding.FragmentOrdersListBindingImpl;
import app.dukhaan.databinding.FragmentProductsBindingImpl;
import app.dukhaan.databinding.ItemCountryBindingImpl;
import app.dukhaan.databinding.ItemProductCategoryListItemBindingImpl;
import app.dukhaan.databinding.ItemProductUnitListItemBindingImpl;
import app.dukhaan.databinding.ItemSearchBindingImpl;
import app.dukhaan.databinding.LayoutCategoryListItemBindingImpl;
import app.dukhaan.databinding.LayoutEmptyDataCardBindingImpl;
import app.dukhaan.databinding.LayoutOrderFilterChipBindingImpl;
import app.dukhaan.databinding.LayoutOrderFilterChipGroupBindingImpl;
import app.dukhaan.databinding.LayoutStepInstructionsBindingImpl;
import app.dukhaan.databinding.LayoutStepNumberBindingImpl;
import app.dukhaan.databinding.ListHeaderOverviewBindingImpl;
import app.dukhaan.databinding.ListHeaderPendingOrdersBindingImpl;
import app.dukhaan.databinding.NetworkItemBindingImpl;
import app.dukhaan.databinding.ProductImageThumbnailEditableBindingImpl;
import app.dukhaan.databinding.ProductListItemBindingImpl;
import app.dukhaan.databinding.StoreInfoCardContainerBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl
extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYADDBUSINESS = 1;
    private static final int LAYOUT_ACTIVITYADDRESSSELECT = 3;
    private static final int LAYOUT_ACTIVITYADDVARIANT = 2;
    private static final int LAYOUT_ACTIVITYBUSINESSDETAILSEDIT = 4;
    private static final int LAYOUT_ACTIVITYCATEGORYDETAIL = 5;
    private static final int LAYOUT_ACTIVITYCHANGELANGUAGE = 6;
    private static final int LAYOUT_ACTIVITYCREATECATEGORY = 7;
    private static final int LAYOUT_ACTIVITYDELIVERYCHARGES = 8;
    private static final int LAYOUT_ACTIVITYEDITCATEGORY = 9;
    private static final int LAYOUT_ACTIVITYEDITPRODUCT = 10;
    private static final int LAYOUT_ACTIVITYKILLSWITCH = 11;
    private static final int LAYOUT_ACTIVITYMAIN = 12;
    private static final int LAYOUT_ACTIVITYMOBILENUMBER = 13;
    private static final int LAYOUT_ACTIVITYONBOARDING = 14;
    private static final int LAYOUT_ACTIVITYORDERDETAILS = 15;
    private static final int LAYOUT_ACTIVITYPRIVACYPOLICY = 16;
    private static final int LAYOUT_ACTIVITYREPORTISSUE = 17;
    private static final int LAYOUT_ACTIVITYSELECTCOUNTRY = 18;
    private static final int LAYOUT_ACTIVITYSPLASH = 19;
    private static final int LAYOUT_ACTIVITYSYNCCONTACTS = 20;
    private static final int LAYOUT_ACTIVITYVERIFYMOBILE = 21;
    private static final int LAYOUT_ACTIVITYVERIFYOTP = 22;
    private static final int LAYOUT_ACTIVITYVIDEOTUTORIALS = 23;
    private static final int LAYOUT_ADDPRODUCTCAMERAICON = 24;
    private static final int LAYOUT_BOTTOMSHEETPLACESSEARCH = 25;
    private static final int LAYOUT_BOTTOMSHEETSELECTLANGUAGE = 26;
    private static final int LAYOUT_BTNPRIMARY = 27;
    private static final int LAYOUT_BTNPRIMARYSHADOWED = 28;
    private static final int LAYOUT_BTNPRIMARYWHITE = 29;
    private static final int LAYOUT_FRAGMENTACCOUNT = 30;
    private static final int LAYOUT_FRAGMENTCATEGORIES = 31;
    private static final int LAYOUT_FRAGMENTHOME = 32;
    private static final int LAYOUT_FRAGMENTONBOARDINGSTEPS = 33;
    private static final int LAYOUT_FRAGMENTORDERS = 34;
    private static final int LAYOUT_FRAGMENTORDERSLIST = 35;
    private static final int LAYOUT_FRAGMENTPRODUCTS = 36;
    private static final int LAYOUT_ITEMCOUNTRY = 37;
    private static final int LAYOUT_ITEMNETWORKSTATE = 38;
    private static final int LAYOUT_ITEMPRODUCTCATEGORYLISTITEM = 39;
    private static final int LAYOUT_ITEMPRODUCTUNITLISTITEM = 40;
    private static final int LAYOUT_ITEMSEARCH = 41;
    private static final int LAYOUT_LAYOUTCATEGORYLISTITEM = 42;
    private static final int LAYOUT_LAYOUTEMPTYDATACARD = 43;
    private static final int LAYOUT_LAYOUTORDERFILTERCHIP = 44;
    private static final int LAYOUT_LAYOUTORDERFILTERCHIPGROUP = 45;
    private static final int LAYOUT_LAYOUTSTEPINSTRUCTIONS = 46;
    private static final int LAYOUT_LAYOUTSTEPNUMBER = 47;
    private static final int LAYOUT_LISTHEADEROVERVIEW = 48;
    private static final int LAYOUT_LISTHEADERPENDINGORDERS = 49;
    private static final int LAYOUT_PRODUCTIMAGETHUMBNAILEDITABLE = 50;
    private static final int LAYOUT_PRODUCTLISTITEM = 51;
    private static final int LAYOUT_STOREINFOCARDCONTAINER = 52;

    static {
        SparseIntArray sparseIntArray;
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray = new SparseIntArray(52);
        sparseIntArray.put(2131558428, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558429, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558430, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558432, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558433, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558434, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558435, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558436, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558437, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558438, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558440, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558441, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558442, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558443, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558444, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558445, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558446, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558447, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558448, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558449, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558450, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558451, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558452, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558454, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558456, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558457, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558460, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558461, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558462, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558496, 30);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558497, 31);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558498, 32);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558499, 33);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558500, 34);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558501, 35);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558502, 36);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558523, 37);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558525, 38);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558526, 39);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558527, 40);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558529, 41);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558531, 42);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558533, 43);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558535, 44);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558536, 45);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558541, 46);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558542, 47);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558545, 48);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558546, 49);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558621, 50);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558622, 51);
        INTERNAL_LAYOUT_ID_LOOKUP.put(2131558627, 52);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent dataBindingComponent, View view, int n, Object object) {
        switch (n) {
            default: {
                return null;
            }
            case 50: {
                if ("layout/product_image_thumbnail_editable_0".equals(object)) {
                    return new ProductImageThumbnailEditableBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for product_image_thumbnail_editable is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 49: {
                if ("layout/list_header_pending_orders_0".equals(object)) {
                    return new ListHeaderPendingOrdersBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for list_header_pending_orders is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 48: {
                if ("layout/list_header_overview_0".equals(object)) {
                    return new ListHeaderOverviewBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for list_header_overview is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 47: {
                if ("layout/layout_step_number_0".equals(object)) {
                    return new LayoutStepNumberBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for layout_step_number is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 46: {
                if ("layout/layout_step_instructions_0".equals(object)) {
                    return new LayoutStepInstructionsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for layout_step_instructions is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 45: {
                if ("layout/layout_order_filter_chip_group_0".equals(object)) {
                    return new LayoutOrderFilterChipGroupBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for layout_order_filter_chip_group is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 44: {
                if ("layout/layout_order_filter_chip_0".equals(object)) {
                    return new LayoutOrderFilterChipBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for layout_order_filter_chip is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 43: {
                if ("layout/layout_empty_data_card_0".equals(object)) {
                    return new LayoutEmptyDataCardBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for layout_empty_data_card is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 42: {
                if ("layout/layout_category_list_item_0".equals(object)) {
                    return new LayoutCategoryListItemBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for layout_category_list_item is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 41: {
                if ("layout/item_search_0".equals(object)) {
                    return new ItemSearchBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for item_search is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 40: {
                if ("layout/item_product_unit_list_item_0".equals(object)) {
                    return new ItemProductUnitListItemBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for item_product_unit_list_item is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 39: {
                if ("layout/item_product_category_list_item_0".equals(object)) {
                    return new ItemProductCategoryListItemBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for item_product_category_list_item is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 38: {
                if ("layout/item_network_state_0".equals(object)) {
                    return new NetworkItemBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for item_network_state is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 37: {
                if ("layout/item_country_0".equals(object)) {
                    return new ItemCountryBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for item_country is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 36: {
                if ("layout/fragment_products_0".equals(object)) {
                    return new FragmentProductsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for fragment_products is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 35: {
                if ("layout/fragment_orders_list_0".equals(object)) {
                    return new FragmentOrdersListBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for fragment_orders_list is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 34: {
                if ("layout/fragment_orders_0".equals(object)) {
                    return new FragmentOrdersBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for fragment_orders is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 33: {
                if ("layout/fragment_onboarding_steps_0".equals(object)) {
                    return new FragmentOnboardingStepsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for fragment_onboarding_steps is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 32: {
                if ("layout/fragment_home_0".equals(object)) {
                    return new FragmentHomeBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for fragment_home is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 31: {
                if ("layout/fragment_categories_0".equals(object)) {
                    return new FragmentCategoriesBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for fragment_categories is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 30: {
                if ("layout/fragment_account_0".equals(object)) {
                    return new FragmentAccountBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for fragment_account is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 29: {
                if ("layout/btn_primary_white_0".equals(object)) {
                    return new BtnPrimaryWhiteBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for btn_primary_white is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 28: {
                if ("layout/btn_primary_shadowed_0".equals(object)) {
                    return new BtnPrimaryShadowedBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for btn_primary_shadowed is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 27: {
                if ("layout/btn_primary_0".equals(object)) {
                    return new BtnPrimaryBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for btn_primary is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 26: {
                if ("layout/bottom_sheet_select_language_0".equals(object)) {
                    return new BottomSheetSelectLanguageBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for bottom_sheet_select_language is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 25: {
                if ("layout/bottom_sheet_places_search_0".equals(object)) {
                    return new BottomSheetPlacesSearchBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for bottom_sheet_places_search is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 24: {
                if ("layout/add_product_camera_icon_0".equals(object)) {
                    return new AddProductCameraIconBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for add_product_camera_icon is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 23: {
                if ("layout/activity_video_tutorials_0".equals(object)) {
                    return new ActivityVideoTutorialsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_video_tutorials is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 22: {
                if ("layout/activity_verify_otp_0".equals(object)) {
                    return new ActivityVerifyOtpBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_verify_otp is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 21: {
                if ("layout/activity_verify_mobile_0".equals(object)) {
                    return new ActivityVerifyMobileBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_verify_mobile is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 20: {
                if ("layout/activity_sync_contacts_0".equals(object)) {
                    return new ActivitySyncContactsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_sync_contacts is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 19: {
                if ("layout/activity_splash_0".equals(object)) {
                    return new ActivitySplashBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_splash is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 18: {
                if ("layout/activity_select_country_0".equals(object)) {
                    return new ActivitySelectCountryBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_select_country is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 17: {
                if ("layout/activity_report_issue_0".equals(object)) {
                    return new ActivityReportIssueBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_report_issue is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 16: {
                if ("layout/activity_privacy_policy_0".equals(object)) {
                    return new ActivityPrivacyPolicyBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_privacy_policy is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 15: {
                if ("layout/activity_order_details_0".equals(object)) {
                    return new ActivityOrderDetailsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_order_details is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 14: {
                if ("layout/activity_onboarding_0".equals(object)) {
                    return new ActivityOnboardingBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_onboarding is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 13: {
                if ("layout/activity_mobile_number_0".equals(object)) {
                    return new ActivityMobileNumberBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_mobile_number is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 12: {
                if ("layout/activity_main_0".equals(object)) {
                    return new ActivityMainBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_main is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 11: {
                if ("layout/activity_killswitch_0".equals(object)) {
                    return new ActivityKillswitchBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_killswitch is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 10: {
                if ("layout/activity_edit_product_0".equals(object)) {
                    return new ActivityEditProductBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_edit_product is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 9: {
                if ("layout/activity_edit_category_0".equals(object)) {
                    return new ActivityEditCategoryBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_edit_category is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 8: {
                if ("layout/activity_delivery_charges_0".equals(object)) {
                    return new ActivityDeliveryChargesBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_delivery_charges is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 7: {
                if ("layout/activity_create_category_0".equals(object)) {
                    return new ActivityCreateCategoryBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_create_category is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 6: {
                if ("layout/activity_change_language_0".equals(object)) {
                    return new ActivityChangeLanguageBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_change_language is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 5: {
                if ("layout/activity_category_detail_0".equals(object)) {
                    return new ActivityCategoryDetailBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_category_detail is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 4: {
                if ("layout/activity_business_details_edit_0".equals(object)) {
                    return new ActivityBusinessDetailsEditBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_business_details_edit is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 3: {
                if ("layout/activity_address_select_0".equals(object)) {
                    return new ActivityAddressSelectBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_address_select is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 2: {
                if ("layout/activity_add_variant_0".equals(object)) {
                    return new ActivityAddVariantBindingImpl(dataBindingComponent, view);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for activity_add_variant is invalid. Received: ");
                stringBuilder.append(object);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 1: 
        }
        if ("layout/activity_add_business_0".equals(object)) {
            return new ActivityAddBusinessBindingImpl(dataBindingComponent, view);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The tag for activity_add_business is invalid. Received: ");
        stringBuilder.append(object);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent dataBindingComponent, View view, int n, Object object) {
        if (n != 51) {
            if (n != 52) {
                return null;
            }
            if ("layout/store_info_card_container_0".equals(object)) {
                return new StoreInfoCardContainerBindingImpl(dataBindingComponent, view);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The tag for store_info_card_container is invalid. Received: ");
            stringBuilder.append(object);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if ("layout/product_list_item_0".equals(object)) {
            return new ProductListItemBindingImpl(dataBindingComponent, view);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The tag for product_list_item is invalid. Received: ");
        stringBuilder.append(object);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add((Object)new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    public String convertBrIdToString(int n) {
        return (String)InnerBrLookup.sKeys.get(n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int n) {
        int n2 = INTERNAL_LAYOUT_ID_LOOKUP.get(n);
        if (n2 <= 0) return null;
        Object object = view.getTag();
        if (object == null) throw new RuntimeException("view must have a tag");
        int n3 = (n2 - 1) / 50;
        if (n3 == 0) return this.internalGetViewDataBinding0(dataBindingComponent, view, n2, object);
        if (n3 != 1) return null;
        return this.internalGetViewDataBinding1(dataBindingComponent, view, n2, object);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] arrview, int n) {
        if (arrview != null) {
            if (arrview.length == 0) {
                return null;
            }
            if (INTERNAL_LAYOUT_ID_LOOKUP.get(n) > 0) {
                if (arrview[0].getTag() != null) {
                    return null;
                }
                throw new RuntimeException("view must have a tag");
            }
        }
        return null;
    }

    public int getLayoutId(String string2) {
        if (string2 == null) {
            return 0;
        }
        Integer n = (Integer)InnerLayoutIdLookup.sKeys.get((Object)string2);
        if (n == null) {
            return 0;
        }
        return n;
    }

}

