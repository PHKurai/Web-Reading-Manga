/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ComicLikeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import utils.DBUtils;

/**
 *
 * @author Admin PC
 */
public class ComicLikeDAO implements I_DAO<ComicLikeDTO, Map<String, Integer>> {

    @Override
    public boolean create(ComicLikeDTO entity) {
        String sql = "INSERT INTO comic_likes (username, comic_id) VALUES (?, ?)";
        String sqlUpdateComics = "UPDATE comics SET likes = likes + 1 WHERE id = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, entity.getUsername());
            ps.setInt(2, entity.getComicId());
            
            PreparedStatement ps2 = conn.prepareStatement(sqlUpdateComics);
            ps2.setInt(1, entity.getComicId());
            
            int i = ps.executeUpdate(), j = 0;
            
            if (i>0) {
                ps2.executeUpdate();
            }
            return i>0 && j>0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(ComicLikeDTO entity) {
        return false;
    }

    @Override
    public boolean delete(Map<String, Integer> id) {
        String sql = "DELETE FROM comic_likes WHERE username = ? AND comic_id = ?";
        String sqlUpdateComics = "UPDATE comics SET likes = likes - 1 WHERE id = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            PreparedStatement ps2 = conn.prepareStatement(sqlUpdateComics);
            
            for (Map.Entry<String, Integer> entry : id.entrySet()) {
                String username = entry.getKey();
                Integer comicId = entry.getValue();
                ps.setString(1, username);
                ps.setInt(2, comicId);
                
                ps2.setInt(1, comicId);
            }

            int i = ps.executeUpdate(), j = 0;
            
            if (i>0) {
                ps2.executeUpdate();
            }
            return i>0 && j>0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<ComicLikeDTO> readAll() {
        return null;
    }

    @Override
    public ComicLikeDTO readById(Map<String, Integer> id) {
        return null;
    }

    @Override
    public List<ComicLikeDTO> search(String searchTerm) {
        return null;
    }
    
    public boolean isLiked(String username, int comicId) {
        String sql = "SELECT 1 FROM comic_likes WHERE username = ? AND comic_id = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setInt(2, comicId);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
