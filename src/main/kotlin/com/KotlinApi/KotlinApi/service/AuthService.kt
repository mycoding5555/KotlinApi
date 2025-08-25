package com.KotlinApi.KotlinApi.service

import com.KotlinApi.KotlinApi.dto.AuthRequest
import com.KotlinApi.KotlinApi.dto.AuthResponse
import com.KotlinApi.KotlinApi.model.User
import com.KotlinApi.KotlinApi.repository.UserRepository
import com.KotlinApi.KotlinApi.security.JwtUtil
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val jwtUtil: JwtUtil
) {
    private val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()

    fun register(authRequest: AuthRequest): AuthResponse {
        if (userRepository.findAll().any { it.email == authRequest.email }) {
            throw IllegalArgumentException("Email already in use")
        }
        val user = User(
            name = authRequest.email.substringBefore("@"),
            email = authRequest.email,
            password = passwordEncoder.encode(authRequest.password)
        )
        userRepository.save(user)
        val token = jwtUtil.generateToken(user.email)
        return AuthResponse(token)
    }

    fun login(authRequest: AuthRequest): AuthResponse {
        val user = userRepository.findAll().find { it.email == authRequest.email }
            ?: throw IllegalArgumentException("Invalid credentials")
        if (!passwordEncoder.matches(authRequest.password, user.password)) {
            throw IllegalArgumentException("Invalid credentials")
        }
        val token = jwtUtil.generateToken(user.email)
        return AuthResponse(token)
    }
}
