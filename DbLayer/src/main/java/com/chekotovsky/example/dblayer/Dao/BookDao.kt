package com.chekotovsky.example.dblayer.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.chekotovsky.example.dblayer.Models.Book

@Dao
interface BookDao {
    @Insert
    suspend fun addBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Query("SELECT * FROM books")
    fun readAll() : LiveData<List<Book>>
    @Delete
    suspend fun deleteBook(book: Book)
}