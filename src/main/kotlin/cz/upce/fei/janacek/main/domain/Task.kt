package cz.upce.fei.janacek.main.domain

import cz.upce.fei.janacek.main.dto.TaskDto
import java.time.LocalDateTime
import javax.persistence.*

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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Task

        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (creationDate != other.creationDate) return false
        if (updateDate != other.updateDate) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Task(id=$id, title='$title', description='$description', creationDate=$creationDate, updateDate=$updateDate)"
    }


}

fun Task.toDto(): TaskDto {
    return TaskDto(
        this.id,
        this.title,
        this.description,
        this.creationDate,
        this.updateDate
    )
}