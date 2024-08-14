package ru.belonogov.taskservicekotlin.service

import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyNameUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.CompanyResponse
import ru.belonogov.taskservicekotlin.domain.entity.Company

interface CompanyService {

    fun create(companyRequest: CompanyRequest): CompanyResponse
    fun readById(id: Long): Company
    fun readByName(name: String): Company
    fun read(name: String): CompanyResponse
    fun update(company: CompanyNameUpdateRequest): CompanyResponse
    fun delete(companyId: Long)



}