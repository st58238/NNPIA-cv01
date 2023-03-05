package cz.upce.fei.janacek.main.controller

import cz.upce.fei.janacek.main.domain.AppUser
import cz.upce.fei.janacek.main.repository.AppUserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/add-user")
class AddUserController (
    private val appUserRepository: AppUserRepository
) {

    @GetMapping("")
    fun findAllAddUsers(): List<AppUser> {
        return appUserRepository.findAllByActiveEquals(true)
    }

    @GetMapping("/add")
    fun addNewUser() {
        appUserRepository.save(AppUser(1, "string", "pass", true, LocalDateTime.now(), LocalDateTime.now(), setOf(), setOf()))
    }
}