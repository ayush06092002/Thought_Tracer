package com.who.thoughttracer.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.who.thoughttracer.data.NoteDataSource
import com.who.thoughttracer.model.Note

class NoteViewModel: ViewModel() {
    private var noteList = mutableStateListOf<Note>()

    init{
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }

    fun getNotes(): List<Note>{
        return noteList
    }
}