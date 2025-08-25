package com.KotlinApi.KotlinApi.service

import com.KotlinApi.KotlinApi.model.User
import com.KotlinApi.KotlinApi.repository.UserRepository
import com.KotlinApi.KotlinApi.dto.UserWithoutStudentsDTO
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {
    fun createUser(user: User): User = userRepository.save(user)

    fun getUserById(id: Long): Optional<User> = userRepository.findById(id)

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getAllUsersWithoutStudents(): List<UserWithoutStudentsDTO> =
        userRepository.findAll().map { user ->
            UserWithoutStudentsDTO(
                id = user.id,
                name = user.name,
                email = user.email
            )
        }

    fun updateUser(id: Long, user: User): Optional<User> {
        return if (userRepository.existsById(id)) {
            Optional.of(userRepository.save(user.copy(id = id)))
        } else {
            Optional.empty()
        }
    }

    fun deleteUser(id: Long): Boolean {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
