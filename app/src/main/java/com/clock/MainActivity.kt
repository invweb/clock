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
                    drawHands(calendar)
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
                    .padding(start = 71.dp), text = "0"
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
                .padding(top = 50.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 0.dp), text = "45"
            )
            Box(
                modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
                    .background(color = Color.Black, shape = RoundedCornerShape(5.dp))
            )

            Box(
                modifier = Modifier
                    .padding(start = 100.dp)
                    .height(10.dp)
                    .width(10.dp)
                    .background(color = Color.Black, shape = RoundedCornerShape(5.dp))
            )
            Text(
                modifier = Modifier
                    .padding(start = 0.dp),
                text = "15"
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 70.dp)
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
            Text(text = "30")
        }
    }
}

    @Composable
    fun drawHands(calendar: Calendar) {
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
                in 30..44 -> {
                    xMinutes = 380f
                    yMinutes= 800f
                }
                in 45..60 -> {
                    xMinutes = 0f
                    yMinutes= 380f
                }
            }
            drawLine(
                start = Offset(x = 380f, y = 410f), //center
//                end = Offset(x = 100f, y = 100f),//
//                end = Offset(x = 0f, y = 410f),//Blue line left
//                end = Offset(x = 760f, y = 410f),//Blue line right
//                end = Offset(x = 380f, y = 0f),//Blue line up
                end = Offset(x = xMinutes, y = yMinutes),//Blue line down

                color = Color.Blue,
                strokeWidth = 10f
            )


            //hours line
            val hours = calendar.get(Calendar.HOUR_OF_DAY)
            var x = 0f
            var y = 0f
            when (hours) {
                in 0..14 -> {
                    x = 380f
                    y= 0f
                }
                in 15..29 -> {
                    x = 760f
                    y= 410f
                }
                in 30..44 -> {
                    x = 380f
                    y= 800f
                }
                in 45..60 -> {
                    x = 0f
                    y= 380f
                }
            }
            drawLine(
                start = Offset(x = 380f, y = 410f), //center
                end = Offset(x = x, y = y),
//                end = Offset(x = 0f, y = 410f),//Black line left
//                end = Offset(x = 760f, y = 410f),//Black line right
//                end = Offset(x = 380f, y = 0f),//Black line up
//                end = Offset(x = 380f, y = 800f),//Black line down
                color = Color.Black,
                strokeWidth = 10f
            )
        }
    }
}


