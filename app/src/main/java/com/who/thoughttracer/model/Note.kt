package com.who.thoughttracer.model

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    var title: String,
    var content: String,
    var entryDate: LocalDateTime = LocalDateTime.now()
)
