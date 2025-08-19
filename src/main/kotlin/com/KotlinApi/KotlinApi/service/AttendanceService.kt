package com.KotlinApi.KotlinApi.service

import com.KotlinApi.KotlinApi.model.Attendance
import com.KotlinApi.KotlinApi.repository.AttendanceRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AttendanceService(private val attendanceRepository: AttendanceRepository) {
    fun getAllAttendances(): List<Attendance> = attendanceRepository.findAll()

    fun createAttendance(attendance: Attendance): Attendance = attendanceRepository.save(attendance)

    fun getAttendanceById(id: Long): Optional<Attendance> = attendanceRepository.findById(id)

    fun updateAttendance(id: Long, updated: Attendance): Optional<Attendance> {
        val existing = attendanceRepository.findById(id)
        return if (existing.isPresent) {
            val updatedAttendance = existing.get().copy(
                user = updated.user,
                checkInTime = updated.checkInTime,
                checkOutTime = updated.checkOutTime
            )
            Optional.of(attendanceRepository.save(updatedAttendance))
        } else {
            Optional.empty()
        }
    }

    fun deleteAttendance(id: Long) {
        attendanceRepository.deleteById(id)
    }
}
