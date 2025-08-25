package com.KotlinApi.KotlinApi.controller

import com.KotlinApi.KotlinApi.model.Student
import com.KotlinApi.KotlinApi.service.StudentService
import com.KotlinApi.KotlinApi.dto.StudentWithAttendanceDTO
import com.KotlinApi.KotlinApi.dto.AttendanceDTO
import com.KotlinApi.KotlinApi.model.Attendance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/students")
class StudentController {

    @Autowired
    private lateinit var studentService: StudentService

    @GetMapping("/{id}/with-attendance")
    fun getStudentWithAttendance(@PathVariable id: Long): ResponseEntity<StudentWithAttendanceDTO> {
        val student = studentService.getStudentById(id)
        return if (student != null) {
            val dto = StudentWithAttendanceDTO(
                id = student.id,
                name = student.name,
                age = student.age,
                studentClass = student.studentClass,
                attendances = student.attendances.map { attendance: Attendance ->
                    AttendanceDTO(
                        id = attendance.id,
                        checkInTime = attendance.checkInTime.toString(),
                        checkOutTime = attendance.checkOutTime?.toString()
                    )
                }
            )
            ResponseEntity.ok(dto)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun getAllStudents(): List<Student> {
        return studentService.getAllStudents()
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        val student = studentService.getStudentById(id)
        return if (student != null) {
            ResponseEntity.ok(student)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createStudent(@RequestBody student: Student): Student {
        return studentService.createStudent(student)
    }

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @RequestBody student: Student): ResponseEntity<Student> {
        val updatedStudent = studentService.updateStudent(id, student)
        return if (updatedStudent != null) {
            ResponseEntity.ok(updatedStudent)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> {
        return if (studentService.deleteStudent(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
