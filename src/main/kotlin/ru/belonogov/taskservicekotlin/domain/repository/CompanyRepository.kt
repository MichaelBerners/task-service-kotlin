package ru.belonogov.taskservicekotlin.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.belonogov.taskservicekotlin.domain.entity.Company

interface CompanyRepository: JpaRepository<Company, Long> {

    fun findCompanyByName(companyName: String): Company?
}