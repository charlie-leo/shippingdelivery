/*
 * *
 *  Created by Charles Raj I on 2021.
 *  @author Charles Raj I
 * /
 *
 */

package com.editor.shippingdelivery.application;

/*
 * Created by Charles Raj I on 14/08/2022.
 *  @author Charles Raj I
 */

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class NetworkReceiver extends BroadcastReceiver {

    private Activity currentActivity;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case Intent.ACTION_MANAGE_NETWORK_USAGE:{

            }
            case Intent.ACTION_APP_ERROR:{
                Toast.makeText(context, "Wrong Error", Toast.LENGTH_SHORT).show();
            }
            default:{
                boolean isActive;
                isActive = isOnline(context);
                Activity activity = getCurrentActivity(); // Getting Current Activity
                if (!isActive) {
                    //if internet connection disconnected, then this block executes
                    //activity is currently running activity
                    if (activity != null) {
                        if (!NoNetworkActivity.class.getName().endsWith(activity.getLocalClassName())) {
                            Intent intent1 = new Intent(activity, NoNetworkActivity.class);
                            activity.startActivity(intent1);
                        }
                    }
                }else {
                    if (activity != null) {
                        if (NoNetworkActivity.class.getName().endsWith(activity.getLocalClassName())) {
                            activity.onBackPressed();
                        }
                    }
                }
            }
        }
    }

    //returns internet connection
    public boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());

        } catch (NullPointerException e) {
            Log.e("TAG", "catch exception: "+ e.getMessage() );
            return false;
        }
    }

    public Activity getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }
}
