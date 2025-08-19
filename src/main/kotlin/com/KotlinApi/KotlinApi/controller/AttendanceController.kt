package com.KotlinApi.KotlinApi.controller

import com.KotlinApi.KotlinApi.model.Attendance
import com.KotlinApi.KotlinApi.repository.AttendanceRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/attendances")
class AttendanceController(private val attendanceRepository: AttendanceRepository) {

    @GetMapping
    fun getAllAttendances(): List<Attendance> = attendanceRepository.findAll()

    @PostMapping
    fun createAttendance(@RequestBody attendance: Attendance): Attendance =
        attendanceRepository.save(attendance)

    @GetMapping("/{id}")
    fun getAttendanceById(@PathVariable id: Long): ResponseEntity<Attendance> {
        val attendance = attendanceRepository.findById(id).orElse(null)
        return if (attendance != null) ResponseEntity.ok(attendance) else ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    fun updateAttendance(
        @PathVariable id: Long,
        @RequestBody updated: Attendance
    ): ResponseEntity<Attendance> {
        val existing = attendanceRepository.findById(id).orElse(null)
        return if (existing != null) {
            val updatedAttendance = existing.copy(
                user = updated.user,
                checkInTime = updated.checkInTime,
                checkOutTime = updated.checkOutTime
            )
            ResponseEntity.ok(attendanceRepository.save(updatedAttendance))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteAttendance(@PathVariable id: Long): ResponseEntity<Void> {
        val attendance = attendanceRepository.findById(id).orElse(null)
        return if (attendance != null) {
            attendanceRepository.delete(attendance)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}