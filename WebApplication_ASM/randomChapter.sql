DECLARE @comic_id INT = 1;
DECLARE @chapterCount INT;
DECLARE @chapter INT;
DECLARE @pageCount INT;
DECLARE @page INT;
DECLARE @chapterTitle NVARCHAR(200);
DECLARE @chapter_id INT;

WHILE @comic_id <= 50
BEGIN
    -- Generate a random chapter count between 10 and 200 for the current comic.
    SELECT @chapterCount = CAST((RAND(CHECKSUM(NEWID())) * (200 - 10 + 1) + 10) AS INT);
    
    SET @chapter = 1;
    WHILE @chapter <= @chapterCount
    BEGIN
         -- Create a basic chapter title.
         SET @chapterTitle = CONCAT('Chapter ', @chapter);
         
         -- With about 50% chance, append a subtitle.
         IF RAND(CHECKSUM(NEWID())) > 0.5
             SET @chapterTitle = CONCAT(@chapterTitle, ': The Adventure Continues');
         
         -- Insert the chapter record.
         INSERT INTO chapters (comic_id, chapter_number, title)
         VALUES (@comic_id, @chapter, @chapterTitle);
         
         -- Capture the new chapter's id (for inserting pages).
         SET @chapter_id = SCOPE_IDENTITY();
         
         -- Generate a random page count between 3 and 10 for this chapter.
         SELECT @pageCount = CAST((RAND(CHECKSUM(NEWID())) * (10 - 3 + 1) + 3) AS INT);
         
         SET @page = 1;
         WHILE @page <= @pageCount
         BEGIN
             DECLARE @pageImage NVARCHAR(200);
             -- Create a dummy image URL using comic id, chapter and page numbers.
             SET @pageImage = CONCAT('https://example.com/comic', @comic_id, '/chapter', @chapter, '/page', @page, '.jpg');
             
             INSERT INTO pages (chapter_id, image_text, page_number)
             VALUES (@chapter_id, @pageImage, @page);
             
             SET @page = @page + 1;
         END
         
         SET @chapter = @chapter + 1;
    END
    
    SET @comic_id = @comic_id + 1;
END

PRINT 'Chapters and pages added for comics 1 to 50.';