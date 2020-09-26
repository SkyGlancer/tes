/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Service
 *  android.content.Context
 *  androidx.fragment.app.Fragment
 *  app.dukhaan.di.component.DaggerAppComponent$AccountFragmentSubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$AddBusinessActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$AddVariantActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$AddressSelectActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$CategoriesFragmentSubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$CategoryDetailActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$ChangeLanguageActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$CreateCategoryActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$DeliveryChargesActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$EditBusinessActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$EditCategoryActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$EditProductActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$HomeFragmentSubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$KillswitchActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$MainActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$MobileNumberActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$OnBoardingActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$OnboardingStepsFragmentSubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$OrderDetailsActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$OrdersFragmentSubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$OrdersListFragmentSubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$PrivacyPolicyActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$ProductsFragmentSubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$ReportIssueActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$SplashActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$SyncContactsActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$VerifyMobileActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$VerifyOtpActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$VideoTutorialsActivitySubcomponentFactory
 *  app.dukhaan.di.component.DaggerAppComponent$WAStoriesActivitySubcomponentFactory
 *  app.dukhaan.di.module.AppModule_ProvideAppDatabaseFactory
 *  app.dukhaan.di.module.AppModule_ProvideAppPrefsFactory
 *  app.dukhaan.di.module.AppModule_ProvideAppUpdateManagerFactory
 *  app.dukhaan.di.module.AppModule_ProvideAppUpdateUtilsFactory
 *  app.dukhaan.di.module.AppModule_ProvideContextFactory
 *  app.dukhaan.di.module.AppModule_ProvideDataRepositoryFactory
 *  app.dukhaan.di.module.AppModule_ProvidesApiServiceFactory
 *  app.dukhaan.di.module.AppModule_ProvidesHttpLoggingInterceptorFactory
 *  app.dukhaan.di.module.AppModule_ProvidesOkHttpClientFactory
 *  app.dukhaan.di.module.AppModule_ProvidesRetrofitFactory
 *  com.google.android.play.core.appupdate.AppUpdateManager
 *  dagger.android.AndroidInjector
 *  dagger.android.AndroidInjector$Factory
 *  dagger.android.DispatchingAndroidInjector
 *  dagger.android.DispatchingAndroidInjector_Factory
 *  dagger.internal.DoubleCheck
 *  dagger.internal.Factory
 *  dagger.internal.InstanceFactory
 *  dagger.internal.MapBuilder
 *  dagger.internal.Preconditions
 *  java.lang.Class
 *  java.lang.Object
 *  java.util.Collections
 *  java.util.Map
 *  javax.inject.Provider
 *  okhttp3.OkHttpClient
 *  okhttp3.logging.HttpLoggingInterceptor
 *  retrofit2.Retrofit
 */
