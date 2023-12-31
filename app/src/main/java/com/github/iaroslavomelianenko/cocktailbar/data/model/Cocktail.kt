package com.github.iaroslavomelianenko.cocktailbar.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cocktails_table")
data class Cocktail (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    //val ingredients: String,
    val recipe: String
): Parcelable
