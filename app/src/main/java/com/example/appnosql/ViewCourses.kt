package com.example.appnosql

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.compose.material3.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appnosql.ui.theme.AppNoSQLTheme
import java.util.jar.Attributes.Name

class ViewCourses : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNoSQLTheme{
                ListCourses()
            }
            // on below line we are specifying background color for our application

        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ListCourses(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onBackground
    ){

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
                Text("Courses", color = Color.Gray, fontSize = 20.sp)
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Row(
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Text(text = "Name", fontSize = 15.sp)
                    Text(text = "Duration", fontSize = 15.sp)
                    Text(text = "Track", fontSize = 15.sp)
                    Text(text = "Description", fontSize = 15.sp)
                }
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                ButtonSample(text = "Register course")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ListCoursesPreview(){
    ListCourses()
}