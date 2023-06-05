package com.kaizen.bangunpc

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kaizen.bangunpc.ui.components.BottomBar
import com.kaizen.bangunpc.ui.navigation.NavigationItem
import com.kaizen.bangunpc.ui.navigation.Screen
import com.kaizen.bangunpc.ui.screen.catalog.CatalogScreen
import com.kaizen.bangunpc.ui.screen.home.HomeScreen
import com.kaizen.bangunpc.ui.screen.about.AboutScreen
import com.kaizen.bangunpc.ui.screen.detail.DetailProductScreen
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
                BottomBar(navController)
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
                        navController.navigate(Screen.About.route)
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
            composable(Screen.About.route) {
                AboutScreen()
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