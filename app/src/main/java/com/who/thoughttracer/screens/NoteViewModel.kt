package com.who.thoughttracer.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.who.thoughttracer.model.Note
import com.who.thoughttracer.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {
//    private var noteList = mutableStateListOf<Note>()

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()
    init{
//        noteList.addAll(NoteDataSource().loadNotes())
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect{
                    listOfNotes ->
                    if(listOfNotes.isEmpty()) {
                        Log.d("NoteViewModel", "Note list is empty")
                    }else{
                        _noteList.value = listOfNotes
                    }
                }
        }
    }

    suspend fun addNode(note: Note){
        viewModelScope.launch {
            repository.addNote(note)
        }
    }
    suspend fun removeNote(note: Note){
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

    suspend fun updateNote(note: Note){
        viewModelScope.launch {
            repository.updateNote(note)
        }
    }
}