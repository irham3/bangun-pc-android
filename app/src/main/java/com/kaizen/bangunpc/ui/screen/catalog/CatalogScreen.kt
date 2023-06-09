package com.kaizen.bangunpc.ui.screen.catalog

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.ui.common.UiState
import com.kaizen.bangunpc.ui.components.CircleButton
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.layouts.ProductVerticalGrid
import com.kaizen.bangunpc.ui.components.SearchBar
import com.kaizen.bangunpc.ui.components.TextChipGroup
import com.kaizen.bangunpc.ui.theme.Orange
import kotlinx.coroutines.launch

@Composable
fun CatalogScreen(
    modifier: Modifier = Modifier,
    navigateToDetailProduct: (Int) -> Unit = {},
    viewModel: CatalogViewModel = hiltViewModel()
) {
    // Change status bar color
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Orange,
            darkIcons = false
        )
    }
    val keyword by viewModel.query
    val products by viewModel.productsState.collectAsState(initial = UiState.Loading)
    val context = LocalContext.current

    Box (modifier = modifier){
        val scope = rememberCoroutineScope()
        val gridState = rememberLazyGridState()
        val showSttButton: Boolean by remember {
            derivedStateOf { gridState.firstVisibleItemIndex > 0 }
        }

        Column {
            CustomTopBar(
                padding = 0.dp,
                content = {
                    SearchBar(
                        query = keyword,
                        onQueryChange = viewModel::search
                    )

                }
            )
            val categoryList = listOf(
                "Lihat Semua",
                "PC Intel",
                "PC AMD",
                "Motherboard",
                "Storage",
                "CPU",
                "GPU",
                "Casing",
                "Memory",
                "Power Supply"
            )
            TextChipGroup(
                chipList = categoryList,
                onSelected = viewModel::getProductsByCategory

            )
            products.let { uiState ->
                when(uiState) {
                    is UiState.Error -> {
                        Toast.makeText(
                            context,
                            uiState.errorMessage,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    UiState.Loading -> {
                        viewModel.getAllProducts()
                    }
                    is UiState.Success -> {
                        ProductVerticalGrid(
                            state = gridState,
                            listProduct = uiState.data,
                            navigateToDetailProduct = navigateToDetailProduct
                        )
                    }
                }
            }
        }

        AnimatedVisibility(
            visible = showSttButton,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier
                .padding(bottom = 20.dp, end = 20.dp)
                .align(Alignment.BottomEnd)
        ) {
            CircleButton(
                onClick = {
                    scope.launch {
                        gridState.animateScrollToItem(index = 0)
                    }
                },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = stringResource(R.string.scroll_to_top),
                    )
                },
                buttonColors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black.copy(
                        alpha = 0.7F
                    ),
                    contentColor = MaterialTheme.colors.primary
                )
            )
        }
    }
}