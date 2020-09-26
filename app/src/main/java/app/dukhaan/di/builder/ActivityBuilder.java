/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.ui.account.AccountFragment
 *  app.dukhaan.ui.addbusiness.AddBusinessActivity
 *  app.dukhaan.ui.addresspicker.AddressSelectActivity
 *  app.dukhaan.ui.addvariant.AddVariantActivity
 *  app.dukhaan.ui.categories.CategoriesFragment
 *  app.dukhaan.ui.categorydetail.CategoryDetailActivity
 *  app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity
 *  app.dukhaan.ui.createcategory.CreateCategoryActivity
 *  app.dukhaan.ui.deliverycharges.DeliveryChargesActivity
 *  app.dukhaan.ui.editbusiness.EditBusinessActivity
 *  app.dukhaan.ui.editcategory.EditCategoryActivity
 *  app.dukhaan.ui.editproduct.EditProductActivity
 *  app.dukhaan.ui.home.HomeFragment
 *  app.dukhaan.ui.killswitch.KillswitchActivity
 *  app.dukhaan.ui.main.MainActivity
 *  app.dukhaan.ui.mobilenumber.MobileNumberActivity
 *  app.dukhaan.ui.onboarding.OnBoardingActivity
 *  app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment
 *  app.dukhaan.ui.orderdetail.OrderDetailsActivity
 *  app.dukhaan.ui.orders.OrdersFragment
 *  app.dukhaan.ui.orders_list.OrdersListFragment
 *  app.dukhaan.ui.privacy.PrivacyPolicyActivity
 *  app.dukhaan.ui.products.ProductsFragment
 *  app.dukhaan.ui.reportissue.ReportIssueActivity
 *  app.dukhaan.ui.splash.SplashActivity
 *  app.dukhaan.ui.sync_contacts.SyncContactsActivity
 *  app.dukhaan.ui.verifymobile.VerifyMobileActivity
 *  app.dukhaan.ui.verifyotp.VerifyOtpActivity
 *  app.dukhaan.ui.videotutorials.VideoTutorialsActivity
 *  dagger.Module
 *  dagger.android.ContributesAndroidInjector
 *  java.lang.Object
 */
package app.dukhaan.di.builder;

