package cz.upce.fei.janacek.main.domain

import javax.persistence.*

@Entity
data class Role (
    @Id
    val id: Int,
    @Column
    val name: String,
    @ManyToMany(mappedBy = "roles")
    val users: Set<AppUser>
) {
}