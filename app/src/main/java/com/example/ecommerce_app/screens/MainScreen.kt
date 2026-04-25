package com.example.ecommerce_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommerce_app.components.BottomNav
import com.example.ecommerce_app.components.FilterList
import com.example.ecommerce_app.components.ProductGrid
import com.example.ecommerce_app.model.ClothingItem
import com.example.ecommerce_app.model.Filter

@Composable
fun MainScreen(
    clothes: List<ClothingItem>,
    filters: List<Filter>,
    onFavoriteClick: (ClothingItem) -> Unit,
    onItemClick: (ClothingItem) -> Unit,
    onFilterClick: (Filter) -> Unit,
    navController: NavController
) {
    var search by remember { mutableStateOf("") }

    Scaffold(

        bottomBar = {
            BottomNav(navController)
        }
    ) { paddingValues ->

        ProductGrid(
            clothes = clothes,
            onClick = { onItemClick(it) },
            onFavoriteClick = onFavoriteClick,
            modifier = Modifier.padding(paddingValues),
            header = {
                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Discover",
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


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp)
                                .background(Color(0xFFF3F4F6), RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            OutlinedTextField(
                                value = search,
                                onValueChange = { search = it },
                                modifier = Modifier.fillMaxWidth(),
                                readOnly = true,
                                placeholder = {

                                    Text(
                                        "Search for clothes...",
                                        color = Color(0xFFBBBBBB)
                                    )
                                },

                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "Search",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(20.dp)
                                    )
                                },

                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Mic,
                                        contentDescription = "Voice Search",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                singleLine = true,
                                shape = RoundedCornerShape(10.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.White,
                                    unfocusedContainerColor = Color.White,
                                    focusedIndicatorColor = Color.Black,
                                    unfocusedIndicatorColor = Color.Transparent
                                )
                            )
                        }


                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color.Black, RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Tune,
                                contentDescription = "Filter",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(24.dp)
                                    .rotate(90f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    FilterList(
                        filters = filters,
                        onFilterClick = onFilterClick
                    )
                }
            }
        )
    }
}
