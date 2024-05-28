package com.submission.bookManagement.controller

import com.submission.bookManagement.service.AuthorsService
import com.submission.bookManagement.tableObj.AuthorObj
import jakarta.validation.constraints.NotBlank
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
class AuthorsController(private val authorsService: AuthorsService) {

    /**
     * 著者を名前でLike検索し取得する
     *
     * @param name 著者の名前
     * @return List<AuthorObj> 著者情報の配列
     */
    @GetMapping("/getauthorsbyname")
    @Validated
    fun getAuthorsByName(
        @RequestParam
        @NotBlank
        name: String
    ): List<AuthorObj> {
        return authorsService.getAuthorsByName(name)
    }

    /**
     * 著者を追加する
     */
    @PostMapping("/insertauthor")
    fun insertAuthor(@Validated @ModelAttribute authorObj: AuthorObj): ResponseEntity<Any> {
        val authorId = authorsService.insertAuthor(authorObj)
        val msg = if (authorId != null) {
            "処理成功 　登録著者ID: $authorId"
        } else {
            "処理失敗"
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(msg)
    }

    /**
     * 著者を更新する
     */
    @PostMapping("/updateauthor")
    fun updateAuthor(@Validated @ModelAttribute authorObj: AuthorObj): ResponseEntity<Any> {
        if (authorObj.id == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("著者IDが指定されていません")
        }
        val updateCount = authorsService.updateAuthor(authorObj)
        val msg = if (updateCount != null && updateCount != 0) {
            "処理成功"
        } else {
            "処理失敗 著者IDが間違っている可能性があります"
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(msg)
    }
}
