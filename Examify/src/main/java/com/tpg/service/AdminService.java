package com.tpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tpg.entity.Admin;
import com.tpg.repository.AdminRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;


    
    public Admin createAdmin(Admin admin) {
    	 String encodedPassword = passwordEncoder.encode(admin.getPassword());
    	 admin.setPassword(encodedPassword);
        return adminRepo.save(admin);
    }

    
    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    
    public Optional<Admin> getAdminById(Long id) {
        return adminRepo.findById(id);
    }

    
    public Admin updateAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

   
    public void deleteAdminById(Long id) {
        adminRepo.deleteById(id);
    }
}
