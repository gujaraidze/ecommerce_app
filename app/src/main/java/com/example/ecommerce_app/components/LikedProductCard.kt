package com.example.ecommerce_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce_app.model.ClothingItem
import com.example.ecommerce_app.model.ClothingType


@Composable
fun LikedProductCard(
    clothingItem: ClothingItem,
    onFavoriteClick: () -> Unit,
    onItemClick: (ClothingItem) -> Unit
) {
    Column(
        modifier = Modifier.clickable {
            onItemClick.invoke(clothingItem)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
        ) {
            Image(
                painter = painterResource(clothingItem.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = (
                        if(clothingItem.clothingType == ClothingType.SHOES){
                            Alignment.BottomCenter
                        }else{
                    Alignment.TopCenter}),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(32.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White.copy(alpha = 0.8f))
            ) {
                IconButton(
                    onClick = onFavoriteClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = if (clothingItem.isFavorite) Color.Red else Color.LightGray,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = clothingItem.title,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            maxLines = 2
        )
        Text(
            text = "$${clothingItem.price}",
            fontSize = 17.sp,
            color = Color.Gray
        )
    }
}


