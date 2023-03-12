package cz.upce.fei.janacek.main.controller

import cz.upce.fei.janacek.main.domain.AppUser
import cz.upce.fei.janacek.main.domain.toDto
import cz.upce.fei.janacek.main.dto.AppUserDto
import cz.upce.fei.janacek.main.dto.AppUserInDto
import cz.upce.fei.janacek.main.dto.toEntity
import cz.upce.fei.janacek.main.service.AppUserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/app-user/")
class AppUserController (
    private val appUserService: AppUserService
) {

    @GetMapping("/{id}")
    fun getUserById(
        @PathVariable
        id: Long
    ): ResponseEntity<AppUserDto> {
        val user = appUserService.findById(id)

        if (user.isPresent)
            return ResponseEntity.ok(user.get().toDto())
        throw AppUserService.ResourceNotFoundException()
    }

    @PostMapping("")
    fun create(
        @RequestBody
        @Validated
        userDto: AppUserInDto
    ): ResponseEntity<AppUserDto> {
        val result = appUserService.create(userDto.toEntity())
        return ResponseEntity<AppUserDto>(result.toDto(), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun put(
        @PathVariable
        id: Long,
        @RequestBody
        @Validated
        userDto: AppUserInDto
    ): ResponseEntity<AppUserDto> {
        val result = appUserService.change(id, userDto.toEntity(id))
        return ResponseEntity<AppUserDto>(result.toDto(), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable
        id: Long
    ): ResponseEntity<Any> {
        appUserService.delete(id)
        return ResponseEntity.noContent().build()
    }
}