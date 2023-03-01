package cz.upce.fei.janacek.main.repository

import cz.upce.fei.janacek.main.domain.AppUser
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface AppUserRepository: PagingAndSortingRepository<AppUser, Long> {
    fun findAllByActiveEquals(active: Boolean): List<AppUser>
}
