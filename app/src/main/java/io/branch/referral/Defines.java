/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.io.branch.referral;

public class Defines {

    public static final class IntentKeys
    extends Enum<IntentKeys> {
        private static final /* synthetic */ IntentKeys[] $VALUES;
        public static final /* enum */ IntentKeys AndroidPushNotificationKey;
        public static final /* enum */ IntentKeys BranchData;
        public static final /* enum */ IntentKeys BranchLinkUsed;
        public static final /* enum */ IntentKeys BranchURI;
        public static final /* enum */ IntentKeys ForceNewBranchSession;
        private String key = "";

        static {
            IntentKeys intentKeys;
            BranchData = new IntentKeys("branch_data");
            AndroidPushNotificationKey = new IntentKeys("branch");
            ForceNewBranchSession = new IntentKeys("branch_force_new_session");
            BranchLinkUsed = new IntentKeys("branch_used");
            BranchURI = intentKeys = new IntentKeys("branch");
            IntentKeys[] arrintentKeys = new IntentKeys[]{BranchData, AndroidPushNotificationKey, ForceNewBranchSession, BranchLinkUsed, intentKeys};
            $VALUES = arrintentKeys;
        }

        private IntentKeys(String string3) {
            this.key = string3;
        }

        public static IntentKeys valueOf(String string2) {
            return (IntentKeys)Enum.valueOf(IntentKeys.class, (String)string2);
        }

        public static IntentKeys[] values() {
            return (IntentKeys[])$VALUES.clone();
        }

        public String getKey() {
            return this.key;
        }

        public String toString() {
            return this.key;
        }
    }

