package com.example.ecommerce_app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommerce_app.components.BottomNav
import com.example.ecommerce_app.components.LikedProductGrid
import com.example.ecommerce_app.model.ClothingItem

@Composable
fun LikedScreen(
    clothes: List<ClothingItem>,
    onItemClick: (ClothingItem) -> Unit,
    onFavoriteClick: (ClothingItem) -> Unit,
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            BottomNav(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            // ... (rest of the header code)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Saved Items",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.NotificationsNone,
                        contentDescription = "Notifications",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }


            Spacer(modifier = Modifier.height(5.dp))
            LikedProductGrid(
                clothes = clothes,
                onClick = { onItemClick.invoke(it) },
                onFavoriteClick = onFavoriteClick
            )
        }

    }
}
