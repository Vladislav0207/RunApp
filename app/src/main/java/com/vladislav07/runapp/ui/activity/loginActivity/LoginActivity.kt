package com.vladislav07.runapp.ui.activity.loginActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.vladislav07.runapp.R
import com.vladislav07.runapp.ui.activity.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()

        signInButton.setOnClickListener {
            viewModel.sendUUID(editLogin.text.toString())
        }

        viewModel.navigateNextLiveData.observe(this){
            if (it){
                val navigateMainActivity = Intent(this, MainActivity::class.java)
                startActivity(navigateMainActivity)
            } else {
                Toast.makeText(this,R.string.error,Toast.LENGTH_SHORT).show()
            }
        }
    }

}