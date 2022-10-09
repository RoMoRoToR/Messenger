package com.example.pr1.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.pr1.data.vo.UserVO

class AppPreferences private constructor() {
    private lateinit var preferences: SharedPreferences
    companion object {
        private val PREFERENCES_FILE_NAME = "APP_PREFERENCES"
        fun create(context: Context): AppPreferences {
            val appPreferences = AppPreferences()
            appPreferences.preferences = context
                .getSharedPreferences(PREFERENCES_FILE_NAME, 0)
            return appPreferences
        }
    }
    val accessToken: String?
    get() = preferences.getString("ACCESS TOKEN", null)
    fun storeAccessToken(accessToken: String) {
        preferences.edit().putString("ACCESS TOKEN", accessToken).apply()
    }

    val userDetalis: UserVO
    get(): UserVO {
        return UserVO (
            preferences.getLong("ID", 0),
            preferences.getString("USERNAME", null).toString(),
            preferences.getString("PHONE_NUMBER", null).toString(),
            preferences.getString("STATUS", null).toString(),
            preferences.getString("CREATED_AT", null).toString()
            )
    }

    /**
     * Следующие функции storeUserDetails и clear сохранияет данные пользователя, переданные UserVO экземпляру класса SharedPreferences
     */
        fun storeUserDetails(user: UserVO){
            val editor:SharedPreferences.Editor = preferences.edit()
            editor.putLong("ID", user.id).apply()
            editor.putString("USERNAME", user.username).apply()
            editor.putString("PHONE_NUMBER", user.phoneNumber).apply()
            editor.putString("STATUS",user.status).apply()
            editor.putString("CREATED_AT", user.createAt.toString()).apply()
        }
        fun clear(){
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()
        }
}