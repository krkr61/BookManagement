package com.submission.bookManagement.repository

import com.jooq.generate.tables.Books
import com.jooq.generate.tables.Books.BOOKS
import com.submission.bookManagement.tableObj.BooksObj
import org.springframework.stereotype.Repository
import org.jooq.DSLContext

@Repository
class BooksRepository(private val dsl: DSLContext) {

    fun findByAuthorId(authorId: Int): List<BooksObj> {
        return dsl.selectFrom(BOOKS)
            .where(BOOKS.AUTHOR_ID.eq(authorId).and(BOOKS.DEL_FLAG.eq(0)))
            .fetchInto(BooksObj::class.java)
    }

    fun findByTitlle(title: String): List<BooksObj> {
        return dsl.selectFrom(BOOKS)
            .where(BOOKS.TITLE.like("%" + title + "%").and(BOOKS.DEL_FLAG.eq(0)))
            .fetchInto(BooksObj::class.java)
    }

    fun insertBook(book: BooksObj): Int? {
        return dsl.insertInto(BOOKS)
            .set(BOOKS.TITLE, book.title)
            .set(BOOKS.ISBN, book.isbn)
            .set(BOOKS.PUBLISHED_DATE, book.publishedDate)
            .set(BOOKS.AUTHOR_ID, book.authorId)
            .set(BOOKS.DEL_FLAG, book.delFlag)
            .returningResult(BOOKS.ID)
            .fetchOne()
            ?.getValue(BOOKS.ID)
    }

    fun updateBook(book: BooksObj): Int? {
        return dsl.update(BOOKS)
            .set(BOOKS.TITLE, book.title)
            .set(BOOKS.ISBN, book.isbn)
            .set(BOOKS.PUBLISHED_DATE, book.publishedDate)
            .set(BOOKS.AUTHOR_ID, book.authorId)
            .set(BOOKS.DEL_FLAG, book.delFlag)
            .where(BOOKS.ID.eq(book.id))
            .execute()
    }
}