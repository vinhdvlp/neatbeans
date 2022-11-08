/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import service.DiemService;

/**
 *
 * @author Admin
 */

public class Diem {
    
    DiemService qld = new DiemService();
    
    private String maSV;
    private String hoTen;
    private float diemAnh;
    private float diemTin;
    private float diemGDTC;

    public Diem() {
    }

    public Diem(String maSV, String hoTen, float diemAnh, float diemTin, float diemGDTC) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemAnh = diemAnh;
        this.diemTin = diemTin;
        this.diemGDTC = diemGDTC;
    }

    

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getDiemAnh() {
        return diemAnh;
    }

    public void setDiemAnh(float diemAnh) {
        this.diemAnh = diemAnh;
    }

    public float getDiemTin() {
        return diemTin;
    }

    public void setDiemTin(float diemTin) {
        this.diemTin = diemTin;
    }

    public float getDieGDTC() {
        return diemGDTC;
    }

    public void setDieGDTC(float dieGDTC) {
        this.diemGDTC = dieGDTC;
    }
    
    public float getDiemTB(){
        float diemTB = 0;
        diemTB = (diemAnh + diemTin + diemGDTC) / 3;
        return diemTB;
    }
    
    
    
}
