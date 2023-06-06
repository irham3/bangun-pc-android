package com.kaizen.bangunpc.ui.screen.catalog

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.data.source.UiState
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.ProductVerticalGrid
import com.kaizen.bangunpc.ui.components.ScreenTitleText
import com.kaizen.bangunpc.ui.theme.AppTheme

@Composable
fun CatalogScreen(
    navigateToDetailProduct: (Int) -> Unit = {},
    catalogViewModel: CatalogViewModel = hiltViewModel()
) {
    val products by catalogViewModel.productsState.collectAsState(initial = UiState.Loading)
    val context = LocalContext.current
    Column {
        CustomTopBar(
            content = { ScreenTitleText(title = stringResource(R.string.catalog)) }
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
                    catalogViewModel.getAllProducts()
                }
                is UiState.Success -> {
                    ProductVerticalGrid(uiState.data, navigateToDetailProduct = navigateToDetailProduct)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun ProductVerticalGridPreview() {
    AppTheme {
        Scaffold {
            CatalogScreen()
        }
    }
}