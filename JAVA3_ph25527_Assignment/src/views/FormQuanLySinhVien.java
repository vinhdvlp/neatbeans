/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Diem;
import models.SinhVien;
import service.DiemService;
import service.SinhVienService;

/**
 *
 * @author Admin
 */
public class FormQuanLySinhVien extends javax.swing.JFrame {

    /**
     * Creates new form FormQuanLySinhVien
     */
    ButtonGroup bt;
    DefaultTableModel dftb = new DefaultTableModel();
    private SinhVienService qlsv = new SinhVienService();
    private DiemService qld = new DiemService();
    String hinhAnh = null;

    public FormQuanLySinhVien() {
        initComponents();
        addIcon();
        rdGioitinh();
        addColumn();
        getData();
        this.setLocationRelativeTo(null);
    }

    void rdGioitinh() {
        bt = new ButtonGroup();
        bt.add(rdnu);
        bt.add(rdnam);
    }

    void addIcon() {
        Icon iconnew = new ImageIcon("add.png");
        Icon iconsave = new ImageIcon("save.png");
        Icon icondele = new ImageIcon("clear.png");
        Icon iconup = new ImageIcon("edit.png");

        this.btn_new.setIcon(iconnew);
        this.btn_save.setIcon(iconsave);
        this.btn_dlete.setIcon(icondele);
        this.btn_update.setIcon(iconup);

    }

    
    boolean checkDele(String masv) {
        for (Diem diem : qld.getList()) {
            if (diem.getMaSV().equals(masv)) {
                JOptionPane.showMessageDialog(this, "xóa điểm trước khi xóa sinh viên");
                return false;
            }
        }
        return true;
    }

