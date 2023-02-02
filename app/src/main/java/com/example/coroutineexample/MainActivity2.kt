package com.example.coroutineexample
//How to make a suspend function
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }
        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }
    }
     suspend fun task1(){
        Log.d("Kotlin Flow -->","Starting Task 1")
         //yield()
         delay(3000)
        Log.d("Kotlin Flow -->","Ending Task 1")
    }
    suspend fun task2(){
        Log.d("Kotlin Flow -->","Starting Task 2")
        yield()
//        delay(3000)
        Log.d("Kotlin Flow -->","Ending Task 2")
    }
}