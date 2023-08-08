package com.github.iaroslavomelianenko.cocktailbar.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room

import androidx.room.RoomDatabase
import com.github.iaroslavomelianenko.cocktailbar.data.model.Cocktail

@Database(entities = [Cocktail::class], version = 1, exportSchema = false)
abstract class CocktailsDatabase : RoomDatabase() {

    abstract fun cocktailDao(): CocktailDao

    companion object {
        @Volatile
        private var INSTANCE: CocktailsDatabase? = null

        fun getDatabase(context: Context): CocktailsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CocktailsDatabase::class.java,
                    "cocktails_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}