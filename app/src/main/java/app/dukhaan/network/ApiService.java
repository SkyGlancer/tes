/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.network.model.AddBusinessResponse
 *  app.dukhaan.network.model.AddProductRequest
 *  app.dukhaan.network.model.EditProductRequest
 *  app.dukhaan.network.model.LoginResponse
 *  io.reactivex.Completable
 *  io.reactivex.Single
 *  java.lang.Object
 *  java.lang.String
 *  okhttp3.MultipartBody
 *  okhttp3.MultipartBody$Part
 *  retrofit2.http.Body
 *  retrofit2.http.DELETE
 *  retrofit2.http.Field
 *  retrofit2.http.FormUrlEncoded
 *  retrofit2.http.GET
 *  retrofit2.http.Header
 *  retrofit2.http.Multipart
 *  retrofit2.http.PATCH
 *  retrofit2.http.POST
 *  retrofit2.http.PUT
 *  retrofit2.http.Part
 *  retrofit2.http.Path
 *  retrofit2.http.Query
 *  retrofit2.http.Url
 */
package app.dukhaan.network;

import app.dukhaan.data.model.ProductResponse;
import app.dukhaan.data.model.UploadImage;
import app.dukhaan.data.model.VariantResponse;
import app.dukhaan.network.model.AddBusinessRequest;
import app.dukhaan.network.model.AddBusinessResponse;
import app.dukhaan.network.model.AddProductRequest;
import app.dukhaan.network.model.AddProductResponse;
import app.dukhaan.network.model.AwardStatsResponse;
import app.dukhaan.network.model.BusinessListResponse;
import app.dukhaan.network.model.BusinessStatsResponse;
import app.dukhaan.network.model.CategoryListResponse;
import app.dukhaan.network.model.CreateCategoryRequest;
import app.dukhaan.network.model.CreateCategoryResonse;
import app.dukhaan.network.model.DeleteCategoryResonse;
import app.dukhaan.network.model.DeleteProductResponse;
import app.dukhaan.network.model.EditBusinessRequest;
import app.dukhaan.network.model.EditCategoryRequest;
import app.dukhaan.network.model.EditDeliveryChargeRequest;
import app.dukhaan.network.model.EditDeliveryChargeResponse;
import app.dukhaan.network.model.EditProductRequest;
import app.dukhaan.network.model.EditProductResponse;
import app.dukhaan.network.model.LoginRequest;
import app.dukhaan.network.model.LoginResponse;
import app.dukhaan.network.model.MapSearchResponse;
import app.dukhaan.network.model.MapTokenResponse;
import app.dukhaan.network.model.OrdersListResponse;
import app.dukhaan.network.model.SearchProductsResponse;
import app.dukhaan.network.model.SyncContactsRequest;
import app.dukhaan.network.model.TrackOrderResponse;
import app.dukhaan.network.model.UpdateOrderStatusRequest;
import app.dukhaan.network.model.UpdateOrderStatusResponse;
import app.dukhaan.network.model.placesResponseData.GooglePlacesResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {
    @POST(value="business/")
    public Single<AddBusinessResponse> addBusiness(@Body AddBusinessRequest var1);

    @POST(value="product/{category_id}/")
    public Single<AddProductResponse> addProduct(@Path(value = "category_id") int var1, @Body AddProductRequest var2);

    @POST(value="product/")
    public Single<AddProductResponse> addProduct(@Body AddProductRequest var1);

    @GET(value="product_by_category/{category_id}/")
    public Single<ProductResponse> categoryProducts(@Path(value = "category_id") int var1, @Query(value = "page") int var2);

    @POST(value="category/")
    public Single<CreateCategoryResonse> createCategory(@Body CreateCategoryRequest var1);

    @DELETE(value="category/{categoryId}/")
    public Single<DeleteCategoryResonse> deleteCategory(@Path(value = "categoryId") int var1);

    @DELETE(value="product/{productId}/")
    public Single<DeleteProductResponse> deleteProduct(@Path(value = "productId") int var1);

    @PATCH(value="category/{categoryId}/")
    public Single<CreateCategoryResonse> editCategory(@Path(value = "categoryId") int var1, @Body EditCategoryRequest var2);

    @PATCH(value="business/{business_id}/")
    public Single<EditDeliveryChargeResponse> editDeliveryCharge(@Path(value = "business_id") int var1, @Body EditDeliveryChargeRequest var2);

    @PATCH(value="product/{productId}/")
    public Single<EditProductResponse> editProduct(@Path(value = "productId") int var1, @Body EditProductRequest var2);

    @GET(value="product/{business_id}/")
    public Single<ProductResponse> getAllProducts(@Path(value = "business_id") int var1, @Query(value = "page") int var2);

    @GET(value="account/awards-stats/")
    public Single<AwardStatsResponse> getAwardsStats();

    @GET(value="business/{businessId}/")
    public Single<BusinessStatsResponse> getBusinessStats(@Path(value = "businessId") int var1);

    @GET(value="business/")
    public Single<BusinessListResponse> getBusinesses();

    @GET(value="all-category/{business_id}/")
    public Single<CategoryListResponse> getCategories(@Path(value = "business_id") int var1, @Query(value = "page") int var2);

    @GET
    public Single<GooglePlacesResponse> getGooglePlacesResponse(@Url String var1, @Query(value = "input") String var2, @Query(value = "sensor") String var3, @Query(value = "key") String var4, @Query(value = "radius") int var5, @Query(value = "location") String var6);

    @GET
    public Single<MapSearchResponse> getMapMyIndiaResponse(@Url String var1, @Header(value = "Authorization") String var2, @Query(value = "query") String var3, @Query(value = "filter") String var4);

    @FormUrlEncoded
    @POST
    public Single<MapTokenResponse> getMapMyIndiaTokenResponse(@Url String var1, @Field(value = "grant_type") String var2, @Field(value = "client_id") String var3, @Field(value = "client_secret") String var4);

    @GET(value="get-order/{business_id}/")
    public Single<OrdersListResponse> getOrders(@Path(value = "business_id") int var1, @Query(value = "page") int var2, @Query(value = "status") String var3);

    @GET(value="product/{product_id}/variant/")
    public Single<VariantResponse> getVariants(@Path(value = "product_id") int var1);

    @POST(value="sign-in/")
    public Single<LoginResponse> login(@Body LoginRequest var1);

    @GET(value="account/jwt-token-fetch/")
    public Single<LoginResponse> refreshToken();

    @GET(value="search/")
    public Single<SearchProductsResponse> search(@Query(value = "q") String var1, @Query(value = "business_id") int var2);

    @POST(value="sync-phonebook/")
    public Completable syncContacts(@Body SyncContactsRequest var1);

    @GET(value="view-order/{orderId}/")
    public Single<TrackOrderResponse> trackOrder(@Path(value = "orderId") String var1);

    @PATCH(value="business/{business_id}/")
    public Single<AddBusinessResponse> updateBusiness(@Path(value = "business_id") int var1, @Body EditBusinessRequest var2);

    @PUT(value="update-order/{order_id}/")
    public Single<UpdateOrderStatusResponse> updateOrderStatus(@Path(value = "order_id") int var1, @Body UpdateOrderStatusRequest var2);

    @Multipart
    @POST(value="upload-image/")
    public Single<UploadImage> uploadImage(@Part MultipartBody.Part var1);
}

