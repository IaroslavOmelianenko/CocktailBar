package com.github.iaroslavomelianenko.cocktailbar.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.github.iaroslavomelianenko.cocktailbar.R
import com.github.iaroslavomelianenko.cocktailbar.data.model.Cocktail
import com.github.iaroslavomelianenko.cocktailbar.data.viewmodels.CocktailViewModel
import com.github.iaroslavomelianenko.cocktailbar.databinding.FragmentAddCocktailBinding

class AddCocktail : Fragment() {

    private lateinit var _binding: FragmentAddCocktailBinding
    private lateinit var cocktailViewModel: CocktailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddCocktailBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cocktailViewModel = ViewModelProvider(this).get(CocktailViewModel::class.java)

        _binding.bSave.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val title = _binding.etlCocktailTitle.text.toString()
        val description = _binding.etCocktailDescription.text.toString()
        //val ingredients
        val recipe = _binding.etCocktailRecipe.text.toString()

        if (!title.isNullOrBlank()){
            //Create cocktail object
            val cocktail = Cocktail(0, title, description, recipe)

            //Add cocktail to database
            cocktailViewModel.addCocktail(cocktail)
            Toast.makeText(requireContext(), R.string.cocktail_added, Toast.LENGTH_LONG).show()

            //Navigate back
            findNavController().navigate(R.id.action_addCocktail_to_myCocktails)
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