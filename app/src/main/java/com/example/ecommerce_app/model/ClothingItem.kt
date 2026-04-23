package com.example.ecommerce_app.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import java.io.Serializable


data class ClothingItem(
    val title: String,
    val price: Int,
    @DrawableRes val image: Int,
    val isFavorite: Boolean,
    val clothingType: ClothingType
): Serializable


enum class ClothingType{
    ALL,
    JEANS,
    SHIRTS,
    HOODIES,
    PANTS,
    SHOES,
}

data class Filter(
    val title: String,
    val isSelected: Boolean,
    val clothingType: ClothingType
)

data class AccountMenuItem(
    val icon: ImageVector,
    val label: String
)


data class UserInfo(
    val name: String,
    val mail: String
)
