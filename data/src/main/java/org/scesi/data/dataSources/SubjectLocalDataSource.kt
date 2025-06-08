package org.scesi.data.dataSources

import org.scesi.domain.models.CapError
import org.scesi.domain.models.CapResult
import org.scesi.domain.models.SearchCategory

interface SubjectLocalDataSource {
    suspend fun getSubjects(code: String, path: String): CapResult<SearchCategory.Subject, CapError>
    suspend fun saveSubjects(subjects: SearchCategory.Subject)
}