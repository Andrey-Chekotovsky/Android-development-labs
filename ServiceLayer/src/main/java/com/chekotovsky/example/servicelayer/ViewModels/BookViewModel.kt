package com.chekotovsky.example.servicelayer.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.chekotovsky.example.dblayer.Dao.BookRepository
import com.chekotovsky.example.dblayer.Database.AppDatabase
import com.chekotovsky.example.dblayer.Models.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {
    val data: LiveData<List<Book>>
    private val repository: BookRepository
    var needToUpdate: Boolean = true

    init {
        val bookDao = AppDatabase.getDatabase(application).bookDao()
        repository = BookRepository(bookDao)
        data = repository.data
    }

    fun addBook(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBook(book)
        }
    }
    fun updateBook(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBook(book)
        }
    }
    fun deleteBook(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBook(book)
        }
    }
    fun reload() {
        needToUpdate = true
    }

}