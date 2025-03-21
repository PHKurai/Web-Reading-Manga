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
public class HistoryDTO {
    private String username;
    private int comic_id;
    private LocalDateTime readAt;

    public HistoryDTO() {
    }

    public HistoryDTO(String username, int comic_id) {
        this.username = username;
        this.comic_id = comic_id;
    }

    public HistoryDTO(String username, int comic_id, LocalDateTime readAt) {
        this.username = username;
        this.comic_id = comic_id;
        this.readAt = readAt;
    }
    
    @Override
    public String toString() {
        return "HistoryDTO{" + "username=" + username + ", comic_id=" + comic_id + ", readAt=" + readAt + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getComic_id() {
        return comic_id;
    }

    public void setComic_id(int comic_id) {
        this.comic_id = comic_id;
    }

    public LocalDateTime getReadAt() {
        return readAt;
    }

    public void setReadAt(LocalDateTime readAt) {
        this.readAt = readAt;
    }
    
    
}
