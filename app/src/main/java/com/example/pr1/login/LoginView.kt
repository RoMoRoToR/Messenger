package com.example.pr1.login

import com.example.pr1.auth.AuthView
import com.example.pr1.base.BaseView

interface LoginView : BaseView, AuthView {
    fun showProgress()
    fun hideProgress()
    fun setUsernameError()
    fun setPasswordError()
    fun navigateToSignUp()
    fun navigateToHome()
}