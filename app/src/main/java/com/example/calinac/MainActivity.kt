package com.example.calinac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calinac.ui.Account
import com.example.calinac.ui.Adopt
import com.example.calinac.ui.Homepage
import com.example.calinac.ui.theme.CaliNacTheme
import com.example.calinac.ui.component.Header
import com.example.calinac.ui.component.Footer

enum class CaliNacScreen() {
    Home,
    Account,
    Adopt,
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
        topBar = { Header(
            goToHome = { navController.navigate( CaliNacScreen.Home.name ) },
            goToAccount = { navController.navigate(CaliNacScreen.Account.name) },
        )},
        bottomBar = { Footer() }
    ) {innerPadding ->

        NavHost(
            navController = navController,
            startDestination = CaliNacScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = CaliNacScreen.Home.name) {
                Homepage(
                    goToAdopt = {navController.navigate(CaliNacScreen.Adopt.name)}
                )
            }
            composable(route = CaliNacScreen.Account.name){
                Account()
            }
            composable(route = CaliNacScreen.Adopt.name){
                Adopt()
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    CaliNacTheme {
        Header({})
    }
}



@Preview(showBackground = true)
@Composable
fun FooterPreview() {
    CaliNacTheme {
        Footer()
    }
}