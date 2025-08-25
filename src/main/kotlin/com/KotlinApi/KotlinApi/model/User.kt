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

	@Column(nullable = false)
	val password: String,

	@OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	@com.fasterxml.jackson.annotation.JsonManagedReference
	val attendances: List<Attendance> = emptyList(),

	@OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	@com.fasterxml.jackson.annotation.JsonIgnore
	val students: List<Student> = emptyList()
)
