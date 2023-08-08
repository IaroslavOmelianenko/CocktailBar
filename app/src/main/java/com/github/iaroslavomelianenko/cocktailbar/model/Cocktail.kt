package com.github.iaroslavomelianenko.cocktailbar.model

data class Cocktail (
    val name: String,
    val description: String,
    val ingredients: List<String>,
    val recipe: String
)
