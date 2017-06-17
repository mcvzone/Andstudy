package com.example.neo.andstudy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MySMSReceiver extends BroadcastReceiver {

    public MySMSReceiver(){
        Log.d("MYLOG", "MySMSReceiver 호출됨.");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MYLOG", "onReceiver 호출됨.");
        Intent myIntent = new Intent(context, MainActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(myIntent);
    }
}
