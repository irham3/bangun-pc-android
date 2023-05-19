package com.kaizen.bangunpc.ui.screen.home

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.kaizen.bangunpc.ui.components.HomeSection
import com.kaizen.bangunpc.ui.components.ProductRow
import com.kaizen.bangunpc.ui.components.SearchBar
import com.kaizen.bangunpc.ui.theme.BangunPCTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Banner()
        HomeSection(
            title = stringResource(R.string.section_rakitan_intel),
            content = { ProductRow(dummyProducts) }
        )
        HomeSection(
            title = stringResource(R.string.section_rakitan_amd),
            content = { ProductRow(dummyProducts) }
        )
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
                        .size(47.dp)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            SearchBar()
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    BangunPCTheme {
        Scaffold() {innerPadding ->
            HomeScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}