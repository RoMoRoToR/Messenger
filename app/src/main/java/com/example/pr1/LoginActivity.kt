package com.example.pr1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.pr1.R
import com.example.pr1.login.LoginView

abstract class LoginActivity : AppCompatActivity(), LoginView,
    View.OnClickListener
{
    /**
     * Отложеная иницилизация переменных
     */
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bindViews()
    }

    /**
     * Привязка ссылки на объект вида маркеров для просмотра элементов
     */
    override fun bindViews() {
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        btnSignUp = findViewById(R.id.btn_sign_up)
        progressBar = findViewById(R.id.progress_bar)
        btnLogin.setOnClickListener(this)
        btnSignUp.setOnClickListener(this)
    }

    /**
     * отображение соответствующего сообщения об ошибке аудентификации при вызове
     */
    override fun showAuthError() {
        Toast.makeText(this, "Invalid username and password combination.",
            Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
    }

    override fun getContext(): Context {
        return this
    }

    /**
     * Реализация методов из LoginView
     */
    override fun showProgress() {
        progressBar.visibility = View.GONE //Индикатор прогресса и изменение видимости
    }

    override fun hideProgress() {
        progressBar.visibility = View.VISIBLE //Индикатор прогресса и изменение видимости
    }

    override fun setUsernameError() {
        etUsername.error = "Username field cannot be empty"
    }

    override fun setPasswordError() {
        etPassword.error = "Password filed cannot be emply"
    }

    override fun navigateToHome() {
    }

    override fun navigateToSignUp() {
    }

}