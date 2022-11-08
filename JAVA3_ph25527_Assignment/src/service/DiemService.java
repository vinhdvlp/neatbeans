/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import models.Diem;
import repo.Diemrepository;


/**
 *
 * @author Admin
 */
public class DiemService {
    
    Diemrepository dr = new Diemrepository();
    
    
    public ArrayList<Diem> getList(){
        return dr.all();
    }
    
    public void insert(Diem diem){
       dr.insert(diem);
    }
    
    public void delete(String id){
        dr.delete(id);
    }
    
    public Diem searchByID(String id){
        for(Diem diem : dr.all()){
            if (diem.getMaSV().equals(id)) {
                return diem;
            }
        }
        return null;
    }
    public void update(String id, Diem d){
        dr.update(id, d);
    }
    
}
