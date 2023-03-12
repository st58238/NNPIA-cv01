package cz.upce.fei.janacek.main.repository

import cz.upce.fei.janacek.main.domain.Task
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository: PagingAndSortingRepository<Task, Long> {

    fun findAllByAuthorId(id: Long): List<Task>
}
