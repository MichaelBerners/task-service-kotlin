package ru.belonogov.taskservicekotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.belonogov.taskservicekotlin.domain.entity.Company
import ru.belonogov.taskservicekotlin.domain.entity.Task

@SpringBootApplication
class TaskServiceKotlinApplication

fun main(args: Array<String>) {
    runApplication<TaskServiceKotlinApplication>(*args)

}
