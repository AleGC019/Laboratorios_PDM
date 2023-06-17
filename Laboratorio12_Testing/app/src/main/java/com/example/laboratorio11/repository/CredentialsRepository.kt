package com.example.laboratorio11.repository

import com.example.laboratorio11.network.ApiResponse
import com.example.laboratorio11.network.dto.login.LoginRequest
import com.example.laboratorio11.network.dto.login.LoginResponse
import com.example.laboratorio11.network.dto.register.RegisterRequest
import com.example.laboratorio11.network.dto.register.RegisterResponse
import com.example.laboratorio11.network.service.AuthService
import retrofit2.HttpException
import java.io.IOException

class CredentialsRepository(private val api: AuthService) {


    suspend fun login(email: String, password: String): ApiResponse<String> {
        return try {
            val response: LoginResponse = api.login(LoginRequest(email, password))
            return ApiResponse.Success(response.token)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Credenciales incorrectas, invalid email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }

    suspend fun register(email: String, password: String, name: String): ApiResponse<String> {
        return try {
            val response: RegisterResponse = api.register(RegisterRequest(email, password, name))
            return ApiResponse.Success(response.message)
        } catch (e: HttpException) {

            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Credenciales incorrectas, invaldiad email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }
}