package cz.upce.fei.janacek.main.domain

import cz.upce.fei.janacek.main.dto.AppUserDto
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class AppUser (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column
    val username: String,
    @Column
    val password: String,
    @Column
    val active: Boolean,
    @Column
    val creationDate: LocalDateTime,
    @Column
    val updateDate: LocalDateTime? = null,
    @OneToMany(mappedBy = "author")
    val tasks: Set<Task> = setOf(),
    @ManyToMany(mappedBy = "users")
    val roles: Set<Role> = setOf()
) {

    constructor(
        username: String,
        password: String,
        active: Boolean,
        creationDate: LocalDateTime,
        updateDate: LocalDateTime
    ) : this(null, username, password, active, creationDate, updateDate, setOf(), setOf())



}

fun AppUser.toDto(): AppUserDto {
    return AppUserDto(
        this.id!!,
        this.username,
        this.password,
        this.active,
        this.creationDate,
        this.updateDate
    )
}