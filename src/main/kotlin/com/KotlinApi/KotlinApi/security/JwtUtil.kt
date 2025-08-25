package com.KotlinApi.KotlinApi.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtUtil {
    private val jwtSecret: SecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256)
    private val jwtExpirationMs: Long = 86400000 // 1 day

    fun generateToken(email: String): String {
        val now = Date()
        val expiryDate = Date(now.time + jwtExpirationMs)
        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(jwtSecret)
            .compact()
    }

    fun getEmailFromToken(token: String): String? {
        return Jwts.parser()
            .setSigningKey(jwtSecret)
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser().setSigningKey(jwtSecret).build().parseClaimsJws(token)
            true
        } catch (ex: Exception) {
            false
        }
    }
}
