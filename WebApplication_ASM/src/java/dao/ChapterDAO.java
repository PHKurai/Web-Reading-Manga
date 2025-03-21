/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ChapterDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin PC
 */
public class ChapterDAO implements I_DAO<ChapterDTO, Integer> {

    @Override
    public boolean create(ChapterDTO entity) {
        String sql = "INSERT INTO chapters (comic_id, chapter_number) "
                + "VALUES (?, ?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, entity.getComicId());
            ps.setInt(2, entity.getChapterNumber());

            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean update(ChapterDTO entity) {
        String sql = "UPDATE chapters "
                + "SET comic_id=?, chapter_number=?, title=?, is_active=? "
                + "WHERE id=?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, entity.getComicId());
            ps.setInt(2, entity.getChapterNumber());
            ps.setString(3, entity.getTitle());
            ps.setBoolean(4, entity.isIsActive());
            ps.setInt(5, entity.getId());
            
            int n = ps.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "UPDATE chapters "
                + "SET is_active=? "
                + "WHERE id=?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setBoolean(1, false);
            ps.setInt(2, id);

            int n = ps.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public List<ChapterDTO> readAll() {
        List<ChapterDTO> list = new ArrayList<>();
        String sql
                = "SELECT id, comic_id, chapter_number, title, FORMAT(created_at, 'dd/MM/yyyy') AS created_date "
                + "FROM chapters";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChapterDTO chapter = new ChapterDTO();
                chapter.setId(rs.getInt("id"));
                chapter.setComicId(rs.getInt("comic_id"));
                chapter.setChapterNumber(rs.getInt("chapter_number"));
                chapter.setTitle(rs.getString("title"));
                chapter.setCreatedDate(rs.getString("created_date"));

                list.add(chapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public ChapterDTO readById(Integer id) {
        String sql
                = "SELECT id, comic_id, chapter_number, title, FORMAT(created_at, 'dd/MM/yyyy') AS created_date "
                + "FROM chapters "
                + "WHERE id = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChapterDTO chapter = new ChapterDTO();
                chapter.setId(rs.getInt("id"));
                chapter.setComicId(rs.getInt("comic_id"));
                chapter.setChapterNumber(rs.getInt("chapter_number"));
                chapter.setTitle(rs.getString("title"));
                chapter.setCreatedDate(rs.getString("created_date"));

                return chapter;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ChapterDTO> search(String searchTerm) {
        return null;
    }

    public List<ChapterDTO> findByComicId(int comicId) {
        List<ChapterDTO> chapters = new ArrayList<>();

        String sql
                = "SELECT id, comic_id, chapter_number, title, FORMAT(created_at, 'dd/MM/yyyy') AS created_date "
                + "FROM chapters "
                + "WHERE comic_id = ? AND is_active = 1 "
                + "ORDER BY chapter_number DESC";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, comicId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChapterDTO chapter = new ChapterDTO();
                chapter.setId(rs.getInt("id"));
                chapter.setComicId(rs.getInt("comic_id"));
                chapter.setChapterNumber(rs.getInt("chapter_number"));
                chapter.setTitle(rs.getString("title"));
                chapter.setCreatedDate(rs.getString("created_date"));

                chapters.add(chapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chapters;
    }

    public List<ChapterDTO> findByComicIdAndSearch(int comicId, String searchTerm) {
        List<ChapterDTO> chapters = new ArrayList<>();

        String sql
                = "SELECT id, comic_id, chapter_number, title, FORMAT(created_at, 'dd/MM/yyyy') AS created_date "
                + "FROM chapters "
                + "WHERE comic_id = ? AND is_active = 1 "
                + "AND (title LIKE ? OR CAST(chapter_number AS VARCHAR(10)) LIKE ?) "
                + "ORDER BY chapter_number";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            String pattern = '%' + searchTerm + '%';

            ps.setInt(1, comicId);
            ps.setString(2, pattern);
            ps.setString(3, pattern);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ChapterDTO chapter = new ChapterDTO();
                    chapter.setId(rs.getInt("id"));
                    chapter.setComicId(rs.getInt("comic_id"));
                    chapter.setChapterNumber(rs.getInt("chapter_number"));
                    chapter.setTitle(rs.getString("title"));
                    chapter.setCreatedDate(rs.getString("created_date"));

                    chapters.add(chapter);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chapters;
    }

    public int countChapterByComicId(int comicId) {
        String sql
                = "SELECT COUNT(*) AS total "
                + "FROM chapters "
                + "WHERE comic_id = ? AND is_active = 1;";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, comicId);
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            int i = rs.getInt("total");
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
    
    public int countAllChapter() {
        String sql
                = "SELECT COUNT(*) AS total "
                + "FROM chapters;";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            int i = rs.getInt("total");
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}
