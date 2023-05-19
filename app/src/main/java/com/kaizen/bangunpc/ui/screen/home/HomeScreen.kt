package com.kaizen.bangunpc.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaizen.bangunpc.R
import com.kaizen.bangunpc.data.dummyProducts
import com.kaizen.bangunpc.ui.components.AutoSlidingCarouselPreview
import com.kaizen.bangunpc.ui.components.ProductHighlight
import com.kaizen.bangunpc.ui.components.ProductRow
import com.kaizen.bangunpc.ui.components.SearchBar
import com.kaizen.bangunpc.ui.theme.AppTheme
import com.kaizen.bangunpc.ui.theme.Orange

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Banner()
        AutoSlidingCarouselPreview()
        ProductHighlight(
            title = stringResource(R.string.section_rakitan_intel),
            content = { ProductRow(dummyProducts) }
        )
        ProductHighlight(
            title = stringResource(R.string.section_rakitan_amd),
            content = { ProductRow(dummyProducts) }
        )
        Service()
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier =  modifier
                .fillMaxWidth()
        )
        Column (modifier = Modifier.padding(16.dp)){
            Spacer(modifier = Modifier.height(48.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
            ){
                Column {
                    Text(
                        text = "Halo Kawan,",
                        color = Color.White,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.ExtraBold
                        ),
                    )
                    Text(
                        text = "Rakit PC Impianmu sekarang",
                        color = Color.White,
                        style = MaterialTheme.typography.subtitle1,
                    )
                }
                Image(
                    painter = painterResource(R.drawable.icon_profile),
                    contentDescription = "Icon Profile",
                    modifier = Modifier
                        .shadow(20.dp, CircleShape)
                        .size(47.dp)
                        .clickable {  }
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            SearchBar()
        }
    }
}

@Composable
fun Service() {
    Column (
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .border(BorderStroke(1.5.dp, Orange))
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        ){
            Image(
                painter = painterResource(R.drawable.logo_gxcomp),
                contentDescription = "Icon Profile",
                modifier = Modifier
                    .size(48.dp)
            )
            Text(
                text = "Butuh Jasa Rakit atau \n" +
                        "Service PC?",
                color = Color.Black,
                style = MaterialTheme.typography.subtitle2,
            )

            Button(
                onClick = {
                //your onclick code here
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Orange)) {
                Text(
                    text = "Hubungi Kami",
                    style = MaterialTheme.typography.subtitle2)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicePreview() {
    AppTheme {
        Service()
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    AppTheme {
        Scaffold() {innerPadding ->
            HomeScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}