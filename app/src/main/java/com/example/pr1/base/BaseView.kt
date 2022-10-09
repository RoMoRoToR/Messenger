package com.example.pr1.base

import android.content.Context

interface BaseView {
    fun bindViews()
    fun getContext(): Context
}