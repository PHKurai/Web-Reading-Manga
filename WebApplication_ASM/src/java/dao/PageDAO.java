/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.PageDTO;
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
public class PageDAO implements I_DAO<PageDTO, Integer> {

    @Override
    public boolean create(PageDTO entity) {
        String sql = "INSERT INTO pages (chapter_id, image_text, page_number) "
                + "VALUES (?, ?, ?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, entity.getChapterId());
            ps.setString(2, entity.getImageText());
            ps.setInt(3, entity.getPageNumber());

            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
                
        return false;
    }

    @Override
    public boolean update(PageDTO entity) {
        String sql = "UPDATE pages "
                + "SET image_text = ? "
                + "WHERE chapter_id = ? AND page_number = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, entity.getImageText());
            ps.setInt(2, entity.getChapterId());
            ps.setInt(3, entity.getPageNumber());
            
            int n = ps.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<PageDTO> readAll() {
        return null;
    }

    @Override
    public PageDTO readById(Integer id) {
        return null;
    }

    @Override
    public List<PageDTO> search(String searchTerm) {
        return null;
    }
    
    public List<PageDTO> readByChapter(int id) {
        List<PageDTO> pages = new ArrayList<>();

        String sql
                = "SELECT chapter_id, image_text, page_number "
                + "FROM pages "
                + "WHERE chapter_id = ? "
                + "ORDER BY page_number";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PageDTO page = new PageDTO();
                page.setChapterId(rs.getInt("chapter_id"));
                page.setImageText(rs.getString("image_text"));
                page.setPageNumber(rs.getInt("page_number"));

                pages.add(page);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pages;
    }
    
    public boolean deleteByChapterId(int id) {
        String sql = "DELETE FROM pages "
                + "WHERE chapter_id = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            
            int n = ps.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
}
