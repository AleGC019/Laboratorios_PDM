package com.example.laboratorio11.network.dto.register

data class RegisterRequest (
    val email: String = "",
    val password: String = "",
    val name: String = ""
)