    public static final class Jsonkey
    extends Enum<Jsonkey> {
        private static final /* synthetic */ Jsonkey[] $VALUES;
        public static final /* enum */ Jsonkey AAID;
        public static final /* enum */ Jsonkey APILevel;
        public static final /* enum */ Jsonkey AdType;
        public static final /* enum */ Jsonkey AddressCity;
        public static final /* enum */ Jsonkey AddressCountry;
        public static final /* enum */ Jsonkey AddressPostalCode;
        public static final /* enum */ Jsonkey AddressRegion;
        public static final /* enum */ Jsonkey AddressStreet;
        public static final /* enum */ Jsonkey AdvertisingIDs;
        public static final /* enum */ Jsonkey Affiliation;
        public static final /* enum */ Jsonkey Amount;
        public static final /* enum */ Jsonkey AndroidAppLinkURL;
        public static final /* enum */ Jsonkey AndroidDeepLinkPath;
        public static final /* enum */ Jsonkey AndroidID;
        public static final /* enum */ Jsonkey AndroidPushIdentifier;
        @Deprecated
        public static final /* enum */ Jsonkey AndroidPushNotificationKey;
        public static final /* enum */ Jsonkey AppIdentifier;
        public static final /* enum */ Jsonkey AppLinks;
        public static final /* enum */ Jsonkey AppVersion;
        public static final /* enum */ Jsonkey BeginAfterID;
        @Deprecated
        public static final /* enum */ Jsonkey BranchData;
        public static final /* enum */ Jsonkey BranchIdentity;
        public static final /* enum */ Jsonkey BranchKey;
        @Deprecated
        public static final /* enum */ Jsonkey BranchLinkUsed;
        public static final /* enum */ Jsonkey BranchViewAction;
        public static final /* enum */ Jsonkey BranchViewData;
        public static final /* enum */ Jsonkey BranchViewHtml;
        public static final /* enum */ Jsonkey BranchViewID;
        public static final /* enum */ Jsonkey BranchViewNumOfUse;
        public static final /* enum */ Jsonkey BranchViewUrl;
        public static final /* enum */ Jsonkey Branch_Instrumentation;
        public static final /* enum */ Jsonkey Branch_Round_Trip_Time;
        public static final /* enum */ Jsonkey Brand;
        public static final /* enum */ Jsonkey Bucket;
        public static final /* enum */ Jsonkey CPUType;
        public static final /* enum */ Jsonkey CalculationType;
        public static final /* enum */ Jsonkey CanonicalIdentifier;
        public static final /* enum */ Jsonkey CanonicalUrl;
        public static final /* enum */ Jsonkey ClickedReferrerTimeStamp;
        public static final /* enum */ Jsonkey Clicked_Branch_Link;
        public static final /* enum */ Jsonkey CommerceData;
        public static final /* enum */ Jsonkey Condition;
        public static final /* enum */ Jsonkey ConnectionType;
        public static final /* enum */ Jsonkey ContentActionView;
        public static final /* enum */ Jsonkey ContentAnalyticsMode;
        public static final /* enum */ Jsonkey ContentData;
        public static final /* enum */ Jsonkey ContentDesc;
        public static final /* enum */ Jsonkey ContentEvents;
        public static final /* enum */ Jsonkey ContentExpiryTime;
        public static final /* enum */ Jsonkey ContentImgUrl;
        public static final /* enum */ Jsonkey ContentItems;
        public static final /* enum */ Jsonkey ContentKeyWords;
        public static final /* enum */ Jsonkey ContentNavPath;
        public static final /* enum */ Jsonkey ContentPath;
        public static final /* enum */ Jsonkey ContentSchema;
        public static final /* enum */ Jsonkey ContentTitle;
        public static final /* enum */ Jsonkey ContentType;
        public static final /* enum */ Jsonkey Country;
        public static final /* enum */ Jsonkey Coupon;
        public static final /* enum */ Jsonkey CreationSource;
        public static final /* enum */ Jsonkey CreationTimestamp;
        public static final /* enum */ Jsonkey Currency;
        public static final /* enum */ Jsonkey CustomData;
        public static final /* enum */ Jsonkey CustomerEventAlias;
        public static final /* enum */ Jsonkey Data;
        public static final /* enum */ Jsonkey Debug;
        public static final /* enum */ Jsonkey DeepLinkPath;
        public static final /* enum */ Jsonkey DefaultBucket;
        public static final /* enum */ Jsonkey Description;
        public static final /* enum */ Jsonkey DeveloperIdentity;
        public static final /* enum */ Jsonkey DeviceBuildId;
        public static final /* enum */ Jsonkey DeviceCarrier;
        public static final /* enum */ Jsonkey DeviceFingerprintID;
        public static final /* enum */ Jsonkey Direction;
        public static final /* enum */ Jsonkey DisableAdNetworkCallouts;
        public static final /* enum */ Jsonkey Environment;
        public static final /* enum */ Jsonkey Event;
        public static final /* enum */ Jsonkey EventData;
        public static final /* enum */ Jsonkey Expiration;
        public static final /* enum */ Jsonkey External_Intent_Extra;
        public static final /* enum */ Jsonkey External_Intent_URI;
        public static final /* enum */ Jsonkey FaceBookAppLinkChecked;
        public static final /* enum */ Jsonkey FireAdId;
        public static final /* enum */ Jsonkey FirstInstallTime;
        public static final /* enum */ Jsonkey GoogleAdvertisingID;
        public static final /* enum */ Jsonkey GooglePlayInstallReferrer;
        public static final /* enum */ Jsonkey GoogleSearchInstallReferrer;
        public static final /* enum */ Jsonkey HardwareID;
        public static final /* enum */ Jsonkey HardwareIDType;
        public static final /* enum */ Jsonkey HardwareIDTypeRandom;
        public static final /* enum */ Jsonkey HardwareIDTypeVendor;
        public static final /* enum */ Jsonkey Identity;
        public static final /* enum */ Jsonkey IdentityID;
        public static final /* enum */ Jsonkey ImageCaptions;
        public static final /* enum */ Jsonkey InstallBeginTimeStamp;
        public static final /* enum */ Jsonkey InstallMetadata;
        public static final /* enum */ Jsonkey Instant;
        public static final /* enum */ Jsonkey InstantApp;
        public static final /* enum */ Jsonkey InstantDeepLinkSession;
        public static final /* enum */ Jsonkey IsFirstSession;
        public static final /* enum */ Jsonkey IsFullAppConv;
        public static final /* enum */ Jsonkey IsHardwareIDReal;
        public static final /* enum */ Jsonkey IsReferrable;
        public static final /* enum */ Jsonkey LATDAttributionWindow;
        public static final /* enum */ Jsonkey LATVal;
        public static final /* enum */ Jsonkey Language;
        public static final /* enum */ Jsonkey LastUpdateTime;
        public static final /* enum */ Jsonkey Last_Round_Trip_Time;
        public static final /* enum */ Jsonkey Latitude;
        public static final /* enum */ Jsonkey Length;
        public static final /* enum */ Jsonkey LimitedAdTracking;
        public static final /* enum */ Jsonkey Link;
        public static final /* enum */ Jsonkey LinkClickID;
        public static final /* enum */ Jsonkey LinkIdentifier;
        public static final /* enum */ Jsonkey LocalIP;
        public static final /* enum */ Jsonkey Locale;
        public static final /* enum */ Jsonkey LocallyIndexable;
        public static final /* enum */ Jsonkey Location;
        public static final /* enum */ Jsonkey Longitude;
        public static final /* enum */ Jsonkey Metadata;
        public static final /* enum */ Jsonkey Model;
        public static final /* enum */ Jsonkey Name;
        public static final /* enum */ Jsonkey NativeApp;
        public static final /* enum */ Jsonkey OS;
        public static final /* enum */ Jsonkey OSVersionAndroid;
        public static final /* enum */ Jsonkey OpenAdvertisingID;
        public static final /* enum */ Jsonkey OriginalInstallTime;
        public static final /* enum */ Jsonkey Params;
        public static final /* enum */ Jsonkey Path;
        public static final /* enum */ Jsonkey PlayAutoInstalls;
        public static final /* enum */ Jsonkey PluginName;
        public static final /* enum */ Jsonkey PluginVersion;
        public static final /* enum */ Jsonkey Prefix;
        public static final /* enum */ Jsonkey PreviousUpdateTime;
        public static final /* enum */ Jsonkey Price;
        public static final /* enum */ Jsonkey PriceCurrency;
        public static final /* enum */ Jsonkey ProductBrand;
        public static final /* enum */ Jsonkey ProductCategory;
        public static final /* enum */ Jsonkey ProductName;
        public static final /* enum */ Jsonkey ProductVariant;
        public static final /* enum */ Jsonkey PublicallyIndexable;
        public static final /* enum */ Jsonkey Quantity;
        public static final /* enum */ Jsonkey Queue_Wait_Time;
        public static final /* enum */ Jsonkey Rating;
        public static final /* enum */ Jsonkey RatingAverage;
        public static final /* enum */ Jsonkey RatingCount;
        public static final /* enum */ Jsonkey RatingMax;
        public static final /* enum */ Jsonkey ReferralCode;
        public static final /* enum */ Jsonkey ReferralLink;
        public static final /* enum */ Jsonkey ReferringBranchIdentity;
        public static final /* enum */ Jsonkey ReferringData;
        public static final /* enum */ Jsonkey ReferringLink;
        public static final /* enum */ Jsonkey Revenue;
        public static final /* enum */ Jsonkey SDK;
        public static final /* enum */ Jsonkey SKU;
        public static final /* enum */ Jsonkey ScreenDpi;
        public static final /* enum */ Jsonkey ScreenHeight;
        public static final /* enum */ Jsonkey ScreenWidth;
        public static final /* enum */ Jsonkey SdkVersion;
        public static final /* enum */ Jsonkey SearchQuery;
        public static final /* enum */ Jsonkey SessionID;
        public static final /* enum */ Jsonkey ShareError;
        public static final /* enum */ Jsonkey SharedLink;
        public static final /* enum */ Jsonkey Shipping;
        public static final /* enum */ Jsonkey Tax;
        public static final /* enum */ Jsonkey Total;
        public static final /* enum */ Jsonkey TrackingDisabled;
        public static final /* enum */ Jsonkey TransactionID;
        public static final /* enum */ Jsonkey Type;
        public static final /* enum */ Jsonkey UIMode;
        public static final /* enum */ Jsonkey URIScheme;
        public static final /* enum */ Jsonkey UTMCampaign;
        public static final /* enum */ Jsonkey UTMMedium;
        public static final /* enum */ Jsonkey UnidentifiedDevice;
        public static final /* enum */ Jsonkey Unique;
        public static final /* enum */ Jsonkey Update;
        public static final /* enum */ Jsonkey UserAgent;
        public static final /* enum */ Jsonkey UserData;
        public static final /* enum */ Jsonkey ViewList;
        public static final /* enum */ Jsonkey WiFi;
        public static final /* enum */ Jsonkey limitFacebookTracking;
        private String key = "";

        static {
            Jsonkey jsonkey;
            IdentityID = new Jsonkey("identity_id");
            Identity = new Jsonkey("identity");
            DeviceFingerprintID = new Jsonkey("device_fingerprint_id");
            SessionID = new Jsonkey("session_id");
            LinkClickID = new Jsonkey("link_click_id");
            GoogleSearchInstallReferrer = new Jsonkey("google_search_install_referrer");
            GooglePlayInstallReferrer = new Jsonkey("install_referrer_extras");
            ClickedReferrerTimeStamp = new Jsonkey("clicked_referrer_ts");
            InstallBeginTimeStamp = new Jsonkey("install_begin_ts");
            FaceBookAppLinkChecked = new Jsonkey("facebook_app_link_checked");
            BranchLinkUsed = new Jsonkey("branch_used");
            ReferringBranchIdentity = new Jsonkey("referring_branch_identity");
            BranchIdentity = new Jsonkey("branch_identity");
            BranchKey = new Jsonkey("branch_key");
            BranchData = new Jsonkey("branch_data");
            PlayAutoInstalls = new Jsonkey("play-auto-installs");
            UTMCampaign = new Jsonkey("utm_campaign");
            UTMMedium = new Jsonkey("utm_medium");
            Bucket = new Jsonkey("bucket");
            DefaultBucket = new Jsonkey("default");
            Amount = new Jsonkey("amount");
            CalculationType = new Jsonkey("calculation_type");
            Location = new Jsonkey("location");
            Type = new Jsonkey("type");
            CreationSource = new Jsonkey("creation_source");
            Prefix = new Jsonkey("prefix");
            Expiration = new Jsonkey("expiration");
            Event = new Jsonkey("event");
            Metadata = new Jsonkey("metadata");
            CommerceData = new Jsonkey("commerce_data");
            ReferralCode = new Jsonkey("referral_code");
            Total = new Jsonkey("total");
            Unique = new Jsonkey("unique");
            Length = new Jsonkey("length");
            Direction = new Jsonkey("direction");
            BeginAfterID = new Jsonkey("begin_after_id");
            Link = new Jsonkey("link");
            ReferringData = new Jsonkey("referring_data");
            ReferringLink = new Jsonkey("referring_link");
            IsFullAppConv = new Jsonkey("is_full_app_conversion");
            Data = new Jsonkey("data");
            OS = new Jsonkey("os");
            HardwareID = new Jsonkey("hardware_id");
            AndroidID = new Jsonkey("android_id");
            UnidentifiedDevice = new Jsonkey("unidentified_device");
            HardwareIDType = new Jsonkey("hardware_id_type");
            HardwareIDTypeVendor = new Jsonkey("vendor_id");
            HardwareIDTypeRandom = new Jsonkey("random");
            IsHardwareIDReal = new Jsonkey("is_hardware_id_real");
            AppVersion = new Jsonkey("app_version");
            APILevel = new Jsonkey("os_version");
            Country = new Jsonkey("country");
            Language = new Jsonkey("language");
            IsReferrable = new Jsonkey("is_referrable");
            Update = new Jsonkey("update");
            OriginalInstallTime = new Jsonkey("first_install_time");
            FirstInstallTime = new Jsonkey("latest_install_time");
            LastUpdateTime = new Jsonkey("latest_update_time");
            PreviousUpdateTime = new Jsonkey("previous_update_time");
            URIScheme = new Jsonkey("uri_scheme");
            AppLinks = new Jsonkey("app_links");
            AppIdentifier = new Jsonkey("app_identifier");
            LinkIdentifier = new Jsonkey("link_identifier");
            GoogleAdvertisingID = new Jsonkey("google_advertising_id");
            AAID = new Jsonkey("aaid");
            FireAdId = new Jsonkey("fire_ad_id");
            OpenAdvertisingID = new Jsonkey("oaid");
            LATVal = new Jsonkey("lat_val");
            LimitedAdTracking = new Jsonkey("limit_ad_tracking");
            limitFacebookTracking = new Jsonkey("limit_facebook_tracking");
            Debug = new Jsonkey("debug");
            Brand = new Jsonkey("brand");
            Model = new Jsonkey("model");
            ScreenDpi = new Jsonkey("screen_dpi");
            ScreenHeight = new Jsonkey("screen_height");
            ScreenWidth = new Jsonkey("screen_width");
            WiFi = new Jsonkey("wifi");
            LocalIP = new Jsonkey("local_ip");
            UserData = new Jsonkey("user_data");
            AdvertisingIDs = new Jsonkey("advertising_ids");
            DeveloperIdentity = new Jsonkey("developer_identity");
            UserAgent = new Jsonkey("user_agent");
            SDK = new Jsonkey("sdk");
            SdkVersion = new Jsonkey("sdk_version");
            UIMode = new Jsonkey("ui_mode");
            InstallMetadata = new Jsonkey("install_metadata");
            LATDAttributionWindow = new Jsonkey("attribution_window");
            Clicked_Branch_Link = new Jsonkey("+clicked_branch_link");
            IsFirstSession = new Jsonkey("+is_first_session");
            AndroidDeepLinkPath = new Jsonkey("$android_deeplink_path");
            DeepLinkPath = new Jsonkey("$deeplink_path");
            AndroidAppLinkURL = new Jsonkey("android_app_link_url");
            AndroidPushNotificationKey = new Jsonkey("branch");
            AndroidPushIdentifier = new Jsonkey("push_identifier");
            CanonicalIdentifier = new Jsonkey("$canonical_identifier");
            ContentTitle = new Jsonkey("$og_title");
            ContentDesc = new Jsonkey("$og_description");
            ContentImgUrl = new Jsonkey("$og_image_url");
            CanonicalUrl = new Jsonkey("$canonical_url");
            ContentType = new Jsonkey("$content_type");
            PublicallyIndexable = new Jsonkey("$publicly_indexable");
            LocallyIndexable = new Jsonkey("$locally_indexable");
            ContentKeyWords = new Jsonkey("$keywords");
            ContentExpiryTime = new Jsonkey("$exp_date");
            Params = new Jsonkey("params");
            SharedLink = new Jsonkey("$shared_link");
            ShareError = new Jsonkey("$share_error");
            External_Intent_URI = new Jsonkey("external_intent_uri");
            External_Intent_Extra = new Jsonkey("external_intent_extra");
            Last_Round_Trip_Time = new Jsonkey("lrtt");
            Branch_Round_Trip_Time = new Jsonkey("brtt");
            Branch_Instrumentation = new Jsonkey("instrumentation");
            Queue_Wait_Time = new Jsonkey("qwt");
            InstantDeepLinkSession = new Jsonkey("instant_dl_session");
            BranchViewData = new Jsonkey("branch_view_data");
            BranchViewID = new Jsonkey("id");
            BranchViewAction = new Jsonkey("action");
            BranchViewNumOfUse = new Jsonkey("number_of_use");
            BranchViewUrl = new Jsonkey("url");
            BranchViewHtml = new Jsonkey("html");
            Path = new Jsonkey("path");
            ViewList = new Jsonkey("view_list");
            ContentActionView = new Jsonkey("view");
            ContentPath = new Jsonkey("content_path");
            ContentNavPath = new Jsonkey("content_nav_path");
            ReferralLink = new Jsonkey("referral_link");
            ContentData = new Jsonkey("content_data");
            ContentEvents = new Jsonkey("events");
            ContentAnalyticsMode = new Jsonkey("content_analytics_mode");
            Environment = new Jsonkey("environment");
            InstantApp = new Jsonkey("INSTANT_APP");
            NativeApp = new Jsonkey("FULL_APP");
            CustomerEventAlias = new Jsonkey("customer_event_alias");
            TransactionID = new Jsonkey("transaction_id");
            Currency = new Jsonkey("currency");
            Revenue = new Jsonkey("revenue");
            Shipping = new Jsonkey("shipping");
            Tax = new Jsonkey("tax");
            Coupon = new Jsonkey("coupon");
            Affiliation = new Jsonkey("affiliation");
            Description = new Jsonkey("description");
            SearchQuery = new Jsonkey("search_query");
            AdType = new Jsonkey("ad_type");
            CPUType = new Jsonkey("cpu_type");
            DeviceBuildId = new Jsonkey("build");
            Locale = new Jsonkey("locale");
            ConnectionType = new Jsonkey("connection_type");
            DeviceCarrier = new Jsonkey("device_carrier");
            PluginName = new Jsonkey("plugin_name");
            PluginVersion = new Jsonkey("plugin_version");
            OSVersionAndroid = new Jsonkey("os_version_android");
            Name = new Jsonkey("name");
            CustomData = new Jsonkey("custom_data");
            EventData = new Jsonkey("event_data");
            ContentItems = new Jsonkey("content_items");
            ContentSchema = new Jsonkey("$content_schema");
            Price = new Jsonkey("$price");
            PriceCurrency = new Jsonkey("$currency");
            Quantity = new Jsonkey("$quantity");
            SKU = new Jsonkey("$sku");
            ProductName = new Jsonkey("$product_name");
            ProductBrand = new Jsonkey("$product_brand");
            ProductCategory = new Jsonkey("$product_category");
            ProductVariant = new Jsonkey("$product_variant");
            Rating = new Jsonkey("$rating");
            RatingAverage = new Jsonkey("$rating_average");
            RatingCount = new Jsonkey("$rating_count");
            RatingMax = new Jsonkey("$rating_max");
            AddressStreet = new Jsonkey("$address_street");
            AddressCity = new Jsonkey("$address_city");
            AddressRegion = new Jsonkey("$address_region");
            AddressCountry = new Jsonkey("$address_country");
            AddressPostalCode = new Jsonkey("$address_postal_code");
            Latitude = new Jsonkey("$latitude");
            Longitude = new Jsonkey("$longitude");
            ImageCaptions = new Jsonkey("$image_captions");
            Condition = new Jsonkey("$condition");
            CreationTimestamp = new Jsonkey("$creation_timestamp");
            TrackingDisabled = new Jsonkey("tracking_disabled");
            DisableAdNetworkCallouts = new Jsonkey("disable_ad_network_callouts");
            Instant = jsonkey = new Jsonkey("instant");
            Jsonkey[] arrjsonkey = new Jsonkey[]{IdentityID, Identity, DeviceFingerprintID, SessionID, LinkClickID, GoogleSearchInstallReferrer, GooglePlayInstallReferrer, ClickedReferrerTimeStamp, InstallBeginTimeStamp, FaceBookAppLinkChecked, BranchLinkUsed, ReferringBranchIdentity, BranchIdentity, BranchKey, BranchData, PlayAutoInstalls, UTMCampaign, UTMMedium, Bucket, DefaultBucket, Amount, CalculationType, Location, Type, CreationSource, Prefix, Expiration, Event, Metadata, CommerceData, ReferralCode, Total, Unique, Length, Direction, BeginAfterID, Link, ReferringData, ReferringLink, IsFullAppConv, Data, OS, HardwareID, AndroidID, UnidentifiedDevice, HardwareIDType, HardwareIDTypeVendor, HardwareIDTypeRandom, IsHardwareIDReal, AppVersion, APILevel, Country, Language, IsReferrable, Update, OriginalInstallTime, FirstInstallTime, LastUpdateTime, PreviousUpdateTime, URIScheme, AppLinks, AppIdentifier, LinkIdentifier, GoogleAdvertisingID, AAID, FireAdId, OpenAdvertisingID, LATVal, LimitedAdTracking, limitFacebookTracking, Debug, Brand, Model, ScreenDpi, ScreenHeight, ScreenWidth, WiFi, LocalIP, UserData, AdvertisingIDs, DeveloperIdentity, UserAgent, SDK, SdkVersion, UIMode, InstallMetadata, LATDAttributionWindow, Clicked_Branch_Link, IsFirstSession, AndroidDeepLinkPath, DeepLinkPath, AndroidAppLinkURL, AndroidPushNotificationKey, AndroidPushIdentifier, CanonicalIdentifier, ContentTitle, ContentDesc, ContentImgUrl, CanonicalUrl, ContentType, PublicallyIndexable, LocallyIndexable, ContentKeyWords, ContentExpiryTime, Params, SharedLink, ShareError, External_Intent_URI, External_Intent_Extra, Last_Round_Trip_Time, Branch_Round_Trip_Time, Branch_Instrumentation, Queue_Wait_Time, InstantDeepLinkSession, BranchViewData, BranchViewID, BranchViewAction, BranchViewNumOfUse, BranchViewUrl, BranchViewHtml, Path, ViewList, ContentActionView, ContentPath, ContentNavPath, ReferralLink, ContentData, ContentEvents, ContentAnalyticsMode, Environment, InstantApp, NativeApp, CustomerEventAlias, TransactionID, Currency, Revenue, Shipping, Tax, Coupon, Affiliation, Description, SearchQuery, AdType, CPUType, DeviceBuildId, Locale, ConnectionType, DeviceCarrier, PluginName, PluginVersion, OSVersionAndroid, Name, CustomData, EventData, ContentItems, ContentSchema, Price, PriceCurrency, Quantity, SKU, ProductName, ProductBrand, ProductCategory, ProductVariant, Rating, RatingAverage, RatingCount, RatingMax, AddressStreet, AddressCity, AddressRegion, AddressCountry, AddressPostalCode, Latitude, Longitude, ImageCaptions, Condition, CreationTimestamp, TrackingDisabled, DisableAdNetworkCallouts, jsonkey};
            $VALUES = arrjsonkey;
        }

        private Jsonkey(String string3) {
            this.key = string3;
        }

        public static Jsonkey valueOf(String string2) {
            return (Jsonkey)Enum.valueOf(Jsonkey.class, (String)string2);
        }

        public static Jsonkey[] values() {
            return (Jsonkey[])$VALUES.clone();
        }

        public String getKey() {
            return this.key;
        }

        public String toString() {
            return this.key;
        }
    }

