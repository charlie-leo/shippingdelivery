package com.editor.shippingdelivery.main.placeOrder;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.editor.shippingdelivery.common.DataInstance;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;
import com.editor.shippingdelivery.main.serviceablity.SelectServiceabilityActivity;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Charles Raj I on 15/08/22.
 *
 * @author Charles Raj I
 */
public class OrderPlacementRepo implements DataInstance {

    private RetrofitInterface service;
    private final String TAG = "OrderPlacementViewModel";
    public OrderPlacementRepo() {
        service = RetrofitClient.getClient();
    }
    // TODO : Need to remove the function
    public void getShipToken(){

        try {
            ShipLoginModel shipLoginModel = new ShipLoginModel();
            DisposableManager.add(service.getShipRocketToken(shipLoginModel)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responseBodyResponse -> {
                        if ( responseBodyResponse != null) {
                            String token = responseBodyResponse.toString();
                            Log.d(TAG, "getShipToken: Response" + token);
                            setApplicationData("token", responseBodyResponse.get("token").toString());
                            setApplicationData("company_id", responseBodyResponse.get("company_id").toString());
                        }
                    }, throwable -> {
                        Log.d(TAG, "getShipToken: Error  " + throwable.getMessage());
                    }));
        }catch (Exception e){
            Log.d(TAG, "getShipToken: exception  " + e.getMessage() );
        }
    }

    public void createShippingOrder(Activity activity, CreateOrderRequest createOrderRequest){
        try {
            DisposableManager.add(service.createShipOrder(createOrderRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(createOrderResponse -> {
                        Intent intent = new Intent(activity, SelectServiceabilityActivity.class);
                        intent.putExtra("orderDetails", createOrderResponse);
                        activity.startActivity(intent);
                        Log.d(TAG, "createShippingOrder: " + createOrderResponse.getStatus());
                    }, throwable -> {
                        Log.d(TAG, "createShippingOrder: " + throwable.getMessage());
                    }));
        }catch (Exception e){
            Log.d(TAG, "createShippingOrder: " + e.getMessage());
        }
    }
}
