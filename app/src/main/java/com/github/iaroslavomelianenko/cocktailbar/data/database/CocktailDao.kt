package com.github.iaroslavomelianenko.cocktailbar.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.github.iaroslavomelianenko.cocktailbar.data.model.Cocktail

@Dao
interface CocktailDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //ignore, if cocktail already exists
    suspend fun addCocktail(cocktail: Cocktail)

    @Query("SELECT * FROM cocktails_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Cocktail>>

    @Update
    suspend fun updateCocktail(cocktail: Cocktail)

    @Delete
    fun deleteCocktail(cocktail: Cocktail)

    @Query("DELETE FROM cocktails_table")
    suspend fun deleteAllCocktails()
}