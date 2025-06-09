package com.itckc.doubleh.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.itckc.doubleh.Navigation.Screen
import com.itckc.doubleh.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(250.dp)
                    .background(Color.White)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(Screen.Profile.route)
                            } // <-- Thêm chỗ này
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.hinh),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(64.dp)
                        )
                        Text("Nguyễn Huy", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    }

                }
                Divider(color = Color.Black.copy(alpha = 0.1f), thickness = 1.dp)
                DrawerItem(icon = R.drawable.home, label = "Trang chủ") {
                    navController.navigate(Screen.Home.route)
                    scope.launch { drawerState.close() }
                }
                DrawerItem(icon = R.drawable.favorite, label = "Yêu Thích") {
                    navController.navigate(Screen.Favorite.route)
                    scope.launch { drawerState.close() }
                }
                DrawerItem(icon = R.drawable.shopping, label = "Đơn hàng") {
                    navController.navigate(Screen.Order.route)
                    scope.launch { drawerState.close() }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
                    title = {
                        Text("DOUBLE H", color = Color.Black)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
                        }
                    },
                    actions = {
                        IconButton(onClick = {navController.navigate(Screen.Search.route)}) {
                            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Black)
                        }
                        IconButton(onClick = {navController.navigate(Screen.Cart.route)}) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = Color.Black)
                        }
                    }
                )
            },
            content = { paddingValues ->
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    item {
                        CategoryRow()
                        BannerImage()
                        Spacer(modifier = Modifier.height(8.dp))
                        ProductSection(title = "Nike", navController)
                        ProductSection(title = "Jordan", navController)
                        ProductSection(title = "Adidas", navController)

                    }
                }
            }
        )
    }
}

@Composable
fun DrawerItem(icon: Int, label: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = label, fontSize = 14.sp, color = Color.Black)
    }
}

@Composable
fun CategoryRow() {
    LazyRow(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(listOf(R.drawable.img_1, R.drawable.img_2, R.drawable.img_3)) { imageRes ->
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Composable
fun BannerImage() {
    Image(
        painter = painterResource(id = R.drawable.img),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ProductSection(title: String, navController: NavController) {
    Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 4.dp)) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(4) {
                ProductCard(navController)
            }
        }
    }
}

@Composable
fun ProductCard(navController: NavController) {
    Column(
        modifier = Modifier
            .width(135.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF6F6F6))
            .shadow(elevation = 0.5.dp, shape = RoundedCornerShape(8.dp))
            .clickable {
                navController.navigate(Screen.ProductDetail.route)
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.hinh),
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
            Text(
                text = "Travis Scott x SB Dunk Low",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "45.000.000 VND",
                fontSize = 12.sp,
                color = Color(0xFF7A7A7A),
                fontWeight = FontWeight.Medium
            )
        }
    }
}
