package com.kaizen.bangunpc.ui.screen.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.data.source.local.entity.ProductEntity
import com.kaizen.bangunpc.ui.components.CircleButton
import com.kaizen.bangunpc.ui.theme.Green
import com.kaizen.bangunpc.ui.theme.Orange
import com.kaizen.bangunpc.utils.toRupiahFormat

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailProductScreen(
    modifier: Modifier = Modifier,
    productId: Int,
    viewModel: DetailViewModel = hiltViewModel(),
    navigateBack: () -> Unit = {}
) {
    viewModel.getDetailProduct(productId)
    val detailState by viewModel.detailState.collectAsState()
    val isFavorite by viewModel.isFavorite

    Scaffold(
        bottomBar = {
            DetailBottomBar(url = detailState.data.url)
        }
    ) {
        Column {
            DetailHeader(
                modifier = modifier,
                detailProduct = detailState.data,
                setFavorite = viewModel::setFavorite,
                navigateBack = navigateBack,
                isFavorite = isFavorite
            )
            DetailDescription(detailProduct = detailState.data)
        }

    }
}

@Composable
private fun DetailHeader(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    detailProduct: ProductEntity,
    setFavorite: () -> Unit,
    isFavorite: Boolean
) {
    Box(modifier = modifier){
        AsyncImage(
            model = detailProduct.image,
            contentDescription = detailProduct.name,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
        )
        CircleButton(
            modifier = modifier.padding(8.dp),
            onClick = { navigateBack() },
            icon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                )
            },
            buttonColors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black.copy(
                    alpha = 0.5F
                ),
                contentColor = MaterialTheme.colors.primary
            )
        )
    }
    Column(
        modifier = modifier
            .padding(top = 4.dp, start = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = modifier.weight(1f)) {
                Text(
                    color = Color.Black,
                    text = detailProduct.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    color = Orange,
                    text = detailProduct.price.toRupiahFormat(),
                    style = MaterialTheme.typography.body1.copy(
                        fontStyle = FontStyle.Italic
                    )
                )
            }
            FavoriteIcon(setFavorite = setFavorite, isFavorite = isFavorite)
        }
    }
    Divider()
}

@Composable
private fun DetailDescription(
    detailProduct: ProductEntity,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 8.dp, bottom = 60.dp, start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = detailProduct.description,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Justify,
        )

    }
}

@Composable
fun DetailBottomBar(
    modifier: Modifier = Modifier,
    url: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .shadow(8.dp)
            .height(56.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.End
    ) {
        TokopediaButton(url)
    }
}

@Composable
private fun FavoriteIcon(
    setFavorite: () -> Unit,
    isFavorite: Boolean
) {
    IconButton(onClick = setFavorite) {
        Icon(
            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = if (isFavorite) "Remove from wishlist" else "Add to wishlist"
        )
    }
}

@Composable
private fun TokopediaButton(
    url: String
) {
    val ctx = LocalContext.current
    Button(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        onClick = {
            val urlIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            )
            ctx.startActivity(urlIntent)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Green))
    {
        Image(
            painter = painterResource(id = R.drawable.tokopedia_logo),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Beli Sekarang",color = Color.White)
    }
}