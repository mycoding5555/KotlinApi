package com.KotlinApi.KotlinApi.service

import com.KotlinApi.KotlinApi.model.Student
import com.KotlinApi.KotlinApi.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService {

    @Autowired
    private lateinit var studentRepository: StudentRepository

    fun getAllStudents(): List<Student> {
        return studentRepository.findAll()
    }

    fun getStudentById(id: Long): Student? {
        return studentRepository.findById(id).orElse(null)
    }

    fun createStudent(student: Student): Student {
        return studentRepository.save(student)
    }

    fun updateStudent(id: Long, student: Student): Student? {
        return if (studentRepository.existsById(id)) {
            studentRepository.save(student.copy(id = id))
        } else {
            null
        }
    }

    fun deleteStudent(id: Long): Boolean {
        return if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
