package com.example.firstkotlinapp_getallnurse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstkotlinapp_getallnurse.ui.theme.FirstKotlinAppGetAllNurseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    FirstKotlinAppGetAllNurseTheme {
        MyApp()
    }
}

@Composable
fun MyApp() {
    var nextScreen by rememberSaveable { mutableStateOf("Home") }

    // Layout principal
    Column(
        modifier = Modifier
            .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        // Barra de navegación fija
        BottomNavigationBar(
            currentScreen = nextScreen,
            onScreenSelected = { selectedScreen -> nextScreen = selectedScreen }
        )
    }
}


@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit, modifier: Modifier = Modifier, message: String
) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onContinueClicked) {
            Text(message)
        }
    }
}

@Composable
fun BottomNavigationBar(
    currentScreen: String,
    onScreenSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { onScreenSelected("Home") },
            enabled = currentScreen != "Home"
        ) {
            Text("Home")
        }
        Button(
            onClick = { onScreenSelected("List Nurse") },
            enabled = currentScreen != "List Nurse"
        ) {
            Text("List Nurse")
        }

    }
    when (currentScreen) {
        "List Nurse" -> ListNurseScreen()
    }
}