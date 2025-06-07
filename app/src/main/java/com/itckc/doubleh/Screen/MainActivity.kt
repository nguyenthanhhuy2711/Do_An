package com.itckc.doubleh.Screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.itckc.doubleh.Navigation.NavGraph
import com.itckc.doubleh.Screen.WelcomeScreen
import com.itckc.doubleh.ui.theme.DoubleHTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        
        lateinit var navController: NavHostController
        super.onCreate(savedInstanceState)
        setContent {
            DoubleHTheme {
                navController= rememberNavController()
                NavGraph(navController=navController)
            }
        }
    }
}



