package com.example.styleq

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation

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
                            onLoginClick = {
                                currentPage = "login_screen"
                            },
                            onSignUpClick = {
                                currentPage = "sign_up"
                            }
                        )
                    }

                    "login_screen" -> {
                        LoginScreen(

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
fun LoginSelectionScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit) {
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
                modifier = Modifier.clickable (
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onLoginClick()
                }

            ){
                Image(
                    painter = painterResource(R.drawable.button_login),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp),
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
                    modifier = Modifier
                        .padding(top = 150.dp)
                        .clickable {
                            onSignUpClick()
                        }
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


@Composable
fun LoginScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
                    modifier = Modifier.padding(top = 120.dp)
                )
                Text(
                    text = "Q",
                    fontSize = 75.sp,
                    color = Color.Yellow,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Playfair_Display,
                    modifier = Modifier.padding(top = 120.dp)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Card(
                shape = RoundedCornerShape(62.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "hello!",
                        color = Color(0xFF0D47A1),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        shape = RoundedCornerShape(100.dp),
                        value = "",
                        onValueChange = {},
                        label = { Text("Username") },
                        leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        shape = RoundedCornerShape(100.dp),
                        value = "",
                        onValueChange = {},
                        label = { Text("Email") },
                        leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        shape = RoundedCornerShape(100.dp),
                        value = "",
                        onValueChange = {},
                        label = { Text("Password") },
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "forgot password?",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.End)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Color(0xFF005B96),
                                            Color(0xFF011F4B)
                                        )
                                    )
                                )
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Login", color = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Text("or Login with")

                    Spacer(modifier = Modifier.height(8.dp))

                    IconButton(onClick = { /* TODO: Google login */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "Instagram",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row {
                        Text("Don't have an account?")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Register",
                            color = Color(0xFF0D47A1),
                            fontWeight = FontWeight.Bold
                        )
                    }
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

