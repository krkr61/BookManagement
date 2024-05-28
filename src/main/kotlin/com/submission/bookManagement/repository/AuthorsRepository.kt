package com.submission.bookManagement.repository

import com.jooq.generate.Tables.AUTHORS
import com.submission.bookManagement.tableObj.AuthorObj
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class AuthorsRepository(private val dsl: DSLContext) {

    fun findByName(name: String): List<AuthorObj> {
        return dsl.selectFrom(AUTHORS)
            .where(AUTHORS.NAME.like("%" + name + "%").and(AUTHORS.DEL_FLAG.eq(0)))
            .fetchInto(AuthorObj::class.java)
    }

    fun insertAuthor(author: AuthorObj): Int? {
        return dsl.insertInto(AUTHORS)
            .set(AUTHORS.NAME, author.name)
            .set(AUTHORS.BIRTH_DATE, author.birthDate)
            .set(AUTHORS.DEL_FLAG, author.delFlag)
            .returningResult(AUTHORS.ID)
            .fetchOne()
            ?.getValue(AUTHORS.ID)
    }

    fun updateAuthor(author: AuthorObj): Int? {
        return dsl.update(AUTHORS)
            .set(AUTHORS.NAME, author.name)
            .set(AUTHORS.BIRTH_DATE, author.birthDate)
            .set(AUTHORS.DEL_FLAG, author.delFlag)
            .where(AUTHORS.ID.eq(author.id))
            .execute()
    }
}