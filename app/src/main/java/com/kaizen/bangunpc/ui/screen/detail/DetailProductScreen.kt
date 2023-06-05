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
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.ScreenTitleText
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.ui.theme.Orange

@Composable
fun DetailProductScreen(
    productId: Int,
    navigateBack: () -> Unit = {}
) {
//    val dataProduct = dummyProducts.first { it.id == productId }
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
//            Image(
//                painter = painterResource(dataProduct.image),
//                contentDescription = null,
//                contentScale = ContentScale.Fit,
//                modifier = Modifier
//                    .height(240.dp)
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
//            )
//            Text(
//                text = dataProduct.title,
//                textAlign = TextAlign.Justify,
//                style = MaterialTheme.typography.h6.copy(
//                    fontWeight = FontWeight.ExtraBold
//                ),
//            )
//            Text(
//                text = dataProduct.price,
//                textAlign = TextAlign.Justify,
//                style = MaterialTheme.typography.h6.copy(
//                    fontWeight = FontWeight.ExtraBold
//                ),
//                color = Orange
//            )
//            Text(
//                text = dataProduct.detail,
//                style = MaterialTheme.typography.body2,
//                textAlign = TextAlign.Justify,
//            )
        }
    }

}


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