package com.anbui.recipely.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.anbui.recipely.core.database.entities.IngredientEntity
import com.anbui.recipely.core.database.entities.LikeEntity
import com.anbui.recipely.core.database.entities.RecentEntity
import com.anbui.recipely.core.database.entities.RecipeEntity
import com.anbui.recipely.core.database.entities.StepEntity
import com.anbui.recipely.core.database.entities.RecipeIngredientCrossRef
import com.anbui.recipely.core.database.relations.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert
    suspend fun insertRecipe(recipe: RecipeEntity)

    @Query("SELECT * FROM Recipe")
    fun getAllRecipeEntities(): Flow<List<RecipeEntity>>

    @Transaction
    @Query("SELECT * FROM Recipe WHERE _id = :recipeId")
    suspend fun getIngredientOfRecipe(recipeId: String): List<RecipeWithIngredient>

    @Transaction
    @Query("SELECT * FROM Recipe")
    fun getAllRecipes(): Flow<List<RecipeAndOwner>>

    @Transaction
    @Query("SELECT * FROM Recipe WHERE _id = :recipeId")
    fun getRecipe(recipeId: String): Flow<RecipeAndOwner>

    @Upsert
    suspend fun insertLike(likeEntity: LikeEntity)

    @Query("DELETE FROM `Like` WHERE recipe_id = :recipeId and account_id = :accountId")
    suspend fun deleteLike(recipeId: String, accountId: String)

    @Upsert
    suspend fun addRecent(recentEntity: RecentEntity)

    @Query("SELECT * FROM Recent WHERE recipe_id = :recipeId AND account_id = :accountId")
    suspend fun getRecentByAccountAndRecipe(accountId: String, recipeId: String): List<RecentEntity>

    @Transaction
    @Query("SELECT * FROM Recipe WHERE owner_id = :accountId")
    fun getRecipeByAccountId(accountId: String): Flow<List<RecipeAndOwner>>

    @Query("DELETE FROM Recipe WHERE _id = :recipeId")
    suspend fun deleteRecipe(recipeId: String)

    @Query("SELECT recipe_id FROM `Like` WHERE account_id = :accountId")
    fun getFavouriteRecipeIds(accountId: String): Flow<List<String>>

    @Transaction
    @Query("SELECT * FROM Recipe WHERE _id IN (:recipeIds)")
    fun getRecipes(recipeIds: List<String>): Flow<List<RecipeAndOwner>>

    @Transaction
    @Query("SELECT * FROM `Like` WHERE account_id = :accountId")
    fun getFavouriteRecipes(accountId: String): Flow<List<LikeAndRecipe>>

    @Transaction
    @Query("SELECT * FROM Recent WHERE account_id = :accountId")
    fun getAllRecent(accountId: String): Flow<List<RecentAndRecipe>>


    @Query("SELECT * FROM Ingredient WHERE _id = :ingredientId")
    suspend fun getIngredientById(ingredientId: String): IngredientEntity?

    @Transaction
    @Insert
    suspend fun insertContains(it: List<RecipeIngredientCrossRef>)

    @Transaction
    @Insert
    suspend fun insertSteps(it: List<StepEntity>)


    @Transaction
    @Query("SELECT * FROM Recipe WHERE title LIKE '%' || :searchText || '%'")
    suspend fun searchRecipe(searchText: String): List<RecipeAndOwner>

    @Transaction
    @Query("SELECT * FROM Ingredient WHERE name LIKE '%' || :searchText || '%'")
    suspend fun searchRecipesByIngredient(searchText: String): IngredientInRecipe?


    @Transaction
    @Query("SELECT * FROM Ingredient WHERE name LIKE '%' || :searchText || '%'")
    suspend fun searchIngredient(searchText: String): List<IngredientEntity>
}
