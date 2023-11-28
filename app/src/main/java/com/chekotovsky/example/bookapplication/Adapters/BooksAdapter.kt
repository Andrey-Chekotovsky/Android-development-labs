package com.chekotovsky.example.bookapplication.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.chekotovsky.example.bookapplication.BookListFragmentDirections
import com.chekotovsky.example.bookapplication.R
import com.chekotovsky.example.dblayer.Dao.BookRepository
import com.chekotovsky.example.dblayer.Models.Book
import com.chekotovsky.example.servicelayer.ViewModels.BookViewModel

class BooksAdapter(val bookViewModel: BookViewModel)
    : RecyclerView.Adapter<BooksAdapter.BookViewHolder>()
{
    var books = emptyList<Book>()
    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nameView: TextView = view.findViewById(R.id.name)
        val authorNameView: TextView = view.findViewById(R.id.author_name)
        val genreView: TextView = view.findViewById(R.id.genre)
        val deleteButton: Button = view.findViewById(R.id.delete_button)
        val editButton: Button = view.findViewById(R.id.edit_button)
//        val imageView: ImageView = view.findViewById(R.id.book_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.book_view , parent, false)

        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.count()
    }


    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentItem = books[position]
        holder.deleteButton.setOnClickListener {
            bookViewModel.deleteBook(currentItem)
            notifyDataSetChanged()
        }
        holder.editButton.setOnClickListener {
            val action = BookListFragmentDirections.actionBookListFragmentToRedactBookFragment(currentItem)
            holder.itemView.findNavController().navigate(action)

        }
        holder.authorNameView.text = currentItem.author
        holder.genreView.text = currentItem.genre
        holder.nameView.text = currentItem.name
    }
    fun setData(books: List<Book>){
        this.books = books
        notifyDataSetChanged()
    }
}