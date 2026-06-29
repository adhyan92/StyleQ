package com.example.styleq

import android.os.Bundle
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.styleq.viewmodel.ProfileViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.styleq.data.BodyTypeRadio

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StyleQTheme {
                val interactionSource = remember { MutableInteractionSource() }
                    StyleQApp()
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
    val CrimsonFontFamily = FontFamily(
        Font(R.font.crimson_regular)
    )
    val NunitoSansFontFamily = FontFamily(
        Font(R.font.nunito_sans)
    )

    @Composable
    fun StyleQApp(
    ) {
        var currentPage by remember { mutableStateOf("SplashScreen") }
        val profileViewModel: ProfileViewModel = viewModel()

        when (currentPage) {

            "SplashScreen" -> {
                SplashScreen(
                    modifier = Modifier,
                    onTimeout = {
                        currentPage = "login_selection"
                    }
                )
            }

            "login_selection" -> {
                LoginSelectionScreen(
                    modifier = Modifier,
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
                    modifier = Modifier,
                    onLoginClick = {
                        currentPage = "welcome_screen"
                    }
                )
            }

            "create_account" -> {
                CreateAccount(
                    modifier = Modifier,
                    onCreatAccountClick = {
                        currentPage = "complete_profile"
                    }
                )
            }

            "complete_profile" -> {
                CompleteProfile(
                    modifier = Modifier,
                    profileViewModel = profileViewModel,
                    onCompleteProfileClick = {
                        currentPage = "welcome_screen"
                    }
                )
            }

            "welcome_screen" -> {
                WelcomeScreen(
                    modifier = Modifier,
                    onContinueClick = {
                        currentPage = "deskripsi_screen1"
                    }
                )
            }

            "deskripsi_screen1" -> {
                DeskripsiScreen1(
                    modifier = Modifier,
                    onContinueClick = {
                        currentPage = "deskripsi_screen2"
                    }
                )
            }

            "deskripsi_screen2" -> {
                DeskripsiScreen2(
                    modifier = Modifier,
                    onContinueClick = {
                        currentPage = "deskripsi_screen3"
                    }
                )
            }

            "deskripsi_screen3" -> {
                DeskripsiScreen3(
                    modifier = Modifier,
                    onContinueClick = {
                        currentPage = "upload_foto"
                    }
                )
            }

            "upload_foto" -> {
                UploadFoto(
                    modifier = Modifier,
                    onContinueClick = {
                        currentPage = "ootd_selection"
                    }
                )
            }

            "ootd_selection" -> {
                OotdSelection(
                    modifier = Modifier,
                    onContinueClick = {
                        currentPage = "color_screen"
                    }
                )
            }

            "color_screen" -> {
                ColorScreen(
                    modifier = Modifier,
                    onContinueClick = {
                        currentPage = "welcome_screen2"
                    }
                )
            }

            "welcome_screen2" -> {
                Welcome_Screen2(
                    modifier = Modifier,
                    onStartClick = {
                        currentPage = "profile_screen"
                    }
                )
            }

            "profile_screen" -> {
                ProfileScreen(
                    modifier = Modifier,
                    profileViewModel = profileViewModel,
                    onSaveClick = {}
                )
            }
        }
    }

    @Composable
    fun SplashScreen(
        modifier: Modifier = Modifier,
        onTimeout: () -> Unit
    ) {
        LaunchedEffect(Unit) {
            delay(4000)
            onTimeout()
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.background1),
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
        modifier: Modifier = Modifier,
        onLoginClick: () -> Unit,
        onSignUpClick: () -> Unit
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.background1),
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
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        onLoginClick()
                    }

                ) {
                    Image(
                        painter = painterResource(R.drawable.button1),
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

                    ) {
                        Image(
                            painter = painterResource(R.drawable.button1),
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
        @DrawableRes leadingIcon: Int,
        keyboardOptions: KeyboardOptions,
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier

    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
            keyboardOptions = keyboardOptions,
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun LoginScreen(
        modifier: Modifier = Modifier,
        onLoginClick: () -> Unit,
    ) {
        var usernameInput by remember { mutableStateOf("") }
        var emailInput by remember { mutableStateOf("") }
        var passwordInput by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        val context = LocalContext.current

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.background1),
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
                        modifier = Modifier.padding(horizontal = 50.dp)
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
                            .padding(horizontal = 50.dp)
                    )

                    Spacer(modifier = Modifier.height(1.dp))

                    OutlinedTextField(
                        value = passwordInput,
                        shape = RoundedCornerShape(100.dp),
                        onValueChange = { passwordInput = it },
                        label = { Text("Password") },
                        singleLine = true,

                        visualTransformation =
                            if (passwordVisible)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),

                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_password),
                                contentDescription = null,
                                modifier = Modifier.size(25.dp)
                            )
                        },

                        trailingIcon = {
                            Icon(
                                painter = painterResource(
                                    if (passwordVisible)
                                        R.drawable.icon_eye_close
                                    else
                                        R.drawable.icon_eye_open
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp)
                                    .clickable {
                                        passwordVisible = !passwordVisible
                                    }
                            )
                        },

                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),

                        modifier = Modifier.padding(horizontal = 50.dp)
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Box(
                        modifier = Modifier
                            .clickable {
                                Toast.makeText(
                                    context,
                                    "Feature Coming Soon",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                        contentAlignment = Alignment.Center
                    ) {
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
                                .padding(horizontal = 50.dp)
                                .fillMaxWidth()
                                .height(50.dp)
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    onLoginClick()
                                }
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

                    Box(
                        modifier = Modifier
                            .clickable {
                                Toast.makeText(
                                    context,
                                    "Feature Coming Soon",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_google),
                            contentDescription = "Google Login",
                            modifier = Modifier.size(26.dp)
                        )
                    }

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
    }

    @Composable
    fun CreateAccount(
        modifier: Modifier = Modifier,
        onCreatAccountClick: () -> Unit,

        ) {
        var passwordVisible by remember { mutableStateOf(false) }
        var usernameInput by remember { mutableStateOf("") }
        var emailInput by remember { mutableStateOf("") }
        var numberhpInput by remember { mutableStateOf("") }
        var passwordInput by remember { mutableStateOf("") }
        var confirmInput by remember { mutableStateOf("") }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.background1),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Style",
                    fontSize = 75.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Playfair_Display,
                    modifier = Modifier.padding(top = 80.dp)
                )
                Text(
                    text = "Q",
                    fontSize = 75.sp,
                    color = Color.Yellow,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Playfair_Display,
                    modifier = Modifier.padding(top = 80.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Create Account",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = InterFontFamily,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Create A New Account",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontFamily = InterFontFamily,
            )

            Spacer(modifier = Modifier.height(50.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(R.drawable.card_create),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 25.dp, end = 25.dp, bottom = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
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
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )

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
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = numberhpInput,
                        shape = RoundedCornerShape(100.dp),
                        onValueChange = { numberhpInput = it },
                        label = { Text("No Handphone") },
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_phone),
                                contentDescription = null,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = passwordInput,
                        shape = RoundedCornerShape(100.dp),
                        onValueChange = { passwordInput = it },
                        label = { Text("Password") },
                        singleLine = true,
                        visualTransformation =
                            if (passwordVisible)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),

                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_password),
                                contentDescription = null,
                                modifier = Modifier.size(25.dp)
                            )
                        },

                        trailingIcon = {
                            Icon(
                                painter = painterResource(
                                    if (passwordVisible)
                                        R.drawable.icon_eye_close
                                    else
                                        R.drawable.icon_eye_open
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp)
                                    .clickable {
                                        passwordVisible = !passwordVisible
                                    }
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = confirmInput,
                        shape = RoundedCornerShape(100.dp),
                        onValueChange = { confirmInput = it },
                        label = { Text("Confirm") },
                        singleLine = true,
                        visualTransformation =
                            if (passwordVisible)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),

                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_password),
                                contentDescription = null,
                                modifier = Modifier.size(25.dp)
                            )
                        },

                        trailingIcon = {
                            Icon(
                                painter = painterResource(
                                    if (passwordVisible)
                                        R.drawable.icon_eye_close
                                    else
                                        R.drawable.icon_eye_open
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp)
                                    .clickable {
                                        passwordVisible = !passwordVisible
                                    }
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

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
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth()
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    onCreatAccountClick()
                                }
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
                                text = "Create Account",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Row {
                        Text(
                            text = "Already have an account? ",
                            fontSize = 12.sp,
                            color = Color.Black,
                            fontFamily = InterFontFamily
                        )
                        Text(
                            text = "Login",
                            fontSize = 12.sp,
                            color = Color(0xFF174C97),
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = InterFontFamily
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun CompleteProfile(
        modifier: Modifier = Modifier,
        onCompleteProfileClick: () -> Unit,
        profileViewModel: ProfileViewModel
    ) {
        val scrollState = rememberScrollState()
        var fullnameInput by remember { mutableStateOf("") }
        var genderInput by remember { mutableStateOf("") }
        var heightInput by remember { mutableStateOf("") }
        var weightInput by remember { mutableStateOf("") }
        var ageInput by remember { mutableStateOf("") }
        var locationInput by remember { mutableStateOf("") }
        var selectedBodyType by remember { mutableStateOf("Pear") }
        var selectedSkinTone by remember { mutableStateOf("Light") }


        val bodyTypeOptions = listOf(
            BodyTypeRadio("Rectangle", Color(0xFF3B9B85)),
            BodyTypeRadio("Inverted", Color(0xFF2B72B9)),
            BodyTypeRadio("Pear", Color(0xFF8E24AA)),
            BodyTypeRadio("Hourglass", Color(0xFFC12757))
        )
        val skinToneOptions = listOf("Fair", "Light", "Medium", "Deep/Dark")

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.background1),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(top = 60.dp, bottom = 40.dp, start = 30.dp, end = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Image(
                        painter = painterResource(R.drawable.card_profile),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize(),
                        contentScale = ContentScale.FillBounds
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 30.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Text(
                            text = "Complete\nYour Profile",
                            fontSize = 32.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center,
                            fontFamily = InterFontFamily,
                            lineHeight = 40.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(50.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 5.dp, end = 24.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Image(
                                painter = painterResource(R.drawable.shape1),
                                contentDescription = null,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .height(35.dp),
                                contentScale = ContentScale.FillHeight
                            )
                            Box(
                                modifier = Modifier
                                    .height(35.dp)
                                    .padding(start = 35.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "About you",
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = InterFontFamily,
                                    modifier = Modifier.padding(start = 30.dp)
                                )
                            }
                        }

                        OutlinedTextField(
                            value = fullnameInput,
                            shape = RoundedCornerShape(100.dp),
                            onValueChange = { fullnameInput = it },
                            label = { Text("Fullname") },
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_person),
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = genderInput,
                            shape = RoundedCornerShape(100.dp),
                            onValueChange = { genderInput = it },
                            label = { Text("Male / Female") },
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_gender),
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = heightInput,
                            shape = RoundedCornerShape(100.dp),
                            onValueChange = { heightInput = it },
                            label = { Text("Height (cm)") },
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_height),
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = weightInput,
                            shape = RoundedCornerShape(100.dp),
                            onValueChange = { weightInput = it },
                            label = { Text("Weight (kg)") },
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_weight),
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = ageInput,
                            shape = RoundedCornerShape(100.dp),
                            onValueChange = { ageInput = it },
                            label = { Text("Age") },
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_person),
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = locationInput,
                            shape = RoundedCornerShape(100.dp),
                            onValueChange = { locationInput = it },
                            label = { Text("Location") },
                            singleLine = true,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_location),
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 5.dp, end = 24.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Image(
                                painter = painterResource(R.drawable.shape1),
                                contentDescription = null,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .height(35.dp),
                                contentScale = ContentScale.FillHeight
                            )
                            Box(
                                modifier = Modifier
                                    .height(35.dp)
                                    .padding(start = 18.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Select your body shape",
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = InterFontFamily,
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 3.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(start = 5.dp, end = 12.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.select_body),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(200.dp)
                                        .height(150.dp),
                                    contentScale = ContentScale.FillWidth
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 10.dp),
                                verticalArrangement = Arrangement.spacedBy(3.dp)
                            ) {
                                bodyTypeOptions.forEach { option ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable { selectedBodyType = option.name }
                                            .padding(vertical = 2.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        RadioButton(
                                            selected = (selectedBodyType == option.name),
                                            onClick = { selectedBodyType = option.name },
                                            colors = RadioButtonDefaults.colors(
                                                selectedColor = option.activeColor,
                                                unselectedColor = Color(0xFFD0D0D0)
                                            ),
                                            modifier = Modifier.size(12.dp)
                                        )

                                        Spacer(modifier = Modifier.width(8.dp))

                                        Text(
                                            text = option.name,
                                            fontSize = 8.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color.Black,
                                            fontFamily = InterFontFamily
                                        )
                                    }
                                }
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 3.dp)
                                .padding(start = 5.dp, end = 24.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Image(
                                painter = painterResource(R.drawable.shape1),
                                contentDescription = null,
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .height(35.dp),
                                contentScale = ContentScale.FillHeight
                            )
                            Box(
                                modifier = Modifier
                                    .height(35.dp)
                                    .padding(start = 18.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Select your skin tone",
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = InterFontFamily,
                                )
                            }
                        }

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(top = 3.dp)
                                    .wrapContentWidth()
                                    .padding(start = 5.dp, end = 12.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.skin_tone),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(400.dp)
                                        .height(100.dp),
                                    contentScale = ContentScale.FillWidth
                                )
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                modifier = Modifier
                                    .width(400.dp)
                                    .padding(start = 5.dp, end = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                skinToneOptions.forEach { tone ->
                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .clickable { selectedSkinTone = tone }
                                            .padding(vertical = 4.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        RadioButton(
                                            selected = (selectedSkinTone == tone),
                                            onClick = { selectedSkinTone = tone },
                                            colors = RadioButtonDefaults.colors(
                                                selectedColor = Color(0xFF2B72B9),
                                                unselectedColor = Color(0xFFD0D0D0)
                                            ),
                                            modifier = Modifier.size(20.dp)
                                        )

                                        Text(
                                            text = tone,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color.Black,
                                            fontFamily = InterFontFamily
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                onClick = {

                                    profileViewModel.saveProfile(
                                        fullName = fullnameInput,
                                        gender = genderInput,
                                        height = heightInput,
                                        weight = weightInput,
                                        age = ageInput,
                                        location = locationInput,
                                        bodyShape = selectedBodyType,
                                        skinTone = selectedSkinTone
                                    )

                                    onCompleteProfileClick()

                                },
                                contentPadding = PaddingValues(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                ),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Box(
                                    modifier = Modifier
                                        .padding(horizontal = 10.dp)
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
                                        text = "Complete Profile",
                                        color = Color.White,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun WelcomeScreen(
        modifier: Modifier = Modifier,
        onContinueClick: () -> Unit,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.background1),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome Back\nTo",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Style",
                    fontSize = 75.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Playfair_Display,
                )
                Text(
                    text = "Q",
                    fontSize = 75.sp,
                    color = Color.Yellow,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Playfair_Display,
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 150.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onContinueClick()
                }

            ) {
                Image(
                    painter = painterResource(R.drawable.button1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = stringResource(R.string.Continue),
                    fontSize = 30.sp,
                    color = Color(0xFF174B96),
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                )
            }
        }
    }

    @Composable
    fun DeskripsiScreen1(
        modifier: Modifier = Modifier,
        onContinueClick: () -> Unit,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(R.drawable.background2),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 120.dp,
                        bottom = 120.dp,
                        start = 50.dp,
                        end = 50.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(R.drawable.image_deskripsi1),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize(),
                        contentScale = ContentScale.FillBounds
                    )

                    Text(
                        text = "Hello",
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontFamily = RaleWayFontFamily,
                        modifier = Modifier.padding(top = 175.dp)
                    )

                    Text(
                        text = "StyleQ helps you discover\noutfits that match your\npersonality and lifestyle\ninstantly.",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                        lineHeight = 26.sp,
                        fontFamily = NunitoSansFontFamily,
                        modifier = Modifier.padding(top = 375.dp)
                    )
                }
            }

            Image(
                painter = painterResource(R.drawable.ic_button_arrow),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 30.dp)
                    .size(50.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        onContinueClick()
                    },
                contentScale = ContentScale.Fit
            )
        }
    }

    @Composable
    fun DeskripsiScreen2(
        modifier: Modifier = Modifier,
        onContinueClick: () -> Unit,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(R.drawable.background2),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 120.dp,
                        bottom = 120.dp,
                        start = 50.dp,
                        end = 50.dp
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(R.drawable.image_deskripsi2),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize(),
                        contentScale = ContentScale.FillBounds
                    )

                    Text(
                        text = "Explore",
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontFamily = RaleWayFontFamily,
                        modifier = Modifier.padding(top = 175.dp)
                    )

                    Text(
                        text = "Get personalized fashion\ntips, curated looks, and\nexclusive deals—all in one\nstylish app.",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                        lineHeight = 26.sp,
                        fontFamily = NunitoSansFontFamily,
                        modifier = Modifier.padding(top = 375.dp)
                    )
                }
            }

            Image(
                painter = painterResource(R.drawable.ic_button_arrow),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 30.dp)
                    .size(50.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        onContinueClick()
                    },
                contentScale = ContentScale.Fit
            )
        }
    }

    @Composable
    fun DeskripsiScreen3(
        modifier: Modifier = Modifier,
        onContinueClick: () -> Unit,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(R.drawable.background2),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 120.dp,
                        bottom = 120.dp,
                        start = 50.dp,
                        end = 50.dp
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(R.drawable.image_deskripsi3),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize(),
                        contentScale = ContentScale.FillBounds
                    )

                    Text(
                        text = "Ready?",
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontFamily = RaleWayFontFamily,
                        modifier = Modifier
                            .padding(top = 175.dp)
                    )
                    Text(
                        text = "StyleQ is your smart fashion\nadvisor, guiding you to dress\nwith confidence every day.",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                        lineHeight = 26.sp,
                        fontFamily = NunitoSansFontFamily,
                        modifier = Modifier
                            .padding(top = 375.dp)
                    )
                }
            }
            Image(
                painter = painterResource(R.drawable.ic_button_arrow),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 30.dp)
                    .size(50.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        onContinueClick()
                    },
                contentScale = ContentScale.Fit
            )
        }
    }

    @Composable
    fun UploadFoto(
        modifier: Modifier = Modifier,
        onContinueClick: () -> Unit,
    ) {
        val context = LocalContext.current

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.background1),
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
            Image(
                painter = painterResource(R.drawable.foto_person),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 20.dp),
                contentScale = ContentScale.Fit
            )

            Box(
                modifier = Modifier
                    .padding(bottom = 300.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "Feature Coming Soon",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.button2),
                    contentDescription = null,
                    modifier = Modifier.size(250.dp),
                    contentScale = ContentScale.Fit
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Upload Photo",
                        fontSize = 28.sp,
                        color = Color(0xFF174B96),
                        fontWeight = FontWeight.Bold,
                        fontFamily = InterFontFamily
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(
                        painter = painterResource(R.drawable.camera),
                        contentDescription = null,
                        tint = Color(0xFF174B96),
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Let your style shine",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 290.dp),
                fontWeight = FontWeight.Normal,
                fontFamily = CrimsonFontFamily,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onContinueClick()
                }

            ) {
                Image(
                    painter = painterResource(R.drawable.button1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = stringResource(R.string.Continue),
                    fontSize = 30.sp,
                    color = Color(0xFF174B96),
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                )
            }
        }
    }

    @Composable
    fun OotdSelection(
        modifier: Modifier = Modifier,
        onContinueClick: () -> Unit
    ) {

        val context = LocalContext.current

        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(R.drawable.background2),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 80.dp,
                    bottom = 180.dp,
                    start = 50.dp,
                    end = 50.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.card_ootd),
                    contentDescription = null,
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Select Your\nSignature Look",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = InterFontFamily,
                    lineHeight = 40.sp,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 35.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 110.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.formal),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Formal",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.casual),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Casual",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.sporty),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Sporty",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.retro),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Retro",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }
                        Box(
                            modifier = Modifier.size(80.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.logo_styleq),
                                contentDescription = "Logo StyleQ",
                                modifier = Modifier.matchParentSize()
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Style",
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Playfair_Display
                                )
                                Text(
                                    text = "Q",
                                    fontSize = 16.sp,
                                    color = Color.Yellow,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Playfair_Display
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.clean),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Clean",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.batik),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Batik",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.muslim),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Muslim",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.street),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Street",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onContinueClick()
                }

            ) {
                Image(
                    painter = painterResource(R.drawable.button1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = stringResource(R.string.Continue),
                    fontSize = 30.sp,
                    color = Color(0xFF174B96),
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                )
            }
        }
    }

    @Composable
    fun ColorScreen(
        modifier: Modifier = Modifier,
        onContinueClick: () -> Unit
    ) {
        val context = LocalContext.current

        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(R.drawable.background2),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 80.dp,
                    bottom = 180.dp,
                    start = 50.dp,
                    end = 50.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.card_color),
                    contentDescription = null,
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Select Your\nColor Look",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = InterFontFamily,
                    lineHeight = 40.sp,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 35.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 110.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.black),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Hitam",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.white),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "White",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.grey),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Grey",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.beige),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Beige",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }
                        Box(
                            modifier = Modifier.size(80.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.logo_styleq),
                                contentDescription = "Logo StyleQ",
                                modifier = Modifier.matchParentSize()
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Style",
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Playfair_Display
                                )
                                Text(
                                    text = "Q",
                                    fontSize = 16.sp,
                                    color = Color.Yellow,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Playfair_Display
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.red),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Red",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.navy),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Navy",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.olive),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Olive",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .size(
                                    width = 75.dp,
                                    height = 100.dp
                                )
                                .clickable {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.camel),
                                contentDescription = null,
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(22.dp)
                                    .align(Alignment.TopCenter),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Camel",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = InterFontFamily
                                )
                            }
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onContinueClick()
                }

            ) {
                Image(
                    painter = painterResource(R.drawable.button1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = stringResource(R.string.Continue),
                    fontSize = 30.sp,
                    color = Color(0xFF174B96),
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                )
            }
        }
    }

    @Composable
    fun Welcome_Screen2(
        modifier: Modifier = Modifier,
        onStartClick: () -> Unit
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.background1),
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
            Image(
                painter = painterResource(R.drawable.foto_person),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 20.dp),
                contentScale = ContentScale.Fit
            )

            Box(
                modifier = Modifier
                    .padding(top = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Hi, Shinta",
                        fontSize = 28.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = InterFontFamily
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(
                        painter = painterResource(R.drawable.hand_welcome),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Define Your Fashion Journey",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 290.dp),
                fontWeight = FontWeight.Normal,
                fontFamily = CrimsonFontFamily,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onStartClick()
                }

            ) {
                Image(
                    painter = painterResource(R.drawable.button1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = stringResource(R.string.Lets_Start),
                    fontSize = 30.sp,
                    color = Color(0xFF174B96),
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                )
            }
        }
    }

    @Composable
    fun ProfileScreen(
        modifier: Modifier = Modifier,
        profileViewModel: ProfileViewModel,
        onSaveClick: () -> Unit = {},
        onBackClick: () -> Unit = {},
    ) {

        val skinToneOptions = listOf("Fair", "Light", "Medium", "Deep/Dark")
        val profile = profileViewModel.profile.value
        val scrollState = rememberScrollState()

        val fullnameInput = profile.fullName
        val genderInput = profile.gender
        val heightInput = profile.height
        val weightInput = profile.weight
        val ageInput = profile.age
        val locationInput = profile.location

        val selectedBodyType = profile.bodyShape
        val selectedSkinTone = profile.skinTone
        val bodyTypeOptions = listOf(
            BodyTypeRadio("Rectangle", Color(0xFF3B9B85)),
            BodyTypeRadio("Inverted", Color(0xFF2B72B9)),
            BodyTypeRadio("Pear", Color(0xFF8E24AA)),
            BodyTypeRadio("Hourglass", Color(0xFFC12757))
        )

        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp)
                ) {

                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize(),
                        contentScale = ContentScale.Crop
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 45.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp)
                        ) {

                            Image(
                                painter = painterResource(R.drawable.arrow_back),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .size(40.dp)
                                    .clickable { onBackClick() }
                            )

                            Text(
                                text = "My Profile",
                                modifier = Modifier.align(Alignment.Center),
                                fontFamily = InterFontFamily,
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Image(
                            painter = painterResource(R.drawable.foto_person),
                            contentDescription = null,
                            modifier = Modifier.size(150.dp)
                        )

                        Spacer(modifier = Modifier.height(28.dp))

                        Text(
                            text = "Hi, ${profile.fullName}",
                            fontFamily = InterFontFamily,
                            color = Color.White,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    OutlinedTextField(
                        value = fullnameInput,
                        onValueChange = {},
                        readOnly = true,
                        shape = RoundedCornerShape(100.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_person),
                                contentDescription = null,
                                modifier = Modifier.size(26.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = genderInput,
                        onValueChange = {},
                        readOnly = true,
                        shape = RoundedCornerShape(100.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_gender),
                                contentDescription = null,
                                modifier = Modifier.size(26.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = heightInput,
                        onValueChange = {},
                        readOnly = true,
                        shape = RoundedCornerShape(100.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_height),
                                contentDescription = null,
                                modifier = Modifier.size(26.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = weightInput,
                        onValueChange = {},
                        readOnly = true,
                        shape = RoundedCornerShape(100.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_weight),
                                contentDescription = null,
                                modifier = Modifier.size(26.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = ageInput,
                        onValueChange = {},
                        readOnly = true,
                        shape = RoundedCornerShape(100.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_person),
                                contentDescription = null,
                                modifier = Modifier.size(26.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = locationInput,
                        onValueChange = {},
                        readOnly = true,
                        shape = RoundedCornerShape(100.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_location),
                                contentDescription = null,
                                modifier = Modifier.size(26.dp)
                            )
                        },
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 8.dp, end = 24.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Image(
                            painter = painterResource(R.drawable.shape1),
                            contentDescription = null,
                            modifier = Modifier
                                .wrapContentWidth()
                                .height(35.dp),
                            contentScale = ContentScale.FillHeight
                        )
                        Box(
                            modifier = Modifier
                                .height(35.dp)
                                .padding(start = 35.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Your body shape",
                                fontSize = 16.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = InterFontFamily,
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(start = 10.dp, end = 12.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Image(
                                painter = painterResource(R.drawable.select_body),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(150.dp),
                                contentScale = ContentScale.FillWidth
                            )
                        }

                        Spacer(modifier = Modifier.width(18.dp))

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 40.dp),
                            verticalArrangement = Arrangement.spacedBy(3.dp)
                        ) {
                            bodyTypeOptions.forEach { option ->

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 2.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    RadioButton(
                                        selected = (profile.bodyShape == option.name),
                                        onClick = {},
                                        enabled = false,
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = option.activeColor,
                                            unselectedColor = Color(0xFFD0D0D0),
                                            disabledSelectedColor = option.activeColor,
                                            disabledUnselectedColor = Color(0xFFD0D0D0)
                                        ),
                                        modifier = Modifier.size(12.dp)
                                    )

                                    Spacer(modifier = Modifier.width(8.dp))

                                    Text(
                                        text = option.name,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color.Black,
                                        fontFamily = InterFontFamily
                                    )
                                }
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 24.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Image(
                            painter = painterResource(R.drawable.shape1),
                            contentDescription = null,
                            modifier = Modifier
                                .wrapContentWidth()
                                .height(35.dp),
                            contentScale = ContentScale.FillHeight
                        )
                        Box(
                            modifier = Modifier
                                .height(35.dp)
                                .padding(start = 45.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Your skin tone",
                                fontSize = 16.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = InterFontFamily,
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(R.drawable.skin_tone),
                            contentDescription = null,
                            modifier = Modifier
                                .width(400.dp)
                                .height(100.dp),
                            contentScale = ContentScale.FillWidth
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {

                            skinToneOptions.forEach { tone ->

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {

                                    RadioButton(
                                        selected = profile.skinTone == tone,
                                        onClick = {},
                                        enabled = false,
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = Color(0xFF2B72B9),
                                            unselectedColor = Color(0xFFD0D0D0),
                                            disabledSelectedColor = Color(0xFF2B72B9),
                                            disabledUnselectedColor = Color(0xFFD0D0D0)
                                        ),
                                        modifier = Modifier.size(20.dp)
                                    )

                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = tone,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color.Black,
                                        fontFamily = InterFontFamily,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(26.dp))

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
                                .padding(horizontal = 50.dp)
                                .fillMaxWidth()
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    onSaveClick()
                                }
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
                                text = "Save",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
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
            StyleQApp(
            )
        }
    }
