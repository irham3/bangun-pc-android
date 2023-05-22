package com.kaizen.bangunpc.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.data.dummyProducts
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.DummyCarousel
import com.kaizen.bangunpc.ui.components.ProductHighlight
import com.kaizen.bangunpc.ui.components.ProductRow
import com.kaizen.bangunpc.ui.theme.AppTheme
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToAbout: () -> Unit = {},
    navigateToDetailProduct: (Long) -> Unit = {}
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        CustomTopBar(
            height = 100.dp,
            content = {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ){
                    Column {
                        Text(
                            text = stringResource(R.string.greeting),
                            color = Color.White,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.h4.copy(
                                fontWeight = FontWeight.ExtraBold
                            ),
                        )
                        Text(
                            text = stringResource(R.string.greeting_description),
                            color = Color.White,
                            style = MaterialTheme.typography.subtitle1,
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.my_photo),
                        contentDescription = stringResource(R.string.about_page),
                        modifier = Modifier
                            .clip(CircleShape)
                            .shadow(20.dp, CircleShape)
                            .size(47.dp)
                            .clickable {
                                navigateToAbout()
                            }
                    )
            }
        })
        DummyCarousel()
        ProductHighlight(
            title = stringResource(R.string.section_rakitan_intel),
            content = { ProductRow(dummyProducts.subList(0, 9),
                navigateToDetailProduct = navigateToDetailProduct) }
        )
        ProductHighlight(
            title = stringResource(R.string.section_rakitan_amd),
            content = { ProductRow(
                dummyProducts.subList(10, 14),
                navigateToDetailProduct = navigateToDetailProduct) }
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    AppTheme {
        Scaffold {innerPadding ->
            HomeScreen(
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}