package com.kaizen.bangunpc.ui.navigation

sealed class Screen (val route: String){
    object  Home : Screen("home")
    object  Catalog : Screen("catalog")
    object  Profile : Screen("profile")
    object  Wishlist : Screen("wishlist")
    object DetailProduct : Screen("home/{productId}") {
        fun createRoute(productId: Int) = "home/$productId"
    }
}