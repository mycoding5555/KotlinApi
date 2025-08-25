package com.KotlinApi.KotlinApi.controller

import com.KotlinApi.KotlinApi.model.User
import com.KotlinApi.KotlinApi.service.UserService
import com.KotlinApi.KotlinApi.dto.UserWithoutStudentsDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController @Autowired constructor(
    private val userService: UserService
) {

    @PostMapping(consumes = ["application/json", "application/json;charset=UTF-8"])
    fun createUser(@RequestBody user: User): User {
        return userService.createUser(user)
    }


    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User? {
        return userService.getUserById(id).orElse(null)
    }


    @GetMapping
    fun getAllUsers(): List<UserWithoutStudentsDTO> {
        return userService.getAllUsersWithoutStudents()
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
