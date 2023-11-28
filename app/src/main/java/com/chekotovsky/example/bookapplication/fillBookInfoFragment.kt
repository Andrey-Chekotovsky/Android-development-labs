package com.chekotovsky.example.bookapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.chekotovsky.example.dblayer.Models.Book
import com.chekotovsky.example.servicelayer.ViewModels.BookViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fillBookInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class fillBookInfoFragment : Fragment() {
    private lateinit var bookViewModel: BookViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fill_book_info, container, false)
        super.onCreate(savedInstanceState)
        var nameField: EditText = view.findViewById(R.id.name_field)
        var authorField: EditText = view.findViewById(R.id.full_author_name_field)
        var genreField: EditText = view.findViewById(R.id.genre_field)
        var yearField: EditText = view.findViewById(R.id.year_field)
        var submitButton: Button = view.findViewById(R.id.submit_button)
        var addImageButton: Button = view.findViewById(R.id.image_add_button)
        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        var navController = NavHostFragment.findNavController(this)

        submitButton.setOnClickListener{
            if (!notEmpty(nameField, authorField, genreField, yearField)){
                Toast.makeText(this.requireContext(), "Not all fields filled", Toast.LENGTH_LONG).show()
            } else {
                bookViewModel.addBook(formBook(nameField, authorField, genreField, yearField))
                navController.navigate(R.id.action_fillBookInfoFragment_to_bookListFragment)
            }
        }

        var backButton: Button = view.findViewById(R.id.back_button)
        backButton.setOnClickListener{
            navController.navigate(R.id.action_fillBookInfoFragment_to_bookListFragment)
        }
        return view
    }
    fun notEmpty(nameField: EditText, authorField: EditText,
                 genreField: EditText, yearField: EditText): Boolean{
        if (nameField.text.toString().isEmpty() || authorField.text.toString().isEmpty() ||
            genreField.text.toString().isEmpty() || yearField.text.toString().isEmpty()) {
            return false
        } else {
            return true
        }
    }
    fun formBook(nameField: EditText, authorField: EditText,
                 genreField: EditText, yearField: EditText): Book {
        var book = Book(nameField.text.toString(), authorField.text.toString(),
            genreField.text.toString(), yearField.text.toString().toInt())
        return book
    }
}