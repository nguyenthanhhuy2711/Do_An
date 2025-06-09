package com.itckc.doubleh.Navigation

sealed class Screen (val route:String){
    object Welcome:Screen("welcome_screen")
    object SignIn:Screen("sign_in_screen")
    object SignUp:Screen("sign_out_screen")
    object Home:Screen("home_screen")
    object Cart:Screen("cart_screen" )
    object CheckOut:Screen("checkout_screen")
    object EditProfile:Screen("edit_profile_screen")
    object Favorite:Screen("favorite_screen")
    object Order: Screen("order_screen")
    object ProductDetail:Screen("product_detail_screen")
    object Profile:Screen("profile_screen")
    object Search:Screen("search_screen")

}