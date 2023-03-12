package cz.upce.fei.janacek.main.dto

import cz.upce.fei.janacek.main.domain.AppUser
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AppUserInDto (
    @field:NotNull
    @field:NotBlank
    @field:Size(max = 255, message = "Username too long")
    val username: String,
    val password: String,
    val active: Boolean = true,
    val creationDate: LocalDateTime,
    val updateDate: LocalDateTime? = null
)

fun AppUserInDto.toEntity(id: Long? = null): AppUser {
    return AppUser(
        id,
        this.username,
        this.password,
        this.active,
        this.creationDate,
        this.updateDate
    )
}