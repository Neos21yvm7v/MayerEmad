package adapters_and_items;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface theApiFunctions {

    //-------------------- profile ----------------------------
    @GET("user_info/{id}")
    Call<ProfileItem> get_api_userInfo(@Path("id") int id) ;

    //-------------------- Shipment ----------------------------
    @GET("ship_info")
    Call<List<ShipmentItem>> get_api_shipments();

    @Multipart
    @POST("ship_store")
    Call<ShipmentItem> uploadShipmentItem(
            @Part MultipartBody.Part image,
            @Part("itemName") RequestBody itemName,
            @Part("from_country") RequestBody from_country,
            @Part("to_country") RequestBody to_country,
            @Part("user_info_id") RequestBody user_info_id,
            @Part("deadline") RequestBody deadline,
            @Part("url") RequestBody productUrl,
            @Part("price") RequestBody price,
            @Part("weight") RequestBody weight,
            @Part("count") RequestBody count
    );

    @Multipart
    @POST("ship_update/{ship_info_id}")
    Call<ShipmentItem> updateShipmentItem(
            @Path("ship_info_id") int itemId,
            @Part MultipartBody.Part image,
            @Part("itemName") RequestBody itemName,
            @Part("from_country") RequestBody from_country,
            @Part("to_country") RequestBody to_country,
            @Part("user_info_id") RequestBody user_info_id,
            @Part("deadline") RequestBody deadline,
            @Part("url") RequestBody productUrl,
            @Part("price") RequestBody price,
            @Part("weight") RequestBody weight,
            @Part("count") RequestBody count
    );

    //-------------------- Trip ----------------------------

    @GET("traveller_info")
    Call<List<TripItem>> get_api_trips();

    @POST("traveller_store")
    Call<TripItem> uploadTripItem(@Body TripItem tripItem);

    @POST("traveller_update/{traveller_info_id}")
    Call<TripItem> updateTripItem(@Path("traveller_info_id") int itemId,@Body TripItem tripItem);

}
