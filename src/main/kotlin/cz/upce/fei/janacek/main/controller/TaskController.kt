package cz.upce.fei.janacek.main.controller

import cz.upce.fei.janacek.main.domain.toDto
import cz.upce.fei.janacek.main.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/tasks")
class TaskController (
    private val taskService: TaskService
) {

    @GetMapping("")
    fun getAllTasks(): ResponseEntity<*> {
        val taskSet = taskService.findAllTasks().map { it.toDto() }.toSet()
        return ResponseEntity.of(Optional.of(taskSet))
    }
}