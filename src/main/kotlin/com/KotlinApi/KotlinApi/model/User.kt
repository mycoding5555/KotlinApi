package com.KotlinApi.KotlinApi.model


import jakarta.persistence.*
import com.KotlinApi.KotlinApi.model.Attendance
import com.KotlinApi.KotlinApi.model.Student

@Entity
@Table(name = "users")

data class User(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	@Column(nullable = false)
	val name: String,

	@Column(nullable = false, unique = true)
	val email: String,

	@OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	@com.fasterxml.jackson.annotation.JsonManagedReference
	val attendances: List<Attendance> = emptyList(),

	@OneToMany(mappedBy = "student", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	@com.fasterxml.jackson.annotation.JsonManagedReference
	val students: List<Student> = emptyList()
)
