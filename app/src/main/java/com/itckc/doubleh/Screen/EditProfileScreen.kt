package com.itckc.doubleh.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavController) {
    // Biến lưu dữ liệu người dùng
    var name by remember { mutableStateOf("Nguyễn Thanh Huy") }
    var email by remember { mutableStateOf("0306221026@gmail.com") }
    var phone by remember { mutableStateOf("0326037833") }
    var address by remember { mutableStateOf("399/6A, Bình Hưng Hòa B, Bình Tân, ...") }
    var password by remember { mutableStateOf("0306221***") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chỉnh sửa hồ sơ", fontSize = 18.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    TextButton(onClick = {
                        // TODO: Lưu thay đổi
                    }) {
                        Text("Save")
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar
            Icon(
                Icons.Default.Person,
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                tint = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Các trường nhập liệu
            EditProfileField("Tên", name) { name = it }
            EditProfileField("Email", email) { email = it }
            EditProfileField("SDT", phone) { phone = it }
            EditProfileField("Địa chỉ", address) { address = it }
            EditProfileField("Mật khẩu", password, isPassword = true) { password = it }
        }
    }
}

@Composable
fun EditProfileField(label: String, value: String, isPassword: Boolean = false, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true
    )
}
