package com.example.calinac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calinac.ui.Homepage
import com.example.calinac.ui.theme.CaliNacTheme
import com.example.calinac.ui.component.Header
import com.example.calinac.ui.component.Footer

enum class CaliNacScreen() {
    Home,
    Account,
    AnimalsList
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaliNacTheme {
                // A surface container using the 'background' color from the theme
                CaliNacApp()
            }
        }
    }
}

@Composable
fun CaliNacApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold(
        topBar = { Header() },
        bottomBar = { Footer() }
    ) {innerPadding ->

        NavHost(
            navController = navController,
            startDestination = CaliNacScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = CaliNacScreen.Home.name) {
                Homepage()

            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    CaliNacTheme {
        Header()
    }
}



@Preview(showBackground = true)
@Composable
fun FooterPreview() {
    CaliNacTheme {
        Footer()
    }
}