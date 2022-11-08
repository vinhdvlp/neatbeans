/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Account;
import util.JdbcUtil;

/**
 *
 * @author Admin
 */
public class LoginRepository {
    
    public Account login(String u, String p){
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "select * from users where username = ? and pass_word = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u);
            ps.setString(2, p);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next() == false) {
                return null;
            }
            String role = rs.getString("vai_tro");
            Account lg = new Account(u, p, role);
            return lg;
        } catch (SQLException ex) {
            Logger.getLogger(LoginRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
