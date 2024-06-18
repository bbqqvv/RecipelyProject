package com.vanbui.recipely.feature.create_recipe.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.vanbui.recipely.core.model.IngredientItem
import com.vanbui.recipely.feature.create_recipe.CreateRecipeEvent

@Composable
fun IngredientsSection(
    onEvent: (CreateRecipeEvent) -> Unit,
    ingredients: List<IngredientItem>,
    onAddIngredientClick: () -> Unit,
    onEditIngredient: (IngredientItem) -> Unit
) {
    Column {
        IngredientDragDropList(
            items = ingredients,
            onMove = { from, to -> onEvent(CreateRecipeEvent.SwapIngredient(from, to)) },
            onAddIngredientClick = onAddIngredientClick,
            onEditIngredient = onEditIngredient
        )
    }
}
