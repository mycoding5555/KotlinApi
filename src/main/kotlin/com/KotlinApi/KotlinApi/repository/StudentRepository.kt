package com.KotlinApi.KotlinApi.repository

import com.KotlinApi.KotlinApi.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long> {
    fun findByName(name: String): List<Student>
}
