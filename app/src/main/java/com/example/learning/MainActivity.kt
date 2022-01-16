package com.example.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindClass.root)

        bindClass.bTest.setOnClickListener {
            bindClass.tvTest.text = "123123132"
        }
    }
}


