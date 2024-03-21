package com.who.thoughttracer.data

import com.who.thoughttracer.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                title = "Market Shopping",
                content = "Buy milk, eggs, and bread"
            ),
            Note(
                title = "Workout",
                content = "Go to the gym at 6pm"
            ),
            Note(
                title = "Meeting",
                content = "Meet with the team at 10am"
            ),
            Note(
                title = "Dentist",
                content = "Appointment at 2pm"
            ),
            Note(
                title = "Grocery Shopping",
                content = "Buy fruits and vegetables"
            ),
            Note(
                title = "Laundry",
                content = "Wash clothes"
            )
        )
    }
}