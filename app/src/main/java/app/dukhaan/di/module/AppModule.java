/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.text.TextUtils
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.di.module.-$
 *  app.dukhaan.di.module.-$$Lambda
 *  app.dukhaan.di.module.-$$Lambda$AppModule
 *  app.dukhaan.di.module.-$$Lambda$AppModule$knjnQI967zK0SHBIsOrTNp71zxI
 *  app.dukhaan.network.interceptor.ConnectivityInterceptor
 *  app.dukhaan.network.interceptor.UnauthorizedInterceptor
 *  com.google.android.play.core.appupdate.AppUpdateManager
 *  com.google.android.play.core.appupdate.AppUpdateManagerFactory
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  dagger.Module
 *  dagger.Provides
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.TimeUnit
 *  javax.inject.Singleton
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSession
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.logging.HttpLoggingInterceptor
 *  okhttp3.logging.HttpLoggingInterceptor$Level
 *  retrofit2.CallAdapter
 *  retrofit2.CallAdapter$Factory
 *  retrofit2.Converter
 *  retrofit2.Converter$Factory
 *  retrofit2.Retrofit
 *  retrofit2.Retrofit$Builder
 *  retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
 *  retrofit2.converter.gson.GsonConverterFactory
 */
package app.dukhaan.di.module;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import app.dukhaan.data.DataRepository;
import app.dukhaan.data.local.AppDatabase;
import app.dukhaan.data.local.AppDatabaseHelper;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.local.AppPrefHelper;
import app.dukhaan.di.module.-$;
import app.dukhaan.di.module.-$$Lambda$AppModule$jlbJzPmGxbotskUXqQHorQD3m9Y;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.interceptor.ConnectivityInterceptor;
import app.dukhaan.network.interceptor.UnauthorizedInterceptor;
import app.dukhaan.ui.views.customdialog.CustomDialog;
import app.dukhaan.util.AppUpdateUtils;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    static /* synthetic */ boolean lambda$providesOkHttpClient$0(String string2, SSLSession sSLSession) {
        return true;
    }

    static /* synthetic */ Response lambda$providesOkHttpClient$1(AppPref appPref, Interceptor.Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder().addHeader("Accept", "application/json");
        String string2 = appPref.getAuthToken();
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            builder.addHeader("Authorization", string2);
        }
        return chain.proceed(builder.build());
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase() {
        return new AppDatabase();
    }

    @Provides
    @Singleton
    AppDatabaseHelper provideAppDatabaseHelper(AppDatabaseHelper appDatabaseHelper) {
        return appDatabaseHelper;
    }

    @Provides
    @Singleton
    AppPrefHelper provideAppPrefHelper(AppPrefHelper appPrefHelper) {
        return appPrefHelper;
    }

    @Provides
    @Singleton
    AppPref provideAppPrefs() {
        return AppPref.getInstance();
    }

    @Provides
    @Singleton
    AppUpdateManager provideAppUpdateManager(Context context) {
        return AppUpdateManagerFactory.create((Context)context);
    }

    @Provides
    @Singleton
    AppUpdateUtils provideAppUpdateUtils() {
        return new AppUpdateUtils();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataRepository provideDataRepository(AppDatabase appDatabase, AppPref appPref) {
        return new DataRepository(appDatabase, appPref);
    }

    @Singleton
    CustomDialog provideDialog(Context context) {
        return new CustomDialog(context);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @Singleton
    ApiService providesApiService(Retrofit retrofit) {
        return (ApiService)retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Context context, AppPref appPref) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(5L, TimeUnit.MINUTES).readTimeout(5L, TimeUnit.MINUTES).writeTimeout(5L, TimeUnit.MINUTES);
        builder.hostnameVerifier((HostnameVerifier)-$$Lambda$AppModule$jlbJzPmGxbotskUXqQHorQD3m9Y.INSTANCE);
        builder.addInterceptor((Interceptor)new UnauthorizedInterceptor());
        builder.addInterceptor((Interceptor)new ConnectivityInterceptor(context));
        builder.addInterceptor((Interceptor)new -$.Lambda.AppModule.knjnQI967zK0SHBIsOrTNp71zxI(appPref));
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl("https://dukaan-api.1kg.me/v2/api/").addConverterFactory((Converter.Factory)GsonConverterFactory.create()).addCallAdapterFactory((CallAdapter.Factory)RxJava2CallAdapterFactory.create()).client(okHttpClient).build();
    }
}

