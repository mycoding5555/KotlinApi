package com.KotlinApi.KotlinApi.model

import com.KotlinApi.KotlinApi.model.Attendance
import jakarta.persistence.*

@Entity
@Table(name = "students")

data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "age", nullable = false)
    val age: Int,

    @Column(name = "class", nullable = false)
    val studentClass: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @com.fasterxml.jackson.annotation.JsonBackReference
    val student: User,

    @OneToMany(mappedBy = "student", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @com.fasterxml.jackson.annotation.JsonManagedReference
    val subjects: List<Attendance> = emptyList()

   
)

