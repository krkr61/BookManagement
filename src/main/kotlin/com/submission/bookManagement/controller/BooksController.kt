package com.submission.bookManagement.controller

import com.submission.bookManagement.service.BooksService
import com.submission.bookManagement.tableObj.BooksObj
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
class BooksController(private val booksService: BooksService) {

    @GetMapping("/topPage")
    fun topPage(): String {
        return "topPage"
    }

    /**
     * 書籍を著者IDで検索し取得する
     *
     * @param authorId 著者ID
     * @return List<BooksObj> 書籍情報の配列
     */
    @GetMapping("/getbooksbyauthorid")
    @Validated
    fun getBooksByAuthorId(
        @RequestParam
        @NotBlank
        @Pattern(regexp = "^[0-9]+\$")
        authorId: String
    ): List<BooksObj> {
        return booksService.getBooksByAuthorId(authorId.toInt())
    }

    /**
     * 書籍をタイトルでLike検索し取得する
     *
     * @param title 書籍のタイトル
     * @return List<BooksObj> 書籍情報の配列
     */
    @GetMapping("/getbooksbytitle")
    @Validated
    fun getBooksByTitle(
        @RequestParam
        @NotBlank
        title: String
    ): List<BooksObj> {
        return booksService.getBooksByTitle(title)
    }

    /**
     * 書籍を追加する
     */
    @PostMapping("/insertbook")
    fun insertBook(@Validated @ModelAttribute booksObj: BooksObj): ResponseEntity<Any> {
        val bookId = booksService.insertBook(booksObj)
        val msg = if (bookId != null) {
            "処理成功 　登録書籍ID: $bookId"
        } else {
            "処理失敗"
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(msg)
    }

    /**
     * 書籍を更新する
     */
    @PostMapping("/updatebook")
    fun updateBook(@Validated @ModelAttribute booksObj: BooksObj): ResponseEntity<Any> {
        if (booksObj.id == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("書籍IDが指定されていません")
        }
        val updateCount = booksService.updateBook(booksObj)
        val msg = if (updateCount != null && updateCount != 0) {
            "処理成功"
        } else {
            "処理失敗 書籍IDが間違っている可能性があります"
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(msg)
    }
}
