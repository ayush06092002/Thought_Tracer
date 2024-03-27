package com.who.thoughttracer.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.who.thoughttracer.model.Note
import com.who.thoughttracer.util.DateConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class NoteDatabase: RoomDatabase(){
    abstract fun noteDao(): NoteDao
}