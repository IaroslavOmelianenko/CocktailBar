package com.github.iaroslavomelianenko.cocktailbar.data.database

import androidx.lifecycle.LiveData
import com.github.iaroslavomelianenko.cocktailbar.data.model.Cocktail

class CocktailRepository (private val cocktailDao: CocktailDao) {
    val readAllData: LiveData<List<Cocktail>> = cocktailDao.readAllData()

    suspend fun addCocktail(cocktail: Cocktail){
        cocktailDao.addCocktail(cocktail)
    }

    suspend fun updateCocktail(cocktail: Cocktail) {
        cocktailDao.updateCocktail(cocktail)
    }

    fun deleteCocktail(cocktail: Cocktail){
        cocktailDao.deleteCocktail(cocktail)
    }

    suspend fun deleteAllCocktails(){
        cocktailDao.deleteAllCocktails()
    }
}