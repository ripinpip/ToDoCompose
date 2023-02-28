package com.example.todocompose.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.todocompose.R

@Composable
fun DisplayAlertDialog(
    title: String,
    message: String,
    openDialog: Boolean,
    closeDialog: () -> Unit,
    onYesClicked: () -> Unit
) {
    if (openDialog) {
        AlertDialog(
            title = {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = message,
                    fontWeight = FontWeight.Normal
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onYesClicked()
                        closeDialog()
                    }
                ) {
                    Text(text = stringResource(id = R.string.yes))
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        closeDialog()
                    }
                ) {
                    Text(text = stringResource(id = R.string.no))
                }
            },
            onDismissRequest = {
                closeDialog()
            }
        )
    }
}