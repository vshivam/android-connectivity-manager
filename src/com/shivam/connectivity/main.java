package com.shivam.connectivity;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ConnectivityManager connec =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
     
        if (connec != null)
        {
            NetworkInfo[] info = connec.getAllNetworkInfo();
            NetworkInfo info_1 = connec.getNetworkInfo(connec.TYPE_MOBILE);
            
            if (info != null)
            {
                for (int i = 0; i < info.length; i++)
                {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        Log.d("net_info"+ Integer.toString(i), "connected");
 
                    }
                    else
                        Log.d("net_info"+ Integer.toString(i), "not connected");

                }

            }
            else 
            	Log.d("tag2","tag2");
            
//            connec.setNetworkPreference(connec.TYPE_MOBILE);
//            connec.setNetworkPreference(connec.TYPE_WIFI);
            
            if (info_1 != null)
            {
            	if(info_1.getState() == NetworkInfo.State.CONNECTED)
            	{
            		Log.d("mob","connected");
            	}
            }
// WiFi            
            WifiManager wifiManager = (WifiManager) getBaseContext().getSystemService(Context.WIFI_SERVICE);
            Toast.makeText(getApplicationContext(),Boolean.toString(wifiManager.isWifiEnabled()),Toast.LENGTH_LONG).show();

        }
    }
}