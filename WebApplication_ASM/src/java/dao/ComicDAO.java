/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ComicDTO;
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
public class ComicDAO implements I_DAO<ComicDTO, Integer> {

    @Override
    public boolean create(ComicDTO entity) {
        String sql = "INSERT INTO comics (title, add_admin, author) "
                + "VALUES (?, ?, ?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getAddAdmin());
            ps.setString(3, entity.getAuthor());

            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ComicDTO entity) {
        String sql = "UPDATE comics "
                + "SET title=?, description=?, cover_image=?, add_admin=?, is_active=?, author=?, status=?, views=?, likes=?, favorites=? "
                + "WHERE id=?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getDescription());
            ps.setString(3, entity.getCoverImage());
            ps.setString(4, entity.getAddAdmin());
            ps.setBoolean(5, entity.isActive());
            ps.setString(6, entity.getAuthor());
            ps.setString(7, entity.getStatus());
            ps.setInt(8, entity.getViews());
            ps.setInt(9, entity.getLikes());
            ps.setInt(10, entity.getFavorites());
            ps.setInt(11, entity.getId());

            int n = ps.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "UPDATE comics "
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
    public List<ComicDTO> readAll() {
        return null;
    }

    @Override
    public ComicDTO readById(Integer id) {
        String sql = "SELECT id, title, description, cover_image, author, status, views, likes, favorites "
                + "FROM comics WHERE id=?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComicDTO sp = new ComicDTO(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("cover_image"),
                        rs.getString("author"),
                        rs.getString("status"),
                        rs.getInt("views"),
                        rs.getInt("likes"),
                        rs.getInt("favorites"));
                return sp;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

    @Override
    public List<ComicDTO> search(String searchTerm) {
        List<ComicDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM comics WHERE title LIKE ? OR author LIKE ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            String param = "%" + searchTerm + "%";
            ps.setString(1, param);
            ps.setString(2, param);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComicDTO b = new ComicDTO(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("cover_image"));
                result.add(b);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public List<ComicDTO> searchComics(String searchTerm, int page, int pageSize) {
        List<ComicDTO> list = new ArrayList<>();
        int offset = (page - 1) * pageSize;

        String sql = "SELECT id, title, description, cover_image "
                + "FROM comics "
                + "WHERE (title LIKE ? OR author LIKE ?) "
                + "ORDER BY id "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            String param = "%" + searchTerm + "%";

            ps.setString(1, param);
            ps.setString(2, param);
            ps.setInt(3, offset);
            ps.setInt(4, pageSize);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ComicDTO comic = new ComicDTO(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("cover_image"));
                    list.add(comic);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countSearchComics(String searchTerm) {
        int total = 0;
        String sql
                = "SELECT COUNT(*) AS total "
                + "FROM comics "
                + "WHERE (title LIKE ? OR author LIKE ?)";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            String param = "%" + searchTerm + "%";
            ps.setString(1, param);
            ps.setString(2, param);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public List<ComicDTO> findByCategoryId(int categoryId, int page, int pageSize) {
        List<ComicDTO> comics = new ArrayList<>();
        int offset = (page - 1) * pageSize;

        String sql
                = "SELECT c.id, c.title, c.description, c.cover_image "
                + "FROM comics AS c "
                + "JOIN comics_categories AS cc ON c.id = cc.comic_id "
                + "JOIN categories AS cat ON cc.category_id = cat.id "
                + "WHERE cat.id = ? "
                + "ORDER BY c.id "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, categoryId);
            ps.setInt(2, offset);
            ps.setInt(3, pageSize);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ComicDTO comic = new ComicDTO(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("cover_image"));
                    comics.add(comic);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comics;
    }

    public int countCategorieshComics(int categoryId) {
        int total = 0;
        String sql
                = "SELECT COUNT(*) AS total "
                + "FROM comics AS c "
                + "JOIN comics_categories AS cc ON c.id = cc.comic_id "
                + "JOIN categories AS cat ON cc.category_id = cat.id "
                + "WHERE cat.id = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getInt("total");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public List<ComicDTO> findByLatestUpdate(int page, int pageSize) {
        List<ComicDTO> comics = new ArrayList<>();
        int offset = (page - 1) * pageSize;

        String sql
                = "SELECT c.id, c.title, c.description, c.cover_image "
                + "FROM comics c "
                + "LEFT JOIN ( "
                + "    SELECT comic_id, MAX(created_at) AS last_chapter_date "
                + "    FROM chapters "
                + "    GROUP BY comic_id "
                + ") AS ch ON c.id = ch.comic_id "
                + "ORDER BY ch.last_chapter_date DESC "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, offset);
            ps.setInt(2, pageSize);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ComicDTO comic = new ComicDTO(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("cover_image"));

                    comics.add(comic);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return comics;
    }

    public List<ComicDTO> findByMostViews(int page, int pageSize) {
        List<ComicDTO> comics = new ArrayList<>();
        int offset = (page - 1) * pageSize;

        String sql
                = "SELECT id, title, description, cover_image, author "
                + "FROM comics "
                + "ORDER BY views DESC "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, offset);
            ps.setInt(2, pageSize);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ComicDTO comic = new ComicDTO(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("cover_image"));
                    comic.setAuthor(rs.getString("author"));
                    comics.add(comic);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return comics;
    }

    public List<ComicDTO> findByMostFavorites(int page, int pageSize) {
        List<ComicDTO> comics = new ArrayList<>();
        int offset = (page - 1) * pageSize;

        String sql
                = "SELECT c.id, c.title, c.description, c.cover_image "
                + "FROM comics c "
                + "ORDER BY c.favorites DESC "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, offset);
            ps.setInt(2, pageSize);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ComicDTO comic = new ComicDTO(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("cover_image"));
                    comics.add(comic);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return comics;
    }

