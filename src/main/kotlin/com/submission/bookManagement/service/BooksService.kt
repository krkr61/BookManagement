package com.submission.bookManagement.service

import com.submission.bookManagement.repository.BooksRepository
import com.submission.bookManagement.tableObj.BooksObj
import org.springframework.stereotype.Service
import java.awt.print.Book

@Service
class BooksService(private val bookRepository: BooksRepository) {
    fun getBooksByAuthorId(authorId: Int): List<BooksObj> {
        return bookRepository.findByAuthorId(authorId)
    }

    fun getBooksByTitle(title: String): List<BooksObj> {
        return bookRepository.findByTitlle(title)
    }

    fun insertBook(book: BooksObj): Int? {
        return bookRepository.insertBook(book)
    }

    fun updateBook(book: BooksObj): Int? {
        return bookRepository.updateBook(book)
    }
}