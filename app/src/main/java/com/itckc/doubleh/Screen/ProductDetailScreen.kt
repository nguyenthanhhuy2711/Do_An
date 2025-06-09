package com.itckc.doubleh.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.itckc.doubleh.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Chi tiết sản phẩm", color = Color.Black)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // Ảnh chính
            Image(
                painter = painterResource(id = R.drawable.hinh), // thay bằng ảnh bạn có
                contentDescription = "Main Shoe",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Ảnh phụ
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(listOf(R.drawable.hinh, R.drawable.hinh, R.drawable.hinh)) { img ->
                    Image(
                        painter = painterResource(id = img),
                        contentDescription = "Thumbnail",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Thông tin sản phẩm
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    "Jordan NU Retro 1 G",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text("Golf Shoes", color = Color.Gray, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("3.527.199 ₫", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "4.409.000 ₫",
                        textDecoration = TextDecoration.LineThrough,
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("20% off", color = Color(0xFF34C759), fontSize = 14.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Out of stock button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray, shape = RoundedCornerShape(24.dp))
                        .padding(vertical = 14.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Out of Stock", color = Color.DarkGray)
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Favorite button
                OutlinedButton(
                    onClick = { /* TODO: Handle favorite */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
                ) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Favorite")
                }
                // Mô tả sản phẩm
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    "This fresh take on the AJ1 brings new energy to a classic neutral colorway. " +
                            "Smooth, premium leather and Nike Air cushioning give you the quality and comfort " +
                            "you've come to expect from Jordan.",
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Thông tin hiển thị
                Column {
                    Text("• Shown: White/Black/Matte Silver/Fire Red")
                    Text("• Style: HF3148-106")
                    Text(
                        "View Product Details",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Divider()

                // Review
                Spacer(modifier = Modifier.height(12.dp))
                Text("Reviews (1)", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(3) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color.Black)
                    }
                    repeat(2) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color.Black)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    "You Might Also Like",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                LazyRow(
                    contentPadding = PaddingValues(bottom = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(3) {
                        Column(
                            modifier = Modifier
                                .width(160.dp)
                                .background(Color.White)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.hinh ),
                                contentDescription = "Suggestion",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "Travis Scott x SB Dunk Low",
                                fontSize = 14.sp,
                                maxLines = 2
                            )
                            Text(
                                "45.000.000 VND",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }


            }
        }
    }
}
