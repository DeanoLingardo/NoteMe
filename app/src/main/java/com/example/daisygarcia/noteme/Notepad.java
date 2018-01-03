package com.example.daisygarcia.noteme;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Daisy Garcia on 03/01/2018.
 */

public class Notepad
{
    private UUID mId;
    private String mTitle;
    private String mContent;
    private Date mDate;
    private boolean mIsComplete;

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismIsComplete() {
        return mIsComplete;
    }

    public void setmIsComplete(boolean mIsComplete) {
        this.mIsComplete = mIsComplete;
    }

    public Notepad()
    {
        mId = UUID.randomUUID();
        mDate = new Date();
    }
}
