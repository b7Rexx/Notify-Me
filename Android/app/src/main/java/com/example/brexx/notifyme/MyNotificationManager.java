package com.example.brexx.notifyme;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

/**
 * Created by bRexx on 7/2/2017.
 */
public class MyNotificationManager {

    public static final int ID_SMALL_NOTIFICATION = 235;

    private Context mCtx;

    public MyNotificationManager(Context mCtx) {
        this.mCtx = mCtx;
    }

   public void showSmallNotification(String title, String message, Intent intent) {
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        mCtx,
                        ID_SMALL_NOTIFICATION,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mCtx);
        Notification notification;
       mBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
       Uri notf_sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
       Ringtone r = RingtoneManager.getRingtone(mCtx, notf_sound);
       r.play();

        notification = mBuilder.setSmallIcon(R.drawable.notifyme_push).setTicker(title).setWhen(0)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.notifyme_push)
                .setLargeIcon(BitmapFactory.decodeResource(mCtx.getResources(), R.drawable.notifyme_push))
                .setContentText(message)
                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) mCtx.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(ID_SMALL_NOTIFICATION, notification);
    }

}