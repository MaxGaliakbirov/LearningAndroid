package com.example.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.i("MyLog", "Start function \"onStart\"")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MyLog", "Start function \"onResume\"")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MyLog", "Start function \"onPause\"")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MyLog", "Start function \"onStop\"")
    }
}

