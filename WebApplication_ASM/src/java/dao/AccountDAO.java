/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AccountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author phucl
 */
public class AccountDAO implements I_DAO<AccountDTO, String> {

    @Override
    public boolean create(AccountDTO entity) {
        String sql = "INSERT INTO accounts "
                + "( username, password) "
                + " VALUES (?,?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getPassword());

            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    @Override
    public boolean update(AccountDTO entity) {
        String sql = "UPDATE accounts SET "
                + "password = ?, "
                + "name = ?, "
                + "email = ?, "
                + "avatar = ? "
                + "WHERE username = ?";
        
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getPassword());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getEmail());
            ps.setString(4, entity.getAvatar());
            ps.setString(5, entity.getUsername());
            int n = ps.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "UPDATE accounts SET "
                + "activity = 0 "
                + "WHERE username = ?";
        
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int n = ps.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return false;
    }

    @Override
    public List<AccountDTO> readAll() {
        String sql = "SELECT * FROM accounts";
        List<AccountDTO> accounts = new ArrayList<>();
        
        try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                AccountDTO sp = new AccountDTO(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("role"),
                        rs.getString("avatar"),
                        rs.getBoolean("is_active"));
                
                accounts.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return accounts;
    }

    @Override
    public AccountDTO readById(String id) {
        String sql = "SELECT * FROM accounts WHERE username LIKE ?";
        
        try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                AccountDTO sp = new AccountDTO(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("role"),
                        rs.getString("avatar"),
                        rs.getBoolean("is_active"));
                return sp;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return null;
    }

    @Override
    public List<AccountDTO> search(String searchTerm) {
        return null;
    }
    
}
