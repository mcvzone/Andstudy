package com.example.neo.andstudy;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        TextView textView = (TextView)findViewById(R.id.permission_tx);
        int BROADCAST_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.BROADCAST_SMS);
        int READ_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        int RECEIVE_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        int SEND_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        StringBuffer text = new StringBuffer();
        text.append("BROADCAST_SMS _ READ_SMS _ RECEIVE_SMS _ SEND_SMS : " + BROADCAST_SMS + " _ " +  READ_SMS + " _ " +  RECEIVE_SMS + " _ " +  SEND_SMS+"\n");
        text.append("PERMISSION_DENIED : " + PackageManager.PERMISSION_DENIED+"\n");
        text.append("PERMISSION_GRANTED : " + PackageManager.PERMISSION_GRANTED+"\n");
        textView.setText(text.toString());
    }
}
