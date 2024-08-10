package ru.belonogov.taskservicekotlin.service

import ru.belonogov.taskservicekotlin.domain.dto.request.EmployeeRatingUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.EmployeeRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.TaskEmployeeRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.EmployeeResponse
import ru.belonogov.taskservicekotlin.domain.entity.Employee

interface EmployeeService {

fun create(employeeRequest: EmployeeRequest): EmployeeResponse
fun readById(employeeId: Long): Employee
fun readAllByCompany(companyName: String): MutableList<Employee>
fun readAllByTask(taskId: Long): MutableList<Employee>
fun updateRating(employeeRatingUpdateRequest: EmployeeRatingUpdateRequest): EmployeeResponse
fun addTask(taskEmployeeRequest: TaskEmployeeRequest)
fun delete(employeeId: Long)
}