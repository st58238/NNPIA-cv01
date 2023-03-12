package cz.upce.fei.janacek.main.service

import cz.upce.fei.janacek.main.domain.toDto
import cz.upce.fei.janacek.main.dto.TaskDto
import cz.upce.fei.janacek.main.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService (
    private val taskRepository: TaskRepository
) {

    fun findAllByAuthorId(id: Long): List<TaskDto> {
        return taskRepository.findAllByAuthorId(id).map { it.toDto() }
    }
}