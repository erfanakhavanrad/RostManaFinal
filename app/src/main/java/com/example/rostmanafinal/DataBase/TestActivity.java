package com.example.rostmanafinal.DataBase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.rostmanafinal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        NotificationDataSource nds = new NotificationDataSource(this);
        nds.open();
        List<NotificationModel> notifications = nds.getAll();
        nds.close();


        NotificationModel notification = new NotificationModel();
        notification.setTitle("عنوان");
        notification.setContent("محتوا");
        notification.setDate_time("زمان");
        nds.open();
        nds.insert(notification);
        nds.close();


        NotificationModel notification_number1 = new NotificationModel();
        nds.open();
        notification_number1 = nds.getOneNotification(1);
        nds.close();
    }

}
