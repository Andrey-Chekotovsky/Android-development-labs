package com.chekotovsky.example.dblayer.Dao

import androidx.lifecycle.LiveData
import com.chekotovsky.example.dblayer.Models.Book

class BookRepository(private val bookDao: BookDao) {
    val data: LiveData<List<Book>> =  bookDao.readAll()

    suspend fun addBook(book: Book){
        bookDao.addBook(book)
    }
    suspend fun updateBook(book: Book){
        bookDao.updateBook(book)
    }
    suspend fun deleteBook(book: Book){
        bookDao.deleteBook(book)
    }

}