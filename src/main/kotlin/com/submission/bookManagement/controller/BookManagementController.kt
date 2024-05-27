package com.submission.bookManagement.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookManagementController {

    @GetMapping("/topPage")
    fun topPage(): String {
        return "topPage"
    }
}