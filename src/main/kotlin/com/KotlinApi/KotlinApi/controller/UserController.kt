package com.KotlinApi.KotlinApi.controller

import com.KotlinApi.KotlinApi.model.User
import com.KotlinApi.KotlinApi.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(
    private val userRepository: UserRepository
) {
    @PostMapping
    fun createUser(@RequestBody user: User): User {
        return userRepository.save(user)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }

    @GetMapping
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User? {
        return if (userRepository.existsById(id)) {
            userRepository.save(user.copy(id = id))
        } else {
            null
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): Boolean {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
