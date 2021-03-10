package com.example.rostmanafinal.Fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.example.rostmanafinal.DataBase.NotificationDataSource;
import com.example.rostmanafinal.DataBase.NotificationModel;
import com.example.rostmanafinal.MainActivity;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.Singleton.NotificationSingleton;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;

import java.util.List;

public class FragmnetNotifs extends Fragment {
    NotificationSingleton notificationSingleton = com.example.rostmanafinal.Singleton.NotificationSingleton.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewNotifs = inflater.inflate(R.layout.fragment_notifs, container, false);
        return viewNotifs;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        NotificationSingleton notificationSingleton = com.example.rostmanafinal.Singleton.NotificationSingleton.getInstance();
        String notificationValue = notificationSingleton.getText();
//        Toast.makeText(this, notificationValue.toString(), Toast.LENGTH_SHORT).show();
        showNotification(notificationValue, notificationValue);

        NotificationDataSource nds = new NotificationDataSource(getContext());
        nds.open();
        List<NotificationModel> notifications = nds.getAll();
        nds.close();


        NotificationModel notification = new NotificationModel();
        notification.setTitle(notificationValue);
        notification.setContent(notificationValue);
        notification.setDate_time(notificationValue);
        nds.open();
        nds.insert(notification);
        nds.close();


        NotificationModel notification_number1 = new NotificationModel();
        nds.open();
        notification_number1 = nds.getOneNotification(1);
        nds.close();
//        showNotification("title", "bodyyyyyyyyyyyyyyyy");
    }

    void showNotification(String title, String message) {
        NotificationManager mNotificationManager =
                (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("my-Channel",
                    "YOUR_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DESCRIPTION");
            mNotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getContext(), "my-Channel")
                .setSmallIcon(R.drawable.glogo) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(message)// message for notification
                .setAutoCancel(true); // clear notification after click
        Intent intent = new Intent(getContext(), MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pi);
        mNotificationManager.notify(0, mBuilder.build());
    }




}
