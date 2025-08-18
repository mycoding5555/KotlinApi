package com.KotlinApi.KotlinApi.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "attendances")
data class Attendance(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val userId: Long,

    @Column(nullable = false)
    val checkInTime: LocalDateTime,

    val checkOutTime: LocalDateTime? = null
)
