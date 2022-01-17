package com.example.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.learning.constance.Constance
import com.example.learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.btResult.setOnClickListener{
            val resultValue = bindingClass.edValue.text.toString()
            when(resultValue){
                Constance.DIRECTOR -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val textTemp = "Ваша зарплата ${Constance.DIRECTOR_SALARY}"
                    bindingClass.tvResult.text = if (bindingClass.edPassword.text.toString() == Constance.DIRECTOR_PASSWORD) {
                    textTemp
                    } else {
                        "Не верный пароль"
                    }
                }
                Constance.ENGINEER -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val textTemp = "Ваша зарплата ${Constance.ENGINEER_SOLARY}"
                    bindingClass.tvResult.text = if (bindingClass.edPassword.text.toString() == Constance.ENGINEER_PASSWORD) {
                        textTemp
                    } else {
                        "Не верный пароль"
                    }
                }
                Constance.DEV -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val textTemp = "Ваша зарплата ${Constance.DEV_SOLARY}"
                    bindingClass.tvResult.text = if (bindingClass.edPassword.text.toString() == Constance.DEV_PASSWORD) {
                        textTemp
                    } else {
                        "Не верный пароль"
                    }
                }
                else -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    bindingClass.tvResult.text = getText(R.string.tvResultTo100000)
                }
            }
        }
    }

}


