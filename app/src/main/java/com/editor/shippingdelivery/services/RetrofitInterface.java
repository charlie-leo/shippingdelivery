package com.editor.shippingdelivery.services;


/*
 * Created by Charles Raj I on 14/08/2022.
 *  @author Charles Raj I
 */


import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingDeliveryOrdersRequest;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.placeOrder.ShipLoginModel;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderResponse;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInterface {

//    @GET("")
//    Observable<DataResponse> getDatas();

    @Headers({
            "Content-Type: application/json"
    })
    @POST("auth/login")
    Observable<JsonObject> getShipRocketToken(@Body ShipLoginModel jsonObject);

    @POST("delivery-order/create/adhoc")
    Observable<CreateOrderResponse> createShipOrder(@Body CreateOrderRequest createOrderRequest);


    @POST("delivery-order/pending")
    Observable<Response<ResponseBody>> getShippingOrderList(@Body PendingDeliveryOrdersRequest pendingDeliveryOrdersRequest);

    /*@POST("delivery-order/pending")
    Call<ResponseBody> getShippingOrderList(@Body PendingDeliveryOrdersRequest pendingDeliveryOrdersRequest);*/
}
