package com.itckc.doubleh.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
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
fun WelcomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Ảnh nền
        Image(
            painter = painterResource(id = R.drawable.background_runner), // Thay bằng ảnh bạn đặt trong res/drawable
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Hình tam giác màu cam
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val path = Path().apply {
                moveTo(0f, 0f)
                lineTo(width * 1.5f, height)
                lineTo(0f, height)
                close()
            }
            drawPath(path, color = Color(0xAAFF6600)) // Màu cam với độ trong suốt
        }

        // Nội dung chữ + nút dưới cùng
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 60.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to DOUBLE H",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Button(
                    onClick = {navController.navigate(Screen.SignUp.route) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    modifier = Modifier
                        .padding(end = 25.dp)
                        .height(50.dp) // Chiều cao to hơn
                        .width(150.dp) // Chiều rộng lớn hơn
                ) {
                    Text(
                        "Đăng ký",
                        color = Color.White,
                        fontSize = 20.sp // Cỡ chữ lớn hơn
                    )
                }
                Button(
                    onClick = { navController.navigate(Screen.SignIn.route)},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier
                        .height(50.dp)
                        .width(150.dp)
                ) {
                    Text(
                        "Đăng nhập",
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                }
            }

        }
    }
}
