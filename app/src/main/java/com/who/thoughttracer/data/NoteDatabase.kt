package com.who.thoughttracer.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.who.thoughttracer.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase(){
    abstract fun noteDao(): NoteDao
}