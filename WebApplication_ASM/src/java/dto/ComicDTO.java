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
public class ComicDTO {
    private int id;
    private String title;
    private String description;
    private String coverImage;
    private String addAdmin;
    private boolean isActive;
    private String author;
    private String status;
    private int views;
    private int likes;
    private int favorites;

    public ComicDTO() {
    }

    public ComicDTO(int id, String title, String description, String coverImage, String addAdmin, boolean isActive, String author, String status, int views, int likes, int favorites) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coverImage = coverImage;
        this.addAdmin = addAdmin;
        this.isActive = isActive;
        this.author = author;
        this.status = status;
        this.views = views;
        this.likes = likes;
        this.favorites = favorites;
    }

    public ComicDTO(int id, String title, String description, String coverImage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coverImage = coverImage;
    }

    public ComicDTO(int id, String title, String description, String coverImage, String author, String status, int views, int likes, int favorites) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coverImage = coverImage;
        this.author = author;
        this.status = status;
        this.views = views;
        this.likes = likes;
        this.favorites = favorites;
    }
    
    @Override
    public String toString() {
        return "ComicDTO{" + "id=" + id + ", title=" + title + ", description=" + description + ", coverImage=" + coverImage + ", addAdmin=" + addAdmin + ", isActive=" + isActive + ", author=" + author + ", status=" + status + ", views=" + views + ", likes=" + likes + ", favorites=" + favorites + '}';
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getAddAdmin() {
        return addAdmin;
    }

    public void setAddAdmin(String addAdmin) {
        this.addAdmin = addAdmin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    
}
