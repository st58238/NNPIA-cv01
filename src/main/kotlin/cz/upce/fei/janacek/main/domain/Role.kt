package cz.upce.fei.janacek.main.domain

import javax.persistence.*

@Entity
data class Role (
    @Id
    val id: Long,
    @Column
    val name: String,
    @ManyToMany
    @JoinTable(
        name = "app_user_role",
        joinColumns = [JoinColumn(name = "role_id")],
        inverseJoinColumns = [JoinColumn(name = "app_user_id")]
    )
    val users: Set<AppUser>
) {
}