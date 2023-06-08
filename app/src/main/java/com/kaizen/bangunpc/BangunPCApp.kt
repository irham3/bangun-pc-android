package com.kaizen.bangunpc

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kaizen.bangunpc.ui.components.BottomNavbarMain
import com.kaizen.bangunpc.ui.navigation.Screen
import com.kaizen.bangunpc.ui.screen.catalog.CatalogScreen
import com.kaizen.bangunpc.ui.screen.home.HomeScreen
import com.kaizen.bangunpc.ui.screen.profile.ProfileScreen
import com.kaizen.bangunpc.ui.screen.detail.DetailProductScreen
import com.kaizen.bangunpc.ui.screen.wishlist.WishlistScreen
import com.kaizen.bangunpc.ui.theme.AppTheme

@Composable
fun BangunPCApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailProduct.route)
                BottomNavbarMain(navController)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToAbout = {
                        navController.navigate(Screen.Profile.route)
                    },
                    navigateToDetailProduct = { productId ->
                        navController.navigate(Screen.DetailProduct.createRoute(productId))
                    }
                )
            }
            composable(Screen.Catalog.route) {
                CatalogScreen(
                    navigateToDetailProduct = { productId ->
                        navController.navigate(Screen.DetailProduct.createRoute(productId))
                    }
                )
            }
            composable(Screen.Wishlist.route) {
                WishlistScreen(
                    navigateToDetailProduct = { productId ->
                        navController.navigate(Screen.DetailProduct.createRoute(productId))
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.DetailProduct.route,
                arguments = listOf(navArgument("productId") {type = NavType.IntType})
            ) {
                val id = it.arguments?.getInt("productId") ?: -1
                DetailProductScreen(
                    productId = id,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun BangunPCAppPreview() {
    AppTheme {
        BangunPCApp()
    }
}