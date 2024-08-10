package ru.belonogov.taskservicekotlin.service.impl

import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyNameUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.TaskEmployeeRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.TaskRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.TaskResponse
import ru.belonogov.taskservicekotlin.domain.entity.Task
import ru.belonogov.taskservicekotlin.service.TaskService

class TaskServiceImpl: TaskService {
    override fun create(taskRequest: TaskRequest): TaskResponse {
        TODO("Not yet implemented")
    }

    override fun readById(taskId: Long): Task {
        TODO("Not yet implemented")
    }

    override fun readAllByEmployee(employeeId: Long): MutableList<TaskResponse> {
        TODO("Not yet implemented")
    }

    override fun updateName(taskNameUpdateRequest: CompanyNameUpdateRequest): TaskResponse {
        TODO("Not yet implemented")
    }

    override fun addEmployee(taskEmployeeRequest: TaskEmployeeRequest) {
        TODO("Not yet implemented")
    }

    override fun delete(taskId: Long) {
        TODO("Not yet implemented")
    }
}