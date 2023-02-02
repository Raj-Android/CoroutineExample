package com.example.coroutineexample
//withContext function
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.math.log

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        CoroutineScope(Dispatchers.Main).launch {
            //execute()
            executing()
        }
    }

    private suspend fun execute() {
        Log.d("Kotlin", "Before")
        GlobalScope.launch {
            delay(1000)
            Log.d("Kotlin", "Inside")
        }
        Log.d("Kotlin", "After")
    }

    private suspend fun executing() {
        Log.d("Kotlin", "Before")
        //Here we can block the coroutine using withContext function
       withContext(Dispatchers.IO){
            delay(1000)
            Log.d("Kotlin", "Inside")
        }
        Log.d("Kotlin", "After")
    }
}