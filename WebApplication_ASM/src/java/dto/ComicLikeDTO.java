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
public class ComicLikeDTO {
    private String username;
    private int comicId;

    public ComicLikeDTO() {
    }

    public ComicLikeDTO(String username, int comicId) {
        this.username = username;
        this.comicId = comicId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    @Override
    public String toString() {
        return "ComicLikeDTO{" + "username=" + username + ", comicId=" + comicId + '}';
    }
    
    
}
