package com.chekotovsky.example.dblayer.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "books")
data class Book (
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    var name: String,
    var author: String,
    var genre: String,
    var yearOfIssue: Int,
    var image: String? ) : Serializable {
    constructor(name: String, author: String, genre: String, yearOfIssue: Int) :
    this(null, name, author, genre, yearOfIssue, null){}
    constructor(name: String, author: String, genre: String, yearOfIssue: Int, image: String) :
            this(null, name, author, genre, yearOfIssue, image){}
    constructor(id: Int, name: String, author: String, genre: String, yearOfIssue: Int) :
            this(id, name, author, genre, yearOfIssue, null){}
}