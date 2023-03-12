package cz.upce.fei.janacek.main.controller

import cz.upce.fei.janacek.main.dto.AppUserDto
import cz.upce.fei.janacek.main.dto.TaskDto
import cz.upce.fei.janacek.main.service.TaskService
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class TaskQLController (
    val taskService: TaskService
) {
    @SchemaMapping(typeName = "AppUser")
    fun tasks(appUser: AppUserDto): List<TaskDto> {
        return taskService.findAllByAuthorId(appUser.id)
    }
}