package com.uj.ifm.typ.mobileprototype;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    /*
    We need this service only if we want to receive notification payloads,
     and so onsend upstream messages
     */

    public MyFirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getData().get("message"));
    }

    private void showNotification (String message){

        Intent i = new Intent(this, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Uri ref = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("Wilec Inventory")
                .setContentText(message)
                .setSound(ref)
                .setSmallIcon(R.mipmap.ic_launcher_app)
                .setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(0, builder.build());
    }
}