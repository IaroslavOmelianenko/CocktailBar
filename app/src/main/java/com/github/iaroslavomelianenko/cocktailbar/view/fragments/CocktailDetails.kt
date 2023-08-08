package com.github.iaroslavomelianenko.cocktailbar.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.iaroslavomelianenko.cocktailbar.R
import com.github.iaroslavomelianenko.cocktailbar.data.viewmodels.CocktailViewModel
import com.github.iaroslavomelianenko.cocktailbar.databinding.FragmentCocktailDetailsBinding

class CocktailDetails : Fragment() {

    private lateinit var _binding: FragmentCocktailDetailsBinding
    private val args by navArgs<CocktailDetailsArgs>()
    private lateinit var cocktailViewModel: CocktailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCocktailDetailsBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cocktailViewModel = ViewModelProvider(this).get(CocktailViewModel::class.java)

        _binding.tvCocktailTitleDetails.setText(args.currentCocktail.name)
        _binding.tvCocktailDescriptionDetails.setText(args.currentCocktail.description)
        _binding.tvCocktailRecipeDetails.setText(args.currentCocktail.recipe)

        _binding.bEdit.setOnClickListener {
            val action = CocktailDetailsDirections.actionCocktailDetailsToUpdateCocktail(args.currentCocktail)
            findNavController().navigate(action)
        }
    }

}