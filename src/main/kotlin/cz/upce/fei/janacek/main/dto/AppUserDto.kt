package cz.upce.fei.janacek.main.dto

import java.time.LocalDateTime


data class AppUserDto (
    private val id: Long,
    val username: String,
    val password: String,
    val active: Boolean,
    val creationDate: LocalDateTime,
    val updateDate: LocalDateTime
)