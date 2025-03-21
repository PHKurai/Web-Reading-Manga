/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ComicCategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin PC
 */
public class ComicCategoryDAO implements I_DAO<ComicCategoryDTO, Integer>{

    @Override
    public boolean create(ComicCategoryDTO entity) {
        String sql = "INSERT INTO comics_categories (comic_id, category_id) "
                + "VALUES (?, ?);";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, entity.getComicId());
            ps.setInt(2, entity.getCategoryId());
            
            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return false;
    }

    @Override
    public boolean update(ComicCategoryDTO entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<ComicCategoryDTO> readAll() {
        return null;
    }

    @Override
    public ComicCategoryDTO readById(Integer id) {
        return null;
    }

    @Override
    public List<ComicCategoryDTO> search(String searchTerm) {
        return null;
    }
    
}
