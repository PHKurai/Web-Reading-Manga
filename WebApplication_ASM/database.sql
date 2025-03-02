USE master;
GO

CREATE DATABASE assignment;
GO

USE assignment;
GO

CREATE TABLE account(
	username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
	name NVARCHAR(50) NOT NULL DEFAULT('member'),
	email VARCHAR(100),
    role VARCHAR(20) NOT NULL DEFAULT('member') CHECK (role IN ('member','admin')),
    avatar VARCHAR(255),
    created_at DATETIME DEFAULT(GETDATE()),
	activity BIT DEFAULT(1)
);

CREATE TABLE comic (
    id INT IDENTITY(1,1) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
	description TEXT,
    cover_image VARCHAR(255),
	add_admin VARCHAR(50) NOT NULL,
    created_at DATETIME DEFAULT(GETDATE()),
	activity BIT DEFAULT(1),
	FOREIGN KEY (add_admin) REFERENCES account(username)
);

CREATE TABLE comic_detail (
    id INT PRIMARY KEY,
    author VARCHAR(100),
    categorie_id TINYINT,
    status VARCHAR(20) NOT NULL DEFAULT('ongoing'),
    views INT NOT NULL DEFAULT(0),
    likes INT NOT NULL DEFAULT(0),
    favorites INT NOT NULL DEFAULT(0),
    FOREIGN KEY (id) REFERENCES comic(id)
);

CREATE TABLE categorie (
    id TINYINT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE comic_categorie (
    comic_id INT NOT NULL,
    category_id TINYINT NOT NULL,
    PRIMARY KEY (comic_id, category_id),
    FOREIGN KEY (comic_id) REFERENCES comic(id),
    FOREIGN KEY (category_id) REFERENCES categorie(id)
);

CREATE TABLE chapter (
    id INT IDENTITY(1,1) PRIMARY KEY,
    comic_id INT NOT NULL,
    chapter_number INT NOT NULL,
    title VARCHAR(200),
    created_at DATETIME DEFAULT(GETDATE()),
    FOREIGN KEY (comic_id) REFERENCES comic(id)
);

CREATE TABLE image (
    id SMALLINT IDENTITY(1,1) PRIMARY KEY,
    chapter_id INT NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    page_number INT,
    FOREIGN KEY (chapter_id) REFERENCES chapter(id)
);

CREATE TABLE comment (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id VARCHAR(50) NOT NULL,
    chapter_id INT NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT(GETDATE()),
    likes INT NOT NULL DEFAULT(0),
    dislikes INT NOT NULL DEFAULT(0),
    FOREIGN KEY (user_id) REFERENCES account(username),
    FOREIGN KEY (chapter_id) REFERENCES chapter(id)
);

CREATE TABLE report (
    report_id INT IDENTITY(1,1) PRIMARY KEY,
    reporter_id VARCHAR(50) NOT NULL,
    type_of_report VARCHAR(20) NOT NULL CHECK (type_of_report IN ('chapter','comment','user')),
    target_id VARCHAR(50) NOT NULL,
    detail TEXT,
    image_of_report VARCHAR(255),
    created_at DATETIME DEFAULT(GETDATE()),
    FOREIGN KEY (reporter_id) REFERENCES account(username)
);


INSERT INTO account( username, password, name, email, role)
VALUES
	('admin01', 'admin@123', N'Đây là admin', 'admin@gmail.com', 'admin'),
	('member01', 'member@123', N'Đây là member', 'member@gmail.com', 'member');
