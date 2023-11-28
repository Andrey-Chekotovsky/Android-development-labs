package com.chekotovsky.example.bookapplication

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main2, container, false)
        val quitButton: Button = view.findViewById(R.id.quit_button)
        var navController = NavHostFragment.findNavController(this)
//        var navController = Navigation.findNavController(view)
        quitButton.setOnClickListener{
            System.exit(0)
        }
        var gitButton: Button = view.findViewById(R.id.about_button)
        gitButton.setOnClickListener{
            navController.navigate(R.id.action_mainFragment4_to_detailsFragment)
        }
        var booksButton: Button = view.findViewById(R.id.book_list_button)
        booksButton.setOnClickListener{
            navController.navigate(R.id.action_mainFragment4_to_bookListFragment)
        }
        return view;
    }
}