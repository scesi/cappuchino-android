package org.scesi.usescases.usecases

import org.koin.core.annotation.Factory
import org.scesi.domain.repositories.CareerRepository

@Factory
class GetSubjectsUseCase(
    private val careerRepository: CareerRepository
) {
    suspend operator fun invoke(code: String, path: String) =
        careerRepository.getListOfSubjects(code, path)
}