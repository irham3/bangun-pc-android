package com.kaizen.bangunpc.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.ui.theme.Orange

@Composable
fun IndicatorDot(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color)
    )
}

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = Orange,
    unSelectedColor: Color = Color.Gray,
    dotSize: Dp
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        items(totalDots) { index ->
            IndicatorDot(
                color = if (index == selectedIndex) selectedColor else unSelectedColor,
                size = dotSize
            )

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(
    modifier: Modifier = Modifier,
    pagerState: PagerState = remember { PagerState() },
    itemsCount: Int,
    itemContent: @Composable (index: Int) -> Unit,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        HorizontalPager(pageCount = itemsCount, state = pagerState) { page ->
            itemContent(page)
        }
        Surface(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter),
            shape = CircleShape,
            color = Color.Black.copy(alpha = 0.5f)
        ) {
            DotsIndicator(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                totalDots = itemsCount,
                selectedIndex = if (isDragged) pagerState.currentPage else pagerState.targetPage,
                dotSize = 8.dp
            )
        }
    }
}

val carouselItems = listOf(
    Pair("https://images.tokopedia.net/img/cache/1200/BgtCLw/2022/11/3/b00947ff-54f2-4536-beaf-62d1d34c15de.jpg", "https://tokopedia.link/epwE0EYsvAb"),
    Pair("https://images.tokopedia.net/img/cache/1200/BgtCLw/2023/5/24/aa7edca8-b28b-487b-8a62-957c872693f2.jpg", "https://tokopedia.link/NcncH1NtvAb"),
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GXCompCarousel(
    isShimmer: Boolean,
    onAsyncImageSuccess: () -> Unit
) {
    val ctx = LocalContext.current
    Card(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Carousel(
            itemsCount = carouselItems.size,
            itemContent = { index ->
                AsyncImage(
                    model = carouselItems[index].first,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    onSuccess = { onAsyncImageSuccess() },
                    modifier = Modifier
                        .background(shimmerBrush(targetValue = 1300f, showShimmer = isShimmer))
                        .height(160.dp)
                        .clickable {
                            val urlIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(carouselItems[index].second)
                            )
                            ctx.startActivity(urlIntent)
                        },
                )
            }
        )
    }
}

@Preview
@Composable
fun CarouselPreview() {
    AppTheme {
        val showShimmer = remember { mutableStateOf(true) }
        GXCompCarousel(
            isShimmer = showShimmer.value,
            onAsyncImageSuccess = { showShimmer.value = false }
        )
    }
}