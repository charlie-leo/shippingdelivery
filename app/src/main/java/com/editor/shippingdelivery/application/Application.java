package com.editor.shippingdelivery.application;
/*
 * Created by Charles Raj I on 14/08/2022.
 *  @author Charles Raj I
 */
import android.app.Activity;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Application extends android.app.Application {

    private NetworkReceiver networkReceiver;
    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                networkReceiver = new NetworkReceiver();
                Log.i("TAG", "onActivityCreated: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
                networkReceiver.setCurrentActivity(activity);
                Log.i("TAG", "onActivityStarted: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                Log.i("TAG", "onActivityResumed: " + activity.getLocalClassName() );
                networkReceiver.setCurrentActivity(activity);
                registerNetworkBroadcastForNougat();
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                networkReceiver.setCurrentActivity(activity);
                Log.i("TAG", "onActivityPaused: " + activity.getLocalClassName());
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {
                Log.i("TAG", "onActivityStopped: "+ activity.getLocalClassName());
                networkReceiver.setCurrentActivity(activity);
                System.gc();
            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                Log.i("TAG", "onActivityDestroyed: " + activity.getLocalClassName());
                unregisterReceiver(networkReceiver);
                Log.d("MyApplicationTest", "onActivityDestroyed: un-registered");
            }
        });
    }
    private void registerNetworkBroadcastForNougat() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(networkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }
}
