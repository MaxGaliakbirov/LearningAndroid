package com.example.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.learning.constance.Constance
import com.example.learning.databinding.ActivitySignInUpBinding

class SignInUpAct : AppCompatActivity() {
    lateinit var bindingClass: ActivitySignInUpBinding
    private var signState = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignInUpBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE).toString()

        if (signState == Constance.SIGN_IN_STATE) {
            bindingClass.edName.visibility = View.GONE
            bindingClass.edSecondName.visibility = View.GONE
            bindingClass.edThridName.visibility = View.GONE
            bindingClass.buttonAvatar.visibility = View.INVISIBLE
        }

    }
    fun onClickDone(view: View) {
        if (signState == Constance.SIGN_UP_STATE) {

            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.toString())
            intent.putExtra(Constance.NAME, bindingClass.edName.toString())
            intent.putExtra(Constance.SECOND_NAME, bindingClass.edSecondName.toString())
            intent.putExtra(Constance.THRID_NAME, bindingClass.edThridName.toString())
            if (bindingClass.imAvatarSignUp.isVisible)intent.putExtra(Constance.AVATAR_ID, R.drawable.avatar1)
            setResult(RESULT_OK, intent)
            finish()

        } else if (signState == Constance.SIGN_IN_STATE) {
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
    fun onClickAvatar(view: View) {
        bindingClass.imAvatarSignUp.visibility = View.VISIBLE
    }
}