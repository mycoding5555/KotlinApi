package com.KotlinApi.KotlinApi.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DashboardController {

    @GetMapping("/")
    fun root(): String {
        return "redirect:/dashboard"
    }

    @GetMapping("/dashboard")
    fun dashboard(): String {
        return "dashboard"
    }

}
