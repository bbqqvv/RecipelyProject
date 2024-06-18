package com.vanbui.recipely.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vanbui.recipely.core.database.converter.LocalDateTimeConverter
import com.vanbui.recipely.core.database.converter.UnitTypeConverter
import com.vanbui.recipely.core.database.dao.AccountDao
import com.vanbui.recipely.core.database.dao.NotificationDao
import com.vanbui.recipely.core.database.dao.OrderDao
import com.vanbui.recipely.core.database.dao.RecipeDao
import com.vanbui.recipely.core.database.entities.*

@Database(
    version = 1,
    entities = [
        RecipeEntity::class,
        AccountEntity::class,
        IngredientEntity::class,
        StepEntity::class,
        LikeEntity::class,
        RecentEntity::class,
        OrderEntity::class,
        OrderStatusEntity::class,
        RecipeIngredientCrossRef::class,
        IngredientAccountCrossRef::class,
        OrderIngredientCrossRef::class, // Đảm bảo entity này được thêm vào
        NotificationEntity::class
    ],
    exportSchema = false
)
@TypeConverters(LocalDateTimeConverter::class, UnitTypeConverter::class)
abstract class RecipelyDatabase : RoomDatabase() {
    abstract val accountDao: AccountDao
    abstract val recipeDao: RecipeDao
    abstract val orderDao: OrderDao
    abstract val notificationDao: NotificationDao
}
