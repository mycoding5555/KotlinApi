package com.KotlinApi.KotlinApi.controller

import com.KotlinApi.KotlinApi.dto.AuthRequest
import com.KotlinApi.KotlinApi.service.AuthService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping
class WebAuthController(private val authService: AuthService) {
    @GetMapping("/login")
    fun loginPage(model: Model): String {
        model.addAttribute("error", null)
        return "login"
    }

    @PostMapping("/login")
    fun login(@ModelAttribute authRequest: AuthRequest, model: Model): String {
        return try {
            authService.login(authRequest)
            "redirect:/users"
        } catch (e: Exception) {
            model.addAttribute("error", "Invalid credentials")
            "login"
        }
    }

    @GetMapping("/logout")
    fun logout(): String {
        return "redirect:/login"
    }

    @GetMapping("/users")
    fun usersPage(): String {
        return "dashboard" // You can create dashboard.html or change this as needed
    }

    @GetMapping("/register")
    fun registerPage(model: Model): String {
        model.addAttribute("error", null)
        return "register"
    }

    @PostMapping("/register")
    fun register(@ModelAttribute authRequest: AuthRequest, model: Model): String {
        return try {
            authService.register(authRequest)
            "redirect:/login"
        } catch (e: Exception) {
            model.addAttribute("error", "Registration failed: ${e.message}")
            "register"
        }
    }
}
