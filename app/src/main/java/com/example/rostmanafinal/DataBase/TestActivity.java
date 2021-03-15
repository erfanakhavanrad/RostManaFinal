package com.example.rostmanafinal.DataBase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.rostmanafinal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.RequiresPermission;
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

    /**
     * NotificationDBOpenHelper
     * فایلی که دیتابیس و جدول ها ساخته میشه
     * <p>
     * NotificationDataSource
     * فایلی که عملیات وصل شدن به دیتابیس و قطع اتصال و توابع حذف و اضافه و ...
     * <p>
     * NotificationModel
     * مدل
     * <p>
     * Test Activity
     * مثال از خوندن اطلاعات، اضافه کردن و حذف
     * <p>
     * <p>
     * <p>
     * تابع open دیتابیس رو باز می کنه و اماده استفاده و تابع close دیتابیس رو میبنده. هر وقت خواستی کاری انجام بدی بازش کن و همه کارات رو انجام بده و بعدش که تموم شد ببند. میتونی وقتی هم که بازه چند کار رو انجام بدی. مجبور نیستی هربار باز و بسته کنی
     * <p>
     * <p>
     * توی کلاس NotificationDBOpenHelper ، توی متند سازندش ، آخرین آرگمان نسخه دیتابیس هست. اگه خواستی تغییری توی این فایل انجام بدی، مثلا ستون اضافه کنی، باید نسخه رو یکی افزایش بدی
     * <p>
     * تابع open دیتابیس رو باز می کنه و اماده استفاده و تابع close دیتابیس رو میبنده. هر وقت خواستی کاری انجام بدی بازش کن و همه کارات رو انجام بده و بعدش که تموم شد ببند. میتونی وقتی هم که بازه چند کار رو انجام بدی. مجبور نیستی هربار باز و بسته کنی
     * <p>
     * J
     * توی کلاس NotificationDBOpenHelper ، توی متند سازندش ، آخرین آرگمان نسخه دیتابیس هست. اگه خواستی تغییری توی این فایل انجام بدی، مثلا ستون اضافه کنی، باید نسخه رو یکی افزایش بدی
     * <p>
     * <p>
     * یه تابع getall نوشتم توی تست، اون از دیتابیس میگیره اطلاعات رو میریزه توی آرایه
     * <p>
     * الان باید یه آداپتر بسازی که ورودیش از نوع List<NotificationModel> باشه
     * List<NotificationModel> notifications = nds.getAll();
     */

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
