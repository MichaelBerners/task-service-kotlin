package ru.belonogov.taskservicekotlin.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.belonogov.taskservicekotlin.domain.dto.request.EmployeeRatingUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.EmployeeRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.TaskEmployeeRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.EmployeeResponse
import ru.belonogov.taskservicekotlin.domain.entity.Employee
import ru.belonogov.taskservicekotlin.domain.repository.EmployeeRepository
import ru.belonogov.taskservicekotlin.service.EmployeeService

@Service
class EmployeeServiceImpl(
    @Autowired
    val employeeRepository: EmployeeRepository): EmployeeService {
    override fun create(employeeRequest: EmployeeRequest): EmployeeResponse {
        TODO("Not yet implemented")
    }

    override fun readById(id: Long): Employee {
        TODO("Not yet implemented")
    }

    override fun readAllByCompany(companyName: String): MutableList<Employee> {
        val employees: MutableList<Employee> = employeeRepository.findByCompanyName(companyName)

        return employees
    }

    override fun readAllByTask(id: Long): MutableList<Employee> {
        TODO("Not yet implemented")
    }

    override fun updateRating(employeeRatingUpdateRequest: EmployeeRatingUpdateRequest): EmployeeResponse {
        TODO("Not yet implemented")
    }

    override fun addTask(taskEmployeeRequest: TaskEmployeeRequest) {
        TODO("Not yet implemented")
    }


    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}