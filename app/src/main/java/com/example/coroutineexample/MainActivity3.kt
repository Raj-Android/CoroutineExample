package com.example.coroutineexample
// launch and async
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val job= CoroutineScope(Dispatchers.Main).launch {
             printFollower()
       }
    }

    private suspend fun printFollower() {
        var fbFollower=0
        var instaFollower=0
       val job= CoroutineScope(Dispatchers.IO).launch {
            fbFollower = getFbFollowers()
        }
        val job2= CoroutineScope(Dispatchers.IO).launch {
            instaFollower = getInstaFollowers()
        }
        job.join()
        job2.join()
//        Log.d("Kotlin Flow -->",fbFollower.toString())
        Log.d("Kotlin Flow","FB Follower-->$fbFollower,Insta Follower -->$instaFollower")
    }

     //Another way to write above function using async
//     private suspend fun printFollower() {
//
//         val job= CoroutineScope(Dispatchers.IO).async{
//             getFbFollowers()
//         }
//         Log.d("Kotlin Flow -->",job.await().toString())
//     }



    //Let suppose this function hit api and return FB Followers 54
    private suspend fun getFbFollowers():Int{
        delay(1000)
        return 54
    }
    //Let suppose this function hit api and return Instagram Followers 113
    private suspend fun getInstaFollowers():Int{
        delay(1000)
        return 113
    }

 }