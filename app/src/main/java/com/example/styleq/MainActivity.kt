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
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import com.example.styleq.viewmodel.ProfileViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.styleq.data.BodyTypeRadio
import com.example.styleq.data.PartnerShopData
import com.example.styleq.data.VoucherItem
import com.example.styleq.ui.theme.solidTextFieldColors
import com.example.styleq.ui.theme.ResponsiveScale
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.styleq.ui.theme.Playfair_Display
import com.example.styleq.ui.theme.InterFontFamily
import com.example.styleq.ui.theme.RaleWayFontFamily
import com.example.styleq.ui.theme.CrimsonFontFamily
import com.example.styleq.ui.theme.NunitoSansFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StyleQTheme {
                val interactionSource = remember { MutableInteractionSource() }
                ResponsiveScale {
                    StyleQApp()
                }
            }
        }
    }
}

@Composable
fun StyleQApp(
) {
    val navController = rememberNavController()
    val profileViewModel: ProfileViewModel = viewModel()

    NavHost(navController = navController, startDestination = "SplashScreen") {

        composable("SplashScreen") {
            SplashScreen(
                modifier = Modifier,
                onTimeout = {
                    navController.navigate("login_selection")
                }
            )
        }

        composable("login_selection") {
            LoginSelectionScreen(
                modifier = Modifier,
                onLoginClick = {
                    navController.navigate("login_screen")
                },
                onSignUpClick = {
                    navController.navigate("create_account")
                }
            )
        }

        composable("login_screen") {
            LoginScreen(
                modifier = Modifier,
                onLoginClick = {
                    navController.navigate("welcome_screen")
                }
            )
        }

        composable("create_account") {
            CreateAccount(
                modifier = Modifier,
                onCreatAccountClick = {
                    navController.navigate("complete_profile")
                }
            )
        }

        composable("complete_profile") {
            CompleteProfile(
                modifier = Modifier,
                profileViewModel = profileViewModel,
                onCompleteProfileClick = {
                    navController.navigate("welcome_screen")
                }
            )
        }

        composable("welcome_screen") {
            WelcomeScreen(
                modifier = Modifier,
                onContinueClick = {
                    navController.navigate("deskripsi_screen1")
                }
            )
        }

        composable("deskripsi_screen1") {
            DeskripsiScreen1(
                modifier = Modifier,
                onContinueClick = {
                    navController.navigate("deskripsi_screen2")
                }
            )
        }

        composable("deskripsi_screen2") {
            DeskripsiScreen2(
                modifier = Modifier,
                onContinueClick = {
                    navController.navigate("deskripsi_screen3")
                }
            )
        }

        composable("deskripsi_screen3") {
            DeskripsiScreen3(
                modifier = Modifier,
                onContinueClick = {
                    navController.navigate("upload_foto")
                }
            )
        }

        composable("upload_foto") {
            UploadFoto(
                modifier = Modifier,
                onContinueClick = {
                    navController.navigate("ootd_selection")
                }
            )
        }

        composable("ootd_selection") {
            OotdSelection(
                modifier = Modifier,
                onContinueClick = {
                    navController.navigate("color_screen")
                }
            )
        }

        composable("color_screen") {
            ColorScreen(
                modifier = Modifier,
                onContinueClick = {
                    navController.navigate("welcome_screen2")
                }
            )
        }

        composable("welcome_screen2") {
            Welcome_Screen2(
                modifier = Modifier,
                onStartClick = {
                    navController.navigate("dashboard")
                }
            )
        }

        composable("dashboard") {
            Dashboard(
                modifier = Modifier,
                onClick = {
                    navController.navigate("categories")
                },
                onProfileClick = {
                    navController.navigate("profile_screen")
                },
                onMyActivityClick = {
                    navController.navigate("my_activity")
                },
                onFavoriteClick = {
                    navController.navigate("favorite")
                },
                onSettingsClick = {
                    navController.navigate("settings")
                },
                onTrendingNowClick = {
                    navController.navigate("trending_now")
                },
                onHomeClick = {
                    navController.navigate("dashboard")
                },
                onColorMatcherClick = {
                    navController.navigate("color_matching")
                },
                onCategoriesClick = {
                    navController.navigate("trending_now")
                },
                onShopClick = {
                    navController.navigate("display_fashion")
                },
            )
        }

        composable("trending_now") {
            TrendingNow(
                modifier = Modifier,
                onHomeClick = {
                    navController.navigate("dashboard")
                },
                onColorMatcherClick = {
                    navController.navigate("color_matching")
                },
                onCategoriesClick = {
                    navController.navigate("trending_now")
                },
                onShopClick = {
                    navController.navigate("display_fashion")
                },
                onProfileClick = {
                    navController.navigate("profile_screen")
                }
            )
        }

        composable("categories") {
            Categories(
                modifier = Modifier,
                onDisplayClick = {
                    navController.navigate("display_fashion")
                },
                onHomeClick = {
                    navController.navigate("dashboard")
                },
                onColorMatcherClick = {
                    navController.navigate("color_matching")
                },
                onCategoriesClick = {
                    navController.navigate("trending_now")
                },
                onShopClick = {
                    navController.navigate("display_fashion")
                },
                onProfileClick = {
                    navController.navigate("profile_screen")
                }
            )
        }

        composable("display_fashion") {
            DisplayFashion(
                modifier = Modifier,
                onBuyNowClick = {
                    navController.navigate("partner_shop")
                },
                onHomeClick = {
                    navController.navigate("dashboard")
                },
                onColorMatcherClick = {
                    navController.navigate("color_matching")
                },
                onCategoriesClick = {
                    navController.navigate("trending_now")
                },
                onShopClick = {
                    navController.navigate("display_fashion")
                },
                onProfileClick = {
                    navController.navigate("profile_screen")
                }
            )
        }

        composable("partner_shop") {
            PartnerShop(
                modifier = Modifier,
                onClaimVoucherClick = {
                    navController.navigate("my_voucher")
                },
                onHomeClick = {
                    navController.navigate("dashboard")
                },
                onColorMatcherClick = {
                    navController.navigate("color_matching")
                },
                onCategoriesClick = {
                    navController.navigate("trending_now")
                },
                onShopClick = {
                    navController.navigate("display_fashion")
                },
                onProfileClick = {
                    navController.navigate("profile_screen")
                }
            )
        }

        composable("my_voucher") {
            MyVoucher(
                modifier = Modifier,
                onSettingsClick = {
                    navController.navigate("settings")
                },
                onHomeClick = {
                    navController.navigate("dashboard")
                },
                onColorMatcherClick = {
                    navController.navigate("color_matching")
                },
                onCategoriesClick = {
                    navController.navigate("trending_now")
                },
                onShopClick = {
                    navController.navigate("display_fashion")
                },
                onProfileClick = {
                    navController.navigate("profile_screen")
                }
            )
        }

        composable("profile_screen") {
            ProfileScreen(
                modifier = Modifier,
                profileViewModel = profileViewModel,
                onBackClick = {
                    navController.navigate("dashboard")
                },
                onSaveClick = {
                    navController.navigate("dashboard")
                }
            )
        }

        composable("settings") {
            Settings(
                modifier = Modifier,
                onBackClick = {
                    navController.navigate("dashboard")
                },
                onHomeClick = {
                    navController.navigate("dashboard")
                },
                onApplyClick = {
                    navController.navigate("dashboard")
                }
            )
        }

        composable("favorite") {
            Favorite(
                modifier = Modifier,
                onHomeClick = {
                    navController.navigate("dashboard")
                },
                onBackClick = {
                    navController.navigate("dashboard")
                }
            )
        }

        composable("my_activity") {
            MyActivity(
                modifier = Modifier,
                onHomeClick = {
                    navController.navigate("dashboard")
                }
            )
        }

        composable("color_matching") {
            ColorMatching(
                modifier = Modifier,
                onHomeClick = {
                    navController.navigate("dashboard")
                }
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
                fontSize = 96.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display
            )
            Text(
                text = "Q",
                fontSize = 96.sp,
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
                fontSize = 96.sp,
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
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onLoginClick()
                },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.button1),
                    contentDescription = null,
                    modifier = Modifier
                        .width(250.dp)
                        .height(70.dp),
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = stringResource(R.string.Login),
                    fontSize = 30.sp,
                    color = Color(0xFF174B96),
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onSignUpClick()
                },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.button1),
                    contentDescription = null,
                    modifier = Modifier
                        .width(250.dp)
                        .height(70.dp),
                    contentScale = ContentScale.FillBounds
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
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Style",
                fontSize = 96.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
            )
            Text(
                text = "Q",
                fontSize = 96.sp,
                color = Color.Yellow,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 350.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.card_login),
                contentDescription = null,
                modifier = Modifier
                    .width(375.dp)
                    .height(550.dp),
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

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedTextField(
                    value = usernameInput,
                    shape = RoundedCornerShape(100.dp),
                    onValueChange = { usernameInput = it },
                    label = { Text("Username") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_profile),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    colors = solidTextFieldColors(),
                    modifier = Modifier
                        .padding(horizontal = 50.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

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
                    colors = solidTextFieldColors(),
                    modifier = Modifier
                        .padding(horizontal = 50.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

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
                    colors = solidTextFieldColors(),
                    modifier = Modifier
                        .padding(horizontal = 50.dp)
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
                            fontSize = 12.sp,
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
                            .padding(horizontal = 85.dp)
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

                Spacer(modifier = Modifier.height(4.dp))


                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "or Login With",
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = InterFontFamily,
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

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
                        modifier = Modifier.size(32.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

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
                    Row {
                        Text(
                            text = "Don't have an account? ",
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontFamily = InterFontFamily
                        )
                        Text(
                            text = "Register",
                            fontSize = 14.sp,
                            color = Color(0xFF174C97),
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = InterFontFamily
                        )
                    }
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
                fontSize = 96.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
                modifier = Modifier.padding(top = 80.dp)
            )
            Text(
                text = "Q",
                fontSize = 96.sp,
                color = Color.Yellow,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
                modifier = Modifier.padding(top = 80.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Create Account",
            fontSize = 36.sp,
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
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 350.dp,
                start = 30.dp,
                end = 30.dp
            ),
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
                .padding(top = 35.dp, start = 25.dp, end = 25.dp, bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = usernameInput,
                shape = RoundedCornerShape(100.dp),
                onValueChange = { usernameInput = it },
                label = { Text("Username") },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_profile),
                        contentDescription = null,
                        modifier = Modifier.size(22.dp)
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = solidTextFieldColors(),
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
                colors = solidTextFieldColors(),
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
                colors = solidTextFieldColors(),
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
                colors = solidTextFieldColors(),
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
                colors = solidTextFieldColors(),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

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
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row {
                Text(
                    text = "Already have an account? ",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = InterFontFamily
                )
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                    color = Color(0xFF174C97),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = InterFontFamily
                )
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
                        fontSize = 36.sp,
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
                                painter = painterResource(R.drawable.ic_profile),
                                contentDescription = null,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        colors = solidTextFieldColors(),
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
                        colors = solidTextFieldColors(),
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
                        colors = solidTextFieldColors(),
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
                        colors = solidTextFieldColors(),
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
                                painter = painterResource(R.drawable.ic_profile),
                                contentDescription = null,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        colors = solidTextFieldColors(),
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
                        colors = solidTextFieldColors(),
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
            fontSize = 40.sp,
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
                fontSize = 96.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
            )
            Text(
                text = "Q",
                fontSize = 96.sp,
                color = Color.Yellow,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 250.dp),
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
                    .width(220.dp)
                    .height(60.dp),
                contentScale = ContentScale.FillBounds
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
                    top = 130.dp,
                    bottom = 130.dp,
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
                    fontSize = 36.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = RaleWayFontFamily,
                    modifier = Modifier.padding(top = 175.dp)
                )

                Text(
                    text = "StyleQ helps you discover\noutfits that match your\npersonality and lifestyle\ninstantly.",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    lineHeight = 26.sp,
                    fontFamily = NunitoSansFontFamily,
                    modifier = Modifier.padding(top = 400.dp)
                )
            }
        }

        Image(
            painter = painterResource(R.drawable.ic_button_arrow),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
                .size(60.dp)
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
                    top = 130.dp,
                    bottom = 130.dp,
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
                    fontSize = 36.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = RaleWayFontFamily,
                    modifier = Modifier.padding(top = 175.dp)
                )

                Text(
                    text = "Get personalized fashion\ntips, curated looks, and\nexclusive deals—all in one\nstylish app.",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    lineHeight = 26.sp,
                    fontFamily = NunitoSansFontFamily,
                    modifier = Modifier.padding(top = 400.dp)
                )
            }
        }

        Image(
            painter = painterResource(R.drawable.ic_button_arrow),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
                .size(60.dp)
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
                    top = 130.dp,
                    bottom = 130.dp,
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
                    fontSize = 36.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = RaleWayFontFamily,
                    modifier = Modifier
                        .padding(top = 175.dp)
                )
                Text(
                    text = "StyleQ is your smart fashion\nadvisor, guiding you to dress\nwith confidence every day.",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    lineHeight = 26.sp,
                    fontFamily = NunitoSansFontFamily,
                    modifier = Modifier
                        .padding(top = 400.dp)
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.ic_button_arrow),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
                .size(60.dp)
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
                fontSize = 96.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
                modifier = Modifier.padding(top = 100.dp)
            )
            Text(
                text = "Q",
                fontSize = 96.sp,
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
                .padding(top = 20.dp)
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
                modifier = Modifier
                    .width(300.dp)
                    .height(60.dp),
                contentScale = ContentScale.FillBounds
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Upload Photo",
                    fontSize = 30.sp,
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
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 375.dp),
            fontWeight = FontWeight.Normal,
            fontFamily = CrimsonFontFamily,
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 130.dp),
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
                    .width(220.dp)
                    .height(60.dp),
                contentScale = ContentScale.FillBounds
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
                bottom = 250.dp,
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
                    .padding(top = 120.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
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
                        modifier = Modifier.size(100.dp),
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
            .padding(bottom = 80.dp),
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
                bottom = 250.dp,
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
                    .padding(top = 120.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
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
                        modifier = Modifier.size(100.dp),
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
            .padding(bottom = 80.dp),
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
                fontSize = 96.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Playfair_Display,
                modifier = Modifier.padding(top = 100.dp)
            )
            Text(
                text = "Q",
                fontSize = 96.sp,
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
                    text = "Hi, People",
                    fontSize = 36.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painter = painterResource(R.drawable.hand_welcome),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
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
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 375.dp),
            fontWeight = FontWeight.Normal,
            fontFamily = CrimsonFontFamily,
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp),
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
fun Dashboard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onMyActivityClick: () -> Unit = {},
    onFavoriteClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onTrendingNowClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onColorMatcherClick: () -> Unit = {},
    onCategoriesClick: () -> Unit = {},
    onShopClick: () -> Unit = {}
) {

    val context = LocalContext.current
    val mainVerticalScrollState = rememberScrollState()
    val trendingScrollState = rememberScrollState()
    val futureScrollState = rememberScrollState()

    Scaffold(

        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 16.dp,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onHomeClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_color_matcher),
                    contentDescription = "Search",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onColorMatcherClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_categories),
                    contentDescription = "Document",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onCategoriesClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_shop),
                    contentDescription = "Shop",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onShopClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onProfileClick()
                        }
                        .size(28.dp))
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(mainVerticalScrollState)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Image(
                        painter = painterResource(R.drawable.foto_person),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(75.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                onProfileClick()
                            }
                    )

                    Button(
                        onClick = { onMyActivityClick() },
                        modifier = Modifier
                            .width(150.dp)
                            .height(40.dp),
                        contentPadding = PaddingValues(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    onMyActivityClick()
                                }
                                .background(
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color(0xFF2E5AA7),
                                            Color(0xFF14264F)
                                        )
                                    ),
                                    RoundedCornerShape(30.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "My Activity",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                onFavoriteClick()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_favorite),
                            contentDescription = "Favorite",
                            tint = Color(0xFFFF3B30),
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                onSettingsClick()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_settings),
                            contentDescription = "Settings",
                            tint = Color(0xFF5A84C7),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Hello, People !",
                        fontFamily = RaleWayFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )
                    Text(
                        text = "Discover your perfect look",
                        fontFamily = RaleWayFontFamily,
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Image(
                    painter = painterResource(R.drawable.banner_dashboard),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(175.dp)
                        .clickable {
                            Toast.makeText(
                                context,
                                "Feature Coming Soon",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                    contentScale = ContentScale.FillBounds
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Trending Now",
                        fontFamily = RaleWayFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        Text(
                            text = "See Now",
                            fontFamily = RaleWayFontFamily,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                        )

                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(
                                    color = Color(0xFF2E5AA7),
                                    shape = CircleShape
                                )
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null
                                ) {
                                    onTrendingNowClick()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = "See All",
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(trendingScrollState)
                ) {
                    Image(
                        painter = painterResource(R.drawable.trending_fashion),
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable {
                                Toast.makeText(
                                    context,
                                    "Feature Coming Soon",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                        contentScale = ContentScale.FillHeight
                    )
                }

                Text(
                    text = "Future Fashion",
                    fontFamily = RaleWayFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(futureScrollState)
                ) {
                    Image(
                        painter = painterResource(R.drawable.future_fashion),
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable {
                                Toast.makeText(
                                    context,
                                    "Feature Coming Soon",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                        contentScale = ContentScale.FillHeight
                    )
                }

                Text(
                    text = "Categories",
                    fontFamily = RaleWayFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Image(
                        painter = painterResource(R.drawable.categories_formal),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .height(210.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                onClick()
                            },
                        contentScale = ContentScale.FillHeight
                    )

                    Image(
                        painter = painterResource(R.drawable.category_casual),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .height(210.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                onClick()
                            },
                        contentScale = ContentScale.FillHeight
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Image(
                        painter = painterResource(R.drawable.categories_sporty),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .height(210.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                onClick()
                            },
                        contentScale = ContentScale.FillHeight
                    )

                    Image(
                        painter = painterResource(R.drawable.categories_retro),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .height(210.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                onClick()
                            },
                        contentScale = ContentScale.FillHeight
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Image(
                        painter = painterResource(R.drawable.categories_batik),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .height(210.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                onClick()
                            },
                        contentScale = ContentScale.FillHeight
                    )

                    Image(
                        painter = painterResource(R.drawable.categories_clean),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .height(210.dp)
                            .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onClick()
                        },
                        contentScale = ContentScale.FillHeight
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Image(
                        painter = painterResource(R.drawable.categories_muslim),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .height(210.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                onClick()
                            },
                        contentScale = ContentScale.FillHeight
                    )

                    Image(
                        painter = painterResource(R.drawable.categories_street),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .height(210.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                onClick()
                            },
                        contentScale = ContentScale.FillHeight
                    )
                }
            }
        }
    }
}

@Composable
fun TrendingNow(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit = {},
    onColorMatcherClick: () -> Unit = {},
    onCategoriesClick: () -> Unit = {},
    onShopClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    var search by remember { mutableStateOf("") }
    val context = LocalContext.current
    val mainVerticalScrollState = rememberScrollState()

    Scaffold(

        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 16.dp,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onHomeClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_color_matcher),
                    contentDescription = "Search",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onColorMatcherClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_categories),
                    contentDescription = "Document",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onCategoriesClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_shop),
                    contentDescription = "Shop",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onShopClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onProfileClick()
                        }
                        .size(28.dp))
            }
        }
    ) { innerPadding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(mainVerticalScrollState)
        ) {
            Box(
                modifier = modifier.fillMaxSize()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.bubble_trending),
                    contentDescription = "Background Bubble",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .fillMaxWidth(0.95f)
                        .height(320.dp)
                )

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 45.dp, end = 24.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Style",
                                fontSize = 56.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = Playfair_Display
                            )
                            Text(
                                text = "Q",
                                fontSize = 56.sp,
                                color = Color(0xFFFDE047),
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = Playfair_Display
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(55.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                    ) {

                        Text(
                            text = "Trending Now",
                            fontFamily = RaleWayFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = Color(0xFF1A1A1A)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(0.65f)
                                .height(46.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color(0xFF2E5AA7),
                                            Color(0xFF14264F)
                                        )
                                    ),
                                    shape = RoundedCornerShape(30.dp)
                                )
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Box(
                                modifier = Modifier.weight(1f),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                if (search.isEmpty()) {
                                    Text(
                                        text = "Search",
                                        color = Color.White.copy(alpha = 0.6f),
                                        fontSize = 14.sp,
                                        fontFamily = RaleWayFontFamily
                                    )
                                }

                                BasicTextField(
                                    value = search,
                                    onValueChange = { search = it },
                                    textStyle = TextStyle(
                                        color = Color.White,
                                        fontSize = 14.sp,
                                        fontFamily = RaleWayFontFamily
                                    ),
                                    cursorBrush = SolidColor(Color.White),
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }

                            Icon(
                                painter = painterResource(R.drawable.camera),
                                contentDescription = "Search Camera",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Feature Coming Soon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                            )
                        }

                        Spacer(modifier = Modifier.height(28.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.78f)
                                .background(
                                    color = Color(0xFFF5F5F5),
                                    shape = RoundedCornerShape(24.dp)
                                )
                                .padding(vertical = 14.dp, horizontal = 20.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                text = "Discover the latest fashion styles and\ncolor palettes that are currently popular.",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = NunitoSansFontFamily,
                                textAlign = TextAlign.Start,
                                lineHeight = 20.sp,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        Spacer(modifier = Modifier.height(36.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Image(
                                painter = painterResource(R.drawable.tren_1),
                                contentDescription = null,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(210.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Feature Coming Soon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                contentScale = ContentScale.FillHeight
                            )

                            Image(
                                painter = painterResource(R.drawable.tren_2),
                                contentDescription = null,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(210.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Feature Coming Soon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                contentScale = ContentScale.FillHeight
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Image(
                                painter = painterResource(R.drawable.tren_3),
                                contentDescription = null,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(210.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Feature Coming Soon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                contentScale = ContentScale.FillHeight
                            )

                            Image(
                                painter = painterResource(R.drawable.tren_4),
                                contentDescription = null,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(210.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Feature Coming Soon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                contentScale = ContentScale.FillHeight
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Image(
                                painter = painterResource(R.drawable.tren_5),
                                contentDescription = null,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(210.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Feature Coming Soon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                contentScale = ContentScale.FillHeight
                            )

                            Image(
                                painter = painterResource(R.drawable.tren_6),
                                contentDescription = null,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(210.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Feature Coming Soon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                contentScale = ContentScale.FillHeight
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Image(
                                painter = painterResource(R.drawable.tren_7),
                                contentDescription = null,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(210.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Feature Coming Soon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                contentScale = ContentScale.FillHeight
                            )

                            Image(
                                painter = painterResource(R.drawable.tren_8),
                                contentDescription = null,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(210.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Feature Coming Soon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                contentScale = ContentScale.FillHeight
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Categories(
    modifier: Modifier = Modifier,
    onDisplayClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onColorMatcherClick: () -> Unit = {},
    onCategoriesClick: () -> Unit = {},
    onShopClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}

) {
    var search by remember { mutableStateOf("") }
    val context = LocalContext.current
    val mainVerticalScrollState = rememberScrollState()
    val formaltopScrollState = rememberScrollState()
    val formalbottomsScrollState = rememberScrollState()
    val shoeScrollState = rememberScrollState()
    val accessoriesScrollState = rememberScrollState()

    Scaffold(

        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 16.dp,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onHomeClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_color_matcher),
                    contentDescription = "Search",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onColorMatcherClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_categories),
                    contentDescription = "Document",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onCategoriesClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_shop),
                    contentDescription = "Shop",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onShopClick()
                        }
                        .size(28.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onProfileClick()
                        }
                        .size(28.dp))
            }
        }
    ) { innerPadding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(mainVerticalScrollState)
        ) {
            Box(
                modifier = modifier.fillMaxSize()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.bubble_trending),
                    contentDescription = "Background Bubble",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .fillMaxWidth(0.95f)
                        .height(320.dp)
                )

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 45.dp, end = 24.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Style",
                                fontSize = 56.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = Playfair_Display
                            )
                            Text(
                                text = "Q",
                                fontSize = 56.sp,
                                color = Color(0xFFFDE047),
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = Playfair_Display
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(55.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                    ) {

                        Text(
                            text = "Formal",
                            fontFamily = RaleWayFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = Color(0xFF1A1A1A)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(0.65f)
                                .height(46.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color(0xFF2E5AA7),
                                            Color(0xFF14264F)
                                        )
                                    ),
                                    shape = RoundedCornerShape(30.dp)
                                )
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier.weight(1f),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                if (search.isEmpty()) {
                                    Text(
                                        text = "Search",
                                        color = Color.White.copy(alpha = 0.6f),
                                        fontSize = 14.sp,
                                        fontFamily = RaleWayFontFamily
                                    )
                                }

                                BasicTextField(
                                    value = search,
                                    onValueChange = { search = it },
                                    textStyle = TextStyle(
                                        color = Color.White,
                                        fontSize = 14.sp,
                                        fontFamily = RaleWayFontFamily
                                    ),
                                    cursorBrush = SolidColor(Color.White),
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }

                            Icon(
                                painter = painterResource(R.drawable.camera),
                                contentDescription = "Search Camera",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Feature Coming Soon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                            )
                        }

                        Spacer(modifier = Modifier.height(28.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.78f)
                                .background(
                                    color = Color(0xFFF5F5F5),
                                    shape = RoundedCornerShape(24.dp)
                                )
                                .padding(vertical = 14.dp, horizontal = 20.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                text = "Elevate your presence with timeless\nformal fashion where elegance meets\nconfidence.",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = NunitoSansFontFamily,
                                textAlign = TextAlign.Start,
                                lineHeight = 20.sp,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        Spacer(modifier = Modifier.height(30.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth(),

                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Recently viewed",
                                    fontFamily = RaleWayFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.recently_view),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .height(80.dp)
                                        .clickable {
                                            Toast.makeText(
                                                context,
                                                "Feature Coming Soon",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()
                                        },
                                    contentScale = ContentScale.FillHeight
                                )
                            }

                            Text(
                                text = "Formal Top",
                                fontFamily = RaleWayFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(formaltopScrollState),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.formal_top),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .height(140.dp)
                                        .clickable(
                                            indication = null,
                                            interactionSource = remember { MutableInteractionSource() }
                                        ) {
                                            onDisplayClick()
                                        },
                                    contentScale = ContentScale.FillHeight
                                )
                            }

                            Text(
                                text = "Formal Bottoms",
                                fontFamily = RaleWayFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(formalbottomsScrollState),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.formal_bottoms),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .height(140.dp)
                                        .clickable {
                                            Toast.makeText(
                                                context,
                                                "Feature Coming Soon",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()
                                        },
                                    contentScale = ContentScale.FillHeight
                                )
                            }

                            Text(
                                text = "Shoe",
                                fontFamily = RaleWayFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(shoeScrollState),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.shoe),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .height(140.dp)
                                        .clickable {
                                            Toast.makeText(
                                                context,
                                                "Feature Coming Soon",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()
                                        },
                                    contentScale = ContentScale.FillHeight
                                )
                            }


                            Text(
                                text = "Accessories",
                                fontFamily = RaleWayFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(accessoriesScrollState),
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.accessories),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .height(140.dp)
                                        .clickable {
                                            Toast.makeText(
                                                context,
                                                "Feature Coming Soon",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()
                                        },
                                    contentScale = ContentScale.FillHeight
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
fun DisplayFashion(
    modifier: Modifier = Modifier,
    onBuyNowClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onColorMatcherClick: () -> Unit = {},
    onCategoriesClick: () -> Unit = {},
    onShopClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {

    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 16.dp,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onHomeClick()
                        }
                )

                Icon(
                    painter = painterResource(R.drawable.ic_color_matcher),
                    contentDescription = "Color Matcher",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onColorMatcherClick()
                        }
                )

                Icon(
                    painter = painterResource(R.drawable.ic_categories),
                    contentDescription = "Categories",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { onCategoriesClick() }
                )

                Icon(
                    painter = painterResource(R.drawable.ic_shop),
                    contentDescription = "Shop",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onShopClick()
                        }
                )

                Icon(
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                        { onProfileClick() }
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                Image(
                    painter = painterResource(R.drawable.display_fashion),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(460.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFF5F5F5),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 20.dp, vertical = 16.dp)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("Based on your body measurements, size ")
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xFF1F51FF),
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("M")
                            }
                            append("\nis the best fit for maximum comfort.")
                        },
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = RaleWayFontFamily,
                        lineHeight = 22.sp,
                        color = Color.Black
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Others",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = RaleWayFontFamily,
                        color = Color.Black
                    )

                    Box(
                        modifier = Modifier
                            .background(Color(0xFFF5F5F5), RoundedCornerShape(6.dp))
                            .padding(horizontal = 14.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "Beige",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.DarkGray
                        )
                    }

                    Box(
                        modifier = Modifier
                            .background(Color(0xFFF5F5F5), RoundedCornerShape(6.dp))
                            .padding(horizontal = 18.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "M",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.DarkGray
                        )
                    }
                }

                Image(
                    painter = painterResource(R.drawable.other_fashion),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(0.68f)
                        .wrapContentHeight(),
                    contentScale = ContentScale.FillWidth
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { onBuyNowClick() },
                    modifier = Modifier
                        .width(145.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1F51FF)
                    )
                ) {
                    Text(
                        text = "Buy now",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = RaleWayFontFamily
                    )
                }
            }
        }
    }
}

