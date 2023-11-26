package com.example.classproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var createNAButton: Button = findViewById(R.id.createNewAccount)
        createNAButton.setOnClickListener {
            var i = Intent(this, CreateNewAccountActivity::class.java)
            startActivity(i)
        }

        val forgotPasswordBtn: Button = findViewById(R.id.forgottenPassword)
        forgotPasswordBtn.setOnClickListener {
            var i = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(i)
        }

        val loginBtn: Button = findViewById(R.id.loginButton)
        loginBtn.setOnClickListener {
            validateCredentials()
        }
    }

    private fun validateCredentials() {
        var usernameEdit: EditText = findViewById(R.id.username)
        var passwordEdit: EditText = findViewById(R.id.password)

        val username: String = usernameEdit.text.toString()
        val password: String = passwordEdit.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {
            navigateToHomePage()
        } else {
            Snackbar.make(
                findViewById(R.id.loginButton),
                "Username and password cannot be empty",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun navigateToHomePage() {
        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
