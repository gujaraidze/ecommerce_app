package com.example.ecommerce_app.model

import com.example.ecommerce_app.R

object Data {
    val filters = listOf(
        Filter(
            title = "All",
            isSelected = true,
            clothingType = ClothingType.ALL
        ),
        Filter(
            title = "Shirts",
            isSelected = false,
            clothingType = ClothingType.SHIRTS
        ),
        Filter(
            title = "Jeans",
            isSelected = false,
            clothingType = ClothingType.JEANS
        ),

        Filter(
            title = "Hoodies",
            isSelected = false,
            clothingType = ClothingType.HOODIES
        ),
        Filter(
            title = "Shoes",
            isSelected = false,
            clothingType = ClothingType.SHOES
        ),
        Filter(
            title = "Pants",
            isSelected = false,
            clothingType = ClothingType.PANTS
        ),
        Filter(
            title = "Black Jeans",
            isSelected = false,
            clothingType = ClothingType.JEANS
        ),
        Filter(
            title = "Casual Shirts",
            isSelected = false,
            clothingType = ClothingType.SHIRTS
        ),
        Filter(
            title = "Warm Hoodies",
            isSelected = false,
            clothingType = ClothingType.HOODIES
        )
    )

    val clothingItems = listOf(
        ClothingItem(
            title = "Classic Black Jeans",
            price = 120,
            image = R.drawable.image,
            isFavorite = false,
            clothingType = ClothingType.JEANS
        ),
        ClothingItem(
            title = "Slim Fit White Shirt",
            price = 90,
            image = R.drawable.image,
            isFavorite = false,
            clothingType = ClothingType.SHIRTS
        ),
        ClothingItem(
            title = "Oversized Gray Hoodie",
            price = 150,
            image = R.drawable.image,
            isFavorite = false,
            clothingType = ClothingType.HOODIES
        ),
        ClothingItem(
            title = "Relaxed Blue Pants",
            price = 110,
            image = R.drawable.image,
            isFavorite = false,
            clothingType = ClothingType.PANTS
        ),
        ClothingItem(
            title = "Formal Beige Pants",
            price = 130,
            image = R.drawable.image,
            isFavorite = false,
            clothingType = ClothingType.PANTS
        ),
        ClothingItem(
            title = "Checked Casual Shirt",
            price = 95,
            image = R.drawable.image,
            isFavorite = false,
            clothingType = ClothingType.SHIRTS
        ),
        ClothingItem(
            title = "Zip-Up Black Hoodie",
            price = 160,
            image = R.drawable.image,
            isFavorite = false,
            clothingType = ClothingType.HOODIES
        )
    )
}