    public static final class LinkParam
    extends Enum<LinkParam> {
        private static final /* synthetic */ LinkParam[] $VALUES;
        public static final /* enum */ LinkParam Alias;
        public static final /* enum */ LinkParam Campaign;
        public static final /* enum */ LinkParam Channel;
        public static final /* enum */ LinkParam Data;
        public static final /* enum */ LinkParam Duration;
        public static final /* enum */ LinkParam Feature;
        public static final /* enum */ LinkParam Stage;
        public static final /* enum */ LinkParam Tags;
        public static final /* enum */ LinkParam Type;
        public static final /* enum */ LinkParam URL;
        private String key = "";

        static {
            LinkParam linkParam;
            Tags = new LinkParam("tags");
            Alias = new LinkParam("alias");
            Type = new LinkParam("type");
            Duration = new LinkParam("duration");
            Channel = new LinkParam("channel");
            Feature = new LinkParam("feature");
            Stage = new LinkParam("stage");
            Campaign = new LinkParam("campaign");
            Data = new LinkParam("data");
            URL = linkParam = new LinkParam("url");
            LinkParam[] arrlinkParam = new LinkParam[]{Tags, Alias, Type, Duration, Channel, Feature, Stage, Campaign, Data, linkParam};
            $VALUES = arrlinkParam;
        }

        private LinkParam(String string3) {
            this.key = string3;
        }

        public static LinkParam valueOf(String string2) {
            return (LinkParam)Enum.valueOf(LinkParam.class, (String)string2);
        }

        public static LinkParam[] values() {
            return (LinkParam[])$VALUES.clone();
        }

        public String getKey() {
            return this.key;
        }

        public String toString() {
            return this.key;
        }
    }

