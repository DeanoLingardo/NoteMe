package com.example.daisygarcia.noteme;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Daisy Garcia on 03/01/2018.
 */

public class NotepadModel {

    private static NotepadModel sNotepadModel;
    private ArrayList<Notepad> mNotepadList;
    private DatabaseHandler db;
   // private List<Notepad> mNotepadList = db.getAllNotes();



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

      /*  for (int i=0; i < 1; i++)
        {
           Notepad notepad = new Notepad();
           notepad.setTitle("Test Note");
           notepad.setContent("This is a tester note, enjoy :)");
           mNotepadList.add(notepad);
        }
        */
    }

    public Notepad getNotepad(int noteId)
    {
        for (Notepad notepad : mNotepadList)
        {
            if (notepad.getId()==(noteId))
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
