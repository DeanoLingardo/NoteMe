package com.example.daisygarcia.noteme;

/**
 * Created by Daisy Garcia on 03/01/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotepadListFragment extends Fragment {

    private RecyclerView mNotepadRecyclerView;
    NotepadAdapter mNotepadAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        mNotepadRecyclerView = (RecyclerView) view.findViewById(R.id.note_recycler_view);
        mNotepadRecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()) );

        updateUI();

        return view;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_note:

                Notepad note = new Notepad();
                NotepadModel.get(getActivity()).addNote(note);

                Intent intent = NotepadActivity.newIntent(getActivity(), note.getId());
                startActivity(intent);

                return true;

            case R.id.exit_app:
                System.exit(0);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_note_list, menu);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        updateUI();
    }


    private void updateUI()
    {
        ArrayList notes = new ArrayList<>();
        NotepadModel notepadModel =  NotepadModel.get(getContext());
        notes = notepadModel.getNotepad();

        if (mNotepadAdapter == null)
        {
            mNotepadAdapter = new NotepadAdapter(notes);
            mNotepadRecyclerView.setAdapter(mNotepadAdapter);
        }
        else
        {
            mNotepadAdapter.notifyDataSetChanged();
        }
    }

    public class NotepadHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Notepad mNote;
        private TextView mTextViewTitle;

        public NotepadHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.list_item_note, parent, false));

            itemView.setOnClickListener(this);

            mTextViewTitle = itemView.findViewById(R.id.note_title);
        }

        @Override
        public void onClick(View view)
        {
            Intent intent = NotepadActivity.newIntent(getActivity(), mNote.getId());
            startActivity(intent);
        }

        public void bind(Notepad note)
        {
            mNote = note;
            mTextViewTitle.setText(mNote.getTitle());
        }

    }

    public class NotepadAdapter extends RecyclerView.Adapter<NotepadListFragment.NotepadHolder> {

        private List<Notepad> mNotes;

        public NotepadAdapter(List<Notepad> notes) {
            mNotes = notes;
        }

        @Override
        public NotepadListFragment.NotepadHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new NotepadHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(NotepadHolder holder, int position) {
            Notepad note = mNotes.get(position);
            holder.bind(note);
        }

        @Override
        public int getItemCount() {
            return mNotes.size();
        }

    }
}