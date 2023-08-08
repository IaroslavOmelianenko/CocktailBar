package com.github.iaroslavomelianenko.cocktailbar.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.iaroslavomelianenko.cocktailbar.R
import com.github.iaroslavomelianenko.cocktailbar.databinding.FragmentMyCocktailsBinding

class MyCocktails : Fragment() {

    lateinit var _binding: FragmentMyCocktailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyCocktailsBinding.inflate(inflater)

        _binding.fabAddCocktail.setOnClickListener {
            findNavController().navigate(R.id.action_myCocktails_to_addCocktail)
        }

        return _binding.root
    }
}