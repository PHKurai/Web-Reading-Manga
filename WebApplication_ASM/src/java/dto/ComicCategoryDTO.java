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
public class ComicCategoryDTO {
    private int comicId;
    private int categoryId;

    public ComicCategoryDTO() {
    }

    public ComicCategoryDTO(int comicId, int categoryId) {
        this.comicId = comicId;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ComicCategoryDTO{" + "comicId=" + comicId + ", categoryId=" + categoryId + '}';
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    
}
