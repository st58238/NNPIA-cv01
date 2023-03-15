package cz.upce.fei.janacek.main.service

import cz.upce.fei.janacek.main.examples.AppUserExample
import cz.upce.fei.janacek.main.repository.AppUserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
internal class AppUserServiceTest {
    @field:Autowired
    private lateinit var appUserService: AppUserService
    @field:Autowired
    private lateinit var appUserRepository: AppUserRepository

    @BeforeEach
    fun setUp() {
        /*`when`(appUserService.findById(100))
            .thenReturn(Optional.of(AppUserExample.EXISTING))*/
    }

    @AfterEach
    fun tearDown() {
        appUserRepository.deleteAll()
    }

    @Test
    @Transactional
    fun findById() {
        val expected = appUserRepository.save(AppUserExample.EXISTING)
        val returned = appUserService.findById(expected.id!!).get()
        bypassLazyLoad(returned)

        assertEquals(expected, returned)
    }

    @Test
    fun create() {
    }

    @Test
    fun change() {
    }

    @Test
    fun delete() {
    }

    private fun bypassLazyLoad(c: Any) {
        c.javaClass.methods.filter { it.name.startsWith("get", true) }.forEach {
            println(it.name + ": " + it.invoke(c))
        }
    }

}