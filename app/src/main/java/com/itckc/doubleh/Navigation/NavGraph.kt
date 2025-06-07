package com.itckc.doubleh.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.itckc.doubleh.Screen.HomeScreen

import com.itckc.doubleh.Screen.SignInScreen
import com.itckc.doubleh.Screen.SignUpScreen
import com.itckc.doubleh.Screen.WelcomeScreen

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(
            route = Screen.Welcome.route
        ){ WelcomeScreen(navController) }
        composable(
            route = Screen.SignIn.route
        ){ SignInScreen(navController) }
        composable(
            route = Screen.SignUp.route
        ){ SignUpScreen(navController) }
        composable(
            route = Screen.Home.route
        ){ HomeScreen(navController) }
    }
}