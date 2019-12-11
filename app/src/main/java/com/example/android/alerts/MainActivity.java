package com.example.android.alerts;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Context;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.support.v4.app.NotificationCompat.*;

public class MainActivity extends AppCompatActivity  {
    Button btnToasts,btnDialog,btnNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToasts = findViewById(R.id.btnToasts);
        btnDialog = findViewById(R.id.btnDialog);
        btnNotif = findViewById(R.id.btnNotif);

        btnToasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t = Toast.makeText(MainActivity.this , "Hello Toast" , Toast.LENGTH_LONG);
               // t.setGravity(Gravity.TOP , 0, 0);
                t.show();
            }
        });

        //Dialog Alerts

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new  AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Welcome");
                dialog.setMessage("Are you Sure You Want To Do ...?");
                dialog.setIcon(R.drawable.ic_launcher_background);
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Positive Button" , "Ok");
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Negative Button" , "Cancel");
                    }
                });
                dialog.show();
            }
        });

        //Notification
       /* btnNotif.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,second.class);
                PendingIntent pInt = PendingIntent.getActivity(MainActivity.this,0,in, PendingIntent.FLAG_UPDATE_CURRENT);
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("New Audio File");
                builder.setContentText("Subject");
                builder.setSmallIcon(R.drawable.ic_launcher_background).getNotification();
                builder.setContentIntent(pInt);
                builder.addAction(android.R.drawable.ic_media_play,"Play",pInt).getNotification();
                builder.addAction(android.R.drawable.ic_media_pause,"Pause",pInt);

                Notification not = builder.build();
                NotificationManager notiManger = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notiManger.notify(0,not);
            }
        });*/

        btnNotif.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,second.class);
                PendingIntent pInt = PendingIntent.getActivity(MainActivity.this,0,in, PendingIntent.FLAG_UPDATE_CURRENT);
                Notification.Builder mBuilder = new Notification.Builder(MainActivity.this);
                mBuilder.setContentTitle("New Audio File");
                mBuilder.setContentText("Subject");
                mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
                mBuilder.setContentIntent(pInt);
                mBuilder.addAction(android.R.drawable.ic_media_play,"Play",pInt);
                mBuilder.addAction(android.R.drawable.ic_media_pause,"Pause",pInt);

                Notification noti = mBuilder.build();
                NotificationManager notiManger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notiManger.notify(0,noti);
            }
        });
    }

}
