-- 著者テーブルの作成
CREATE TABLE authors (
    id SERIAL PRIMARY KEY,      --id
    name VARCHAR(100) NOT NULL, --著者名
    birth_date DATE,             --生年月日
    del_flag INT DEFAULT 0 NOT NULL  --削除フラグ
);

-- 書籍テーブルの作成
CREATE TABLE books (
    id SERIAL PRIMARY KEY,             --id
    title VARCHAR(200) NOT NULL,       --題名
    isbn VARCHAR(13) UNIQUE NOT NULL,  --ISBN
    published_date DATE,               --発行日
    author_id INT NOT NULL,            --著者id
    del_flag INT DEFAULT 0 NOT NULL,   --削除フラグ
    FOREIGN KEY (author_id) REFERENCES authors (id)
);