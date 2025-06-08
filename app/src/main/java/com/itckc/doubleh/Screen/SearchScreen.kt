package com.itckc.doubleh.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF0F0F0), shape = MaterialTheme.shapes.small)
                            .padding(horizontal = 8.dp, vertical = 6.dp)
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Search Icon", tint = Color.Gray)
                        Spacer(modifier = Modifier.width(6.dp))
                        BasicTextField(
                            value = searchText,
                            onValueChange = { searchText = it },
                            singleLine = true,
                            modifier = Modifier.weight(1f),
                            decorationBox = { innerTextField ->
                                if (searchText.text.isEmpty()) {
                                    Text("Tìm kiếm", color = Color.Gray)
                                }
                                innerTextField()
                            }
                        )
                    }
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
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            if (searchText.text.isNotEmpty()) {
                // Giả sử có dữ liệu tìm được
                Text("Kết quả cho: \"${searchText.text}\"", fontSize = 16.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(12.dp))

                // Kết quả mô phỏng
                SearchResultItem("Travis Scott x SB Dunk Low")
                SearchResultItem("Air Jordan 1 High OG")
            }
        }
    }
}

@Composable
fun SearchResultItem(name: String) {
    Text(
        text = name,
        fontSize = 15.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                // TODO: Xử lý khi nhấn vào kết quả tìm kiếm
            }
    )
}
