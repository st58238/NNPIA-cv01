package cz.upce.fei.janacek.main.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator

@Entity
data class AppUser (
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "app_user_sequence", allocationSize = 25)
    val id: Long,
    @Column
    val username: String,
    @Column
    val password: String,
    @Column
    val active: Boolean,
    @Column
    val creationDate: LocalDateTime,
    @Column
    val updateDate: LocalDateTime,
    @OneToMany(mappedBy = "author")
    val tasks: Set<Task>,
    @ManyToMany
    val roles: Set<Role>
) {
}