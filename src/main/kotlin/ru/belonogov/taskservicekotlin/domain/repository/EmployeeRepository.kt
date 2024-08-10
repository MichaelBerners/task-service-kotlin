package ru.belonogov.taskservicekotlin.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.belonogov.taskservicekotlin.domain.entity.Employee

interface EmployeeRepository: JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e JOIN FETCH e.company c where c.name = :companyName")
    fun findByCompanyName(companyName: String): MutableList<Employee>
}