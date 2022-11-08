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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.SinhVien;
import util.JdbcUtil;

/**
 *
 * @author Admin
 */
public class SinhVienRepository {

    public ArrayList<SinhVien> all() {
        ArrayList<SinhVien> listSV = new ArrayList<>();
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "select * from students";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String masv = rs.getString("masv");
                String ten = rs.getString("ho_ten");
                String email = rs.getString("email");
                String dc = rs.getString("dia_chi");
                String sdt = rs.getString("sdt");
                boolean gt = rs.getBoolean("gioi_tinh");
                String hinh = rs.getString("hinh");
                SinhVien sv = new SinhVien(masv, ten, email, sdt, gt, dc, hinh);
                listSV.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSV;
    }
    
    

    public void insert(SinhVien sv) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "insert into students"
                    + "(masv,ho_ten,email,sdt,gioi_tinh,dia_chi,hinh)"
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setString(3, sv.getEmail());
            ps.setString(4, sv.getSdt());
            ps.setBoolean(5, sv.getGioiTinh());
            ps.setString(6, sv.getDiaChi());
            ps.setString(7, sv.getAnh());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SinhVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String id) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "delete from students where masv = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("xoa thanh cong");
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String id, SinhVien sv) {
        try {
            
            Connection conn = JdbcUtil.getConnection();
            String sql = "update students set masv = ?, ho_ten = ?, email = ?, sdt = ?, gioi_tinh = ?, dia_chi = ?, hinh = ? where masv = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setString(3, sv.getEmail());
            ps.setString(4, sv.getSdt());
            ps.setBoolean(5, sv.getGioiTinh());
            ps.setString(6, sv.getDiaChi());
            ps.setString(7, sv.getAnh());
            ps.setString(8, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SinhVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
