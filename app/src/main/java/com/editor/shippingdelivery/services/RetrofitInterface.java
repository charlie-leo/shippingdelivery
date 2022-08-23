package com.editor.shippingdelivery.services;


/*
 * Created by Charles Raj I on 14/08/2022.
 *  @author Charles Raj I
 */


import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingDeliveryOrdersRequest;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.PlaceOrderModel;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.PlaceOrderResponse;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderResponse;
import com.editor.shippingdelivery.main.serviceablity.model.ServiceabilityResponse;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappDeliveryStatusRequest;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInterface {

    String baseUrl = "https://botreeuat.csngsfa.com/api/v1/";
    String baseLocalUrl = "http://10.0.2.2:8080/api/v1/";


    @Headers({
            "Content-Type: application/json"
    })
    @POST( "delivery-order/pending")
    Observable<Response<ResponseBody>> getShippingOrderList(@Body PendingDeliveryOrdersRequest pendingDeliveryOrdersRequest);

    @Headers({
            "Content-Type: application/json"
    })
    @POST("delivery-order/create/adhoc")
    Observable<CreateOrderResponse> createShipOrder(@Body CreateOrderRequest createOrderRequest);


    @GET( "delivery-order/serviceability")
    Observable<ServiceabilityResponse> getAvailableServices(@Query("order_id") String order_id);




    // WHATSAPP DEVELOPERS PLEASE ADD WHATSAPP APIS BELOW !!

    @POST("delivery-order/pending")
    Observable<Response<ResponseBody>> getWhatsappOrderList(@Body WhatsappDeliveryStatusRequest pendingDeliveryOrdersRequest);

    @POST("wa-messaging/send")
    Observable<PlaceOrderResponse> placeOrderViaWaMessaging(@Body PlaceOrderModel placeOrderModel);
}
