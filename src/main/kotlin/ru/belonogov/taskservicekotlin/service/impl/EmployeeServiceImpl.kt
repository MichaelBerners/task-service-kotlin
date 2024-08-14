package ru.belonogov.taskservicekotlin.service.impl

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import ru.belonogov.taskservicekotlin.domain.dto.mapper.toEmployeeResponse
import ru.belonogov.taskservicekotlin.domain.dto.request.EmployeeRatingUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.EmployeeRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.TaskEmployeeRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.EmployeeResponse
import ru.belonogov.taskservicekotlin.domain.entity.Company
import ru.belonogov.taskservicekotlin.domain.entity.Employee
import ru.belonogov.taskservicekotlin.domain.entity.Task
import ru.belonogov.taskservicekotlin.domain.entity.TaskStatus
import ru.belonogov.taskservicekotlin.domain.exception.EmployeeNotFoundException
import ru.belonogov.taskservicekotlin.domain.exception.AddTaskException
import ru.belonogov.taskservicekotlin.domain.repository.EmployeeRepository
import ru.belonogov.taskservicekotlin.service.CompanyService
import ru.belonogov.taskservicekotlin.service.EmployeeService
import ru.belonogov.taskservicekotlin.service.TaskService
import kotlin.jvm.optionals.getOrNull

@Service
class EmployeeServiceImpl(
    val employeeRepository: EmployeeRepository,
    val companyService: CompanyService,
    val taskService: TaskService): EmployeeService {
    override fun create(employeeRequest: EmployeeRequest): EmployeeResponse {
        val companyEntity: Company = companyService.readByName(employeeRequest.companyName)
        val employeeEntity: Employee = Employee(
            firstName = employeeRequest.firstName,
            lastName = employeeRequest.lastName,
            company = companyEntity)
        val saveEmployee = employeeRepository.save(employeeEntity)

        return saveEmployee.toEmployeeResponse()
    }

    override fun readById(employeeId: Long): Employee {
        val employeeEntity: Employee =
            employeeRepository.findById(employeeId).getOrNull() ?: throw EmployeeNotFoundException()

        return employeeEntity
    }

    override fun readAllByCompany(companyName: String): List<EmployeeResponse> {
        val employees: List<Employee> = employeeRepository.findByCompanyName(companyName)

        return employees.map { e -> e.toEmployeeResponse() }
    }

    override fun readAllByTask(id: Long): List<EmployeeResponse> {
        val employees: List<Employee> = employeeRepository.findByTaskId(id)

        return employees.map { e -> e.toEmployeeResponse() }
    }

    override fun updateRating(employeeRatingUpdateRequest: EmployeeRatingUpdateRequest): EmployeeResponse {
        val id: Long = employeeRatingUpdateRequest.id
        val ratingUpd: Int = employeeRatingUpdateRequest.rating
        val employeeEntity = readById(id)
        employeeEntity.rating = ratingUpd
        val updEmployee = employeeRepository.save(employeeEntity)

        return updEmployee.toEmployeeResponse()
    }

    @Transactional
    override fun addTask(taskEmployeeRequest: TaskEmployeeRequest) {
        val taskId: Long = taskEmployeeRequest.taskId
        val employeeId: Long = taskEmployeeRequest.employeeId
        val taskEntity: Task = taskService.readById(taskId)
        val employeeEntity: Employee = readById(employeeId)
        if(validateAddTask(employeeEntity.rating, taskEntity)) {
            employeeEntity.addTask(taskEntity)
            taskService.updateStatus(taskEntity)
            employeeRepository.save(employeeEntity)
        } else throw AddTaskException()
    }

    private fun validateAddTask(employeeRating: Int, taskEntity: Task): Boolean {
        if((taskEntity.taskStatus != TaskStatus.SEARCH_FOR_EMPLOYEES)
            || employeeRating < taskEntity.rating) throw AddTaskException()

      return true
    }

    override fun delete(employeeId: Long) {
        val employeeEntity: Employee = readById(employeeId)
        employeeRepository.delete(employeeEntity)
    }
}