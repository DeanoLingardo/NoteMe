package com.example.daisygarcia.noteme;

import java.util.UUID;

/**
 * Created by Daisy Garcia on 03/01/2018.
 */

public class Notepad
{
    private UUID mId;
    private String mTitle;
    private String mContent;

    public Notepad()
    {
        mId = UUID.randomUUID();
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

    public void setId(UUID mId) {
        this.mId = mId;
    }

    public UUID getId() {
        return mId;
    }
}
