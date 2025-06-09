package com.itckc.doubleh.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import com.itckc.doubleh.Navigation.Screen
import com.itckc.doubleh.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavController) {
    // Biến dữ liệu sản phẩm
    var soLuong by remember { mutableStateOf(1) }

    val tenSanPham = "Travis Scott x SB Dunk Low"
    val mau = "Nâu"
    val gia = 45000000
    val kichThuoc = 40

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Giỏ hàng", fontSize = 18.sp) },
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
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hinh), // thay bằng ảnh thật của bạn
                    contentDescription = "Ảnh sản phẩm",
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.LightGray, RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(tenSanPham, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text("Màu: $mau")
                    Text("Kích thước: $kichThuoc")
                    Text("Giá: ${gia.toString()} VNĐ", fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(4.dp))

                    // Tăng giảm số lượng
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { if (soLuong > 1) soLuong-- }) {
                            Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Giảm")
                        }
                        Text("$soLuong", fontSize = 16.sp)
                        IconButton(onClick = { soLuong++ }) {
                            Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Tăng")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nút chức năng
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navController.navigate(Screen.CheckOut.route) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text("Thanh toán", color = Color.White)
                }

                Button(
                    onClick = { /* TODO: Xử lý xoá */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("Xoá", color = Color.White)
                }
            }
        }
    }
}
