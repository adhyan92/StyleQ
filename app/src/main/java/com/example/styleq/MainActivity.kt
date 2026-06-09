package com.example.styleq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import kotlinx.coroutines.delay
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StyleQTheme {
                var currentPage by remember { mutableStateOf("splash") }

                when (currentPage) {
                    "splash" -> {
                        StyleQSplashScreen(
                            message = "StyleQ",
                            modifier = Modifier.fillMaxSize(),
                            onTimeout = { currentPage = "login_selection" }
                        )
                    }

                    "login_selection" -> {
                        LoginSelectionScreen(
                            onLoginClick = { },
                            onSignUpClick = { }
                        )
                    }
                }
            }
        }
    }
}





val Playfair_Display = FontFamily(
    Font(R.font.playfair_display)
)
val InterFontFamily = FontFamily(
    Font(R.font.inter, FontWeight.Normal)
)

@Composable
fun StyleQSplashScreen(message: String, modifier: Modifier = Modifier, onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(4000)
        onTimeout()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
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

@Composable
fun LoginSelectionScreen(onLoginClick: () -> Unit, onSignUpClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Style",
                fontSize = 75.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
                modifier = Modifier.padding(top = 210.dp)
            )
            Text(
                text = "Q",
                fontSize = 75.sp,
                color = Color.Yellow,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
                modifier = Modifier.padding(top = 210.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 225.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                contentAlignment = Alignment.Center,
            ){
                Image(
                    painter = painterResource(R.drawable.button_login),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = stringResource(R.string.Login),
                    fontSize = 30.sp,
                    color = Color(0xFF174B96),
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(top = 150.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.button_signup),
                        contentDescription = null,
                        modifier = Modifier.size(200.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = stringResource(R.string.Sign_Up),
                        fontSize = 30.sp,
                        color = Color(0xFF174B96),
                        fontWeight = FontWeight.Bold,
                        fontFamily = InterFontFamily,
                    )
                }
            }
        }
    }
}
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        StyleQTheme {
        }
    }