import app.dukhaan.ui.account.AccountFragment;
import app.dukhaan.ui.account.AccountModule;
import app.dukhaan.ui.addbusiness.AddBusinessActivity;
import app.dukhaan.ui.addbusiness.AddBusinessModule;
import app.dukhaan.ui.addresspicker.AddressPickerModule;
import app.dukhaan.ui.addresspicker.AddressSelectActivity;
import app.dukhaan.ui.addvariant.AddVariantActivity;
import app.dukhaan.ui.addvariant.AddVariantModule;
import app.dukhaan.ui.categories.CategoriesFragment;
import app.dukhaan.ui.categories.CategoryModule;
import app.dukhaan.ui.categorydetail.CategoryDetailActivity;
import app.dukhaan.ui.categorydetail.CategoryDetailModule;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageActivity;
import app.dukhaan.ui.createcategory.CreateCategoryActivity;
import app.dukhaan.ui.createcategory.CreateCategoryModule;
import app.dukhaan.ui.deliverycharges.DeliveryChargesActivity;
import app.dukhaan.ui.deliverycharges.DeliveryChargesModule;
import app.dukhaan.ui.editbusiness.EditBusinessActivity;
import app.dukhaan.ui.editbusiness.EditBusinessModule;
import app.dukhaan.ui.editcategory.EditCategoryActivity;
import app.dukhaan.ui.editcategory.EditCategoryModule;
import app.dukhaan.ui.editproduct.EditProductActivity;
import app.dukhaan.ui.editproduct.EditProdutModule;
import app.dukhaan.ui.home.HomeFragment;
import app.dukhaan.ui.home.HomeModule;
import app.dukhaan.ui.killswitch.KillswitchActivity;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.ui.main.MainActivityModule;
import app.dukhaan.ui.mobilenumber.MobileNumberActivity;
import app.dukhaan.ui.mobilenumber.MobileNumberModule;
import app.dukhaan.ui.onboarding.OnBoardingActivity;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsFragment;
import app.dukhaan.ui.onboarding_setps.OnboardingStepsModule;
import app.dukhaan.ui.orderdetail.OrderDetailModule;
import app.dukhaan.ui.orderdetail.OrderDetailsActivity;
import app.dukhaan.ui.orders.OrdersFragment;
import app.dukhaan.ui.orders.OrdersModule;
import app.dukhaan.ui.orders_list.OrdersListFragment;
import app.dukhaan.ui.privacy.PrivacyPolicyActivity;
import app.dukhaan.ui.privacy.PrivacyPolicyModule;
import app.dukhaan.ui.products.ProductModule;
import app.dukhaan.ui.products.ProductsFragment;
import app.dukhaan.ui.reportissue.ReportIssueActivity;
import app.dukhaan.ui.reportissue.ReportIssueModule;
import app.dukhaan.ui.splash.SplashActivity;
import app.dukhaan.ui.splash.SplashModule;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity;
import app.dukhaan.ui.sync_contacts.SyncContactsModule;
import app.dukhaan.ui.verifymobile.VerifyMobileActivity;
import app.dukhaan.ui.verifymobile.VerifyMobileModule;
import app.dukhaan.ui.verifyotp.VerifyOtpActivity;
import app.dukhaan.ui.verifyotp.VerifyOtpModule;
import app.dukhaan.ui.videotutorials.VideoTutorialModule;
import app.dukhaan.ui.videotutorials.VideoTutorialsActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules={HomeModule.class})
    abstract HomeFragment binHomeFragment();

    @ContributesAndroidInjector(modules={AccountModule.class})
    abstract AccountFragment bindAccountFragment();

    @ContributesAndroidInjector(modules={AddVariantModule.class})
    abstract AddVariantActivity bindAddVariantActivity();

    @ContributesAndroidInjector(modules={AddressPickerModule.class})
    abstract AddressSelectActivity bindAddressSelectActivity();

    @ContributesAndroidInjector(modules={AddBusinessModule.class})
    abstract AddBusinessActivity bindBusinessDetailsActivity();

    @ContributesAndroidInjector(modules={CategoryDetailModule.class})
    abstract CategoryDetailActivity bindCategoryDetailActivity();

    @ContributesAndroidInjector(modules={CategoryModule.class})
    abstract CategoriesFragment bindCategoryFragment();

    @ContributesAndroidInjector(modules={AccountModule.class})
    abstract ChangeLanguageActivity bindChangeLanguage();

    @ContributesAndroidInjector(modules={CreateCategoryModule.class})
    abstract CreateCategoryActivity bindCreateCategoryActivity();

    @ContributesAndroidInjector(modules={DeliveryChargesModule.class})
    abstract DeliveryChargesActivity bindDeliveryChargesActivity();

    @ContributesAndroidInjector(modules={EditBusinessModule.class})
    abstract EditBusinessActivity bindEditBusinessActivity();

    @ContributesAndroidInjector(modules={EditCategoryModule.class})
    abstract EditCategoryActivity bindEditCategoryActivity();

    @ContributesAndroidInjector(modules={EditProdutModule.class})
    abstract EditProductActivity bindEditProductActivity();

    @ContributesAndroidInjector(modules={AccountModule.class})
    abstract KillswitchActivity bindKillswitchActivity();

    @ContributesAndroidInjector(modules={MainActivityModule.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules={MobileNumberModule.class})
    abstract MobileNumberActivity bindMobileNumberActivity();

    @ContributesAndroidInjector(modules={AccountModule.class})
    abstract OnBoardingActivity bindOnBoardingActivity();

    @ContributesAndroidInjector(modules={OnboardingStepsModule.class})
    abstract OnboardingStepsFragment bindOnboardingStepsFragment();

    @ContributesAndroidInjector(modules={OrderDetailModule.class})
    abstract OrderDetailsActivity bindOrderDetailsActivity();

    @ContributesAndroidInjector(modules={OrdersModule.class})
    abstract OrdersFragment bindOrdersFragment();

    @ContributesAndroidInjector(modules={OrdersModule.class})
    abstract OrdersListFragment bindOrdersListFragment();

    @ContributesAndroidInjector(modules={PrivacyPolicyModule.class})
    abstract PrivacyPolicyActivity bindPrivacyPolicyActivity();

    @ContributesAndroidInjector(modules={ProductModule.class})
    abstract ProductsFragment bindProductFragment();

    @ContributesAndroidInjector(modules={ReportIssueModule.class})
    abstract ReportIssueActivity bindReportIssueActivity();

    @ContributesAndroidInjector(modules={SplashModule.class})
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules={SyncContactsModule.class})
    abstract SyncContactsActivity bindSyncContactsActivity();

    @ContributesAndroidInjector(modules={VerifyMobileModule.class})
    abstract VerifyMobileActivity bindVerifyMobileActivity();

    @ContributesAndroidInjector(modules={VerifyOtpModule.class})
    abstract VerifyOtpActivity bindVerifyOtpActivity();

    @ContributesAndroidInjector(modules={VideoTutorialModule.class})
    abstract VideoTutorialsActivity bindVideoTutorialActivity();
}

