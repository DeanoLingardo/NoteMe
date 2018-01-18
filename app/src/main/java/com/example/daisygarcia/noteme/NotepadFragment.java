package com.example.daisygarcia.noteme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class NotepadFragment extends Fragment {

    private static final String ARG_NOTE_ID = "note_id";
    private static final String TAG = "NOTEPAD FRAGMENT";

    private Notepad mNote;
    public EditText mEditTextTitle;
    public EditText mEditContent;
    private DatabaseHandler db;


    /*
    Rather than the calling the constructor directly, Activity(s) should call newInstance
    and pass required parameters that the fragment needs to create its arguments.
     */
    public static NotepadFragment newInstance(int noteId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_NOTE_ID, noteId);
        NotepadFragment fragment = new NotepadFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        int noteId = (int) getActivity()
                .getIntent().getSerializableExtra(NotepadActivity.EXTRA_NOTE_ID);
        mNote = NotepadModel.get(getActivity()).getNotepad(noteId);
        setHasOptionsMenu(true);
        db = new DatabaseHandler(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        Log.d(TAG, "onCreateView: started");

        View view = inflater.inflate(R.layout.fragment_note, container, false);

//NOTE TITLE
        mEditTextTitle = view.findViewById(R.id.note_title);
        mEditTextTitle.setEnabled(false);
        mEditTextTitle.setText(mNote.getTitle());
        mEditTextTitle.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // This line is intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mNote.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                // This line is intentionally left blank
            }
        });

//NOTE CONTENT
        mEditContent = view.findViewById(R.id.note_body);
        mEditContent.setEnabled(false);
        mEditContent.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // This line is intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                mNote.setContent(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                // This line is intentionally left blank
            }
        });

        mEditContent.setText(mNote.getContent());
        return view;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_note, menu);
    }

    public void showTableInLogger()
    {
        // Reading all contacts
        Log.d("Reading: ", "Reading all notes..");
        List<Notepad> notes2 = db.getAllNotes();

        //Print out table in logger
        for (Notepad cn : notes2)
        {
            String log = "Id: " + cn.getId() + " ,Title: " + cn.getTitle() + " ,content: " + cn.getContent();
            // Writing Notes to log
            Log.d("Name: ", log);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
//Delete note button
            case R.id.remove_note:

                //Old remove method
               NotepadModel.get(getActivity()).removeNote(mNote);


                //TODO Find how to pass value of note ID to deleteNote method
               // db.deleteNote(notes.get(0));

                db.getAllNotes();

                showTableInLogger();

                Intent intent = new Intent(getActivity(), NotepadListActivity.class);
                startActivity(intent);

                Toast.makeText(
                        getActivity(),
                        mNote.getTitle() + " deleted",
                        Toast.LENGTH_SHORT)
                        .show();

                return true;

//Save note button with CRUD Operations
            case R.id.save_note:

                //Inserting note
                db.addNotepad(new Notepad(mNote.getTitle(),mNote.getContent()));

               showTableInLogger();

                //Simple toast
                Toast.makeText(
                        getActivity(),
                        mNote.getTitle() + " Saved",
                        Toast.LENGTH_SHORT)
                        .show();

                //Return to list
                Intent i = new Intent(getActivity(), NotepadListActivity.class);
                startActivity(i);

//Edit button TODO change to toggle button
            case R.id.edit_note:
                    mEditContent.setEnabled(true);
                    mEditTextTitle.setEnabled(true);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}