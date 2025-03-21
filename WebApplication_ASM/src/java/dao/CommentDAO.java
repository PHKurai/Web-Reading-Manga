/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CommentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin PC
 */
public class CommentDAO implements I_DAO<CommentDTO, Integer> {

    @Override
    public boolean create(CommentDTO entity) {
        String sql = "INSERT INTO comments (username, chapter_id, content) "
                + "VALUES (?, ?, ?)";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, entity.getUserId());
            ps.setInt(2, entity.getChapterId());
            ps.setString(3, entity.getContent());

            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(CommentDTO entity) {
        String sql
                = "UPDATE comments "
                + "SET content = ?, is_active = ? "
                + "WHERE id = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, entity.getContent());
            ps.setBoolean(2, entity.isIsActive());
            ps.setInt(3, entity.getId());

            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql
                = "UPDATE comments "
                + "SET is_active = 0 "
                + "WHERE id = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<CommentDTO> readAll() {
        return null;
    }

    @Override
    public CommentDTO readById(Integer id) {
        String sql
                = "SELECT id, username, chapter_id, content, created_at, is_active "
                + "FROM comments "
                + "WHERE id = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CommentDTO comment = new CommentDTO();
                    comment.setId(rs.getInt("id"));
                    comment.setUserId(rs.getString("username"));
                    comment.setChapterId(rs.getInt("chapter_id"));
                    comment.setContent(rs.getString("content"));
                    comment.setIsActive(rs.getBoolean("is_active"));

                    Timestamp ts = rs.getTimestamp("created_at");
                    if (ts != null) {
                        comment.setCreatedAt(ts.toLocalDateTime());
                    }
                    
                    return comment;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CommentDTO> search(String searchTerm) {
        return null;
    }

    public List<CommentDTO> getCommentsByChapterId(int chapterId, int page, int pageSize) {
        List<CommentDTO> list = new ArrayList<>();
        int offset = (page - 1) * pageSize;

        String sql
                = "SELECT id, username, chapter_id, content, created_at, is_active "
                + "FROM comments "
                + "WHERE chapter_id = ? AND is_active = 1 "
                + "ORDER BY created_at DESC "
                + "OFFSET ? ROWS "
                + "FETCH NEXT ? ROWS ONLY;";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, chapterId);
            ps.setInt(2, offset);
            ps.setInt(3, pageSize);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CommentDTO comment = new CommentDTO();
                    comment.setId(rs.getInt("id"));
                    comment.setUserId(rs.getString("username"));
                    comment.setChapterId(rs.getInt("chapter_id"));
                    comment.setContent(rs.getString("content"));
                    comment.setIsActive(rs.getBoolean("is_active"));

                    Timestamp ts = rs.getTimestamp("created_at");
                    if (ts != null) {
                        comment.setCreatedAt(ts.toLocalDateTime());
                    }
                    list.add(comment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countCommentsByChapter(int chapterId) {
        String sql = "SELECT COUNT(*) AS total FROM comments WHERE chapter_id = ? AND is_active = 1";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, chapterId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
