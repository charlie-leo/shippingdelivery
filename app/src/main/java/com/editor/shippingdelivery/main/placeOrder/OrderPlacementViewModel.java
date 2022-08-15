package com.editor.shippingdelivery.main.placeOrder;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.editor.shippingdelivery.common.DataInstance;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;
import com.google.gson.JsonObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Charles Raj I on 15/08/22.
 *
 * @author Charles Raj I
 */
public class OrderPlacementViewModel extends AndroidViewModel implements DataInstance {

    private final Application application;
    public OrderPlacementViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public void getShipToken(){
        RetrofitInterface service = RetrofitClient.getClient();
        try {
            ShipLoginModel shipLoginModel = new ShipLoginModel();
            DisposableManager.add(service.getShipRocketToken(shipLoginModel)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responseBodyResponse -> {
                        if ( responseBodyResponse != null) {
                            String token = responseBodyResponse.toString();
                            Log.d("TAG", "getShipToken: Response" + token);
                            setApplicationData("token", responseBodyResponse.get("token").toString());
                            setApplicationData("company_id", responseBodyResponse.get("company_id").toString());
                        }
                    }, throwable -> {
                        Log.d("TAG", "getShipToken: Error  " + throwable.getMessage());
                    }));
        }catch (Exception e){
            Log.d("TAG", "getShipToken: exception  " + e.getMessage() );
        }
    }
}
