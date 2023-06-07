package com.example.laboratorio11

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.R
import com.example.laboratorio11.network.retrofit.RetrofitInstance
import com.example.laboratorio11.network.service.AuthService
import com.example.laboratorio11.repository.CredentialsRepository

class RetrofitApplication : Application() {


    private val prefs: SharedPreferences by lazy {
        getSharedPreferences(USER_TOKEN, Context.MODE_PRIVATE)
    }

    fun getToken(): String = prefs.getString(USER_TOKEN, "")!!

    private fun getAPIService() = with(RetrofitInstance){
        setToken(getToken())
        getLoginService()
        getRegisterService()
    }


    val credentialsRepository: CredentialsRepository by lazy {
        CredentialsRepository(getAPIService())
    }




    fun saveAuthTOken(Token: String){
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, Token)
        editor.apply()
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }
}