package com.github.iaroslavomelianenko.cocktailbar.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.github.iaroslavomelianenko.cocktailbar.R
import com.github.iaroslavomelianenko.cocktailbar.data.viewmodels.CocktailViewModel
import com.github.iaroslavomelianenko.cocktailbar.databinding.FragmentMyCocktailsBinding
import com.github.iaroslavomelianenko.cocktailbar.service.CocktailsListAdapter

class MyCocktails : Fragment() {

    lateinit var _binding: FragmentMyCocktailsBinding
    lateinit var cocktailViewModel: CocktailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyCocktailsBinding.inflate(inflater)

        // Fab add button
        _binding.fabAddCocktail.setOnClickListener {
            findNavController().navigate(R.id.action_myCocktails_to_addCocktail)
        }

        // RecyclerView
        val adapter = CocktailsListAdapter()
        val recyclerView = _binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        // CocktailViewModel
        cocktailViewModel = ViewModelProvider(this).get(CocktailViewModel::class.java)


        cocktailViewModel.readAllData.observe(viewLifecycleOwner, Observer { cocktail ->
            //If there is no data, navigate to MyCocktailsEmpty fragment
            if (adapter.checkDataIsEmpty(cocktail)) findNavController().navigate(R.id.action_myCocktails_to_myCocktailsEmpty)
            else adapter.setData(cocktail)
        })

        return _binding.root
    }
}