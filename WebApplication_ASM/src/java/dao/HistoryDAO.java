/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.HistoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import utils.DBUtils;

/**
 *
 * @author Admin PC
 */
public class HistoryDAO implements I_DAO<HistoryDTO, Map<String, Integer>> {

    @Override
    public boolean create(HistoryDTO entity) {
        return false;
    }

    @Override
    public boolean update(HistoryDTO entity) {
        return false;
    }

    @Override
    public boolean delete(Map<String, Integer> id) {
        return false;
    }

    @Override
    public List<HistoryDTO> readAll() {
        return null;
    }

    @Override
    public HistoryDTO readById(Map<String, Integer> id) {
        return null;
    }

    @Override
    public List<HistoryDTO> search(String searchTerm) {
        return null;
    }

    public boolean changeHistory(HistoryDTO entity) {
        String sql
                = "IF EXISTS (SELECT 1 "
                + "FROM histories "
                + "WHERE username = ? "
                + "AND comic_id = ?) "
                + "BEGIN "
                + "UPDATE histories "
                + "SET read_at = GETDATE() "
                + "WHERE username = ? "
                + "AND comic_id = ?; "
                + "END "
                + "ELSE "
                + "BEGIN "
                + "INSERT INTO histories (username, comic_id, read_at) "
                + "VALUES (?, ?, GETDATE()); "
                + "END";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, entity.getUsername());
            ps.setInt(2, entity.getComic_id());
            ps.setString(3, entity.getUsername());
            ps.setInt(4, entity.getComic_id());
            ps.setString(5, entity.getUsername());
            ps.setInt(6, entity.getComic_id());

            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
