/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.AccountDAO;
import dto.AccountDTO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin PC
 */
public class AuthUtil {
    private static final AccountDAO aDAO = new AccountDAO();
    private static String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static String emailRegex = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,6}$";
    
    public static boolean isLogin(HttpSession session) {
        return session.getAttribute("account")!=null;
    }
    
    public static boolean isAdmin(HttpSession session) {
        if (!isLogin(session))
            return false;
        AccountDTO acc = getAccount(session);
        return acc.getRole().equals("admin");
    }   
    
    public static AccountDTO getAccount(HttpSession session) {
        if (!isLogin(session))
            return null;
        return (AccountDTO) session.getAttribute("account");
    }
    
    public static boolean isValidAccount(String username, String password) {
        AccountDTO acc = getAccount(username);
        return acc != null && acc.getPassword().equals(password) && acc.isActivity();
    }
    
    public static AccountDTO getAccount(String username) {
        return aDAO.readById(username);
    }
    
    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        
        return matcher.matches();
    }
    
    public static boolean isValidName(String name) {
        return name.length()>=4;
    }
    
    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
}
