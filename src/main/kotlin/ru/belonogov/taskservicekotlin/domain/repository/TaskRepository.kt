package ru.belonogov.taskservicekotlin.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.belonogov.taskservicekotlin.domain.entity.Task

interface TaskRepository: JpaRepository<Task, Long> {
}