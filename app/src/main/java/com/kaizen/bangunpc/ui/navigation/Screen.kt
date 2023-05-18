package com.kaizen.bangunpc.ui.navigation

sealed class Screen (val route: String){
    object  Home : Screen("home")
    object  Service : Screen("service")
    object  Catalog : Screen("catalog")
    object  Profile : Screen("profile")
    object DetailComponent : Screen("home/{componentId}") {
        fun createRoute(componentId: Long) = "home/$componentId"
    }
}