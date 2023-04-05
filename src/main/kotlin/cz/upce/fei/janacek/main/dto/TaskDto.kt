package cz.upce.fei.janacek.main.dto

import java.time.LocalDateTime

data class TaskDto
    (
    val id: Long,
    val title: String,
    val description: String,
    val creationDate: LocalDateTime,
    val updateDate: LocalDateTime?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TaskDto

        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (creationDate != other.creationDate) return false
        if (updateDate != other.updateDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + (updateDate?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "TaskDto(id=$id, title='$title', description='$description', creationDate=$creationDate, updateDate=$updateDate)"
    }


}
