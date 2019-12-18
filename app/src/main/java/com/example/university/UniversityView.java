package com.example.university;

import android.graphics.drawable.Drawable;

public class UniversityView {
    private String tv_name;
    private Drawable img;

    public UniversityView(String tv_name, Drawable img) {
        this.tv_name = tv_name;
        this.img = img;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
