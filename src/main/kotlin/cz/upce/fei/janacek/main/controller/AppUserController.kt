package cz.upce.fei.janacek.main.controller

import cz.upce.fei.janacek.main.domain.AppUser
import cz.upce.fei.janacek.main.repository.AppUserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

@RestController
@RequestMapping("/app-user")
class AppUserController (
    private val appUserRepository: AppUserRepository
) {

    @GetMapping
    fun getUserById(@RequestParam id: Long): AppUser {
        return appUserRepository.findByIdOrNull(id)!!
    }

    @ControllerAdvice
    class UserNotFoundException: RuntimeException() {
        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(NullPointerException::class)
        fun handleAppUserNotFound() {}
    }
}