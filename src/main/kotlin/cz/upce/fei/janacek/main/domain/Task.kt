package cz.upce.fei.janacek.main.domain

import cz.upce.fei.janacek.main.dto.TaskDto
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Task (
    @Id
    val id: Long,
    @Column
    val title: String,
    @Column
    val description: String,
    @Column
    val creationDate: LocalDateTime,
    @Column
    val updateDate: LocalDateTime?,
    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    val author: AppUser
)

fun Task.toDto(): TaskDto {
    return TaskDto(
        this.id,
        this.title,
        this.description,
        this.creationDate,
        this.updateDate,
        this.author
    )
}