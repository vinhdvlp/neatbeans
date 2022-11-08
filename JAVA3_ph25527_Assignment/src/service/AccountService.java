/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import models.Account;
import repo.LoginRepository;


/**
 *
 * @author Admin
 */
public class AccountService {
    
    ArrayList<Account> list = new ArrayList<>();
    LoginRepository lgr = new LoginRepository();

    public AccountService() {
        
        list.add(new Account("admin", "admin", "dt"));
        list.add(new Account("giaovien", "giaovien", "gv"));
        
    }
    
    public Account login(String u, String p){
        return this.lgr.login(u, p);
    }
    
   
    
    
    
}
