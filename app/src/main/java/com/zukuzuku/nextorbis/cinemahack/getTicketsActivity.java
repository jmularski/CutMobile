package com.zukuzuku.nextorbis.cinemahack;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class getTicketsActivity extends AppCompatActivity {
    Button get_button;
    private NotificationCompat.Builder builder;
    private int notification_id;
    private NotificationManager notificationManager;
    private RemoteViews remoteViews;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_tickets);

        context= this;
        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        remoteViews= new RemoteViews(getPackageName(),R.layout.custom_notification);

        notification_id=(int) System.currentTimeMillis();
        Intent button_intent= new Intent("button_clicked");
        button_intent.putExtra("id",notification_id);

        PendingIntent p_button_intent= PendingIntent.getBroadcast(context,123,button_intent,0);
        remoteViews.setOnClickPendingIntent(R.id.button_rate,p_button_intent);

        get_button= (Button) findViewById(R.id.button_get_tickets);

        get_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(v.getContext(),"User served!", Toast.LENGTH_LONG).show();

                Intent notification_intent= new Intent(context,getTicketsActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context,0,notification_intent,0);
                builder= new NotificationCompat.Builder(context,"id");
                builder.setSmallIcon(R.drawable.logobar).setAutoCancel(true).setCustomContentView(remoteViews).setContentIntent(pendingIntent);
                notificationManager.notify(notification_id,builder.build() );
            }
        });
    }

}
