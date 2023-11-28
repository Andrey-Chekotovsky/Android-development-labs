package com.chekotovsky.example.dblayer.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chekotovsky.example.dblayer.Dao.BookDao
import com.chekotovsky.example.dblayer.Models.Book

@Database(entities = [Book::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao() : BookDao;

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null;

        fun getDatabase(context: Context) : AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}