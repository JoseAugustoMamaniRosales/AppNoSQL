package com.example.appnosql

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appnosql.ui.theme.AppNoSQLTheme
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNoSQLTheme {
                val banco = openOrCreateDatabase("CadastroCurso", MODE_PRIVATE, null)
                banco.execSQL("CREATE TABLE IF NOT EXISTS course(course_name TEXT, course_duration TEXT, course_track TEXT, course_description TEXT)")
                //banco.execSQL("INSERT INTO course(course_name, course_duration, course_track, course_description) VALUES (2, "", "", "","")")
                App()
            }
        }
    }
}

@Composable
fun App(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onBackground
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("SQlite Database in Android", color = Color.Gray)
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                SimpleTextField("Enter your course name.", "courseName")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                SimpleTextField("Enter your course duration.", "courseDuration")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                SimpleTextField("Enter your course track.", "courseTrack")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                SimpleTextField("Enter your course description.", "courseDescription")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                ButtonSample("Add course to Database")

                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                ButtonSample("Read courses to Database")

                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
                

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppNoSQLTheme {
        App()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(label: String, name: String) {
    var text by rememberSaveable{ mutableStateOf("") }
    TextField(

        modifier = Modifier.background(color = Color.Gray),
        value = text,
        onValueChange = { text = it},

        label = { Text(label) },
    )
}
@Composable
fun ButtonSample(text: String){
    Button(
        colors = ButtonDefaults.buttonColors(Color.Cyan),
        onClick = {

        })
    {
        Text(text)
    }
}