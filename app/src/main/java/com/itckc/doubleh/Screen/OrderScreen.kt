package com.itckc.doubleh.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

data class OrderItem(
    val name: String,
    val price: String,
    val color: String,
    val size: String,
    val quantity: Int,
    val imageResId: Int,
    val status: String,
    val rated: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(navController: NavController) {
    val tabs = listOf("Tất cả", "Chờ xác nhận", "Chờ giao hàng", "Đã giao")
    var selectedTabIndex by remember { mutableStateOf(0) }

    val allOrders = remember {
        listOf(
            OrderItem(
                name = "Jordan NU Retro 1 G",
                price = "3.500.000 VNĐ",
                color = "Đỏ",
                size = "40",
                quantity = 1,
                imageResId = R.drawable.jordan2,
                status = "Đã giao",
                rated = false
            ),
            OrderItem(
                name = "Jordan NU Retro 1 G",
                price = "3.500.000 VNĐ",
                color = "Xanh ngọc",
                size = "40",
                quantity = 1,
                imageResId = R.drawable.jordan2,
                status = "Chờ xác nhận",
                rated = false
            )
        )
    }

    val filteredOrders = when (selectedTabIndex) {
        1 -> allOrders.filter { it.status == "Chờ xác nhận" }
        2 -> allOrders.filter { it.status == "Chờ giao hàng" }
        3 -> allOrders.filter { it.status == "Đã giao" }
        else -> allOrders
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Đơn hàng", fontSize = 18.sp) },
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
        Column(modifier = Modifier.padding(paddingValues)) {
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                edgePadding = 0.dp,
                containerColor = Color.White,
                contentColor = Color.Black
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title, fontSize = 14.sp) }
                    )
                }
            }

            LazyColumn(modifier = Modifier.padding(8.dp)) {
                items(filteredOrders) { item ->
                    OrderItemCard(item)
                    Divider(thickness = 0.5.dp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun OrderItemCard(item: OrderItem) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = item.name,
            modifier = Modifier
                .size(100.dp)
                .padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(item.name, fontWeight = FontWeight.Bold)
            Text(item.price, color = Color.Red, fontWeight = FontWeight.Bold)
            Text("Đỏ, ${item.size}")
            Text("x${item.quantity}    Tổng: ${item.price}", fontSize = 13.sp)
            if (item.status == "Đã giao") {
                Text("Đánh giá", fontSize = 13.sp)
                Text("★ ☆ ☆ ☆ ☆", fontSize = 13.sp)
                Text(item.status, fontSize = 13.sp)
            } else {
                Text(item.status, fontSize = 13.sp)
            }
        }
    }
}
