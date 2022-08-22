package com.editor.shippingdelivery.services;


/*
 * Created by Charles Raj I on 14/08/2022.
 *  @author Charles Raj I
 */


import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingDeliveryOrdersRequest;
import com.editor.shippingdelivery.main.placeOrder.PlaceOrderModel;
import com.editor.shippingdelivery.main.placeOrder.PlaceOrderResponse;
import com.editor.shippingdelivery.main.placeOrder.ShipLoginModel;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderResponse;
import com.editor.shippingdelivery.main.serviceablity.model.ServiceabilityResponse;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappDeliveryStatusRequest;
import com.google.gson.JsonObject;

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

    String baseUrl = "https://botreeuat.csngsfa.com/api/v1/";
    String baseLocalUrl = "http://10.0.2.2:8080/api/v1/";

//    @GET("")
//    Observable<DataResponse> getDatas();

    @Headers({
            "Content-Type: application/json"
    })
    @POST(baseUrl+"auth/login")
    Observable<JsonObject> getShipRocketToken(@Body ShipLoginModel jsonObject);

    @POST(baseLocalUrl+"delivery-order/create/adhoc")
    Observable<CreateOrderResponse> createShipOrder(@Body CreateOrderRequest createOrderRequest);


    @POST(baseUrl+"delivery-order/pending")
    Observable<Response<ResponseBody>> getShippingOrderList(@Body PendingDeliveryOrdersRequest pendingDeliveryOrdersRequest);

    @POST(baseUrl+"delivery-order/pending")
    Observable<Response<ResponseBody>> getWhatsappOrderList(@Body WhatsappDeliveryStatusRequest pendingDeliveryOrdersRequest);


    @GET(baseLocalUrl+"delivery-order/serviceability")
    Observable<ServiceabilityResponse> getAvailableServices(@Query("order_id") String order_id);

    /*@POST("delivery-order/pending")
    Call<ResponseBody> getShippingOrderList(@Body PendingDeliveryOrdersRequest pendingDeliveryOrdersRequest);*/

    @POST("wa-messaging/send")
    Observable<PlaceOrderResponse> placeOrderViaWaMessaging(@Body PlaceOrderModel placeOrderModel);
}
