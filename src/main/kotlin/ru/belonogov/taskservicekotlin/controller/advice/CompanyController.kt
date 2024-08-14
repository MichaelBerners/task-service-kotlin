package ru.belonogov.taskservicekotlin.controller.advice

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyNameUpdateRequest
import ru.belonogov.taskservicekotlin.domain.dto.request.CompanyRequest
import ru.belonogov.taskservicekotlin.domain.dto.responce.CompanyResponse
import ru.belonogov.taskservicekotlin.service.CompanyService

@RestController
@RequestMapping("/company")
class CompanyController (val companyService: CompanyService){

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody companyRequest: CompanyRequest): CompanyResponse =
        companyService.create(companyRequest)

    @GetMapping(value = ["/{companyName}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun read(@PathVariable companyName: String): CompanyResponse = companyService.read(companyName)

    @PostMapping(value = ["/update"])
    fun update(companyNameUpdateRequest: CompanyNameUpdateRequest): CompanyResponse =
        companyService.update(companyNameUpdateRequest)

    @PostMapping(value = ["/delete{companyId}"])
    fun delete(@PathVariable companyId: Long) = companyService.delete(companyId)




}