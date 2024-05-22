package com.anbui.recipely.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
//
//val MIGRATION_1_2: Migration = object : Migration(1, 2) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        // Thực hiện các thao tác migration cần thiết, ví dụ:
//        // database.execSQL("ALTER TABLE your_table ADD COLUMN new_column INTEGER NOT NULL DEFAULT 0");
//    }
//}
//
//// Sau đó, thêm migration này vào trình xây dựng cơ sở dữ liệu:
//var db: RecipelyDatabase =
//    databaseBuilder(getApplicationContext(), AppDatabase::class.java, "your_database")
//        .addMigrations(MIGRATION_1_2)
//        .build()

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context) =
        Room
            .databaseBuilder(
                appContext,
                RecipelyDatabase::class.java,
                "Recipely.sqlite"
            )
            .createFromAsset("recipely.sqlite")
//            .fallbackToDestructiveMigration() // todo remove
            .build()
}

