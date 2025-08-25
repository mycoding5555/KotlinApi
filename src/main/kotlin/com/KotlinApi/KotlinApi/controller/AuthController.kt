package com.KotlinApi.KotlinApi.controller

import com.KotlinApi.KotlinApi.dto.AuthRequest
import com.KotlinApi.KotlinApi.dto.AuthResponse
import com.KotlinApi.KotlinApi.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> =
        try {
            ResponseEntity.ok(authService.register(request))
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }

    @PostMapping("/login")
    fun login(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> =
        try {
            ResponseEntity.ok(authService.login(request))
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
}
