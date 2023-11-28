package com.chekotovsky.example.bookapplication


import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

//import org.koin.android.ext.koin.androidContext
//import org.koin.core.context.startKoin

class BookApplicationActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        startKoin{
            androidContext(applicationContext)
            modules()
        }
        setContentView(R.layout.main_activity)
    }
}