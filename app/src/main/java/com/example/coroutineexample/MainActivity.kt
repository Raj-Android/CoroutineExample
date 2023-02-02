package com.example.coroutineexample
//Difference Between Thread and Coroutine
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var counterText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText=findViewById(R.id.counter)
        Log.d("Hello","${Thread.currentThread().name}")
    }
    fun updateCounter(view: View){
        Log.d("Hello","${Thread.currentThread().name}")
        counterText.text="${counterText.text.toString().toInt()+1}"
    }
    private fun executeLongRunningTask(){
        for (i in 1..1000000000){
            Log.d("TAG==>","$i")
        }
    }

    fun doActionOnMainThread(view: View) {
        executeLongRunningTask()
    }

    //Here we are uses Thread
//    fun doActionOnOther(view: View) {
//        thread(start = true) {
//            executeLongRunningTask()
//        }
//    }

    //Here we are uses Coroutine
    //Now when we click on ExecuteTaskOnOtherThread BUTTON then three coroutine are launch
    fun doActionOnOther(view: View) {
        //here we make three coroutine
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("Kotlin Flow -->1","${Thread.currentThread().name}")
            executeLongRunningTask()
        }
//        GlobalScope.launch(Dispatchers.Main){
//            Log.d("Kotlin Flow -->2","${Thread.currentThread().name}")
//        }
//
//        MainScope().launch(Dispatchers.Default){
//            Log.d("Kotlin Flow -->3","${Thread.currentThread().name}")
//        }
    }



}