package ru.belonogov.taskservicekotlin.domain.exception


import kotlin.RuntimeException

class CompanyNotFoundException(message: String = "Company not found"): Throwable(message) {
}