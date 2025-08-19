package com.KotlinApi.KotlinApi.controller

import com.KotlinApi.KotlinApi.model.User
import com.KotlinApi.KotlinApi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody user: User): User {
        return userService.createUser(user)
    }


    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User? {
        return userService.getUserById(id).orElse(null)
    }


    @GetMapping
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }


    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User? {
        return userService.updateUser(id, user).orElse(null)
    }


    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): Boolean {
        return userService.deleteUser(id)
    }
}
