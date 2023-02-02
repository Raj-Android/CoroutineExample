package com.example.coroutineexample
//Job Hierarchy
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity5 : AppCompatActivity() {
    private var TAG: String = "KotlinIsFun"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        GlobalScope.launch(Dispatchers.Main) {
            // executing()
            executed()
        }
    }
    /* private suspend fun executing() {
         val parentJob=GlobalScope.launch(Dispatchers.Main){
             Log.d(TAG,"Parent Started")

             val childJob=launch {
                 Log.d(TAG,"Child Started")
                 delay(5000)
                 Log.d(TAG,"Child Ended")

             }
             delay(3000)
            // childJob.cancel() //here we manually cancel child coroutine
             Log.d(TAG,"Parent Ended")
         }
         //Suppose user press back button after one sec
         //delay(1000)
         //parentJob.cancel()
         parentJob.join()
         Log.d(TAG,"Parent Completed")
     } */

    private suspend fun executed() {
        val parentJob = CoroutineScope(Dispatchers.IO).launch{

            for (i in 1..1000) {
                if (isActive) {
                    executeLongRunningTask()
                    Log.d(TAG, i.toString())
                }
            }
        }
        delay(100)
        Log.d(TAG, "Cancel Job")
        parentJob.cancel()
        parentJob.join()
        Log.d(TAG, "Parent Job Completed")
    }

    private fun executeLongRunningTask() {
        for (i in 1..10000000) {
        }
    }
}