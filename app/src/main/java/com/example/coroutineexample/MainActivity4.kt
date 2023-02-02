package com.example.coroutineexample
//Job Hierarchy
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        GlobalScope.launch(Dispatchers.Main) {
            execute()
        }
    }

    private suspend fun execute() {
        val parentJob = GlobalScope.launch(Dispatchers.Main) {
            Log.d("Kotlin Flow -->", "Parent -$coroutineContext")

            /* //here we do not need to write context particularly childJob inherit its parents context
              val childJob=launch{
              Log.d("Kotlin Flow -->","Child -$coroutineContext")
              }
             */

            //we can override parents context by write manually
            val childJob = launch(Dispatchers.IO) {
                Log.d("Kotlin Flow -->", "Child -$coroutineContext")
            }
        }
    }

}