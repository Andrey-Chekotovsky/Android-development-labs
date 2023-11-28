package com.chekotovsky.example.bookapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GithubFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GithubFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_github, container, false)
        var navController = NavHostFragment.findNavController(this)
        var backButton: Button = view.findViewById(R.id.back_button)
        backButton.setOnClickListener{
            navController.navigate(R.id.action_githubFragment_to_detailsFragment)
        }

        return view
    }

}