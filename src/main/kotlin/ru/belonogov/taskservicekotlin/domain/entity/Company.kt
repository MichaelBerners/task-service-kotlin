package ru.belonogov.taskservicekotlin.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.SequenceGenerator
import ru.belonogov.taskservicekotlin.domain.dto.responce.CompanyResponse

@Entity
class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_id_seq")
    @SequenceGenerator(name = "company_id_seq", allocationSize = 1)
    val id: Long? = null,
    val name: String,
    @OneToMany(mappedBy = "company")
    val employees: MutableSet<Employee> = mutableSetOf())
