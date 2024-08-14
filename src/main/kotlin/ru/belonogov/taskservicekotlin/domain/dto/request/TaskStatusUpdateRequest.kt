package ru.belonogov.taskservicekotlin.domain.dto.request

import ru.belonogov.taskservicekotlin.domain.entity.TaskStatus

class TaskStatusUpdateRequest(
    var id: Long,
    var taskStatus: TaskStatus
) {
}