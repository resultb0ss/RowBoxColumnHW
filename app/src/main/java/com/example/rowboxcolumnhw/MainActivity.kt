package com.example.rowboxcolumnhw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rowboxcolumnhw.ui.theme.RowBoxColumnHWTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           GreetingPreview()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    Column(Modifier.fillMaxSize()
        .border(width = 1.dp, shape = RectangleShape, color = Color.Black)
        .padding(horizontal = 4.dp)
        .padding(top = 30.dp)) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.DarkGray)
            .border(width = 1.dp, shape = RectangleShape, color = Color.Black),
            Arrangement.Absolute.Center) {

            Text(text = "Данные по персоналу", modifier = Modifier, fontSize = 18.sp,
                fontWeight = FontWeight.Bold)
        }

        Row (modifier = Modifier.background(color = Color.LightGray).fillMaxWidth(), Arrangement.SpaceAround){
            Text(text = "Имя")
            Text(text = "Зарплата")
            Text(text = "Телефон")

        }

        Surface(Modifier.fillMaxSize().border(width = 1.dp, shape = RectangleShape, color = Color.Black)) {

            Column {
                for (item in PersonDataBase.personList){
                    Row (modifier = Modifier.fillMaxWidth()
                        .border(width = 0.5.dp, shape = RectangleShape, color = Color.Black), Arrangement.SpaceAround) {
                        Text(text = item.name)
                        Text(text = item.salary.toString())
                        Text(text = getRandomPhone())
                    }
                }
            }
        }
    }
}

fun getRandomPhone(): String{
    val phone = "+7"+(90000000..99999999).random().toString()
    return phone
}