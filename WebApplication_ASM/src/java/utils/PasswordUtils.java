/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.AccountDAO;
import dto.AccountDTO;
import java.security.MessageDigest;
import java.util.List;

/**
 *
 * @author Admin PC
 */
public class PasswordUtils {

    public static String hashPassword(String plainPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] messageDigest = md.digest(plainPassword.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        String newHashedPassword = hashPassword(plainPassword);
        return newHashedPassword != null && newHashedPassword.equals(hashedPassword);
    }

    public static void migratePasswords() {
        AccountDAO dao = new AccountDAO();
        List<AccountDTO> users = dao.readAll();
        
        for (AccountDTO user : users) {
            String plainPassword = user.getPassword();

            String hashedPassword = PasswordUtils.hashPassword(plainPassword);

            user.setPassword(hashedPassword);

            dao.update(user);
        }

    }
    
    public static void main(String[] args) {
       migratePasswords();
    }
}

