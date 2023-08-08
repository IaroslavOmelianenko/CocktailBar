package com.github.iaroslavomelianenko.cocktailbar.data.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.iaroslavomelianenko.cocktailbar.data.database.CocktailRepository
import com.github.iaroslavomelianenko.cocktailbar.data.database.CocktailsDatabase
import com.github.iaroslavomelianenko.cocktailbar.data.model.Cocktail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CocktailViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Cocktail>>
    private val repository: CocktailRepository

    init {
        val cocktailDao = CocktailsDatabase.getDatabase(application).cocktailDao()
        repository = CocktailRepository(cocktailDao)
        readAllData = repository.readAllData
    }

    fun addCocktail(cocktail: Cocktail){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCocktail(cocktail)
        }
    }

    fun updateCocktail(cocktail: Cocktail){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCocktail(cocktail)
        }
    }

    fun deleteCocktail(cocktail: Cocktail){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCocktail(cocktail)
        }
    }

    fun deleteAllCocktail(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCocktails()
        }
    }
}