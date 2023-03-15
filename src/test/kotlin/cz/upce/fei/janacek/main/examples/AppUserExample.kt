package cz.upce.fei.janacek.main.examples

import cz.upce.fei.janacek.main.domain.AppUser
import java.time.LocalDateTime.now

object AppUserExample {

    val EXISTING = AppUser(100, (Math.random()*100).toString(), "superSecretPassword", true, now())

}