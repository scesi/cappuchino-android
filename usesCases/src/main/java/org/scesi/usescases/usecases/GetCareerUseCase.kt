package org.scesi.usescases.usecases

import org.koin.core.annotation.Factory
import org.scesi.domain.repositories.CareerRepository

@Factory
class GetCareerUseCase(
    private val careerRepository: CareerRepository
) {
    suspend operator fun invoke() =
        careerRepository.getCareer()
}