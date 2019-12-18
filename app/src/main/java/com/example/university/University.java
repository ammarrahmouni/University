package com.example.university;

import android.graphics.drawable.Drawable;

public class University {

    private int id;
    private String name;
    private String level ;
    private String city;
    private String description;
    private String language;
    private String dateStart;
    private String dateEnd;
    private String link;



    public University(String name, String level, String city, String description, String language, String dateStart, String dateEnd, String link) {
        this.name = name;
        this.level = level;
        this.city = city;
        this.description = description;
        this.language = language;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}