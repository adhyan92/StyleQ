package com.example.styleq

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.styleq.ui.theme.StyleQTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StyleQTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SplashScreen(
                        message = "StyleQ",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

val Playfair_Display = FontFamily(
    Font(R.font.playfair_display)
)

    @Composable
    fun SplashScreen(message: String, modifier: Modifier = Modifier) {
        val splashPainter = painterResource(id = R.drawable.splash_screen)


        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = splashPainter,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Row(
                 verticalAlignment = Alignment.CenterVertically
             ) {
                 Text(
                     text = "Style",
                     fontSize = 75.sp,
                     color = Color.White,
                     fontWeight = FontWeight.SemiBold,
                     fontFamily = Playfair_Display
                 )
                 Text(
                     text = "Q",
                     fontSize = 75.sp,
                     color = Color.Yellow,
                     fontWeight = FontWeight.SemiBold,
                     fontFamily = Playfair_Display
                 )
             }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StyleQTheme {
        }
    }
}