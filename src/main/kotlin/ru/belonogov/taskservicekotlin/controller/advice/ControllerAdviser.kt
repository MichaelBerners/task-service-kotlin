package ru.belonogov.taskservicekotlin.controller.advice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import ru.belonogov.taskservicekotlin.domain.exception.CompanyNotFoundException
import ru.belonogov.taskservicekotlin.domain.exception.ErrorMessageModel

@ControllerAdvice
class ControllerAdviser {

    fun handleCompanyNotFoundException(ex: CompanyNotFoundException): ResponseEntity<ErrorMessageModel> {

        val errorMessageModel: ErrorMessageModel = ErrorMessageModel(ex.message, HttpStatus.NOT_FOUND.value())

        return ResponseEntity(errorMessageModel, HttpStatus.NOT_FOUND)
    }
}