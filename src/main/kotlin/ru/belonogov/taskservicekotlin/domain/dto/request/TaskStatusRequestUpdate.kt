package ru.belonogov.taskservicekotlin.domain.dto.request

class TaskStatusRequestUpdate(
    var id: Long,
    var taskStatus: String
) {
}