package com.kaizen.bangunpc.ui.navigation

sealed class Screen (val route: String){
    object  Home : Screen("home")
    object DetailProduct : Screen("home/{productId}") {
        fun createRoute(productId: Int) = "home/$productId"
    }
    object  Catalog : Screen("catalog")
    object  Wishlist : Screen("wishlist")
    object  Profile : Screen("profile")
}