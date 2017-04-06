package com.auribises.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    // onReceive shall be executed when event will be received
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(action.equals("a.b.c.d")){
            Toast.makeText(context,"a.b.c.d received",Toast.LENGTH_LONG).show();
        }

        if(action.equals("android.intent.action.ACTION_POWER_CONNECTED")){
            Toast.makeText(context,"Charging Started",Toast.LENGTH_LONG).show();
        }

        if(action.equals(Intent.ACTION_POWER_DISCONNECTED)){
            Toast.makeText(context,"Charging Finished",Toast.LENGTH_LONG).show();
        }
    }
}
