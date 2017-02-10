package inleggo.com.myapplication.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by apurisaca on 25/11/2016.
 */
public class UtilNetwork {
    private Context mContext;

    public UtilNetwork(Context mContext) {
        this.mContext = mContext;
    }
    public boolean isAvailableNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}