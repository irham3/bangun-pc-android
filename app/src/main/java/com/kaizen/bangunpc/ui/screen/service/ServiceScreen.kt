package com.kaizen.bangunpc.ui.screen.service

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.ui.components.CircleButton
import com.kaizen.bangunpc.ui.components.CustomTopBar
import com.kaizen.bangunpc.ui.components.ScreenTitleText
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.ui.theme.Orange

@Composable
fun ServiceScreen(
    modifier: Modifier = Modifier
) {
    Column() {
        CustomTopBar(
            content = {
                ScreenTitleText(title = stringResource(R.string.service_title))
            }
        )
        Column(
            modifier = modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = "https://images.tokopedia.net/img/cache/900/VqbcmM/2022/11/18/71c0fe32-b704-4730-b3a1-e5e46256b5bf.png",
                contentDescription = "GXComp ",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(160.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Text(
                color = Color.Black,
                text = stringResource(R.string.gxcomp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(top = 16.dp)
            )
            Text(
                color = Color.Black,
                text = stringResource(R.string.gxcomp_description),
                style = MaterialTheme.typography.body1.copy(
                    fontStyle = FontStyle.Normal
                )
            )
            Row (
                modifier = modifier
                    .fillMaxWidth()
            ){
                BorderCircularButton(
                    linkUrl = stringResource(R.string.gxcomp_tokopedia),
                    imageIcon = painterResource(id = R.drawable.tokopedia_logo)
                )
                BorderCircularButton(
                    linkUrl = stringResource(R.string.gxcomp_shopee),
                    imageIcon = painterResource(id = R.drawable.shopee_logo)
                )
                BorderCircularButton(
                    linkUrl = stringResource(R.string.gxcomp_whatsapp),
                    imageIcon = painterResource(id = R.drawable.whatsapp_logo)
                )
            }
        }
    }
}

@Composable
private fun BorderCircularButton(
    modifier: Modifier = Modifier,
    linkUrl: String,
    imageIcon: Painter,
    ctx: Context = LocalContext.current
) {
    CircleButton(
        modifier = modifier
            .padding(8.dp)
            .border(BorderStroke(2.dp, Orange), CircleShape),
        onClick = {
            val urlIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(linkUrl)
            )
            ctx.startActivity(urlIntent)
        },
        icon = {
            Image(
                painter = imageIcon,
                contentScale = ContentScale.Fit,
                contentDescription = "Link Toko",
            )
        },
        buttonColors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        )
    )
}

@Preview(
    showSystemUi = true
)
@Composable
private fun ServiceScreenPreview() {
    AppTheme {
        ServiceScreen()
    }
}