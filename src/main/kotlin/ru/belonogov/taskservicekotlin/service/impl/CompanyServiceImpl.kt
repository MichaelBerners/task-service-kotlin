package ru.belonogov.taskservicekotlin.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.belonogov.taskservicekotlin.domain.dto.mapper.toCompany
import ru.belonogov.taskservicekotlin.domain.dto.mapper.toCompanyResponse
import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyNameUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.CompanyResponse
import ru.belonogov.taskservicekotlin.domain.entity.Company
import ru.belonogov.taskservicekotlin.domain.exception.CompanyNotFoundException
import ru.belonogov.taskservicekotlin.domain.repository.CompanyRepository
import ru.belonogov.taskservicekotlin.service.CompanyService
import kotlin.jvm.optionals.getOrNull

@Service
class CompanyServiceImpl(
    @Autowired
    val companyRepository: CompanyRepository): CompanyService {
    override fun create(companyRequest: CompanyRequest): CompanyResponse {
        val company:Company = companyRequest.toCompany()
        val saveCompany: Company = companyRepository.saveAndFlush(company)

        return saveCompany.toCompanyResponse()
    }

    override fun readById(id: Long): Company {
        val company: Company = companyRepository.findById(id).getOrNull()?:
        throw CompanyNotFoundException()

        return company
    }

    override fun readByName(name: String): Company {
        val company: Company = companyRepository.findCompanyByName(name) ?: throw CompanyNotFoundException()

        return company
    }

    override fun read(name: String): CompanyResponse {
        val company = companyRepository.findCompanyByName(name) ?: throw CompanyNotFoundException()

        return company.toCompanyResponse()
    }

    override fun update(companyNameUpdateRequest: CompanyNameUpdateRequest): CompanyResponse {
        val companyEntity: Company = readById(companyNameUpdateRequest.id)
        companyEntity.name = companyNameUpdateRequest.name
        val updateCompanyEntity: Company = companyRepository.save(companyEntity)

        return updateCompanyEntity.toCompanyResponse()
    }

    override fun delete(id: Long) {
        val companyEntity: Company = companyRepository.findById(id).getOrNull()?: throw CompanyNotFoundException()
        companyRepository.delete(companyEntity)
    }
}