    public int countComics() {
        int total = 0;
        String sql
                = "SELECT COUNT(*) AS total "
                + "FROM comics";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getInt("total");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public ComicDTO readByChapter(int id) {
        String sql = "SELECT c.id AS id, c.title AS title "
                + "FROM comics c "
                + "JOIN chapters ch ON c.id = ch.comic_id "
                + "WHERE ch.id = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComicDTO sp = new ComicDTO();
                sp.setId(rs.getInt("id"));
                sp.setTitle(rs.getString("title"));

                return sp;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public List<ComicDTO> findByHistory(String userId, int page, int pageSize) {
        List<ComicDTO> list = new ArrayList<>();
        int offset = (page - 1) * pageSize;

        String sql
                = "SELECT c.id, c.title, c.description, c.cover_image "
                + "FROM comics c "
                + "JOIN histories h ON c.id = h.comic_id "
                + "WHERE h.username = ? "
                + "ORDER BY h.read_at DESC "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userId);
            ps.setInt(2, offset);
            ps.setInt(3, pageSize);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ComicDTO comic = new ComicDTO();
                    comic.setId(rs.getInt("id"));
                    comic.setTitle(rs.getString("title"));
                    comic.setDescription(rs.getString("description"));
                    comic.setCoverImage(rs.getString("cover_image"));

                    list.add(comic);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int countByHistory(String userId) {
        int total = 0;
        String sql = "SELECT COUNT(*) AS total "
                + "FROM histories "
                + "WHERE username = ? ";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getInt("total");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public List<ComicDTO> findByFollowed(String userId, int page, int pageSize) {
        List<ComicDTO> list = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        
        String sql
                = "SELECT c.id, c.title, c.description, c.cover_image "
                + "FROM comics c "
                + "JOIN follows f ON c.id = f.comic_id "
                + "WHERE f.username = ? "
                + "ORDER BY f.follow_at DESC "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userId);
            ps.setInt(2, offset);
            ps.setInt(3, pageSize);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ComicDTO comic = new ComicDTO();
                comic.setId(rs.getInt("id"));
                comic.setTitle(rs.getString("title"));
                comic.setDescription(rs.getString("description"));
                comic.setCoverImage(rs.getString("cover_image"));

                list.add(comic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countByFollowed(String userId) {
        int total = 0;
        String sql = "SELECT COUNT(*) AS total "
                + "FROM follows "
                + "WHERE username = ? ";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getInt("total");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
