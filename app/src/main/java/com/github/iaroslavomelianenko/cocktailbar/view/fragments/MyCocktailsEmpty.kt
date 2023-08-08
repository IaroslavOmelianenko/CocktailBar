package com.github.iaroslavomelianenko.cocktailbar.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.iaroslavomelianenko.cocktailbar.R
import com.github.iaroslavomelianenko.cocktailbar.databinding.FragmentMyCocktailsEmptyBinding
import kotlinx.android.synthetic.main.activity_main.*


class MyCocktailsEmpty : Fragment() {

    lateinit var _binding: FragmentMyCocktailsEmptyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyCocktailsEmptyBinding.inflate(inflater)

        // Fab add button
        _binding.fabAddCocktailEmpty.setOnClickListener {
            findNavController().navigate(R.id.action_myCocktailsEmpty_to_addCocktail)
        }
        return _binding.root
    }
}