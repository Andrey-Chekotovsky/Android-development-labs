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
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_details, container, false)

        var navController = NavHostFragment.findNavController(this)

        var backButton: Button = view.findViewById(R.id.back_button)
        backButton.setOnClickListener {
            navController.navigate(R.id.action_detailsFragment_to_mainFragment4)
        }
        val aboutUsButton: Button = view.findViewById(R.id.about_us_button)
        aboutUsButton.setOnClickListener {
            navController.navigate(R.id.action_detailsFragment_to_aboutUsFragment)
        }
        var guitButton: Button = view.findViewById(R.id.git_button)
        guitButton.setOnClickListener {
            navController.navigate(R.id.action_detailsFragment_to_githubFragment)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}