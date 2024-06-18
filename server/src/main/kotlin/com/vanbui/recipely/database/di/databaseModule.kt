package com.vanbui.recipely.database.di

import com.vanbui.recipely.database.objects.article.DAOFacade
import com.vanbui.recipely.database.objects.article.DAOFacadeImpl
import com.vanbui.recipely.database.objects.recipe.RecipeDao
import com.vanbui.recipely.database.objects.recipe.RecipeDaoImpl
import kotlinx.coroutines.runBlocking
import org.koin.dsl.module

val databaseModule = module {
    single<DAOFacade> {
        DAOFacadeImpl().apply {
            runBlocking {
                if (allArticles().isEmpty()) {
                    addNewArticle("The drive to develop!", "...it's what keeps me going.")
                }
            }
        }
    }
    single<RecipeDao> {
        RecipeDaoImpl()
    }
}