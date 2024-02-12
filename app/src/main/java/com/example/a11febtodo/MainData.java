package com.example.a11febtodo;

//define table name

import java.io.Serializable;

public class MainData implements Serializable {
    private int ID;
    private String text;

    public MainData() {
        // Empty constructor required by some frameworks
    }

    public MainData(String text) {
        this.text = text;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