    public static final class ModuleNameKeys
    extends Enum<ModuleNameKeys> {
        private static final /* synthetic */ ModuleNameKeys[] $VALUES;
        public static final /* enum */ ModuleNameKeys imei;
        private String key = "";

        static {
            ModuleNameKeys moduleNameKeys;
            imei = moduleNameKeys = new ModuleNameKeys("imei");
            $VALUES = new ModuleNameKeys[]{moduleNameKeys};
        }

        private ModuleNameKeys(String string3) {
            this.key = string3;
        }

        public static ModuleNameKeys valueOf(String string2) {
            return (ModuleNameKeys)Enum.valueOf(ModuleNameKeys.class, (String)string2);
        }

        public static ModuleNameKeys[] values() {
            return (ModuleNameKeys[])$VALUES.clone();
        }

        public String getKey() {
            return this.key;
        }

        public String toString() {
            return this.key;
        }
    }

    public static final class PreinstallKey
    extends Enum<PreinstallKey> {
        private static final /* synthetic */ PreinstallKey[] $VALUES;
        public static final /* enum */ PreinstallKey campaign;
        public static final /* enum */ PreinstallKey partner;
        private String key = "";

        static {
            PreinstallKey preinstallKey;
            campaign = new PreinstallKey("preinstall_campaign");
            partner = preinstallKey = new PreinstallKey("preinstall_partner");
            PreinstallKey[] arrpreinstallKey = new PreinstallKey[]{campaign, preinstallKey};
            $VALUES = arrpreinstallKey;
        }

        private PreinstallKey(String string3) {
            this.key = string3;
        }

        public static PreinstallKey valueOf(String string2) {
            return (PreinstallKey)Enum.valueOf(PreinstallKey.class, (String)string2);
        }

        public static PreinstallKey[] values() {
            return (PreinstallKey[])$VALUES.clone();
        }

        public String getKey() {
            return this.key;
        }

        public String toString() {
            return this.key;
        }
    }

