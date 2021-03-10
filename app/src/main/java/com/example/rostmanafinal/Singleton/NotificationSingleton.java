package com.example.rostmanafinal.Singleton;

public class NotificationSingleton {
    String NotificationValue;
    private static final NotificationSingleton ourInstance = new NotificationSingleton();

    public static NotificationSingleton getInstance() {
        return ourInstance;
    }

    private NotificationSingleton() {
    }

    public void setText(String NotificationValue) {
        this.NotificationValue = NotificationValue;
    }

    public String getText() {
        return NotificationValue;
    }
}
