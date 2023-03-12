package cz.upce.fei.janacek.main.dto

import cz.upce.fei.janacek.main.domain.AppUser
import java.time.LocalDateTime

data class TaskDto
    (
    val id: Long,
    val title: String,
    val description: String,
    val creationDate: LocalDateTime,
    val updateDate: LocalDateTime?,
    val author: AppUser
) {

}