package app.dukhaan.di.component;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import androidx.fragment.app.Fragment;
import app.dukhaan.app.MyApplication;
import app.dukhaan.app.MyApplication_MembersInjector;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppDatabase;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.di.builder.ActivityBuilder_BinHomeFragment;
import app.dukhaan.di.builder.ActivityBuilder_BindAccountFragment;
import app.dukhaan.di.builder.ActivityBuilder_BindAddVariantActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindAddressSelectActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindBusinessDetailsActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindCategoryDetailActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindCategoryFragment;
import app.dukhaan.di.builder.ActivityBuilder_BindChangeLanguage;
import app.dukhaan.di.builder.ActivityBuilder_BindCreateCategoryActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindDeliveryChargesActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindEditBusinessActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindEditCategoryActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindEditProductActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindKillswitchActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindMainActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindMobileNumberActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindOnBoardingActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindOnboardingStepsFragment;
import app.dukhaan.di.builder.ActivityBuilder_BindOrderDetailsActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindOrdersFragment;
import app.dukhaan.di.builder.ActivityBuilder_BindOrdersListFragment;
import app.dukhaan.di.builder.ActivityBuilder_BindPrivacyPolicyActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindProductFragment;
import app.dukhaan.di.builder.ActivityBuilder_BindReportIssueActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindSplashActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindSyncContactsActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindVerifyMobileActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindVerifyOtpActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindVideoTutorialActivity;
import app.dukhaan.di.builder.ActivityBuilder_BindWAStoriesActivity;
import app.dukhaan.di.component.AppComponent;
import app.dukhaan.di.component.DaggerAppComponent;
import app.dukhaan.di.module.AppModule;
import app.dukhaan.di.module.AppModule_ProvideAppDatabaseFactory;
import app.dukhaan.di.module.AppModule_ProvideAppPrefsFactory;
import app.dukhaan.di.module.AppModule_ProvideAppUpdateManagerFactory;
import app.dukhaan.di.module.AppModule_ProvideAppUpdateUtilsFactory;
import app.dukhaan.di.module.AppModule_ProvideContextFactory;
import app.dukhaan.di.module.AppModule_ProvideDataRepositoryFactory;
import app.dukhaan.di.module.AppModule_ProvidesApiServiceFactory;
import app.dukhaan.di.module.AppModule_ProvidesHttpLoggingInterceptorFactory;
import app.dukhaan.di.module.AppModule_ProvidesOkHttpClientFactory;
import app.dukhaan.di.module.AppModule_ProvidesRetrofitFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.account.AccountFragment;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import app.dukhaan.ui.addresspicker.AddressSelectActivity;
import app.dukhaan.ui.addvariant.AddVariantActivity;
import app.dukhaan.ui.categories.CategoriesFragment;
import app.dukhaan.ui.categorydetail.CategoryDetailActivity;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity;
import app.dukhaan.ui.createcategory.CreateCategoryActivity;
import app.dukhaan.ui.deliverycharges.DeliveryChargesActivity;
import app.dukhaan.ui.editbusiness.EditBusinessActivity;
import app.dukhaan.ui.editcategory.EditCategoryActivity;
import app.dukhaan.ui.editproduct.EditProductActivity;
import app.dukhaan.ui.home.HomeFragment;
import app.dukhaan.ui.killswitch.KillswitchActivity;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.ui.mobilenumber.MobileNumberActivity;
import app.dukhaan.ui.onboarding.OnBoardingActivity;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import app.dukhaan.ui.orders.OrdersFragment;
import app.dukhaan.ui.orders_list.OrdersListFragment;
import app.dukhaan.ui.privacy.PrivacyPolicyActivity;
import app.dukhaan.ui.products.ProductsFragment;
import app.dukhaan.ui.reportissue.ReportIssueActivity;
import app.dukhaan.ui.splash.SplashActivity;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity;
import app.dukhaan.ui.verifyotp.VerifyOtpActivity;
import app.dukhaan.ui.videotutorials.VideoTutorialsActivity;
import app.dukhaan.util.AppUpdateUtils;
import com.google.android.play.core.appupdate.AppUpdateManager;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public final class DaggerAppComponent
implements AppComponent {
    private Provider<ActivityBuilder_BindAccountFragment.AccountFragmentSubcomponent.Factory> accountFragmentSubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindBusinessDetailsActivity.AddBusinessActivitySubcomponent.Factory> addBusinessActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindAddVariantActivity.AddVariantActivitySubcomponent.Factory> addVariantActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindAddressSelectActivity.AddressSelectActivitySubcomponent.Factory> addressSelectActivitySubcomponentFactoryProvider;
    private Provider<Application> applicationProvider;
    private Provider<ActivityBuilder_BindCategoryFragment.CategoriesFragmentSubcomponent.Factory> categoriesFragmentSubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindCategoryDetailActivity.CategoryDetailActivitySubcomponent.Factory> categoryDetailActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindChangeLanguage.ChangeLanguageActivitySubcomponent.Factory> changeLanguageActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindCreateCategoryActivity.CreateCategoryActivitySubcomponent.Factory> createCategoryActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindDeliveryChargesActivity.DeliveryChargesActivitySubcomponent.Factory> deliveryChargesActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindEditBusinessActivity.EditBusinessActivitySubcomponent.Factory> editBusinessActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindEditCategoryActivity.EditCategoryActivitySubcomponent.Factory> editCategoryActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindEditProductActivity.EditProductActivitySubcomponent.Factory> editProductActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BinHomeFragment.HomeFragmentSubcomponent.Factory> homeFragmentSubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindKillswitchActivity.KillswitchActivitySubcomponent.Factory> killswitchActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory> mainActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindMobileNumberActivity.MobileNumberActivitySubcomponent.Factory> mobileNumberActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindOnBoardingActivity.OnBoardingActivitySubcomponent.Factory> onBoardingActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindOnboardingStepsFragment.OnboardingStepsFragmentSubcomponent.Factory> onboardingStepsFragmentSubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindOrderDetailsActivity.OrderDetailsActivitySubcomponent.Factory> orderDetailsActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindOrdersFragment.OrdersFragmentSubcomponent.Factory> ordersFragmentSubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindOrdersListFragment.OrdersListFragmentSubcomponent.Factory> ordersListFragmentSubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindPrivacyPolicyActivity.PrivacyPolicyActivitySubcomponent.Factory> privacyPolicyActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindProductFragment.ProductsFragmentSubcomponent.Factory> productsFragmentSubcomponentFactoryProvider;
    private Provider<AppDatabase> provideAppDatabaseProvider;
    private Provider<AppPref> provideAppPrefsProvider;
    private Provider<AppUpdateManager> provideAppUpdateManagerProvider;
    private Provider<AppUpdateUtils> provideAppUpdateUtilsProvider;
    private Provider<Context> provideContextProvider;
    private Provider<DataRepository> provideDataRepositoryProvider;
    private Provider<ApiService> providesApiServiceProvider;
    private Provider<HttpLoggingInterceptor> providesHttpLoggingInterceptorProvider;
    private Provider<OkHttpClient> providesOkHttpClientProvider;
    private Provider<Retrofit> providesRetrofitProvider;
    private Provider<ActivityBuilder_BindReportIssueActivity.ReportIssueActivitySubcomponent.Factory> reportIssueActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindSplashActivity.SplashActivitySubcomponent.Factory> splashActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindSyncContactsActivity.SyncContactsActivitySubcomponent.Factory> syncContactsActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindVerifyMobileActivity.VerifyMobileActivitySubcomponent.Factory> verifyMobileActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindVerifyOtpActivity.VerifyOtpActivitySubcomponent.Factory> verifyOtpActivitySubcomponentFactoryProvider;
    private Provider<ActivityBuilder_BindVideoTutorialActivity.VideoTutorialsActivitySubcomponent.Factory> videoTutorialsActivitySubcomponentFactoryProvider;

    private DaggerAppComponent(AppModule appModule, Application application) {
        this.initialize(appModule, application);
    }

    static /* synthetic */ Provider access$3200(DaggerAppComponent daggerAppComponent) {
        return daggerAppComponent.provideDataRepositoryProvider;
    }

    static /* synthetic */ Provider access$3300(DaggerAppComponent daggerAppComponent) {
        return daggerAppComponent.providesApiServiceProvider;
    }

    static /* synthetic */ Provider access$3400(DaggerAppComponent daggerAppComponent) {
        return daggerAppComponent.provideAppUpdateUtilsProvider;
    }

    static /* synthetic */ Provider access$3500(DaggerAppComponent daggerAppComponent) {
        return daggerAppComponent.provideAppUpdateManagerProvider;
    }

    public static AppComponent.Builder builder() {
        return new Builder();
    }

    private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
        return DispatchingAndroidInjector_Factory.newInstance(this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), (Map)Collections.emptyMap());
    }

    private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
        return DispatchingAndroidInjector_Factory.newInstance(this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), (Map)Collections.emptyMap());
    }

    private DispatchingAndroidInjector<Service> getDispatchingAndroidInjectorOfService() {
        return DispatchingAndroidInjector_Factory.newInstance(this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), (Map)Collections.emptyMap());
    }

    private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
        return MapBuilder.newMapBuilder((int)29).put(MainActivity.class, this.mainActivitySubcomponentFactoryProvider).put(MobileNumberActivity.class, this.mobileNumberActivitySubcomponentFactoryProvider).put(SplashActivity.class, this.splashActivitySubcomponentFactoryProvider).put(VerifyOtpActivity.class, this.verifyOtpActivitySubcomponentFactoryProvider).put(AddBusinessActivity.class, this.addBusinessActivitySubcomponentFactoryProvider).put(AddVariantActivity.class, this.addVariantActivitySubcomponentFactoryProvider).put(HomeFragment.class, this.homeFragmentSubcomponentFactoryProvider).put(CategoriesFragment.class, this.categoriesFragmentSubcomponentFactoryProvider).put(OrdersListFragment.class, this.ordersListFragmentSubcomponentFactoryProvider).put(OrdersFragment.class, this.ordersFragmentSubcomponentFactoryProvider).put(ProductsFragment.class, this.productsFragmentSubcomponentFactoryProvider).put(VideoTutorialsActivity.class, this.videoTutorialsActivitySubcomponentFactoryProvider).put(EditProductActivity.class, this.editProductActivitySubcomponentFactoryProvider).put(OrderDetailsActivity.class, this.orderDetailsActivitySubcomponentFactoryProvider).put(CreateCategoryActivity.class, this.createCategoryActivitySubcomponentFactoryProvider).put(EditCategoryActivity.class, this.editCategoryActivitySubcomponentFactoryProvider).put(EditBusinessActivity.class, this.editBusinessActivitySubcomponentFactoryProvider).put(AccountFragment.class, this.accountFragmentSubcomponentFactoryProvider).put(ChangeLanguageActivity.class, this.changeLanguageActivitySubcomponentFactoryProvider).put(OnBoardingActivity.class, this.onBoardingActivitySubcomponentFactoryProvider).put(KillswitchActivity.class, this.killswitchActivitySubcomponentFactoryProvider).put(VerifyMobileActivity.class, this.verifyMobileActivitySubcomponentFactoryProvider).put(PrivacyPolicyActivity.class, this.privacyPolicyActivitySubcomponentFactoryProvider).put(ReportIssueActivity.class, this.reportIssueActivitySubcomponentFactoryProvider).put(CategoryDetailActivity.class, this.categoryDetailActivitySubcomponentFactoryProvider).put(DeliveryChargesActivity.class, this.deliveryChargesActivitySubcomponentFactoryProvider).put(AddressSelectActivity.class, this.addressSelectActivitySubcomponentFactoryProvider).put(OnboardingStepsFragment.class, this.onboardingStepsFragmentSubcomponentFactoryProvider).put(SyncContactsActivity.class, this.syncContactsActivitySubcomponentFactoryProvider).build();
    }

    private void initialize(AppModule appModule, Application application) {
        Provider provider;
        Provider provider2;
        Factory factory;
        Provider provider3;
        Provider provider4;
        this.mainActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.mobileNumberActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindMobileNumberActivity.MobileNumberActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindMobileNumberActivity.MobileNumberActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.splashActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindSplashActivity.SplashActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindSplashActivity.SplashActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.verifyOtpActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindVerifyOtpActivity.VerifyOtpActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindVerifyOtpActivity.VerifyOtpActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.addBusinessActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindBusinessDetailsActivity.AddBusinessActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindBusinessDetailsActivity.AddBusinessActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.addVariantActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindAddVariantActivity.AddVariantActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindAddVariantActivity.AddVariantActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.homeFragmentSubcomponentFactoryProvider = new Provider<ActivityBuilder_BinHomeFragment.HomeFragmentSubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BinHomeFragment.HomeFragmentSubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.categoriesFragmentSubcomponentFactoryProvider = new Provider<ActivityBuilder_BindCategoryFragment.CategoriesFragmentSubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindCategoryFragment.CategoriesFragmentSubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.ordersListFragmentSubcomponentFactoryProvider = new Provider<ActivityBuilder_BindOrdersListFragment.OrdersListFragmentSubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindOrdersListFragment.OrdersListFragmentSubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.ordersFragmentSubcomponentFactoryProvider = new Provider<ActivityBuilder_BindOrdersFragment.OrdersFragmentSubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindOrdersFragment.OrdersFragmentSubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.productsFragmentSubcomponentFactoryProvider = new Provider<ActivityBuilder_BindProductFragment.ProductsFragmentSubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindProductFragment.ProductsFragmentSubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.videoTutorialsActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindVideoTutorialActivity.VideoTutorialsActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindVideoTutorialActivity.VideoTutorialsActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.editProductActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindEditProductActivity.EditProductActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindEditProductActivity.EditProductActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.orderDetailsActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindOrderDetailsActivity.OrderDetailsActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindOrderDetailsActivity.OrderDetailsActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.createCategoryActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindCreateCategoryActivity.CreateCategoryActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindCreateCategoryActivity.CreateCategoryActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.editCategoryActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindEditCategoryActivity.EditCategoryActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindEditCategoryActivity.EditCategoryActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.editBusinessActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindEditBusinessActivity.EditBusinessActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindEditBusinessActivity.EditBusinessActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.accountFragmentSubcomponentFactoryProvider = new Provider<ActivityBuilder_BindAccountFragment.AccountFragmentSubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindAccountFragment.AccountFragmentSubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.changeLanguageActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindChangeLanguage.ChangeLanguageActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindChangeLanguage.ChangeLanguageActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.onBoardingActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindOnBoardingActivity.OnBoardingActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindOnBoardingActivity.OnBoardingActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.killswitchActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindKillswitchActivity.KillswitchActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindKillswitchActivity.KillswitchActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.verifyMobileActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindVerifyMobileActivity.VerifyMobileActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindVerifyMobileActivity.VerifyMobileActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.privacyPolicyActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindPrivacyPolicyActivity.PrivacyPolicyActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindPrivacyPolicyActivity.PrivacyPolicyActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.reportIssueActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindReportIssueActivity.ReportIssueActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindReportIssueActivity.ReportIssueActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.categoryDetailActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindCategoryDetailActivity.CategoryDetailActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindCategoryDetailActivity.CategoryDetailActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.deliveryChargesActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindDeliveryChargesActivity.DeliveryChargesActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindDeliveryChargesActivity.DeliveryChargesActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.addressSelectActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindAddressSelectActivity.AddressSelectActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindAddressSelectActivity.AddressSelectActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.onboardingStepsFragmentSubcomponentFactoryProvider = new Provider<ActivityBuilder_BindOnboardingStepsFragment.OnboardingStepsFragmentSubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindOnboardingStepsFragment.OnboardingStepsFragmentSubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.syncContactsActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindSyncContactsActivity.SyncContactsActivitySubcomponent.Factory>(this){
            final /* synthetic */ DaggerAppComponent this$0;
            {
                this.this$0 = daggerAppComponent;
            }

            public ActivityBuilder_BindSyncContactsActivity.SyncContactsActivitySubcomponent.Factory get() {
                return new /* Unavailable Anonymous Inner Class!! */;
            }
        };
        this.provideAppDatabaseProvider = DoubleCheck.provider((Provider)AppModule_ProvideAppDatabaseFactory.create((AppModule)appModule));
        this.provideAppPrefsProvider = provider3 = DoubleCheck.provider((Provider)AppModule_ProvideAppPrefsFactory.create((AppModule)appModule));
        this.provideDataRepositoryProvider = DoubleCheck.provider((Provider)AppModule_ProvideDataRepositoryFactory.create((AppModule)appModule, this.provideAppDatabaseProvider, (Provider)provider3));
        this.providesHttpLoggingInterceptorProvider = DoubleCheck.provider((Provider)AppModule_ProvidesHttpLoggingInterceptorFactory.create((AppModule)appModule));
        this.applicationProvider = factory = InstanceFactory.create((Object)application);
        this.provideContextProvider = provider = DoubleCheck.provider((Provider)AppModule_ProvideContextFactory.create((AppModule)appModule, (Provider)factory));
        this.providesOkHttpClientProvider = provider2 = DoubleCheck.provider((Provider)AppModule_ProvidesOkHttpClientFactory.create((AppModule)appModule, this.providesHttpLoggingInterceptorProvider, (Provider)provider, this.provideAppPrefsProvider));
        this.providesRetrofitProvider = provider4 = DoubleCheck.provider((Provider)AppModule_ProvidesRetrofitFactory.create((AppModule)appModule, (Provider)provider2));
        this.providesApiServiceProvider = DoubleCheck.provider((Provider)AppModule_ProvidesApiServiceFactory.create((AppModule)appModule, (Provider)provider4));
        this.provideAppUpdateUtilsProvider = DoubleCheck.provider((Provider)AppModule_ProvideAppUpdateUtilsFactory.create((AppModule)appModule));
        this.provideAppUpdateManagerProvider = DoubleCheck.provider((Provider)AppModule_ProvideAppUpdateManagerFactory.create((AppModule)appModule, this.provideContextProvider));
    }

    private MyApplication injectMyApplication(MyApplication myApplication) {
        MyApplication_MembersInjector.injectActivityDispatchingAndroidInjector(myApplication, this.getDispatchingAndroidInjectorOfActivity());
        MyApplication_MembersInjector.injectDispatchingServiceInjector(myApplication, this.getDispatchingAndroidInjectorOfService());
        MyApplication_MembersInjector.injectMFragmentInjector(myApplication, this.getDispatchingAndroidInjectorOfFragment());
        return myApplication;
    }

    @Override
    public void inject(MyApplication myApplication) {
        this.injectMyApplication(myApplication);
    }

    private static final class Builder
    implements AppComponent.Builder {
        private Application application;

        private Builder() {
        }

        @Override
        public Builder application(Application application) {
            this.application = (Application)Preconditions.checkNotNull((Object)application);
            return this;
        }

        @Override
        public AppComponent build() {
            Preconditions.checkBuilderRequirement((Object)this.application, Application.class);
            return new DaggerAppComponent(new AppModule(), this.application);
        }
    }

}

