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
    )

    val clothingItems = listOf(
        ClothingItem(
            title = "Classic Black Jeans",
            price = 120,
            images = listOf(R.drawable.classic_black_jeans, R.drawable.classic_black_jeans_01, R.drawable.classic_black_jeans_02),
            isFavorite = false,
            clothingType = ClothingType.JEANS
        ),
        ClothingItem(
            title = "Slim Fit Blue Jeans",
            price = 135,
            images = listOf(R.drawable.slim_fit_blue_jeans, R.drawable.slim_fit_blue_jeans_01, R.drawable.slim_fit_blue_jeans_02),
            isFavorite = false,
            clothingType = ClothingType.JEANS
        ),
        ClothingItem(
            title = "Ripped Street Jeans",
            price = 145,
            images = listOf(R.drawable.ripped_street_jeans, R.drawable.ripped_street_jeans_01, R.drawable.ripped_street_jeans_02),
            isFavorite = false,
            clothingType = ClothingType.JEANS
        ),
        ClothingItem(
            title = "Dark Wash Denim",
            price = 155,
            images = listOf(R.drawable.dark_wash_denim_jeans, R.drawable.dark_wash_denim_jeans_01, R.drawable.dark_wash_denim_jeans_02),
            isFavorite = false,
            clothingType = ClothingType.JEANS
        ),

        ClothingItem(
            title = "Slim Fit White Shirt",
            price = 90,
            images = listOf(R.drawable.slim_fit_white_shirt, R.drawable.slim_fit_white_shirt_01, R.drawable.slim_fit_white_shirt_02),
            isFavorite = false,
            clothingType = ClothingType.SHIRTS
        ),
        ClothingItem(
            title = "Checked Casual Shirt",
            price = 95,
            images = listOf(R.drawable.checked_casual_shirt, R.drawable.checked_casual_shirt_01, R.drawable.checked_casual_shirt_02),
            isFavorite = false,
            clothingType = ClothingType.SHIRTS
        ),
        ClothingItem(
            title = "Regular Blue Shirt",
            price = 100,
            images = listOf(R.drawable.regular_blue_shirt, R.drawable.regular_blue_shirt_01, R.drawable.regular_blue_shirt_02),
            isFavorite = false,
            clothingType = ClothingType.SHIRTS
        ),
        ClothingItem(
            title = "Formal Black Shirt",
            price = 115,
            images = listOf(R.drawable.formal_black_shirt, R.drawable.formal_black_shirt_01, R.drawable.formal_black_shirt_02),
            isFavorite = false,
            clothingType = ClothingType.SHIRTS
        ),

        ClothingItem(
            title = "Oversized Gray Hoodie",
            price = 150,
            images = listOf(R.drawable.oversized_gray_hoodie, R.drawable.oversized_gray_hoodie_01, R.drawable.oversized_gray_hoodie_02),
            isFavorite = false,
            clothingType = ClothingType.HOODIES
        ),
        ClothingItem(
            title = "Zip-Up Black Hoodie",
            price = 160,
            images = listOf(R.drawable.zip_up_black_hoodie, R.drawable.zip_up_black_hoodie_01, R.drawable.zip_up_black_hoodie_02),
            isFavorite = false,
            clothingType = ClothingType.HOODIES
        ),
        ClothingItem(
            title = "Essential Cream Hoodie",
            price = 155,
            images = listOf(R.drawable.essential_cream_hoodie, R.drawable.essential_cream_hoodie_01, R.drawable.essential_cream_hoodie_02),
            isFavorite = false,
            clothingType = ClothingType.HOODIES
        ),
        ClothingItem(
            title = "Relaxed Fit Brown Hoodie",
            price = 170,
            images = listOf(R.drawable.relaxed_fit_brown_hoodie, R.drawable.relaxed_fit_brown_hoodie_01, R.drawable.relaxed_fit_brown_hoodie_02),
            isFavorite = false,
            clothingType = ClothingType.HOODIES
        ),

        ClothingItem(
            title = "Relaxed Blue Pants",
            price = 110,
            images = listOf(R.drawable.relaxed_blue_pants, R.drawable.relaxed_blue_pants_01, R.drawable.relaxed_blue_pants_02),
            isFavorite = false,
            clothingType = ClothingType.PANTS
        ),
        ClothingItem(
            title = "Formal Beige Pants",
            price = 130,
            images = listOf(R.drawable.formal_beige_pants, R.drawable.formal_beige_pants_01, R.drawable.formal_beige_pants_02),
            isFavorite = false,
            clothingType = ClothingType.PANTS
        ),
        ClothingItem(
            title = "Wide Leg Black Pants",
            price = 140,
            images = listOf(R.drawable.wide_leg_black_pants, R.drawable.wide_leg_black_pants_01, R.drawable.wide_leg_black_pants_02),
            isFavorite = false,
            clothingType = ClothingType.PANTS
        ),
        ClothingItem(
            title = "Classic Office Trousers",
            price = 150,
            images = listOf(R.drawable.classic_office_trousers, R.drawable.classic_office_trousers_01, R.drawable.classic_office_trousers_02),
            isFavorite = false,
            clothingType = ClothingType.PANTS
        ),

        ClothingItem(
            title = "Running Sneakers",
            price = 180,
            images = listOf(R.drawable.running_sneakers, R.drawable.running_sneakers_01, R.drawable.running_sneakers_02),
            isFavorite = false,
            clothingType = ClothingType.SHOES
        ),
        ClothingItem(
            title = "Classic Black Shoes",
            price = 170,
            images = listOf(R.drawable.classic_black_shoes, R.drawable.classic_black_shoes_01, R.drawable.classic_black_shoes_02),
            isFavorite = false,
            clothingType = ClothingType.SHOES
        ),
        ClothingItem(
            title = "Sport Black Trainers",
            price = 190,
            images = listOf(R.drawable.sport_black_trainers, R.drawable.sport_black_trainers_01, R.drawable.sport_black_trainers_02),
            isFavorite = false,
            clothingType = ClothingType.SHOES
        ),
        ClothingItem(
            title = "Minimal Leather Sneakers",
            price = 210,
            images = listOf(R.drawable.minimal_leather_sneakers, R.drawable.minimal_leather_sneakers_01, R.drawable.minimal_leather_sneakers_02),
            isFavorite = false,
            clothingType = ClothingType.SHOES
        )
    )
}
