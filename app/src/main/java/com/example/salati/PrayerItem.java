package com.example.salati;

public class PrayerItem {
    private String title;
    private int imageResId;
    private int rakatCount;

    public PrayerItem(String title, int imageResId, int rakatCount) {
        this.title = title;
        this.imageResId = imageResId;
        this.rakatCount = rakatCount;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getRakatCount() {
        return rakatCount;
    }
}