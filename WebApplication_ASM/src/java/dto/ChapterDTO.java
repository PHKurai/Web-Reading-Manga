/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin PC
 */
public class ChapterDTO {

    private int id;
    private int comicId;
    private int chapterNumber;
    private String title;
    private String createdDate;
    private boolean isActive;

    public ChapterDTO() {
    }

    public ChapterDTO(int id, int comicId, int chapterNumber, String title, String createdDate, boolean isActive) {
        this.id = id;
        this.comicId = comicId;
        this.chapterNumber = chapterNumber;
        this.title = title;
        this.createdDate = createdDate;
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChapterDTO other = (ChapterDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "ChapterDTO{" + "id=" + id + ", comicId=" + comicId + ", chapterNumber=" + chapterNumber + ", title=" + title + ", createdDate=" + createdDate + ", isActive=" + isActive + '}';
    }

    

}
