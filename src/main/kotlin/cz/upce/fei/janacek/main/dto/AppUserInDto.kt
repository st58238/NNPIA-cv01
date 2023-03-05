package cz.upce.fei.janacek.main.dto

import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AppUserInDto (
    @NotNull
    @NotBlank
    @Size(min = 1, max = 255, message = "Username too long")
    val username: String,
    val password: String,
    val active: Boolean,
    val creationDate: LocalDateTime,
    val updateDate: LocalDateTime
)