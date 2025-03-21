/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author Admin PC
 */
public class CommentDTO {
    private int id;
    private String userId;
    private int chapterId;
    private String content;
    private LocalDateTime createdAt;
    private boolean isActive;
    
    public CommentDTO() {
    }

    public CommentDTO(int id, String userId, int chapterId, String content, LocalDateTime createdAt, boolean isActive) {
        this.id = id;
        this.userId = userId;
        this.chapterId = chapterId;
        this.content = content;
        this.createdAt = createdAt;
        this.isActive = isActive;
    }

    public CommentDTO(String userId, int chapterId, String content) {
        this.userId = userId;
        this.chapterId = chapterId;
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentDTO{" + "id=" + id + ", userId=" + userId + ", chapterId=" + chapterId + ", content=" + content + ", createdAt=" + createdAt + '}';
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
