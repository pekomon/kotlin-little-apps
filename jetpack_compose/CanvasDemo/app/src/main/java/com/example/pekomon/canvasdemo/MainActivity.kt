package com.example.pekomon.canvasdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pekomon.canvasdemo.ui.theme.CanvasDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MyCanvas()
            MyCanvasBehind()
        }
    }
}



@Composable
fun MyCanvas() {
    Canvas(modifier = Modifier
        .padding(20.dp)
        .size(300.dp)
    ) {
        drawRect(
            color = Color.Black,
            size = size
        )
        drawRect(
            color = Color.Red,
            topLeft = Offset(100f, 100f),
            size = Size(100f, 100f),
            style = Stroke(
                width = 3.dp.toPx()
            )
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.Red,
                    Color.Yellow
                ),
                center = center,
                radius = 100f
            ),
            radius = 100f,
            center = center
        )
        drawArc(
            color = Color.Green,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = false,
            topLeft = Offset(100f, 500f),
            size = Size(200f, 200f),
            style = Stroke(
                width = 3.dp.toPx()
            )
        )
        drawOval(
            color = Color.Magenta,
            topLeft = Offset(500f, 100f),
            size = Size(200f, 300f)
        )
        drawLine(
            color = Color.Cyan,
            start = Offset(300f, 700f),
            end = Offset(700f, 700f),
            strokeWidth = 5.dp.toPx()
        )
    }
}

@Composable
fun MyCanvasBehind() {
    val doIt = true
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow)
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan)
            .clipToBounds()
            .drawBehind {
                //Do something creative

                if (doIt) {
                    drawArc(
                        color = Color.Green,
                        startAngle = 0f,
                        sweepAngle = 270f,
                        useCenter = true,
                        topLeft = Offset(this.center.x - 300f, size.height /2f),
                        size = Size(600f, 600f)
                    )
                }

            },
            contentAlignment = Alignment.TopCenter
        ) {
            Column() {
                OutlinedButton(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = 120.dp, bottom = 50.dp)
                        .onGloballyPositioned {  },
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color.Yellow),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),

                    ) {
                    Text(text = "re")
                }
                Text(
                    text = "Hello", modifier = Modifier.padding(vertical = 30.dp))
            }

        }

    }

}

@Preview()
@Composable
fun DefaultPreview() {
    CanvasDemoTheme {
        // Do something()
    }
}