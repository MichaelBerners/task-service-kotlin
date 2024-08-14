package ru.belonogov.taskservicekotlin.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.belonogov.taskservicekotlin.domain.dto.responce.EmployeeResponse
import ru.belonogov.taskservicekotlin.domain.entity.Employee

interface EmployeeRepository: JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e JOIN FETCH e.company c where c.name = :name")
    fun findByCompanyName(name: String): List<Employee>
    @Query("SELECT e from Employee e JOIN FETCH e.tasks t where t.id = :id")
    fun findByTaskId(id: Long): List<Employee>
}