@Composable
fun PartnerShop(
    modifier: Modifier = Modifier,
    onClaimVoucherClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onColorMatcherClick: () -> Unit = {},
    onCategoriesClick: () -> Unit = {},
    onShopClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    val context = LocalContext.current

    val shopList = listOf(
        PartnerShopData(
            logoRes = R.drawable.logo_3second,
            name = "3 Second",
            address = "Jl. Malioboro No. 15, Yogyakarta, DIY 55213",
            price = "Rp 120.000",
            rating = "4.9"
        ),
        PartnerShopData(
            logoRes = R.drawable.logo_erigo,
            name = "Erigo",
            address = "Jl. Kaliurang No. 12, Yogyakarta, DIY 55213",
            price = "Rp 150.000",
            rating = "4.8"
        ),
        PartnerShopData(
            logoRes = R.drawable.logo_dobujack,
            name = "Dobujack",
            address = "Jl. Gejayan No. 88, Yogyakarta, DIY 55213",
            price = "Rp 99.000",
            rating = "4.8"
        )
    )

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 16.dp,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { onHomeClick() }
                )

                Icon(
                    painter = painterResource(R.drawable.ic_color_matcher),
                    contentDescription = "Color Matcher",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { onColorMatcherClick() }
                )

                Icon(
                    painter = painterResource(R.drawable.ic_categories),
                    contentDescription = "Categories",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { onCategoriesClick() }
                )

                Icon(
                    painter = painterResource(R.drawable.ic_shop),
                    contentDescription = "Shop",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onShopClick()
                        }
                )

                Icon(
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { onProfileClick() }
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Partner Shop",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A)
                )

                Button(
                    onClick = { onClaimVoucherClick() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE8EFFF)
                    ),
                    shape = RoundedCornerShape(50.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                    modifier = Modifier.height(38.dp)
                ) {
                    Text(
                        text = "Claim Vouchers",
                        color = Color(0xFF1F51FF),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(18.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 14.dp)
            ) {
                Text(
                    text = "Explore exclusive collections and special offers from our trusted fashion partners. Shop with confidence and style.",
                    fontSize = 13.sp,
                    color = Color(0xFF4A4A4A),
                    lineHeight = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            shopList.forEach { shop ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.width(110.dp)
                        ) {
                            Image(
                                painter = painterResource(shop.logoRes),
                                contentDescription = shop.name,
                                modifier = Modifier
                                    .size(110.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context, "${shop.name}: Feature Coming Soon",
                                            Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFF5F5F5)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = shop.name,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black,
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .padding(start = 4.dp)
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            Text(
                                text = shop.sizes,
                                fontSize = 12.sp,
                                color = Color(0xFF1F51FF),
                                fontWeight = FontWeight.SemiBold
                            )

                            Row(verticalAlignment = Alignment.Top) {
                                Text(text = "📍 ", fontSize = 11.sp)
                                Text(
                                    text = shop.address,
                                    fontSize = 11.sp,
                                    color = Color.DarkGray,
                                    lineHeight = 14.sp
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = "🔗 ", fontSize = 11.sp)
                                Text(text = "Shoppe : ", fontSize = 11.sp, color = Color.Black)
                                Text(
                                    text = shop.shopeeUrl,
                                    fontSize = 11.sp,
                                    color = Color(0xFF1F51FF),
                                    maxLines = 1
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = "🔗 ", fontSize = 11.sp)
                                Text(text = "Tokopedia : ", fontSize = 11.sp, color = Color.Black)
                                Text(
                                    text = shop.tokopediaUrl,
                                    fontSize = 11.sp,
                                    color = Color(0xFF1F51FF),
                                    maxLines = 1
                                )
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = shop.price,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )

                                Row(
                                    modifier = Modifier
                                        .background(Color(0xFFE8EFFF), RoundedCornerShape(6.dp))
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text(text = "★", color = Color(0xFF1F51FF), fontSize = 12.sp)
                                    Text(
                                        text = shop.rating,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyVoucher(
    modifier: Modifier = Modifier,
    onSettingsClick: () -> Unit,
    onHomeClick: () -> Unit = {},
    onColorMatcherClick: () -> Unit = {},
    onCategoriesClick: () -> Unit = {},
    onShopClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
) {

    val context = LocalContext.current
    var isProgressTabActive by remember { mutableStateOf(false) }

    val activeRewardsList = remember {
        listOf(
            VoucherItem(
                "First StyleQ Purchase!",
                "20% off for your next order",
                "Valid Until 5.16.20"
            ),
            VoucherItem(
                "Student Special: Off with Campus ID",
                "15% off for your next purchase",
                "Valid Until 6.20.20"
            ),
            VoucherItem(
                "Gift From Customer Care",
                "15% off for your next purchase",
                "Valid Until 6.20.20"
            )
        )
    }

    val progressList = remember {
        listOf(
            VoucherItem("Rp50k off Orders 300k+", "off your next purchase", "Valid Until 6.20.20"),
            VoucherItem(
                "Gift From Customer Care",
                "15% off for your next purchase",
                "Valid Until 6.20.20"
            ),
            VoucherItem(
                "Buy 1 Get 50% Off Next",
                "50% off your next purchase",
                "Valid Until 6.20.20"
            ),
            VoucherItem(
                "Gift From Customer Care",
                "15% off for your next purchase",
                "Valid Until 6.20.20"
            ),
            VoucherItem(
                "Gift From Customer Care",
                "15% off for your next purchase",
                "Valid Until 6.20.20"
            )
        )
    }

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 16.dp,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(vertical = 16.dp, horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }) { onHomeClick() })
                Icon(
                    painter = painterResource(R.drawable.ic_color_matcher),
                    contentDescription = "Color Matcher",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }) { onColorMatcherClick() })
                Icon(
                    painter = painterResource(R.drawable.ic_categories),
                    contentDescription = "Categories",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }) { onCategoriesClick() })
                Icon(
                    painter = painterResource(R.drawable.ic_shop),
                    contentDescription = "Shop",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onShopClick()
                        }
                )
                Icon(
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }) { onProfileClick() })
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.foto_person),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Vouchers",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .border(1.dp, Color(0xFFE0E0E0), CircleShape)
                        .clip(CircleShape)
                        .clickable { onSettingsClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_settings),
                        contentDescription = "Settings",
                        modifier = Modifier.size(22.dp),
                        tint = Color(0xFF2E52F8)
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp)
                        .background(
                            color = if (!isProgressTabActive) Color(0xFFE8EEFF) else Color(
                                0xFFF5F5F5
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isProgressTabActive = false },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Active Rewards",
                        color = if (!isProgressTabActive) Color(0xFF2E52F8) else Color.Gray,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp)
                        .background(
                            color = if (isProgressTabActive) Color(0xFFE8EEFF) else Color(0xFFF5F5F5),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isProgressTabActive = true },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Progress",
                        color = if (isProgressTabActive) Color(0xFF2E52F8) else Color.Gray,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
            }

            val currentList = if (!isProgressTabActive) activeRewardsList else progressList

            currentList.forEach { voucher ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(135.dp)
                        .background(Color.White, VoucherItem.TicketShape)
                        .border(1.5.dp, Color(0xFF2E52F8), VoucherItem.TicketShape)
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val lineY = size.height * 0.28f

                        drawLine(
                            color = Color(0xFF2E52F8),
                            start = Offset(x = 0f, y = lineY), // Dimulai dari ujung kiri bingkai
                            end = Offset(x = size.width, y = lineY), // Sampai ujung kanan bingkai
                            strokeWidth = 1.5.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 12f), 0f)
                        )
                    }

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.32f),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Voucher",
                                color = Color(0xFF2E52F8),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = voucher.validity,
                                color = Color.Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.68f)
                                .padding(top = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)) {
                                Text(
                                    text = voucher.title,
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = voucher.subtitle,
                                    color = Color.Gray,
                                    fontSize = 13.sp,
                                    maxLines = 1
                                )
                            }

                            Button(
                                onClick = {
                                    Toast.makeText(
                                        context,
                                        "Feature Coming Soon",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF2E52F8),
                                    contentColor = Color.White
                                ),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
                                modifier = Modifier.wrapContentSize()
                            ) {
                                Text(
                                    text = "Collected",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
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
                    .height(450.dp)
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
                        .padding(top = 80.dp),
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
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    onBackClick()
                                },
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
                            painter = painterResource(R.drawable.ic_profile),
                            contentDescription = null,
                            modifier = Modifier.size(26.dp)
                        )
                    },
                    colors = solidTextFieldColors(),
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
                    colors = solidTextFieldColors(),
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
                    colors = solidTextFieldColors(),
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
                    colors = solidTextFieldColors(),
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
                            painter = painterResource(R.drawable.ic_profile),
                            contentDescription = null,
                            modifier = Modifier.size(26.dp)
                        )
                    },
                    colors = solidTextFieldColors(),
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
                    colors = solidTextFieldColors(),
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

