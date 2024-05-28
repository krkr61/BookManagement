# README

## 環境構築

ブログを参考に構築を進めました

利用ツール: Spring initializr

プラグイン: JOOQ, Flyway Migration, PostgreSQL Driver

Java: 17

データベース: postgresql 16.3

疎通確認用URL: http://localhost:8080/topPage

## データベース定義

以下のテーブルを作成しアプリケーションを構築しました
また、DDLとテストデータは以下に配置しFlywayで管理しました

` resources/db/migration`

### `books` テーブル

| カラム名           | データ型         | 制約                    | 説明    |
|----------------|--------------|-----------------------|-------|
| id             | SERIAL       | PRIMARY KEY           | 書籍ID  |
| title          | VARCHAR(200) | NOT NULL              | タイトル  |
| isbn           | VARCHAR(13)  | UNIQUE, NOT NULL      | ISBN  |
| published_date | DATE         |                       | 発行日   |
| author_id      | INT          | NOT NULL, FOREIGN KEY | 著者ID  |
| del_flag       | INT          | DEFAULT 0, NOT NULL   | 削除フラグ |

#### カラム詳細

- **id**: 書籍の一意の識別子
- **title**: 書籍のタイトル
- **isbn**: 書籍のISBNコード
- **published_date**: 書籍の発行日
- **author_id**: 著者のID。`authors` テーブルの `id` を参照する外部キー。
- **del_flag**: 削除フラグ。デフォルトは0。削除された場合は1になる。

### `authors` テーブル

| カラム名       | データ型         | 制約                  | 説明    |
|------------|--------------|---------------------|-------|
| id         | SERIAL       | PRIMARY KEY         | 著者ID  |
| name       | VARCHAR(100) | NOT NULL            | 著者名   |
| birth_date | DATE         |                     | 生年月日  |
| del_flag   | INT          | DEFAULT 0, NOT NULL | 削除フラグ |

#### カラム詳細

- **id**: 著者の一意の識別子
- **name**: 著者の名前
- **birth_date**: 著者の生年月日
- **del_flag**: 削除フラグ。デフォルトは0。削除された場合は1になる。

## JOOQの生成コード

JOOQで生成したコードは以下に配置されます

`src/main/java/com/jooq/generate`

## API説明

以下に作成したAPIの説明と使用方法を記載します

### 書籍著者ID検索

#### ソース

`kotlin/com/submission/bookManagement/controller/BooksController.kt`

`fun getBooksByAuthorId`

#### 説明

取得した著者IDから、その著者に紐づく書籍を配列で取得します

#### 使用例

http://localhost:8080/getbooksbyauthorid?authorId=1

### 書籍タイトル検索

#### ソース

`kotlin/com/submission/bookManagement/controller/BooksController.kt`

`fun getBooksByTitle`

#### 説明

取得したタイトルを含む書籍を配列で取得します

#### 使用例

http://localhost:8080/getbooksbytitle?title=%E9%88%B4%E6%9C%A8

### 書籍追加

#### ソース

`kotlin/com/submission/bookManagement/controller/BooksController.kt`

`fun insertBook`

#### 説明

書籍情報をデータベースに追加します  
追加に成功した場合は自動で採番された書籍IDを、失敗した場合は失敗のメッセージを返します

#### 使用例

src/main/resources/postHtml/bookinsert.html
をブラウザで開きpost

またはPostmanなどpostを送信するツールで以下の項目を送信

* title
* isbn
* publishedDate
* authorId
* delFlag

### 書籍更新

#### ソース

`kotlin/com/submission/bookManagement/controller/BooksController.kt`

`fun updateBook`

#### 説明

書籍IDの一致する書籍情報を更新します  
更新に成功した場合はメッセージを返します  
書籍IDが指定されていない場合や更新対象が存在しない場合は失敗のメッセージを返します

#### 使用例

src/main/resources/postHtml/bookupdate.html
をブラウザで開きpost

またはPostmanなどpostを送信するツールで以下の項目を送信

* id
* title
* isbn
* publishedDate
* authorId
* delFlag

### 著者検索

#### ソース

`kotlin/com/submission/bookManagement/controller/AuthorsController.kt`

`fun getAuthorsByName`

#### 説明

取得した名前を含む著者を配列で取得します

#### 使用例

http://localhost:8080/getauthorsbyname?name=%E9%83%8E

### 書籍追加

#### ソース

`kotlin/com/submission/bookManagement/controller/AuthorsController.kt`

`fun insertAuthor`

#### 説明

著者情報をデータベースに追加します  
追加に成功した場合は自動で採番された著者IDを、失敗した場合は失敗のメッセージを返します

#### 使用例

src/main/resources/postHtml/authorinsert.html
をブラウザで開きpost

またはPostmanなどpostを送信するツールで以下の項目を送信

* name
* birthDate
* delFlag

### 書籍更新

#### ソース

`kotlin/com/submission/bookManagement/controller/AuthorsController.kt`

`fun updateAuthor`

#### 説明

著者IDの一致する著者情報を更新します  
更新に成功した場合はメッセージを返します  
著者IDが指定されていない場合や更新対象が存在しない場合は失敗のメッセージを返します

#### 使用例

src/main/resources/postHtml/authorupdate.html
をブラウザで開きpost

またはPostmanなどpostを送信するツールで以下の項目を送信

* id
* name
* birthDate
* delFlag

## ToDo

以下については実装ができていません

* エラーハンドリングができていないため、データベース側で一意制約違反などエラーが発生するとデフォルトのエラーページに遷移するため、エラーの原因がユーザーからは特定しにくい
* 挿入・更新処理の前にID等の重複チェックができていない
* 削除単体でのAPIがないため更新処理でdelFlagを1にするしかない
* 書籍や著者の検索できる項目が限られているため、各年月日などで絞り込み検索ができない
* 書籍と著者を複合した情報での検索ができない

## 感想

* KotlinもSpring Bootも初めて触れるため、特にプラグイン周りの構築に苦戦した
* JOOQで自動生成されたコード使用する手順を確立するまではかなり悩んだが、使えるようになるとかなり便利だと感じた
* controller service repositoryの役割分担については、初めてながら正しく書けていると思う
* やはり初めての技術は調べるのも理解するのも大変だが、徐々に動くようになってくると喜びを感じる