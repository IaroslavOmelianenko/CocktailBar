package com.github.iaroslavomelianenko.cocktailbar.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.iaroslavomelianenko.cocktailbar.R
import com.github.iaroslavomelianenko.cocktailbar.data.model.Cocktail
import com.github.iaroslavomelianenko.cocktailbar.data.viewmodels.CocktailViewModel
import com.github.iaroslavomelianenko.cocktailbar.databinding.FragmentUpdateCocktailBinding


class UpdateCocktail : Fragment() {

    private lateinit var _binding: FragmentUpdateCocktailBinding
    private val args by navArgs<CocktailDetailsArgs>()
    private lateinit var cocktailViewModel: CocktailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateCocktailBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cocktailViewModel = ViewModelProvider(this).get(CocktailViewModel::class.java)

        _binding.etlCocktailTitleUpdate.setText(args.currentCocktail.name)
        _binding.etCocktailDescriptionUpdate.setText(args.currentCocktail.description)
        _binding.etCocktailRecipeUpdate.setText(args.currentCocktail.recipe)

        _binding.bUpdate.setOnClickListener {
            updateItem()
        }
    }

    private fun updateItem(){
        val title = _binding.etlCocktailTitleUpdate.text.toString()
        val description = _binding.etCocktailDescriptionUpdate.text.toString()
        //val ingredients
        val recipe = _binding.etCocktailRecipeUpdate.text.toString()

        if (!title.isNullOrBlank()){
            //Create updated cocktail object
            val cocktail = Cocktail(0, title, description, recipe)

            //Update cocktail in database
            cocktailViewModel.updateCocktail(cocktail)
            Toast.makeText(requireContext(), R.string.cocktail_updated, Toast.LENGTH_LONG).show()

            //Navigate back
            findNavController().navigate(R.id.action_updateCocktail_to_myCocktails)
        }
        else{
            Toast.makeText(
                requireContext(),
                R.string.cocktail_needs_a_title,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}