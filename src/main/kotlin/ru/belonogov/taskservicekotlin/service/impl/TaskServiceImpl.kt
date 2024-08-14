package ru.belonogov.taskservicekotlin.service.impl

import org.springframework.stereotype.Service
import ru.belonogov.taskservicekotlin.domain.dto.mapper.toTask
import ru.belonogov.taskservicekotlin.domain.dto.mapper.toTaskResponse
import ru.belonogov.taskservicekotlin.domain.dto.request.TaskRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.TaskResponse
import ru.belonogov.taskservicekotlin.domain.entity.Task
import ru.belonogov.taskservicekotlin.domain.entity.TaskStatus
import ru.belonogov.taskservicekotlin.domain.exception.TaskNotFoundException
import ru.belonogov.taskservicekotlin.domain.repository.TaskRepository
import ru.belonogov.taskservicekotlin.service.TaskService
import kotlin.jvm.optionals.getOrNull

@Service
class TaskServiceImpl(val taskRepository: TaskRepository): TaskService {
    override fun create(taskRequest: TaskRequest): TaskResponse {
        val taskEntity = taskRequest.toTask()
        val saveTask = taskRepository.save(taskEntity)

        return saveTask.toTaskResponse()
    }

    override fun readById(id: Long): Task {
        val taskEntity = taskRepository.findTasksById(id)?: throw TaskNotFoundException()

        return taskEntity
    }

    override fun readAllByEmployee(employeeId: Long): List<TaskResponse> {
        val tasks: List<Task> = taskRepository.findAllByEmployee(employeeId)

        return tasks.map { e -> e.toTaskResponse() }
    }

    override fun updateStatus(taskEntity: Task, canceled: Boolean): Task {
        if(canceled) {
            taskEntity.taskStatus = TaskStatus.CANCELED
            taskRepository.save(taskEntity)
        }
        else if(taskEntity.taskStatus == TaskStatus.SEARCH_FOR_EMPLOYEES
            && taskEntity.employees.size == taskEntity.employeeAssigned) {
            taskEntity.taskStatus = TaskStatus.IN_PROGRESS
        }
        else if(taskEntity.taskStatus == TaskStatus.IN_PROGRESS) {
            taskEntity.taskStatus = TaskStatus.COMPLETED
            taskRepository.save(taskEntity)
        }

        return taskEntity
    }
    override fun delete(taskId: Long) {
        val taskEntity: Task = taskRepository.findById(taskId).getOrNull() ?: throw TaskNotFoundException()
        taskRepository.delete(taskEntity)
    }
}