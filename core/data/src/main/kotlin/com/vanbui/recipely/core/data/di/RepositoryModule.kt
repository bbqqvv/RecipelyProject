package com.vanbui.recipely.core.data.di

import com.vanbui.recipely.core.data.impl.AccountRepositoryImpl
import com.vanbui.recipely.core.data.impl.CartRepositoryImpl
import com.vanbui.recipely.core.data.impl.NotificationRepositoryImpl
import com.vanbui.recipely.core.data.impl.RecipeRepositoryImpl
import com.vanbui.recipely.core.data.repository.AccountRepository
import com.vanbui.recipely.core.data.repository.CartRepository
import com.vanbui.recipely.core.data.repository.NotificationRepository
import com.vanbui.recipely.core.data.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAccountRepository(
        accountRepositoryImpl: AccountRepositoryImpl
    ): AccountRepository

    @Binds
    abstract fun bindRecipeRepository(
        recipeRepositoryImpl: RecipeRepositoryImpl
    ): RecipeRepository

    @Binds
    abstract fun bindCartRepository(
        cartRepositoryImpl: CartRepositoryImpl
    ): CartRepository

    @Binds
    abstract fun bindNotificationRepository(
        notificationRepositoryImpl: NotificationRepositoryImpl
    ): NotificationRepository
}