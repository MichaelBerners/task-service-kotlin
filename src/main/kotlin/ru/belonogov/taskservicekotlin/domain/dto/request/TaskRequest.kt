package ru.belonogov.taskservicekotlin.domain.dto.request

class TaskRequest(
    var name: String,
    var description: String,
    var rating: Int,
    var employeeNeeded: Int
) {
}