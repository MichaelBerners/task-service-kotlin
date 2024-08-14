package ru.belonogov.taskservicekotlin.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.belonogov.taskservicekotlin.domain.entity.Task

interface TaskRepository: JpaRepository<Task, Long> {

    @Query("SELECT t from Task t JOIN FETCH t.employees e where e.id = :employeeId")
    fun findAllByEmployee(employeeId: Long): List<Task>

    @Query("SELECT t FROM Task t JOIN FETCH t.employees e WHERE t.id = :id")
    fun findTasksById(id: Long): Task?
}