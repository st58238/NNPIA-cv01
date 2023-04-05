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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AppUser

        if (id != other.id) return false
        if (username != other.username) return false
        if (password != other.password) return false
        if (active != other.active) return false
        if (creationDate != other.creationDate) return false
        if (updateDate != other.updateDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + username.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + active.hashCode()
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + (updateDate?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "AppUser(id=$id, username='$username', password='$password', active=$active, creationDate=$creationDate, updateDate=$updateDate)"
    }


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