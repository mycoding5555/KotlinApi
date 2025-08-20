package com.KotlinApi.KotlinApi.dto

import com.KotlinApi.KotlinApi.model.Attendance

data class StudentWithAttendanceDTO(
    val id: Long,
    val name: String,
    val age: Int,
    val studentClass: String,
    val attendances: List<AttendanceDTO>
)

data class AttendanceDTO(
    val id: Long,
    val checkInTime: String,
    val checkOutTime: String?
)
