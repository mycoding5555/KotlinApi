package com.KotlinApi.KotlinApi.repository

import com.KotlinApi.KotlinApi.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>
