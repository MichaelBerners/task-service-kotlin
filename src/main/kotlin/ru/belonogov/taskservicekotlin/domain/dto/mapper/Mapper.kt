package ru.belonogov.taskservicekotlin.domain.dto.mapper

import ru.belonogov.taskservicekotlin.domain.dto.request.*
import ru.belonogov.taskservicekotlin.domain.dto.responce.CompanyResponse
import ru.belonogov.taskservicekotlin.domain.dto.responce.EmployeeResponse
import ru.belonogov.taskservicekotlin.domain.dto.responce.TaskResponse
import ru.belonogov.taskservicekotlin.domain.entity.Company
import ru.belonogov.taskservicekotlin.domain.entity.Employee
import ru.belonogov.taskservicekotlin.domain.entity.Task

fun CompanyRequest.toCompany() = Company(name = name)
fun EmployeeRequest.toEmployee() = Employee(firstName = firstName, lastName = lastName)
fun TaskRequest.toTask() = Task(name = name, description = description, rating = rating)
fun Company.toCompanyResponse() = CompanyResponse(name = name)
fun Employee.toEmployeeResponse() = EmployeeResponse(
    firstName = firstName!!,
    lastName = lastName!!,
    rating = rating,
    companyName = company!!.name)
fun Task.toTaskResponse() = TaskResponse(name = name, description = description, rating = rating)

