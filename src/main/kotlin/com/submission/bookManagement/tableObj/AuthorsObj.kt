package com.submission.bookManagement.tableObj

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.time.LocalDate

data class AuthorObj(
    val id: Int? = null,

    @NotEmpty(message = "Name is required")
    val name: String,

    val birthDate: LocalDate? = null,

    @NotNull(message = "Delete Flag is required")
    @Positive(message = "Delete Flag must be a positive integer")
    val delFlag: Int = 0
)