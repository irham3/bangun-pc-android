package com.kaizen.bangunpc.ui.screen.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.ScreenTitleText
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.ui.theme.Orange
import com.kaizen.bangunpc.utils.toRupiahFormat

@Composable
fun DetailProductScreen(
    productId: Int,
    viewModel: DetailViewModel = hiltViewModel(),
    navigateBack: () -> Unit = {}
) {
    viewModel.getDetailProduct(productId)
    val detailProduct by viewModel.detailState.collectAsState()
    val isFavorite by viewModel.isFavorite

    Scaffold(
        topBar = {
            CustomTopBar(
                content = {
                    Row {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            tint = Color.White,
                            contentDescription = stringResource(R.string.back),
                            modifier = Modifier
                                .padding(6.dp)
                                .size(40.dp)
                                .clickable { navigateBack() }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        ScreenTitleText(title = stringResource(R.string.detail_produk))
                    }
                }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(8.dp)
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
                ) {
                    Image(
                        painter = rememberVectorPainter(image = Icons.Default.ShoppingCart),
                        contentDescription = "Tokopedia Logo",
                        modifier = Modifier.size(20.dp)
                    )

                    Text(text = "Beli Sekarang", Modifier.padding(start = 10.dp))
                }
            }
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Column {
                AsyncImage(
                    model = detailProduct.data.image,
                    contentDescription = detailProduct.data.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            color = Color.Black,
                            text = detailProduct.data.name,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            color = Orange,
                            text = detailProduct.data.price.toRupiahFormat(),
                            style = MaterialTheme.typography.body1.copy(
                                fontStyle = FontStyle.Italic
                            )
                        )
                    }
                    IconButton(onClick = viewModel::setFavorite) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = if (isFavorite) "Remove from wishlist" else "Add to wishlist"
                        )
                    }
                }
                Divider()
                Text(
                    text = detailProduct.data.description,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Justify,
                )
            }

        }
    }
}

//@Composable
//fun DetailContent(
//    modifier: Modifier = Modifier,
//    isFavorite: Boolean,
//    setFavorite:(Boolean) -> Unit,
//    detailData: ProductEntity
//) {
//
//}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun DetailProductScreenPreview() {
    AppTheme {
        Scaffold {
            DetailProductScreen(productId = 1) {

            }
        }
    }
}