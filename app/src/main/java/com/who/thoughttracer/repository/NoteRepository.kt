package com.who.thoughttracer.repository

import com.who.thoughttracer.data.NoteDao
import com.who.thoughttracer.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao){
    suspend fun addNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.update(note)
    }

    suspend fun deleteAllNotes() {
        noteDao.deleteAll()
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }

    fun getAllNotes(): Flow<List<Note>> = noteDao.getNotes().flowOn(Dispatchers.IO).conflate()

}