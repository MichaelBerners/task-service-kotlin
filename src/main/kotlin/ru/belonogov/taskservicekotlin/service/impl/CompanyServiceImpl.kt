package ru.belonogov.taskservicekotlin.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.belonogov.taskservicekotlin.domain.dto.mapper.toCompany
import ru.belonogov.taskservicekotlin.domain.dto.mapper.toCompanyResponse
import ru.belonogov.taskservicekotlin.domain.dto.request.CompanySaveRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyUpdateRequest
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
    override fun create(companySaveRequest: CompanySaveRequest): CompanyResponse {
        val company:Company = companySaveRequest.toCompany()
        val saveCompany: Company = companyRepository.saveAndFlush(company)

        return saveCompany.toCompanyResponse()
    }

    override fun findById(id: Long): Company {
        val company: Company = companyRepository.findById(id).getOrNull()?:
        throw CompanyNotFoundException()

        return company
    }

    override fun findByName(name: String): Company {
        val company: Company = companyRepository.findCompanyByName(name) ?: throw CompanyNotFoundException()

        return company
    }

    override fun read(name: String): CompanyResponse {
        val company = companyRepository.findCompanyByName(name) ?: throw CompanyNotFoundException()

        return company.toCompanyResponse()
    }

    override fun update(companyRequest: CompanyUpdateRequest): CompanyResponse {
        val companyEntity = companyRequest.toCompany()
        val updateCompanyEntity = companyRepository.save(companyEntity)

        return updateCompanyEntity.toCompanyResponse()
    }

    override fun delete(id: Long) {
        val companyEntity: Company = companyRepository.findById(id).getOrNull()?: throw CompanyNotFoundException()
        companyRepository.delete(companyEntity)
    }
}