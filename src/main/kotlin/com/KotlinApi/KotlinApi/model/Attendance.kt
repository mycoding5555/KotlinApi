package com.KotlinApi.KotlinApi.model


import com.KotlinApi.KotlinApi.model.User
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "attendances")
data class Attendance(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @com.fasterxml.jackson.annotation.JsonBackReference
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    @com.fasterxml.jackson.annotation.JsonBackReference
    val student: Student,

    @Column(nullable = false)
    val checkInTime: LocalDateTime,

    val checkOutTime: LocalDateTime? = null
)
