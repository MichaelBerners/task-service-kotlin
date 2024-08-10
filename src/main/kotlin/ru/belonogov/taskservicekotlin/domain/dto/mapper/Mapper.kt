package ru.belonogov.taskservicekotlin.domain.dto.mapper

import ru.belonogov.taskservicekotlin.domain.dto.request.CompanySaveRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.CompanyResponse
import ru.belonogov.taskservicekotlin.domain.entity.Company

fun CompanySaveRequest.toCompany() = Company(name = this.name)
fun CompanyUpdateRequest.toCompany() = Company(id = this.id, name = this.name)
fun Company.toCompanyResponse() = CompanyResponse(name = this.name)


