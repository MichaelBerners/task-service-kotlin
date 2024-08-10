package ru.belonogov.taskservicekotlin.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.belonogov.taskservicekotlin.domain.entity.Employee

interface EmployeeRepository: JpaRepository<Employee, Long> {
}