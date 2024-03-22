package com.who.thoughttracer.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.who.thoughttracer.R
import com.who.thoughttracer.model.Note
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun NotesScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,
    onEditNote: (Note) -> Unit
){
    val context = LocalContext.current
    Column(modifier = Modifier
        .padding(8.dp)
        .background(Color(0xFFFFFFFF))) {
        TopAppBar(
            title = {
                Text(modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.app_name),
                    style = TextStyle(
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFE7E7E7)
            ),
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Notifications"
                )
            }
        )

        var isColumnVisible by remember {
            mutableStateOf(false)
        }
        var titleText by remember {
            mutableStateOf("")
        }
        var contentText by remember {
            mutableStateOf("")
        }
        if(isColumnVisible){
            Column(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp),){

                OutlinedTextField(value = titleText, onValueChange = {
                    titleText = it
                },
                    label = {
                        Text(text = "Title", style = TextStyle(
                            color = Color(0xFFF24C00),
                            fontWeight = FontWeight.Bold,
                        ))
                    },
                    modifier = Modifier.padding(8.dp),
                    textStyle = TextStyle(
                        color = Color(0xFFF24C00)
                    )
                )
                OutlinedTextField(value = contentText, onValueChange = {
                    contentText = it
                },
                    label = {
                        Text(text = "Note", style = TextStyle(
                            color = Color(0xFF485696),
                            fontWeight = FontWeight.Bold,
                        ))
                    },
                    modifier = Modifier.padding(8.dp),
                    textStyle = TextStyle(
                        color = Color(0xFF485696)
                    )
                )
                Button(modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp),
                    onClick = {
                        if(titleText.isNotEmpty())
                        {
                            onAddNote(Note(
                                title = titleText,
                                content = contentText
                            ))
                            isColumnVisible = false
                            titleText = ""
                            contentText = ""
                            Toast.makeText(context, "Note added", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            Toast.makeText(context, "Title cannot be empty", Toast.LENGTH_SHORT).show()
                        }
                    }) {
                    Text(text = "Save Note")
                }
            }
        }

        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(8.dp),
            onClick = { isColumnVisible = !isColumnVisible }) {
            Text(text = if(isColumnVisible) "Cancel" else "Add Note")
        }

        Spacer(modifier = Modifier.padding(15.dp))
        var selectedNote by remember { mutableStateOf<Note?>(null) }
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)) {
            items(notes) { note ->
                NoteRow(note = note, onNoteClicked = { selectedNote = note },
                    onEditClicked = onEditNote, onDeleteClicked = { onRemoveNote(note) })
            }
        }
        selectedNote?.let { note ->
            NoteEditDialog(
                note = note,
                onEdit = onEditNote,
                onDelete = onRemoveNote,
                onClose = { selectedNote = null }
            )}
    }
}

@Composable
fun NoteRow(modifier: Modifier = Modifier,
            note: Note,
            onNoteClicked: (Note) -> Unit,
            onEditClicked: (Note) -> Unit,
            onDeleteClicked: (Note) -> Unit){
    Surface(
        modifier
            .padding(2.dp)
            .clip(RoundedCornerShape(20.dp))
            .width(200.dp),
        color = Color(0xFFE7E7E7)
    ) {
        Column(modifier = modifier
            .clickable { onNoteClicked(note) }
            .padding(10.dp),
            horizontalAlignment = Alignment.Start) {
            Text(text = note.title, style = TextStyle(
                color = Color(0xFFF24C00),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
            ))
            Text(text = note.content, style = TextStyle(
                color = Color(0xFF485696),
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
            ))
            Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"
            )), style = TextStyle(
                color = Color(0xFF485696),
                fontWeight = FontWeight.ExtraLight,
                fontSize = 10.sp,
            ))
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(onClick = { onEditClicked(note) }) {
                    Text(text = "Edit")
                }
                Spacer(modifier = Modifier.width(6.dp))
                Button(onClick = { onDeleteClicked(note) }) {
                    Text(text = "Delete")
                }
            }
        }
    }
}


@Composable
fun NoteEditDialog(
    note: Note,
    onEdit: (Note) -> Unit,
    onDelete: (Note) -> Unit,
    onClose: () -> Unit
) {
    var editContent by remember { mutableStateOf(note.content) }
    var editTitle by remember { mutableStateOf(note.title) }
    AlertDialog(
        onDismissRequest = { onClose() },
        title = {
            Text(text = "Edit Note")
        },
        text = {
            Column {
                TextField(value = editTitle, onValueChange = {
                    editTitle = it
                })
                TextField(value = editContent, onValueChange = {
                    editContent = it
                })
                Text(text = note.entryDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val updatedNote = note.copy(content = editContent, title = editTitle)
                    onEdit(updatedNote)
                    onClose()
                }
            ) {
                Text(text = "Save")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    onDelete(note)
                    onClose()
                }
            ) {
                Text(text = "Delete")
            }
        }
    )
}





