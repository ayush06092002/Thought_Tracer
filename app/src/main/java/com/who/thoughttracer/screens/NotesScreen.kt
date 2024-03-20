package com.who.thoughttracer.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.who.thoughttracer.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun NotesScreen(){
    Column(modifier = Modifier
        .padding(8.dp)
        .background(Color(0xFFE7E7E7))) {
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
            }
        }

        Button(modifier = Modifier.align(Alignment.CenterHorizontally).padding(8.dp),
            onClick = { isColumnVisible = !isColumnVisible }) {
            Text(text = if(isColumnVisible) "Cancel" else "Add Note")
        }
    }
}


