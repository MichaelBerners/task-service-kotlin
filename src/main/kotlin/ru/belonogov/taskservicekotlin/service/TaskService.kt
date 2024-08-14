package ru.belonogov.taskservicekotlin.service

import ru.belonogov.taskservicekotlin.domain.dto.request.TaskEmployeeRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.TaskRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.TaskStatusUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.TaskResponse
import ru.belonogov.taskservicekotlin.domain.entity.Task
import javax.swing.text.html.parser.Entity

interface TaskService {

    fun create(taskRequest: TaskRequest): TaskResponse
    fun readById(id: Long): Task
    fun readAllByEmployee(employeeId: Long): List<TaskResponse>
    fun updateStatus(taskEntity: Task, canceled: Boolean = false): Task
    fun delete(taskId: Long)
}