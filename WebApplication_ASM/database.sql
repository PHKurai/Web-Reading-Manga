USE master;

CREATE DATABASE assignment;
GO

USE assignment;

CREATE TABLE accounts(
	username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
	name NVARCHAR(50) NOT NULL DEFAULT('member'),
	email VARCHAR(100),
    role VARCHAR(20) NOT NULL DEFAULT('member') CHECK (role IN ('member','admin')),
    avatar TEXT,
	created_at DATETIME DEFAULT(GETDATE()),
	is_active BIT DEFAULT(1)
);

CREATE TABLE comics (
    id INT IDENTITY(1,1) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
	description TEXT,
    cover_image TEXT,
	add_admin VARCHAR(50) NOT NULL,
	is_active BIT DEFAULT(1),
    author VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT('ongoing'),
    views INT NOT NULL DEFAULT(0),
    likes INT NOT NULL DEFAULT(0),
    favorites INT NOT NULL DEFAULT(0),
	created_at DATETIME DEFAULT(GETDATE()),
	FOREIGN KEY (add_admin) REFERENCES accounts(username)
);

CREATE TABLE categories (
    id TINYINT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE comics_categories (
    comic_id INT NOT NULL,
    category_id TINYINT NOT NULL,
    PRIMARY KEY (comic_id, category_id),
    FOREIGN KEY (comic_id) REFERENCES comics(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE chapters (
    id INT IDENTITY(1,1) PRIMARY KEY,
    comic_id INT NOT NULL,
    chapter_number INT NOT NULL,
    title VARCHAR(200),
	is_active BIT DEFAULT(1),
	created_at DATETIME DEFAULT(GETDATE()),
    FOREIGN KEY (comic_id) REFERENCES comics(id)
);

CREATE TABLE pages (
    id SMALLINT IDENTITY(1,1) PRIMARY KEY,
    chapter_id INT NOT NULL,
    image_text TEXT NOT NULL,
    page_number INT NOT NULL,
    FOREIGN KEY (chapter_id) REFERENCES chapters(id)
);

CREATE TABLE comments (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    chapter_id INT NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT(GETDATE()),
	is_active BIT DEFAULT(1),
    FOREIGN KEY (username) REFERENCES accounts(username),
    FOREIGN KEY (chapter_id) REFERENCES chapters(id)
);

CREATE TABLE reports (
    report_id INT IDENTITY(1,1) PRIMARY KEY,
    reporter_id VARCHAR(50) NOT NULL,
    type_of_report VARCHAR(20) NOT NULL CHECK (type_of_report IN ('chapter','comment','user')),
    target_id VARCHAR(50) NOT NULL,
    detail TEXT,
    image_of_report TEXT,
    created_at DATETIME DEFAULT(GETDATE()),
	is_active BIT DEFAULT(1),
    FOREIGN KEY (reporter_id) REFERENCES accounts(username)
);

CREATE TABLE histories (
    username VARCHAR(50) NOT NULL,
    comic_id INT NOT NULL,
    read_at DATETIME NOT NULL,
	PRIMARY KEY (username, comic_id),
    FOREIGN KEY (username) REFERENCES accounts(username), 
    FOREIGN KEY (comic_id) REFERENCES comics(id)
);

CREATE TABLE follows (
    username VARCHAR(50) NOT NULL,
    comic_id INT NOT NULL,
    follow_at DATETIME NOT NULL DEFAULT(GETDATE()),
	PRIMARY KEY (username, comic_id),
    FOREIGN KEY (username) REFERENCES accounts(username),
    FOREIGN KEY (comic_id) REFERENCES comics(id)
);

CREATE TABLE comic_likes (
    username VARCHAR(50) NOT NULL,
    comic_id INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT(GETDATE()),
    PRIMARY KEY (username, comic_id),
    FOREIGN KEY (username) REFERENCES accounts(username),
    FOREIGN KEY (comic_id) REFERENCES comics(id)
);

INSERT INTO accounts(username, password, name, email, role)
VALUES
	('admin01', 'admin@123', N'Đây là admin', 'admin@gmail.com', 'admin'),
	('member01', 'member@123', N'Đây là member', 'member@gmail.com', 'member');
