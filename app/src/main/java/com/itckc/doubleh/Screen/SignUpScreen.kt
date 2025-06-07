package com.itckc.doubleh.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import com.itckc.doubleh.Navigation.Screen

@Composable
fun SignUpScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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
            Text("Đăng ký", fontSize = 30.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Tên đăng nhập") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                modifier = modifierField,
                shape = shape
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                modifier = modifierField,
                shape = shape
            )

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("SDT") },
                leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                modifier = modifierField,
                shape = shape
            )

            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Địa Chỉ") },
                leadingIcon = { Icon(Icons.Default.Home, contentDescription = null) },
                modifier = modifierField,
                shape = shape
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mật khẩu") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                trailingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = modifierField,
                shape = shape
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Nhập lại mật khẩu") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                trailingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = modifierField,
                shape = shape
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.SignIn.route)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.Black),
                shape = shape,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Text("Đăng ký", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Đã có tài khoản? Đăng nhập",
                color = Color.Blue,
                fontSize = 14.sp,
                modifier = Modifier.clickable { navController.navigate(Screen.SignIn.route) }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

