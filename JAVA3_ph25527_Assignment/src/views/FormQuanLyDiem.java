/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Diem;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.SinhVien;
import service.DiemService;
import service.SinhVienService;

/**
 *
 * @author Admin
 */
public class FormQuanLyDiem extends javax.swing.JFrame {

    /**
     * Creates new form FormQuanLyDiem
     */
    DefaultTableModel dftb = new DefaultTableModel();
    private DiemService qld = new DiemService();
    private SinhVienService qlsv = new SinhVienService();

    public FormQuanLyDiem() {
        initComponents();
        addIcon();
        addColumn();
        this.setLocationRelativeTo(null);
//        sort();
        getData();

    }

    boolean check() {
        if (txt_ma.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "nhập mã sinh viên");
            return false;
        }
        if (txt_ta.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "nhập điểm tiếng anh");
            return false;
        }
        if (txt_th.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "nhập điểm tin học");
            return false;
        }
        if (txt_gdtc.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "nhập điểm gdtc");
            return false;
        }
        try {
            Float.parseFloat(txt_ta.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "điểm phải nhập số");
            return false;
        }
        if (Float.parseFloat(txt_ta.getText()) < 0 || Float.parseFloat(txt_ta.getText()) > 10) {
            JOptionPane.showMessageDialog(this, "điểm không hợp lệ");
            return false;
        }
        try {
            Float.parseFloat(txt_th.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "điểm phải nhập số");
            return false;
        }
        if (Float.parseFloat(txt_th.getText()) < 0 || Float.parseFloat(txt_th.getText()) > 10) {
            JOptionPane.showMessageDialog(this, "điểm không hợp lệ");
            return false;
        }
        try {
            Float.parseFloat(txt_gdtc.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "điểm phải nhập số");
            return false;
        }
        if (Float.parseFloat(txt_gdtc.getText()) < 0 || Float.parseFloat(txt_gdtc.getText()) > 10) {
            JOptionPane.showMessageDialog(this, "điểm không hợp lệ");
            return false;
        }
        return true;
    }

    boolean checkMaSV(String masv) {
        for (SinhVien sv : qlsv.getList()) {
            if (sv.getMaSV().equals(masv)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(this, "không thể thêm mới sinh viên");
        return false;
    }

    public Diem addSv() {
        String maSV = txt_ma.getText();
        float da = Float.parseFloat(txt_ta.getText());
        float dt = Float.parseFloat(txt_th.getText());
        float dgdtc = Float.parseFloat(txt_gdtc.getText());
        Diem diem = new Diem(maSV, "", da, dt, dgdtc);
        return diem;
    }

    void getData() {
        dftb = (DefaultTableModel) tb.getModel();
        dftb.setRowCount(0);
        for (Diem diem : qld.getList()) {
            dftb.addRow(new Object[]{
                diem.getMaSV(), diem.getHoTen(), diem.getDiemAnh(), diem.getDiemTin(), diem.getDieGDTC(), diem.getDiemTB()
            });
        }

    }

    void addIcon() {
        Icon iconnew = new ImageIcon("add.png");
        Icon iconsearch = new ImageIcon("search.png");
        Icon iconsave = new ImageIcon("save.png");
        Icon icondele = new ImageIcon("clear.png");
        Icon iconup = new ImageIcon("edit.png");
        Icon iconfirst = new ImageIcon("first.png");
        Icon iconpre = new ImageIcon("previous.png");
        Icon iconnnext = new ImageIcon("next.png");
        Icon iconlast = new ImageIcon("last.png");

        this.btn_new.setIcon(iconnew);
        this.btn_search.setIcon(iconsearch);
        this.btn_save.setIcon(iconsave);
        this.btn_dele.setIcon(icondele);
        this.btn_up.setIcon(iconup);
        this.btn_first.setIcon(iconfirst);
        this.btn_pre.setIcon(iconpre);
        this.btn_next.setIcon(iconnnext);
        this.btn_last.setIcon(iconlast);
    }

    void addColumn() {
        dftb = (DefaultTableModel) tb.getModel();
        dftb.setColumnCount(0);
        ArrayList<String> column = new ArrayList<>();
        column.add("Mã SV");
        column.add("Họ tên");
        column.add("Tiếng Anh");
        column.add("Tin Học");
        column.add("GDTC");
        column.add("Điểm TB");
        for (String a : column) {
            dftb.addColumn(a);
        }
    }

    void clearForm() {
        txt_search.setText("");
        txt_ma.setText("");
        lb_ten.setText("-");
        txt_ta.setText("");
        txt_th.setText("");
        txt_gdtc.setText("");
        lb_diemtb.setText("0");
    }

    void fillData(int row) {
        txt_ma.setText(tb.getValueAt(row, 0).toString());
        lb_ten.setText(tb.getValueAt(row, 1).toString());
        txt_ta.setText(tb.getValueAt(row, 2).toString());
        txt_th.setText(tb.getValueAt(row, 3).toString());
        txt_gdtc.setText(tb.getValueAt(row, 4).toString());
        lb_diemtb.setText(tb.getValueAt(row, 5).toString());
    }

    public void sort() {
        Collections.sort(qld.getList(), (a, b) -> (int) (b.getDiemTB() - a.getDiemTB()));
        getData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_ta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_th = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_gdtc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lb_diemtb = new javax.swing.JLabel();
        lb_ten = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_dele = new javax.swing.JButton();
        btn_up = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_pre = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Điểm Sinh Viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Quản Lý Điểm Sinh Viên");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Mã SV:");

        btn_search.setForeground(new java.awt.Color(0, 102, 255));
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Họ và tên sv:");

        jLabel5.setText("Mã sv:");

        jLabel6.setText("Tiếng Anh:");

        jLabel7.setText("Tin Học:");

        jLabel8.setText("GDTC:");

        jLabel9.setText("Điểm TB:");

        lb_diemtb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_diemtb.setForeground(new java.awt.Color(0, 102, 255));
        lb_diemtb.setText("0");

        lb_ten.setForeground(new java.awt.Color(102, 102, 255));
        lb_ten.setText("-");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_ta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_th, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_diemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_gdtc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_ten)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lb_ten))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_ta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_th, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_diemtb))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_gdtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

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

        btn_dele.setText("Delete");
        btn_dele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleActionPerformed(evt);
            }
        });

        btn_up.setText("Update");
        btn_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upActionPerformed(evt);
            }
        });

        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preActionPerformed(evt);
            }
        });

        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(tb);

        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("3 sinh viên điểm cao nhất");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_dele, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_up, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_first)
                                        .addGap(10, 10, 10)
                                        .addComponent(btn_pre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_next)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_last)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(194, 194, 194))))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_new)
                        .addGap(18, 18, 18)
                        .addComponent(btn_save)
                        .addGap(18, 18, 18)
                        .addComponent(btn_dele)
                        .addGap(18, 18, 18)
                        .addComponent(btn_up))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_first)
                    .addComponent(btn_pre)
                    .addComponent(btn_next)
                    .addComponent(btn_last))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        clearForm();

    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        if (txt_search.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "phải nhập mã sinh viên");
        } else {
            Diem d = qld.searchByID(txt_search.getText());
            if (d == null) {
                JOptionPane.showMessageDialog(this, "không có sinh viên");
            } else {
                txt_ma.setText(d.getMaSV());
                lb_ten.setText(d.getHoTen());
                txt_ta.setText(String.valueOf(d.getDiemAnh()));
                txt_th.setText(String.valueOf(d.getDiemTin()));
                txt_gdtc.setText(String.valueOf(d.getDieGDTC()));
                lb_diemtb.setText(String.valueOf(d.getDiemTB()));
            }
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_deleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleActionPerformed
        // TODO add your handling code here:

        int row = tb.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chọn sinh viên muốn xóa");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "bạn có chắc muốn xóa không", "xóa", JOptionPane.YES_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                String ma = tb.getValueAt(row, 0).toString();
                qld.delete(ma);
                getData();
                clearForm();
            }
        }
    }//GEN-LAST:event_btn_deleActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        // TODO add your handling code here:
        try {
            int row = tb.getSelectedRow();
            fillData(row);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_tbMouseClicked

    private void btn_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upActionPerformed
        // TODO add your handling code here:
        int row = tb.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "không có sinh viên để cập nhật");
            return;
        }
        Diem diem = addSv();
        String ma = tb.getValueAt(row, 0).toString();
        String matxt = txt_ma.getText();
        if (ma.equals(matxt)) {
            qld.update(ma, diem);
            JOptionPane.showMessageDialog(this, "cập nhật thành công");
            getData();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "không thể thay đổi mã sinh viên");
            txt_ma.setText(tb.getValueAt(row, 0).toString());
        }

    }//GEN-LAST:event_btn_upActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        if (check()) {
            Diem diem = addSv();
            if (checkMaSV(diem.getMaSV())) {
                qld.insert(diem);
                clearForm();
                getData();
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        // TODO add your handling code here:
        try {
            int row = 0;
            fillData(row);
            tb.setRowSelectionInterval(row, row);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preActionPerformed
        // TODO add your handling code here:
        try {
            int row = tb.getSelectedRow();
            if (row == 0) {
                row = qld.getList().size() - 1;
                fillData(row);
                tb.setRowSelectionInterval(row, row);
            } else {
                row--;
                fillData(row);
                tb.setRowSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_preActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // TODO add your handling code here:
        try {
            int row = tb.getSelectedRow();
            if (row == qld.getList().size() - 1) {
                row = 0;
                fillData(row);
                tb.setRowSelectionInterval(row, row);
            } else {
                row++;
                fillData(row);
                tb.setRowSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        // TODO add your handling code here:
        try {
            int row = qld.getList().size() - 1;
            fillData(row);
            tb.setRowSelectionInterval(row, row);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_lastActionPerformed

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
            java.util.logging.Logger.getLogger(FormQuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQuanLyDiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dele;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_pre;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_up;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_diemtb;
    private javax.swing.JLabel lb_ten;
    private javax.swing.JTable tb;
    private javax.swing.JTextField txt_gdtc;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_ta;
    private javax.swing.JTextField txt_th;
    // End of variables declaration//GEN-END:variables
}