    public static final class RequestPath
    extends Enum<RequestPath> {
        private static final /* synthetic */ RequestPath[] $VALUES;
        public static final /* enum */ RequestPath CompletedAction;
        public static final /* enum */ RequestPath ContentEvent;
        public static final /* enum */ RequestPath GetApp;
        public static final /* enum */ RequestPath GetCPID;
        public static final /* enum */ RequestPath GetCreditHistory;
        public static final /* enum */ RequestPath GetCredits;
        public static final /* enum */ RequestPath GetLATD;
        public static final /* enum */ RequestPath GetURL;
        public static final /* enum */ RequestPath IdentifyUser;
        public static final /* enum */ RequestPath Logout;
        public static final /* enum */ RequestPath RedeemRewards;
        public static final /* enum */ RequestPath RegisterClose;
        public static final /* enum */ RequestPath RegisterInstall;
        public static final /* enum */ RequestPath RegisterOpen;
        public static final /* enum */ RequestPath TrackCustomEvent;
        public static final /* enum */ RequestPath TrackStandardEvent;
        private String key = "";

        static {
            RequestPath requestPath;
            RedeemRewards = new RequestPath("v1/redeem");
            GetURL = new RequestPath("v1/url");
            GetApp = new RequestPath("v1/app-link-settings");
            RegisterInstall = new RequestPath("v1/install");
            RegisterClose = new RequestPath("v1/close");
            RegisterOpen = new RequestPath("v1/open");
            GetCredits = new RequestPath("v1/credits/");
            GetCreditHistory = new RequestPath("v1/credithistory");
            CompletedAction = new RequestPath("v1/event");
            IdentifyUser = new RequestPath("v1/profile");
            Logout = new RequestPath("v1/logout");
            ContentEvent = new RequestPath("v1/content-events");
            TrackStandardEvent = new RequestPath("v2/event/standard");
            TrackCustomEvent = new RequestPath("v2/event/custom");
            GetCPID = new RequestPath("v1/cpid");
            GetLATD = requestPath = new RequestPath("v1/cpid/latd");
            RequestPath[] arrrequestPath = new RequestPath[]{RedeemRewards, GetURL, GetApp, RegisterInstall, RegisterClose, RegisterOpen, GetCredits, GetCreditHistory, CompletedAction, IdentifyUser, Logout, ContentEvent, TrackStandardEvent, TrackCustomEvent, GetCPID, requestPath};
            $VALUES = arrrequestPath;
        }

        private RequestPath(String string3) {
            this.key = string3;
        }

        public static RequestPath valueOf(String string2) {
            return (RequestPath)Enum.valueOf(RequestPath.class, (String)string2);
        }

        public static RequestPath[] values() {
            return (RequestPath[])$VALUES.clone();
        }

        public String getPath() {
            return this.key;
        }

        public String toString() {
            return this.key;
        }
    }

}

