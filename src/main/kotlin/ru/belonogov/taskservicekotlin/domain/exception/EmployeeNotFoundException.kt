package ru.belonogov.taskservicekotlin.domain.exception

class EmployeeNotFoundException(message: String = "User not found"): RuntimeException(message)