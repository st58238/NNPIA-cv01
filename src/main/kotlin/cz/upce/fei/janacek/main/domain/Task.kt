package cz.upce.fei.janacek.main.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn

@Entity
data class Task (
    @Id
    val id: Int,
    @Column
    val title: String,
    @Column
    val description: String,
    @Column
    val creationDate: LocalDateTime,
    @Column
    val updateDate: LocalDateTime,
    @JoinColumn()
    val author: AppUser
) {
}