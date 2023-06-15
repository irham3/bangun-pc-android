package com.kaizen.bangunpc.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.ui.common.UiState
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.GXCompCarousel
import com.kaizen.bangunpc.ui.components.ProductHighlight
import com.kaizen.bangunpc.ui.components.layouts.ProductHorizontalList
import com.kaizen.bangunpc.ui.theme.Orange

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigateToAbout: () -> Unit = {},
    navigateToDetailProduct: (Int) -> Unit = {},
) {
    val intelPCs by homeViewModel.intelPCState.collectAsState(initial = UiState.Loading)
    val amdPCs by homeViewModel.amdPCState.collectAsState(initial = UiState.Loading)
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Orange,
            darkIcons = false
        )
    }

    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        CustomTopBar(
            height = 100.dp,
            content = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {
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
                            .size(40.dp)
                            .clickable {
                                navigateToAbout()
                            }
                    )
                }
            })
        val isShimmer = remember { mutableStateOf(true) }
        GXCompCarousel(
            isShimmer = isShimmer.value,
            onAsyncImageSuccess = {isShimmer.value = false}
        )
        intelPCs.let { uiState ->
            when (uiState) {
                UiState.Loading -> {
                    homeViewModel.getAllIntelPCs()
                }
                is UiState.Error -> {}
                is UiState.Success -> {
                    ProductHighlight(
                        title = stringResource(R.string.section_rakitan_intel),
                        content = {
                            ProductHorizontalList(
                                uiState.data,
                                navigateToDetailProduct = navigateToDetailProduct
                            )
                        }
                    )
                }
            }
        }

        amdPCs.let { uiState ->
            when (uiState) {
                UiState.Loading -> {
                    homeViewModel.getAllAMDPCs()
                }

                is UiState.Error -> {}
                is UiState.Success -> {
                    ProductHighlight(
                        title = stringResource(R.string.section_rakitan_amd),
                        content = {
                            ProductHorizontalList(
                                uiState.data,
                                navigateToDetailProduct = navigateToDetailProduct
                            )
                        }
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun HomeScreenPreview() {
//    AppTheme {
//        Scaffold {innerPadding ->
//            HomeScreen(
//                modifier = Modifier.padding(innerPadding),
//            )
//        }
//    }
//}