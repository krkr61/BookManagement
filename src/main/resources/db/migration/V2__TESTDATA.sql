INSERT INTO authors (name, birth_date, del_flag) VALUES
('田中　太郎', '1970-11-01', 0),
('鈴木　一郎', '1980-02-24', 0);

INSERT INTO books (title, isbn, published_date, author_id, del_flag) VALUES
('田中自伝', '1234567890123', '2020-11-12', 1, 0),
('鈴木デビュー', '1234567890124', '2019-06-25', 2, 0),
('鈴木二作目', '1234567890125', '2022-07-05', 2, 0);