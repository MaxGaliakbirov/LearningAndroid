package com.example.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.learning.constance.Constance
import com.example.learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit private var bindingClass : ActivityMainBinding
    private var login: String = "empty" //переменная не будет доступна из других классов
    private var password: String = "empty"
    private var name: String = "empty"
    private var secondName: String = "empty"
    private var thridName: String = "empty"
    private var avatarImageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constance.REQUEST_CODE_SIGN_IN) {

            val loginIntent = data?.getStringExtra(Constance.LOGIN)
            val passwordIntent = data?.getStringExtra(Constance.PASSWORD)
            if (login == loginIntent && password == passwordIntent){
                bindingClass.imAvatar.setImageResource(avatarImageId)
                val textInfo = "$name $secondName $thridName"
                bindingClass.tvInfo.text = textInfo
            } else {
                bindingClass.tvInfo.text = "Нет такого аккаунта"
            }

        } else if (requestCode == Constance.REQUEST_CODE_SIGN_UP) {

            login = data?.getStringExtra(Constance.LOGIN).toString()
            password = data?.getStringExtra(Constance.PASSWORD).toString()
            name = data?.getStringExtra(Constance.NAME).toString()
            secondName = data?.getStringExtra(Constance.SECOND_NAME).toString()
            thridName = data?.getStringExtra(Constance.THRID_NAME).toString()
            avatarImageId = data?.getIntExtra(Constance.AVATAR_ID, 0)!!
            bindingClass.tvInfo.visibility = View.VISIBLE
            val textInf = "$name " //$secondName $thridName

            bindingClass.tvInfo.text = textInf

            bindingClass.buttonSignUp.visibility = View.INVISIBLE
            bindingClass.imAvatar.visibility = View.VISIBLE
            bindingClass.buttonSingIn.text = getString(R.string.button_sign_in_exit)
        }
    }

    fun onClickSignIn(view: View) {
        val intent = Intent(this, SignInUpAct::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
    }
    fun onClickSignUp(view: View) {
        val intent = Intent(this, SignInUpAct::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)
    }
}


