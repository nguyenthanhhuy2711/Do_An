package com.itckc.doubleh.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.itckc.doubleh.Screen.CartScreen
import com.itckc.doubleh.Screen.CheckoutScreen
import com.itckc.doubleh.Screen.EditProfileScreen
import com.itckc.doubleh.Screen.FavoriteScreen
import com.itckc.doubleh.Screen.HomeScreen
import com.itckc.doubleh.Screen.OrderScreen
import com.itckc.doubleh.Screen.ProductDetailScreen
import com.itckc.doubleh.Screen.ProfileScreen
import com.itckc.doubleh.Screen.SearchScreen

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
        composable(
            route = Screen.Cart.route
        ){ CartScreen(navController) }
        composable(
            route = Screen.CheckOut.route
        ){ CheckoutScreen(navController) }
        composable(
            route = Screen.EditProfile.route
        ){ EditProfileScreen(navController) }
        composable(
            route = Screen.Favorite.route
        ){ FavoriteScreen(navController) }
        composable(
            route = Screen.Order.route
        ){ OrderScreen(navController) }
        composable(
            route = Screen.ProductDetail.route
        ){ ProductDetailScreen(navController) }
        composable(
            route = Screen.Profile.route
        ){ ProfileScreen(navController) }
        composable(
            route = Screen.Search.route
        ){ SearchScreen(navController) }
    }
}