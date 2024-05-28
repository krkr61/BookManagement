package com.submission.bookManagement.service

import com.submission.bookManagement.repository.AuthorsRepository
import com.submission.bookManagement.tableObj.AuthorObj
import org.springframework.stereotype.Service

@Service
class AuthorsService(private val authorsRepository: AuthorsRepository) {

    fun getAuthorsByName(name: String): List<AuthorObj> {
        return authorsRepository.findByName(name)
    }

    fun insertAuthor(author: AuthorObj): Int? {
        return authorsRepository.insertAuthor(author)
    }

    fun updateAuthor(author: AuthorObj): Int? {
        return authorsRepository.updateAuthor(author)
    }
}