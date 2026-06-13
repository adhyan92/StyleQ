package com.example.styleq

import android.graphics.drawable.Icon
import android.os.Bundle
import android.renderscript.Sampler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
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
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StyleQTheme {
                var currentPage by remember { mutableStateOf("splash") }
                val interactionSource = remember { MutableInteractionSource() }


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
                                currentPage = "create_account"
                            }
                        )
                    }

                    "login_screen" -> {
                        LoginScreen(
                            message = "StyleQ",
                            modifier = Modifier
                            )
                        }

//                    "create_account" -> {
//                        CreateAccount(
//                            message = "StyleQ",
//                            modifier = Modifier
//                            )
//                        }
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

val RaleWayFontFamily = FontFamily(
    Font(R.font.raleway_semibold)
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
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
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
fun OutlinedTextField(
    @StringRes label: Int,
    @DrawableRes leadingIcon : Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier

) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon),null )},
        keyboardOptions = keyboardOptions,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun LoginScreen(
    message: String,
    modifier: Modifier = Modifier
) {
    var usernameInput by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

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
                modifier = Modifier.padding(top = 100.dp)
            )
            Text(
                text = "Q",
                fontSize = 75.sp,
                color = Color.Yellow,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
                modifier = Modifier.padding(top = 100.dp)
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(275.dp))

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.card_login),
                contentDescription = null,
                modifier = Modifier.size(450.dp),
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier
                    .padding(bottom = 6.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "hello!",
                    fontSize = 40.sp,
                    color = Color(0xFF174C97),
                    fontFamily = RaleWayFontFamily
                )

                Spacer(modifier = Modifier.height(1.dp))

                OutlinedTextField(
                    value = usernameInput,
                    shape = RoundedCornerShape(100.dp),
                    onValueChange = { usernameInput = it },
                    label = { Text("Username") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_person),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.padding(horizontal = 80.dp)
                )

                Spacer(modifier = Modifier.height(1.dp))

                OutlinedTextField(
                    value = emailInput,
                    shape = RoundedCornerShape(100.dp),
                    onValueChange = { emailInput = it },
                    label = { Text("Email") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_email),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .padding(horizontal = 80.dp)
                )

                Spacer(modifier = Modifier.height(1.dp))

                OutlinedTextField(
                    value = passwordInput,
                    shape = RoundedCornerShape(100.dp),
                    onValueChange = { passwordInput = it },
                    label = { Text("Password") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_password),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .padding(horizontal = 80.dp)
                )

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "forgot password?",
                        fontSize = 10.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = InterFontFamily,
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { },
                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 80.dp)
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(0xFF005B96),
                                        Color(0xFF011F4B)
                                    )
                                ),
                                shape = RoundedCornerShape(100.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Login",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(3.dp))


                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "or Login With",
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = InterFontFamily,
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Image(
                    painter = painterResource(R.drawable.ic_google),
                    contentDescription = "Google Login",
                    modifier = Modifier.size(26.dp)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row {
                    Text(
                        text = "Don't have an account? ",
                        fontSize = 12.sp,
                        color = Color.Black,
                        fontFamily = InterFontFamily
                    )
                    Text(
                        text = "Register",
                        fontSize = 12.sp,
                        color = Color(0xFF174C97),
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = InterFontFamily
                    )
                }
            }
        }
    }

    @Composable
    fun CreateAccount(
        message: String,
        modifier: Modifier = Modifier

    ) {
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
                    modifier = Modifier.padding(top = 280.dp)
                )
                Text(
                    text = "Q",
                    fontSize = 75.sp,
                    color = Color.Yellow,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Playfair_Display,
                    modifier = Modifier.padding(top = 280.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Create Account",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Create A New Account",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(24.dp))


                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Username") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("No Handphone") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Confirm Password") },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        StyleQTheme {
            LoginScreen(
                message = "StyleQ",
                modifier = Modifier
            )
//            CreateAccount(
//                message = "StyleQ",
//                modifier = Modifier
//            )
        }
    }

