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
public class FollowDTO {
    private String userId;
    private int comicId;
    private LocalDateTime followAt;

    public FollowDTO() {
    }

    public FollowDTO(String userId, int comicId, LocalDateTime followAt) {
        this.userId = userId;
        this.comicId = comicId;
        this.followAt = followAt;
    }

    public FollowDTO(String userId, int comicId) {
        this.userId = userId;
        this.comicId = comicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public LocalDateTime getFollowAt() {
        return followAt;
    }

    public void setFollowAt(LocalDateTime followAt) {
        this.followAt = followAt;
    }

    @Override
    public String toString() {
        return "FollowDTO{" + "userId=" + userId + ", comicId=" + comicId + ", followAt=" + followAt + '}';
    }
    
}
