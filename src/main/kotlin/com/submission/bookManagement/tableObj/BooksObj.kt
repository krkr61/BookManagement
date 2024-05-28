package com.submission.bookManagement.tableObj

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class BooksObj(
    val id: Int? = null,

    @NotEmpty
    val title: String,

    @NotEmpty(message = "ISBN is required")
    @Pattern(regexp = "\\d{13}")
    val isbn: String,

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    val publishedDate: LocalDate? = null,

    @NotNull
    @Positive
    val authorId: Int,

    val delFlag: Int = 0
)