package com.example.daisygarcia.noteme;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Daisy Garcia on 03/01/2018.
 */

public class NotepadModel {

    private static NotepadModel sNotepadModel;
    private ArrayList<Notepad> mNotepadList;

    public static NotepadModel get(Context context)
    {
        if (sNotepadModel == null)
        {
            sNotepadModel = new NotepadModel(context);
        }
        return sNotepadModel;
    }

    private NotepadModel(Context context)
    {
        mNotepadList = new ArrayList<>();

        for (int i=0; i < 3; i++)
        {
            Notepad notepad = new Notepad();
            notepad.setmTitle("Todo title " + i);
            notepad.setmContent("Detail for task " + notepad.getmId().toString());
            notepad.setmIsComplete(false);

            mNotepadList.add(notepad);
        }
    }

    public Notepad getNotepad(UUID NotepadId)
    {
        for (Notepad notepad : mNotepadList)
        {
            if (notepad.getmId().equals(NotepadId))
            {
                return notepad;
            }
        }
        return null;
    }

    public ArrayList<Notepad> getNotepad()
    {
        return mNotepadList;
    }

    public void addNote(Notepad notepad)
    {
        mNotepadList.add(notepad);
    }

    public void removeNote (Notepad notepad)
    {
        mNotepadList.remove(notepad);
    }
}
