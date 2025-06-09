package com.itckc.doubleh.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.itckc.doubleh.R // Đảm bảo bạn có file ảnh ở drawable (vd: shoe_red)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen(navController: NavController) {
    var paymentMethod by remember { mutableStateOf("COD") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Thanh toán") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Thông tin khách hàng
            Text("Thông tin khách hàng", fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text("Tên")
            OutlinedTextField(value = "Nguyễn Thanh Huy", onValueChange = {}, enabled = false)
            Text("SDT")
            OutlinedTextField(value = "0326037833", onValueChange = {}, enabled = false)
            Text("Địa chỉ")
            OutlinedTextField(
                value = "399/6A, Bình Hưng Hòa B, Bình Tân, ...",
                onValueChange = {}, enabled = false
            )

            Spacer(Modifier.height(16.dp))

            // Thông tin đơn hàng
            Text("Thông tin đơn hàng", fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.jordan2), // ảnh trong drawable
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(8.dp))
                Column {
                    Text("Jordan NU Retro 1 G", fontSize = 14.sp)
                    Text("Đỏ, 40", fontSize = 14.sp)
                    Text("x1", fontSize = 14.sp)
                    Text("3.500.000 VND", fontSize = 14.sp)
                }
            }

            Spacer(Modifier.height(16.dp))

            // Tóm tắt đơn hàng
            Text("Tóm tắt yêu cầu", fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Tổng phụ")
                Text("3.500.000 VND")
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Vận chuyển")
                Text("50.000 VND")
            }
            Divider(Modifier.padding(vertical = 4.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Tổng", fontWeight = FontWeight.Bold)
                Text("3.550.000 VND", fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(16.dp))

            // Phương thức thanh toán
            Text("Phương thức thanh toán", fontWeight = FontWeight.Bold)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { paymentMethod = "COD" }
            ) {
                Checkbox(checked = paymentMethod == "COD", onCheckedChange = { paymentMethod = "COD" })
                Text("Thanh toán khi nhận hàng")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { paymentMethod = "BANK" }
            ) {
                Checkbox(checked = paymentMethod == "BANK", onCheckedChange = { paymentMethod = "BANK" })
                Text("Thanh toán qua thẻ ngân hàng")
            }

            Spacer(Modifier.height(16.dp))

            // Nút đặt hàng
            Button(
                onClick = {
                    // TODO: Xử lý đặt hàng
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) {
                Text("Đặt hàng", color = Color.White)
            }
        }
    }
}
