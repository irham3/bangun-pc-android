package com.kaizen.bangunpc.ui.navigation

sealed class Screen (val route: String){
    object  Home : Screen("home")
    object  Catalog : Screen("catalog")
    object  About : Screen("about")
    object  Favorite : Screen("favorite")
    object DetailProduct : Screen("home/{productId}") {
        fun createRoute(productId: Int) = "home/$productId"
    }
}