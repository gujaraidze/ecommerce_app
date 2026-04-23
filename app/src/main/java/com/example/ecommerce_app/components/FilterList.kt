package com.example.ecommerce_app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.ecommerce_app.model.Filter

@Composable
fun FilterList(
    filters: List<Filter>,
    onFilterClick: (Filter) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(filters) { filter ->
            FilterCard(filterItem = filter, onClick = {onFilterClick.invoke(filter)})
        }
    }
}