package com.example.rostmanafinal.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class NotificationDataSource {
    SQLiteOpenHelper helper;
    SQLiteDatabase database;
    Context context;

    String[] columns = {"id", "title", "content", "date_time"};

    public NotificationDataSource(Context context) {
        helper = new NotificationDBOpenHelper(context);
        this.context = context;
    }

    public void open() {
        database = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

    public NotificationModel insert(NotificationModel notification) {
        ContentValues values = new ContentValues();
        values.put("title", notification.getTitle());
        values.put("content", notification.getContent());
        values.put("content", notification.getDate_time());
        long a = database.insert("notifications", null, values);
        notification.setId(a);
        return notification;
    }

    public List<NotificationModel> getAll() {
        List<NotificationModel> notifications = new ArrayList<>();

        Cursor cursor = database.query("notifications", columns, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                if (cursor.getInt(cursor.getColumnIndex("id")) > 1) {
                    NotificationModel notification = new NotificationModel();
                    notification.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    notification.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                    notification.setContent(cursor.getString(cursor.getColumnIndex("content")));
                    notification.setDate_time(cursor.getString(cursor.getColumnIndex("date_time")));
                    notifications.add(notification);
                }
            }
        }

        return notifications;
    }

    public NotificationModel getOneNotification(long id) {
        NotificationModel notification = new NotificationModel();
        String[] whereArgs = new String[]{id + ""};
        Cursor cursor = database.query("notifications", columns, "id = ?", whereArgs, null, null, null);

        if (null != cursor) {
            cursor.moveToFirst();
            notification.setId(cursor.getInt(cursor.getColumnIndex("id")));
            notification.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            notification.setContent(cursor.getString(cursor.getColumnIndex("content")));
            notification.setDate_time(cursor.getString(cursor.getColumnIndex("date_time")));
        }

        return notification;
    }

    public void delete(long id) {
        database.delete("notifications", "id=" + id, null);
    }

    public void clearAllData() {
        database.delete("notifications", "", null);
    }

    public void update(NotificationModel notification) {
        ContentValues values = new ContentValues();
        values.put("title", notification.getTitle());
        values.put("content", notification.getContent());
        values.put("date_time", notification.getDate_time());
        database.update("notifications", values, "id=" + notification.getId(), null);
    }

}
