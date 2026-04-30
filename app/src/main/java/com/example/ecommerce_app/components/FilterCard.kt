package com.example.ecommerce_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce_app.model.Filter

@Composable
fun FilterCard(
    filterItem: Filter,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (filterItem.isSelected) Color.Black
                else Color.White
            )
            .clickable {
                onClick.invoke()
            }
            .border(
                width = 2.dp,
                color = if (filterItem.isSelected) Color.Black else Color(0xFFE6E6E6),
                shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 20.dp, vertical = 7.dp)

    ) {
        Text(
            text = filterItem.title,
            color = if (filterItem.isSelected) Color.White else Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight(600)
        )
    }
}
