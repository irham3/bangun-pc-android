package com.kaizen.bangunpc.ui.screen.catalog

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.data.dummyProducts
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.ProductVerticalGrid
import com.kaizen.bangunpc.ui.components.ScreenTitleText
import com.kaizen.bangunpc.ui.theme.AppTheme

@Composable
fun CatalogScreen(
    navigateToDetailProduct: (Int) -> Unit = {}
) {
    Column {
        CustomTopBar(
            content = { ScreenTitleText(title = stringResource(R.string.catalog)) }
        )
        ProductVerticalGrid(dummyProducts, navigateToDetailProduct = navigateToDetailProduct)
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