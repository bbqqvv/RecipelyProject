package com.vanbui.recipely.core.database

import com.vanbui.recipely.core.database.dao.NotificationDao
import com.vanbui.recipely.core.database.dao.OrderDao
import com.vanbui.recipely.core.database.dao.RecipeDao
import com.vanbui.recipely.core.database.dao.AccountDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Singleton
    @Provides
    fun provideAccountDao(db: RecipelyDatabase): AccountDao = db.accountDao

    @Singleton
    @Provides
    fun provideRecipeDao(db: RecipelyDatabase): RecipeDao = db.recipeDao

    @Singleton
    @Provides
    fun provideOrderDao(db: RecipelyDatabase): OrderDao = db.orderDao

    @Singleton
    @Provides
    fun provideNotificationDao(db: RecipelyDatabase): NotificationDao =
        db.notificationDao
}