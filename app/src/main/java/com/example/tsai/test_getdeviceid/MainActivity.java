package com.example.tsai.test_getdeviceid;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PHONE_STATE = 1; // on android 6.0以上版本要用到
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting unique id for device
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_PHONE_STATE},
                REQUEST_PHONE_STATE);
        String id =  Secure.getString(this.getBaseContext().getContentResolver(), Secure.ANDROID_ID);

        TelephonyManager tM=(TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = tM.getDeviceId();

        //String mNumber = tM.getLine1Number();

        //displaying id in textview1
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText("deviceI_id:"+id);

        //displaying IEMI in textview2
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setText("IMEI:"+imei);
        int testing = 123;
        //test git
        String testing2="love you too";
    }

}
