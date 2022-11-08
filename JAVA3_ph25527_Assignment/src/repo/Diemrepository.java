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
import models.Diem;
import util.JdbcUtil;

/**
 *
 * @author Admin
 */
public class Diemrepository {

    public ArrayList<Diem> all() {
        ArrayList<Diem> list = new ArrayList<>();

        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "select top 3 ho_ten,* from grades join students on grades.masv = students.masv order by (tieng_anh + tin_hoc + gdtc)/3 desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String masv = rs.getString("masv");
                String ten = rs.getString("ho_ten");
                float ta = rs.getFloat("tieng_anh");
                float th = rs.getFloat("tin_hoc");
                float gdtc = rs.getFloat("gdtc");
                Diem diem = new Diem(masv, ten, ta, th, gdtc);
                list.add(diem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Diemrepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(Diem diem) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "insert into grades"
                    + "(masv,tieng_anh,tin_hoc,gdtc)"
                    + "values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, diem.getMaSV());
            ps.setFloat(2, diem.getDiemAnh());
            ps.setFloat(3, diem.getDiemTin());
            ps.setFloat(4, diem.getDieGDTC());
            ps.execute();
            System.out.println("them thanh cong");
        } catch (SQLException ex) {
            Logger.getLogger(Diemrepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(String masv) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "delete from grades where masv = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, masv);
            ps.executeUpdate();
            System.out.println("xoa thanh cong");
        } catch (SQLException ex) {
            Logger.getLogger(Diemrepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String id, Diem diem) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "update grades set tieng_anh = ?, tin_hoc = ?, gdtc = ? where masv = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, diem.getDiemAnh());
            ps.setFloat(2, diem.getDiemTin());
            ps.setFloat(3, diem.getDiemAnh());
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Diemrepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
