package com.itckc.doubleh.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.itckc.doubleh.R

data class FavoriteItem(
    val name: String,
    val price: String,
    val imageResId: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(navController: NavController) {
    val favoriteItems = remember {
        listOf(
            FavoriteItem("Jordan NU Retro 1 G", "3.500.000 VNĐ", R.drawable.jordan2),
            FavoriteItem("Jordan NU Retro 1 G", "3.500.000 VNĐ", R.drawable.jordan2),
            FavoriteItem("Jordan NU Retro 1 G", "3.500.000 VNĐ", R.drawable.jordan2)
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Yêu thích", fontSize = 18.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        containerColor = Color.White
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(paddingValues)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(favoriteItems) { item ->
                FavoriteItemCard(item)
            }
        }
    }
}

@Composable
fun FavoriteItemCard(item: FavoriteItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Xử lý khi click */ }
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = item.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Icon(
                Icons.Default.Favorite,
                contentDescription = "Favorite",
                tint = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(6.dp)
            )
        }

        Text(
            text = item.name,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )

        Text(
            text = item.price,
            fontSize = 14.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )
    }
}
