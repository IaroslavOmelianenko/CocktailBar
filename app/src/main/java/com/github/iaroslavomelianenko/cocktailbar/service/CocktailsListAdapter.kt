package com.github.iaroslavomelianenko.cocktailbar.service

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.iaroslavomelianenko.cocktailbar.R
import com.github.iaroslavomelianenko.cocktailbar.data.model.Cocktail
import com.github.iaroslavomelianenko.cocktailbar.databinding.CocktailItemBinding
import com.github.iaroslavomelianenko.cocktailbar.view.fragments.MyCocktails
import com.github.iaroslavomelianenko.cocktailbar.view.fragments.MyCocktailsDirections

class CocktailsListAdapter : RecyclerView.Adapter<CocktailsListAdapter.CocktailsViewHolder>() {

    private var cocktailsList = emptyList<Cocktail>()

    class CocktailsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val _binding = CocktailItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailsViewHolder {
        return CocktailsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cocktail_item, parent,false))
    }

    override fun onBindViewHolder(holder: CocktailsViewHolder, position: Int) {
        val currentItem = cocktailsList[position]

        holder._binding.tvCocktailCard.text = currentItem.name
        holder._binding.tvCocktailCard.setBackgroundResource(R.drawable.mohito)

        holder._binding.clCocktailItem.setOnClickListener{
            val action = MyCocktailsDirections.actionMyCocktailsToCocktailDetails(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return cocktailsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(cocktail: List<Cocktail>) {
        this.cocktailsList = cocktail
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun checkDataIsEmpty(cocktail: List<Cocktail>): Boolean {
        this.cocktailsList = cocktail
        notifyDataSetChanged()
        return cocktailsList.isEmpty()
    }
}