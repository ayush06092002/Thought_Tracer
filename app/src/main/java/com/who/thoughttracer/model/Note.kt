package com.who.thoughttracer.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "table_title")
    var title: String,

    @ColumnInfo(name = "table_content")
    var content: String,

    @ColumnInfo(name = "table_entry_date")
    var entryDate: LocalDateTime = LocalDateTime.now()
)
