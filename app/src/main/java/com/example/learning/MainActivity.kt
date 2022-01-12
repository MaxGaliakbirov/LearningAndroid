package com.example.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var tvNull: TextView? = null //глобальная переменная, инициализированная со значением null,
                            // иначе не получится добавить эту глобальную переменную
    lateinit var tvLate: TextView //глоб переменная, но без значения null
    //TextView это класс
    lateinit var bt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tv:TextView = findViewById(R.id.tvTest)
        tv.text = "fuckfuck"
        tvNull = findViewById(R.id.tvTest)
        tvNull?.text = "Fuck 2"
    }

    override fun onStart() {
        super.onStart()
        Log.i("MyLog", "Start function \"onStart\"")
        bt = findViewById(R.id.bTest)
        bt.setOnClickListener{
            tvLate.text = "OMG!"
        }

    }

    override fun onResume() {
        super.onResume()
        Log.i("MyLog", "Start function \"onResume\"")
        tvLate = findViewById(R.id.tvTest)

    }

    override fun onPause() {
        super.onPause()
        Log.i("MyLog", "Start function \"onPause\"")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MyLog", "Start function \"onStop\"")
    }
    fun onClickStart(view: View) { tvLate.text = "fuckfuckFUCK" }

}


