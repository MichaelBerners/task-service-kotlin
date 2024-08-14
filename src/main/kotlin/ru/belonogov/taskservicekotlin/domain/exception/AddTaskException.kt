package ru.belonogov.taskservicekotlin.domain.exception

class AddTaskException(message: String = "Task cannot be added") : RuntimeException(message)
