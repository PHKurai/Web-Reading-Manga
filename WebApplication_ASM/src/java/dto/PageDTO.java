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
public class PageDTO {
    private int chapterId;
    private String imageText;
    private int pageNumber;

    public PageDTO() {
    }

    public PageDTO(int chapterId, String imageText, int pageNumber) {
        this.chapterId = chapterId;
        this.imageText = imageText;
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "PageDTO{" + "chapterId=" + chapterId + ", imageText=" + imageText + ", pageNumber=" + pageNumber + '}';
    }
    
    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

}