@Composable
fun SolidTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    TextField(
        value = value,
        onValueChange = onValueChange,

        placeholder = {
            Text(text = placeholder)
        },

        singleLine = true,

        keyboardOptions = keyboardOptions,

        shape = RoundedCornerShape(100.dp),

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedPlaceholderColor = Color.Gray,
            unfocusedPlaceholderColor = Color.Gray
        ),

        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}

@Composable
fun Settings(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onApplyClick: () -> Unit = {}
) {

    val context = LocalContext.current
    var searchSettings by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement
                    .SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onBackClick()
                        },
                )

                SolidTextField(
                    value = searchSettings,
                    onValueChange = { searchSettings = it },
                    placeholder = "Search Settings",
                    modifier = Modifier.width(280.dp)
                )

                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = null,
                    modifier = Modifier
                        .size(34.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onHomeClick()
                        },
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Toast.makeText(
                        context,
                        "Feature Coming Soon",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .padding(start = 40.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.ic_account),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(18.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                Text(
                    text = "Account",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                    color = Color(0xFF174B96)
                )

                Text(
                    text = "Edit profile, change password, verify email",
                    fontSize = 13.sp,
                    fontFamily = InterFontFamily,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Toast.makeText(
                        context,
                        "Feature Coming Soon",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .padding(start = 40.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.ic_preference),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(18.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                Text(
                    text = "Preference",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                    color = Color(0xFF174B96)
                )

                Text(
                    text = "Language, theme, units of measurement",
                    fontSize = 13.sp,
                    fontFamily = InterFontFamily,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Toast.makeText(
                        context,
                        "Feature Coming Soon",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .padding(start = 40.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.ic_privacy),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(18.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                Text(
                    text = "Privacy",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                    color = Color(0xFF174B96)
                )

                Text(
                    text = "Visibility settings, Location permissions",
                    fontSize = 13.sp,
                    fontFamily = InterFontFamily,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Toast.makeText(
                        context,
                        "Feature Coming Soon",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .padding(start = 40.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.ic_notification),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(18.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                Text(
                    text = "Notification",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                    color = Color(0xFF174B96)
                )

                Text(
                    text = "Push notification, notification sound",
                    fontSize = 13.sp,
                    fontFamily = InterFontFamily,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Toast.makeText(
                        context,
                        "Feature Coming Soon",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .padding(start = 40.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.ic_other),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(18.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                Text(
                    text = "Other",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily,
                    color = Color(0xFF174B96)
                )

                Text(
                    text = "Help center, privacy policy, delete account",
                    fontSize = 13.sp,
                    fontFamily = InterFontFamily,
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

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
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        onApplyClick()
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
                    text = "Apply",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun Favorite(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onHomeClick: () -> Unit = {}
) {
    var searchFavorite by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement
                    .SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onBackClick()
                        },
                )

                SolidTextField(
                    value = searchFavorite,
                    onValueChange = { searchFavorite = it },
                    placeholder = "Search Favorite",
                    modifier = Modifier.width(280.dp)
                )

                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onHomeClick()
                        },
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 200.dp,
                start = 16.dp,
                end = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.favorite_1),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(210.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "Feature Coming Soon",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                contentScale = ContentScale.FillBounds
            )

            Image(
                painter = painterResource(R.drawable.favorite_2),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(210.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "Feature Coming Soon",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                contentScale = ContentScale.FillBounds
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.favorite_3),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(210.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "Feature Coming Soon",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                contentScale = ContentScale.FillBounds
            )

            Image(
                painter = painterResource(R.drawable.favorite_4),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(210.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "Feature Coming Soon",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                contentScale = ContentScale.FillBounds
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.favorite_5),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(210.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "Feature Coming Soon",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                contentScale = ContentScale.FillBounds
            )

            Image(
                painter = painterResource(R.drawable.favorite_6),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(210.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "Feature Coming Soon",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
fun MyActivity(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit
) {
    var searchHistory by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement
                    .SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SolidTextField(
                    value = searchHistory,
                    onValueChange = { searchHistory = it },
                    placeholder = "Search History",
                    modifier = Modifier.width(280.dp)
                )

                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onHomeClick()
                        },
                )
            }
        }
    }
}

@Composable
fun ColorMatching(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit = {},
    onSaveLookClick: () -> Unit = {},
    onShopClick: () -> Unit = {}
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 120.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Color Matcher",
                    fontSize = 28.sp,
                    fontFamily = RaleWayFontFamily,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color(0xFFF2F2F2),
                            RoundedCornerShape(22.dp)
                        )
                        .padding(horizontal = 20.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = "Instantly find the perfect color\ncombinations to match your outfit and\nexpress your style.",
                        fontSize = 14.sp,
                        fontFamily = NunitoSansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 20.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(18.dp))

            Icon(
                painter = painterResource(R.drawable.ic_home),
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        onHomeClick()
                    },
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(R.drawable.fashion_matcher),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .height(350.dp),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Bottom Color Recommendations",
            fontSize = 16.sp,
            fontFamily = RaleWayFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 26.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.drawable.beige_matcher),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(R.drawable.hijauzaitun_matcher),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(R.drawable.tan_matcher),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Button(
                onClick = { onSaveLookClick() },
                modifier = Modifier
                    .weight(1f)
                    .height(58.dp),
                shape = RoundedCornerShape(50.dp),
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFF2E5AA7),
                                    Color(0xFF14264F)
                                )
                            ),
                            shape = RoundedCornerShape(50.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Save Look",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                onClick = { onShopClick() },
                modifier = Modifier
                    .weight(1f)
                    .height(58.dp),
                shape = RoundedCornerShape(50.dp),
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFF2E5AA7),
                                    Color(0xFF14264F)
                                )
                            ),
                            shape = RoundedCornerShape(50.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Shop",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
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
        ResponsiveScale {
            StyleQApp()
        }
    }
}
