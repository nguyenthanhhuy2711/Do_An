package com.itckc.doubleh.Navigation

sealed class Screen (val route:String){
    object Welcome:Screen(route = "welcome_screen")
    object SignIn:Screen(route = "signin_screen")
    object SignUp:Screen(route = "signout_screen")
    object Home:Screen(route="home_screen")
}