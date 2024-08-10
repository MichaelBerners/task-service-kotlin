package ru.belonogov.taskservicekotlin.service

import ru.belonogov.taskservicekotlin.domain.dto.request.CompanySaveRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.CompanyResponse
import ru.belonogov.taskservicekotlin.domain.entity.Company

interface CompanyService {

    fun create(companySaveRequest: CompanySaveRequest): CompanyResponse
    fun findById(id: Long): Company?
    fun findByName(name: String): Company?
    fun read(name: String): CompanyResponse
    fun update(company: CompanyUpdateRequest): CompanyResponse
    fun delete(id: Long)



}