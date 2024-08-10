package ru.belonogov.taskservicekotlin.service

import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyNameUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.TaskEmployeeRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.TaskRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.TaskResponse
import ru.belonogov.taskservicekotlin.domain.entity.Task

interface TaskService {

    fun create(taskRequest: TaskRequest): TaskResponse
    fun readById(taskId: Long): Task
    fun readAllByEmployee(employeeId: Long): MutableList<TaskResponse>
    fun updateName(taskNameUpdateRequest: CompanyNameUpdateRequest): TaskResponse
    fun addEmployee(taskEmployeeRequest: TaskEmployeeRequest)
    fun delete(taskId: Long)
}