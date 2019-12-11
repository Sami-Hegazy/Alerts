package com.example.android.alerts;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by SaMi on 2019-11-11.
 */

public class second extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(0);
    }
}
