/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.FollowDTO;
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
public class FollowDAO implements I_DAO<FollowDTO, Map<String, Integer>> {

    @Override
    public boolean create(FollowDTO entity) {
        String sql = "INSERT INTO follows (username, comic_id) VALUES (?, ?)";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, entity.getUserId());
            ps.setInt(2, entity.getComicId());

            int i = ps.executeUpdate();
            return i>0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(FollowDTO entity) {
        return false;
    }

    @Override
    public boolean delete(Map<String, Integer> id) {
        String sql = "DELETE FROM follows WHERE username = ? AND comic_id = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            for (Map.Entry<String, Integer> entry : id.entrySet()) {
                String username = entry.getKey();
                Integer comicId = entry.getValue();
                ps.setString(1, username);
                ps.setInt(2, comicId);
            }

            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<FollowDTO> readAll() {
        return null;
    }

    @Override
    public FollowDTO readById(Map<String, Integer> id) {
        return null;
    }

    @Override
    public List<FollowDTO> search(String searchTerm) {
        return null;
    }

    public boolean isFollowing(String username, int comicId) {
        String sql = "SELECT 1 FROM follows WHERE username = ? AND comic_id = ?";
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