    boolean check() {
        if (txt_ma.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "nhập mã sinh viên");
            return false;
        }
        if (txt_ten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "nhập tên sinh viên");
            return false;
        }
        if (txt_email.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "nhập email sinh viên");
            return false;
        }
        if (txt_sdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "nhập sdt sinh viên");
            return false;
        }
        if (tarea.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "nhập địa chỉ sinh viên");
            return false;
        }
        try {
            Integer.parseInt(txt_sdt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "số điện thoại phải là số");
            return false;
        }
        if (!rdnam.isSelected() && !rdnu.isSelected()) {
            JOptionPane.showMessageDialog(this, "chọn giới tính");
        }
        return true;
    }

    void addColumn() {
        dftb = (DefaultTableModel) tb.getModel();
        dftb.setColumnCount(0);
        ArrayList<String> column = new ArrayList<>();
        column.add("Mã SV");
        column.add("Họ tên");
        column.add("Email");
        column.add("Số ĐT");
        column.add("Giới tính");
        column.add("Địa chỉ");
        column.add("Hình");
        for (String a : column) {
            dftb.addColumn(a);
        }
    }

    void update(SinhVien sv) {
        SinhVien sinhVien = qlsv.searchID(txt_ma.getText());
        if (sinhVien != null) {
            sinhVien.setMaSV(sv.getMaSV());
            sinhVien.setHoTen(sv.getHoTen());
            sinhVien.setEmail(sv.getEmail());
            sinhVien.setSdt(sv.getSdt());
            sinhVien.setDiaChi(sv.getDiaChi());
            sinhVien.setAnh(sv.getAnh());
        }
    }

    void clearForm() {
        txt_ma.setText("");
        txt_ten.setText("");
        txt_email.setText("");
        txt_sdt.setText("");
        tarea.setText("");
        bt.clearSelection();
        lbl_anh.setText("anh");
        lbl_anh.setIcon(null);
        hinhAnh = null;
    }

    SinhVien addSV() {
        SinhVien sv = new SinhVien();
        sv.setMaSV(txt_ma.getText());
        sv.setHoTen(txt_ten.getText());
        sv.setEmail(txt_email.getText());
        sv.setDiaChi(tarea.getText());
        sv.setSdt(txt_sdt.getText());
        if (rdnam.isSelected()) {
            sv.setGioiTinh(true);
        } else {
            sv.setGioiTinh(false);
        }
        if (hinhAnh == null) {
            sv.setAnh("no avatar");
        } else {
            sv.setAnh(hinhAnh);
        }
        return sv;
    }

    void getData() {
        dftb = (DefaultTableModel) tb.getModel();
        dftb.setRowCount(0);
        for (SinhVien sv : qlsv.getList()) {
            dftb.addRow(new Object[]{
                sv.getMaSV(), sv.getHoTen(), sv.getEmail(), sv.getSdt(), sv.getGioiTinh(), sv.getDiaChi(), sv.getAnh()
            });
        }
    }

    boolean checkID(SinhVien sv) {
        sv = qlsv.searchID(txt_ma.getText());
        if (sv != null) {
            JOptionPane.showMessageDialog(this, "mã sinh viên đã tồn tại");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        rdnam = new javax.swing.JRadioButton();
        rdnu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tarea = new javax.swing.JTextArea();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_dlete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        txt_ma = new javax.swing.JTextField();
        lbl_anh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setText("Mã SV:");

        jLabel3.setText("Họ tên:");

        jLabel4.setText("Email:");

        jLabel5.setText("SDT");

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);

        jLabel6.setText("Giới tính:");

        rdnam.setText("Nam");

        rdnu.setText("Nữ");

        jLabel7.setText("Địa chỉ");

        tarea.setColumns(20);
        tarea.setRows(5);
        jScrollPane2.setViewportView(tarea);

        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_dlete.setText("Delete");
        btn_dlete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dleteActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        lbl_anh.setText("anh");
        lbl_anh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdnam)
                                        .addGap(28, 28, 28)
                                        .addComponent(rdnu))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_ma, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_ten, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                        .addComponent(txt_sdt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btn_dlete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 18, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(rdnam))
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(rdnu)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_new)
                            .addComponent(btn_save))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_dlete)
                            .addComponent(btn_update))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_dleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dleteActionPerformed
        // TODO add your handling code here:
        int row = tb.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chọn sinh viên muốn xóa");
        } else {
            String ma = tb.getValueAt(row, 0).toString();
            int choice = JOptionPane.showConfirmDialog(this, "sẽ xóa sinh viên?", "xóa", JOptionPane.YES_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                String masv = txt_ma.getText();
                if (checkDele(masv)) {
                    qlsv.delete(ma);
                    JOptionPane.showMessageDialog(this, "xóa thành công");
                    getData();
                    clearForm();
                }
            }
        }
    }//GEN-LAST:event_btn_dleteActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        if (check()) {
            SinhVien sv = addSV();
            if (checkID(sv)) {
                qlsv.add(sv);
                JOptionPane.showMessageDialog(this, "thêm thành công");
                getData();
                clearForm();
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        // TODO add your handling code here:
        try {
            int row = tb.getSelectedRow();
            txt_ma.setText(tb.getValueAt(row, 0).toString());
            txt_ten.setText(tb.getValueAt(row, 1).toString());
            txt_email.setText(tb.getValueAt(row, 2).toString());
            txt_sdt.setText(tb.getValueAt(row, 3).toString());
            tarea.setText(tb.getValueAt(row, 5).toString());
            if (tb.getValueAt(row, 4).toString().equals("true")) {
                rdnam.setSelected(true);
            } else {
                rdnu.setSelected(true);
            }
            if (tb.getValueAt(row, 6).equals("no avatar")) {
                lbl_anh.setText("no avartar");
                lbl_anh.setIcon(null);
            } else {
                lbl_anh.setText("");
                ImageIcon icon = new ImageIcon(tb.getValueAt(row, 6).toString());
                int w = lbl_anh.getWidth();
                int h = lbl_anh.getHeight();
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(w, h, 0);
                ImageIcon icons = new ImageIcon(newimg);
                lbl_anh.setIcon(icons);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbMouseClicked

    private void lbl_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhMouseClicked
        try {
            // TODO add your handling code here:
            JFileChooser jfc = new JFileChooser("F:\\JV3\\JAVA3_ph25527_Assignment");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            lbl_anh.setText("");
            hinhAnh = file.getName();
            int w = lbl_anh.getWidth();
            int h = lbl_anh.getHeight();
            lbl_anh.setIcon(new ImageIcon(img.getScaledInstance(w, h, 0)));
        } catch (IOException ex) {
            Logger.getLogger(FormQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbl_anhMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        int row = tb.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chọn sinh viên muốn cập nhật");
            return;
        }
        SinhVien sv = new SinhVien();
        sv.setMaSV(txt_ma.getText());
        sv.setHoTen(txt_ten.getText());
        sv.setEmail(txt_email.getText());
        sv.setDiaChi(tarea.getText());
        sv.setSdt(txt_sdt.getText());
        if (rdnam.isSelected()) {
            sv.setGioiTinh(true);
        } else {
            sv.setGioiTinh(false);
        }
        if (hinhAnh == null) {
            sv.setAnh("no avatar");
        } else {
            sv.setAnh(hinhAnh);
        }

        String ma = txt_ma.getText();
        qlsv.update(ma, sv);
        JOptionPane.showMessageDialog(this, "cập nhật thành công");
        getData();
        clearForm();
    }//GEN-LAST:event_btn_updateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQuanLySinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dlete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JRadioButton rdnam;
    private javax.swing.JRadioButton rdnu;
    private javax.swing.JTextArea tarea;
    private javax.swing.JTable tb;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
