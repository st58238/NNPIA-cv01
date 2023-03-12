package cz.upce.fei.janacek.main.controller

import cz.upce.fei.janacek.main.domain.toDto
import cz.upce.fei.janacek.main.dto.AppUserDto
import cz.upce.fei.janacek.main.dto.AppUserInDto
import cz.upce.fei.janacek.main.service.AppUserService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/graphql")
class AppUserQLController (
    private val appUserService: AppUserService
) {

    @QueryMapping
    fun appUser(@Argument id: Long): AppUserDto {
        return appUserService.findById(id).get().toDto()
    }

    @MutationMapping
    fun addAppUser(@Argument appUser: AppUserInDto) {
        
    }

}