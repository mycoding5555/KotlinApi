package com.KotlinApi.KotlinApi.controller

import com.KotlinApi.KotlinApi.model.Attendance
import com.KotlinApi.KotlinApi.service.AttendanceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/attendances")
class AttendanceController(private val attendanceService: AttendanceService) {


    @GetMapping
    fun getAllAttendances(): List<Attendance> = attendanceService.getAllAttendances()


    @PostMapping
    fun createAttendance(@RequestBody attendance: Attendance): Attendance =
        attendanceService.createAttendance(attendance)


    @GetMapping("/{id}")
    fun getAttendanceById(@PathVariable id: Long): ResponseEntity<Attendance> {
        val attendance = attendanceService.getAttendanceById(id)
        return if (attendance.isPresent) ResponseEntity.ok(attendance.get()) else ResponseEntity.notFound().build()
    }


    @PutMapping("/{id}")
    fun updateAttendance(
        @PathVariable id: Long,
        @RequestBody updated: Attendance
    ): ResponseEntity<Attendance> {
        val updatedAttendance = attendanceService.updateAttendance(id, updated)
        return if (updatedAttendance.isPresent) {
            ResponseEntity.ok(updatedAttendance.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }


    @DeleteMapping("/{id}")
    fun deleteAttendance(@PathVariable id: Long): ResponseEntity<Void> {
        val attendance = attendanceService.getAttendanceById(id)
        return if (attendance.isPresent) {
            attendanceService.deleteAttendance(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}