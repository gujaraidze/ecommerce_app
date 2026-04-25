package com.example.ecommerce_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce_app.model.ClothingItem
import com.example.ecommerce_app.model.ClothingType
import com.example.ecommerce_app.screens.ItemScreen
import com.example.ecommerce_app.screens.LikedScreen
import com.example.ecommerce_app.screens.MainScreen
import com.example.ecommerce_app.screens.ProfileScreen
import com.example.ecommerce_app.screens.SignUpScreen
import com.example.ecommerce_app.model.Data.filters
import com.example.ecommerce_app.model.Data.clothingItems
import com.example.ecommerce_app.model.UserInfo


@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    var clothes by remember { mutableStateOf(clothingItems) }
    var filters by remember { mutableStateOf(filters) }
    var currentUser by remember { mutableStateOf(UserInfo("", "", "")) }
    val selectedFilter = filters.find { it.isSelected }

    val filteredClothes = clothes.filter { item ->
        item.clothingType == selectedFilter?.clothingType
    }

    val items = when {
        selectedFilter?.clothingType == ClothingType.ALL -> clothes
        else -> {filteredClothes}
    }


    NavHost(navController, startDestination = "main") {

        composable("signup") {
            SignUpScreen(
                navController = navController,
                onSignUpSuccess = { userInfo ->
                    currentUser = userInfo
                }
            )
        }

        composable("main") {
            MainScreen(
                clothes = items,
                filters = filters,
                onItemClick =  {navController.currentBackStackEntry?.savedStateHandle?.set("clothing_item", it)
                        navController.navigate("itemScreen")},
                onFavoriteClick = {
                    clothes = clothes.map { currentItem ->
                        if (currentItem == it) {
                            currentItem.copy(isFavorite = !currentItem.isFavorite)
                        } else {
                            currentItem
                        }
                    }
                },
                onFilterClick = {
                    filters = filters.map { currentFilter ->
                        if (currentFilter == it) {
                            currentFilter.copy(isSelected = true)
                        } else {
                            currentFilter.copy(isSelected = false)
                        }
                    }
                },

                navController = navController
            )
        }

        composable("liked") {
            LikedScreen(
                clothes = clothes,
                onItemClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("clothing_item", it)
                    navController.navigate("itemScreen")
                },
                onFavoriteClick = {
                    clothes = clothes.map { currentItem ->
                        if (currentItem == it) {
                            currentItem.copy(isFavorite = !currentItem.isFavorite)
                        } else {
                            currentItem
                        }
                    }
                },
                navController = navController)
        }

        composable("profile") {
            ProfileScreen(
                userInfo = currentUser,
                navController = navController,
                onLogout = { userInfo ->
                    currentUser = userInfo
                }
            )
        }
        composable("itemScreen") {
            val savedItem = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<ClothingItem>("clothing_item")

            val clothingItem = savedItem?.let { selectedItem ->
                clothes.find {
                    it.title == selectedItem.title &&
                        it.price == selectedItem.price &&
                        it.image == selectedItem.image
                }
            } ?: savedItem

            ItemScreen(
                navController = navController,
                clothingItem = clothingItem,
                onFavoriteClick = { clickedItem ->
                    clothes = clothes.map { currentItem ->
                        if (
                            currentItem.title == clickedItem.title &&
                            currentItem.price == clickedItem.price &&
                            currentItem.image == clickedItem.image
                        ) {
                            currentItem.copy(isFavorite = !currentItem.isFavorite)
                        } else {
                            currentItem
                        }
                    }
                }
            )
        }
    }
}
