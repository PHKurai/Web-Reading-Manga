/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CategoryDTO;
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
public class CategoryDAO implements I_DAO<CategoryDTO, Byte>{

    @Override
    public boolean create(CategoryDTO entity) {
        return false;
    }

    @Override
    public boolean update(CategoryDTO entity) {
        return false;
    }

    @Override
    public boolean delete(Byte id) {
        return false;
    }

    @Override
    public List<CategoryDTO> readAll() {
        List<CategoryDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM categories";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CategoryDTO category = new CategoryDTO(
                        rs.getByte("id"),
                        rs.getString("name"));
                result.add(category);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    @Override
    public CategoryDTO readById(Byte id) {
        String sql = "SELECT * FROM categories WHERE id LIKE ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setByte(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CategoryDTO category = new CategoryDTO(
                        rs.getByte("id"),
                        rs.getString("name"));
                
                return category;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    @Override
    public List<CategoryDTO> search(String searchTerm) {
        return null;
    }
    
    public List<CategoryDTO> findByComicId(int comicId) {
        List<CategoryDTO> categories = new ArrayList<>();

        String sql = 
            "SELECT cat.id, cat.name " +
            "FROM categories AS cat " +
            "JOIN comics_categories AS cc ON cat.id = cc.category_id " +
            "WHERE cc.comic_id = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, comicId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CategoryDTO category = new CategoryDTO();
                    category.setId(rs.getByte("id"));
                    category.setName(rs.getString("name"));
                    categories.add(category);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
}
