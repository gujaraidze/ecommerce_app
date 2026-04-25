package com.example.ecommerce_app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce_app.model.ClothingItem

@Composable
fun ProductGrid(
    clothes: List<ClothingItem>,
    onClick: (ClothingItem) -> Unit,
    onFavoriteClick: (ClothingItem) -> Unit,
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item(span = { GridItemSpan(maxLineSpan) }) {
            header()
        }

        items(clothes) { cloth ->
            ProductCard(
                clothingItem = cloth,
                onItemClick = {onClick(cloth)},
                onFavoriteClick = { onFavoriteClick(cloth) }
            )
        }
    }
}

