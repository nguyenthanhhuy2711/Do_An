package com.itckc.doubleh.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.itckc.doubleh.Navigation.Screen

@Composable
fun SignInScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val shape = RoundedCornerShape(12.dp)
    val modifierField = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF8B4513), Color.Black)
                )
            )
            .padding(24.dp),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Text("Đăng nhập", fontSize = 30.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Tên đăng nhập") },
                modifier = modifierField,
                shape = shape,
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) }
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mật khẩu") },
                modifier = modifierField,
                shape = shape,
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) }
            )

            Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Quên mật khẩu?",
                    color = Color.Blue,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .clickable {
                        // TODO: Thêm logic quên mật khẩu
                    }
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                )

            Button(
                onClick = {
                    navController.navigate(Screen.Home.route)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.Black),
                shape = shape,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Text("Đăng nhập", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Chưa có tài khoản? Đăng ký",
                color = Color.Blue,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
                    .clickable {
                        navController.navigate(Screen.SignUp.route)
                    }
            )
        }
    }
}
