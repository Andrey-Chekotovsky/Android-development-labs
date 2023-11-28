package com.chekotovsky.example.bookapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chekotovsky.example.bookapplication.Adapters.BooksAdapter
import com.chekotovsky.example.servicelayer.ViewModels.BookViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookListFragment : Fragment() {
    private lateinit var bookViewModel: BookViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_book_list, container, false)
        var progressBar: ProgressBar = view.findViewById(R.id.load)
        progressBar.visibility = View.VISIBLE
        var context: Context = this.requireContext()

        var navController = NavHostFragment.findNavController(this)

        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            if (bookViewModel.needToUpdate) {
                delay(3000L)
                bookViewModel.needToUpdate = false
            }
            val bookList: RecyclerView = view.findViewById(R.id.book_list)
            bookList.layoutManager = LinearLayoutManager(context)
            var adapter = BooksAdapter(bookViewModel)
            bookViewModel.data.observe(viewLifecycleOwner, Observer { books ->
                adapter.setData(books)
            })
            bookList.adapter = adapter

            progressBar.visibility = View.GONE
        }

        var backButton: Button = view.findViewById(R.id.back_button)
        backButton.setOnClickListener{
            bookViewModel.reload()
            navController.navigate(R.id.action_bookListFragment_to_mainFragment4)
        }
        var addButton: Button = view.findViewById(R.id.add_button)
        addButton.setOnClickListener{
            navController.navigate(R.id.action_bookListFragment_to_fillBookInfoFragment)
        }
        return view
    }

}