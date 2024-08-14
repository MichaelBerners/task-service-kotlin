package ru.belonogov.taskservicekotlin.domain.exception

class TaskNotFoundException(message: String = "Task not found") : RuntimeException(message) {

}
