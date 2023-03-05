package cz.upce.fei.janacek.main.service

import cz.upce.fei.janacek.main.domain.AppUser
import cz.upce.fei.janacek.main.repository.AppUserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.Optional

@Service
class AppUserService (
    private val appUserRepository: AppUserRepository
) {

    @Transactional(readOnly = true)
    fun findById(id: Long): Optional<AppUser> {
        val user = appUserRepository.findByIdOrNull(id)

        return Optional.ofNullable(user)
    }

    @Transactional
    fun create(toEntity: AppUser): AppUser {
        return appUserRepository.save(toEntity)
    }

    @Transactional
    fun change(id: Long, toEntity: AppUser): AppUser {
        val user = appUserRepository.findById(id)
        if (!user.isPresent)
            throw ResourceNotFoundException()
        val u = user.get()
        val n = AppUser(
            u.id,
            u.username,
            u.password,
            u.active,
            u.creationDate,
            u.updateDate,
            u.tasks,
            u.roles
        )

        return create(n)
    }

    @Transactional
    fun delete(id: Long) {
        appUserRepository.deleteById(id)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class ResourceNotFoundException: RuntimeException() {
        @ExceptionHandler(ResourceNotFoundException::class)
        fun handleAppUserNotFound() {}
    }
}