package com.vanbui.recipely.core.testing.di

import com.vanbui.recipely.core.data.di.RepositoryModule
import com.vanbui.recipely.core.data.impl.AccountRepositoryImpl
import com.vanbui.recipely.core.data.repository.AccountRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

//@Module
//@TestInstallIn(
//    components = [SingletonComponent::class],
//    replaces = [RepositoryModule::class]
//)
//abstract class RepositoryTestModule {
//    @Binds
//    abstract fun bindAccountRepository(
//        accountRepositoryImpl: AccountRepositoryImpl
//    ): AccountRepository
//}