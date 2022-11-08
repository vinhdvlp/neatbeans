/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import models.SinhVien;
import repo.SinhVienRepository;

/**
 *
 * @author Admin
 */
public class SinhVienService {

    public ArrayList<SinhVien> listSV = new ArrayList<>();
    SinhVienRepository svr;

    public SinhVienService() {
        this.svr = new SinhVienRepository();
    }

    public ArrayList<SinhVien> getList() {
        return this.svr.all();
    }

    public void add(SinhVien sv) {
        this.svr.insert(sv);
    }

    public SinhVien searchID(String id) {
        for (SinhVien sv : svr.all()) {
            if (sv.getMaSV().equals(id)) {
                return sv;
            }
        }
        return null;
    }

    public void delete(String id) {
        this.svr.delete(id);
    }

    public void update(String id, SinhVien sv) {
        this.svr.update(id, sv);
    }
}
