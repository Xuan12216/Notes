package com.example.notes;

import androidx.cardview.widget.CardView;

import com.example.notes.Models.Notes;

public interface NotesClickListener {
    void onCLick(Notes notes);
    void onLongCLick(Notes notes, CardView cardView);
}
