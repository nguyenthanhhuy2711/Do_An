package com.itckc.doubleh.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.itckc.doubleh.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile", fontSize = 18.sp) },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "User",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                tint = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(onClick = { navController.navigate(Screen.EditProfile.route) }) {
                Text("Chỉnh sửa")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfileMenuItem(navController, Icons.Default.ShoppingCart, "Đơn hàng", "order_screen")
                ProfileMenuItem(navController, Icons.Default.ShoppingCart, "Giỏ hàng", "cart_screen")
                ProfileMenuItem(navController, Icons.Default.Favorite, "Yêu thích", "favorite_screen")
                ProfileMenuItem(navController, Icons.Default.ExitToApp, "Đăng xuất", "welcome_screen")
            }
        }
    }
}

@Composable
fun ProfileMenuItem(
    navController: NavController,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    route: String
) {
    Column(
        modifier = Modifier.clickable {
            navController.navigate(route)
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(icon, contentDescription = null, tint = Color.Black, modifier = Modifier.size(28.dp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, fontSize = 12.sp, color = Color.Black)
    }
}
