package com.clock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clock.ui.theme.ClockTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClockTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Circles()
                    val calendar = Calendar.getInstance()
                    calendar.timeInMillis = System.currentTimeMillis()
                    DrawHands(calendar)
                }
            }
        }
    }

    @Composable
    @Preview
    fun Circles() {
        Column(
            modifier = Modifier.padding(start = 32.dp, top = 32.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 66.dp),
                    text = "12"
                )

            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .padding(start = 70.dp)
                        .height(10.dp)
                        .width(10.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(50))
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 30.dp), text = "11"
                )
                Box(
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .height(10.dp)
                        .width(10.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(5.dp))
                )

                Box(
                    modifier = Modifier
                        .padding(start = 31.dp)
                        .height(10.dp)
                        .width(10.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(5.dp))
                )
                Text(
                    modifier = Modifier
                        .padding(start = 0.dp),
                    text = "1"
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp), text = "10"
                )
                Box(
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                        .background(
                            color = Color.Black,
                            shape = RoundedCornerShape(5.dp)
                        )
                )

                Box(
                    modifier = Modifier
                        .padding(start = 80.dp)
                        .height(10.dp)
                        .width(10.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(5.dp))
                )
                Text(
                    modifier = Modifier
                        .padding(start = 0.dp),
                    text = "2"
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 0.dp), text = "9"
                )
                Box(
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(5.dp))
                )

                Box(
                    modifier = Modifier
                        .padding(start = 125.dp)
                        .height(10.dp)
                        .width(10.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(5.dp))
                )
                Text(
                    modifier = Modifier
                        .padding(start = 0.dp),
                    text = "3"
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 19.dp), text = "8"
                )
                Box(
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(5.dp))
                )

                Box(
                    modifier = Modifier
                        .padding(start = 81.dp)
                        .height(10.dp)
                        .width(10.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(5.dp))
                )
                Text(
                    modifier = Modifier
                        .padding(start = 0.dp),
                    text = "4"
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 39.dp), text = "7"
                )
                Box(
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                        .background(
                            color = Color.Black,
                            shape = RoundedCornerShape(5.dp)
                        )
                )

                Box(
                    modifier = Modifier
                        .padding(start = 41.dp)
                        .height(10.dp)
                        .width(10.dp)
                        .background(
                            color = Color.Black,
                            shape = RoundedCornerShape(5.dp)
                        )
                )
                Text(
                    modifier = Modifier
                        .padding(start = 0.dp),
                    text = "5"
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp, start = 70.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(5.dp))
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 68.dp)
            ) {
                Text(text = "6")
            }
        }
    }

    @Composable
    fun DrawHands(calendar: Calendar) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            //minutes line
            val minutes = calendar.get(Calendar.MINUTE)
            var xMinutes = 0f
            var yMinutes = 0f
            when (minutes) {
                in 0..14 -> {
                    xMinutes = 380f
                    yMinutes= 0f
                }
                in 15..29 -> {
                    xMinutes = 760f
                    yMinutes= 410f
                }
                in 30..39 -> {
                    xMinutes = 380f
                    yMinutes= 800f
                }
                in 45..60 -> {
                    xMinutes = 0f
                    yMinutes= 380f
                }
                in 40..45 -> {
                    xMinutes = 800f
                    yMinutes= 300f
                }
            }
            drawLine(
                start = Offset(x = 300f, y = 350f), //center
                end = Offset(x = xMinutes, y = yMinutes),//Blue line down

                color = Color.Blue,
                strokeWidth = 10f
            )


            //hours line
            val hours = calendar.get(Calendar.HOUR_OF_DAY)
            var xHours = 0f
            var yHours = 0f
            when (hours) {
                0 -> {
                    xHours = 200f
                    yHours= 0f
                }
                1 -> {//1
                    xHours = 560f
                    yHours= 0f
                }
                2  -> {//2
                    xHours = 600f
                    yHours= 0f
                }
                3 -> {//3
                    xHours = 800f
                    yHours= 450f
                }
                4 -> {//4
                    xHours = 800f
                    yHours= 670f
                }
                5 -> {//5
                    xHours = 900f
                    yHours= 1570f
                }
                6 -> {//6
                    xHours = 380f
                    yHours= 800f
                }
                7 -> {//7
                    xHours = 140f
                    yHours= 1000f
                }
                8 -> {//8
                    xHours = 140f
                    yHours= 600f
                }
                9 -> {//9
                    xHours = 140f
                    yHours= 460f
                }
                10 -> {//10
                    xHours = 140f
                    yHours= 320f
                }
                11 -> {//11
                    xHours = 250f//
                    yHours= 100f//
                }
                12 -> {//12
                    xHours = 370f
                    yHours= 100f
                }
                13 -> {//13
                    xHours = 520f
                    yHours= 100f
                }
                14 -> {//14
                    xHours = 600f
                    yHours= 0f
                }
                15 -> {//15
                    xHours = 800f
                    yHours= 460f
                }
                16 -> {//16
                    xHours = 800f
                    yHours= 670f
                }
                17 -> {//17
                    xHours = 900f
                    yHours= 1570f
                }
                18 -> {//18
                    xHours = 380f
                    yHours= 800f
                }
                19 -> {//19
                    xHours = 240f
                    yHours= 800f
                }
                20/* остановился тут */ -> {//20
                    xHours = -700f
                    yHours= 1070f
                }
                21 -> {//21
                    xHours = 140f
                    yHours= 460f
                }
                22 -> {//22
                    xHours = 140f
                    yHours= 320f
                }
                23 -> {//23
                    xHours = 250f
                    yHours= 100f
                }
            }
            drawLine(
                start = Offset(x = 300f, y = 350f), //center
                end = Offset(x = xHours, y = yHours),
                color = Color.Black,
                strokeWidth = 10f
            )
        }
    }
}
