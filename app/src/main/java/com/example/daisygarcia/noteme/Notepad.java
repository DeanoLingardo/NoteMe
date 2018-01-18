package com.example.daisygarcia.noteme;

import java.util.Date;

/**
 * Created by Daisy Garcia on 03/01/2018.
 */

public class Notepad {
    private int mId;
    private String mTitle;
    private String mContent;
    private Date mDate;


    public Notepad() {
        mId = (int)(Math.random()*100);
        mDate = new Date();
    }

    public Notepad(String mTitle, String mContent){
        this.mTitle = mTitle;
        this.mContent = mContent;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getId() {
        return mId;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }
}
