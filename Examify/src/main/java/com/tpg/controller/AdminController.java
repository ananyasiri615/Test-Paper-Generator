package com.tpg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tpg.entity.Admin;
import com.tpg.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    
    @PostMapping("/create")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    
    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    
    @GetMapping("/getby/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id).orElseThrow();
    }

   
    @PutMapping("/updateby/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        admin.setId(id);
        return adminService.updateAdmin(admin);
    }

   
    @DeleteMapping("/delete/{id}")
    public void deleteAdminById(@PathVariable Long id) {
        adminService.deleteAdminById(id);
    }
    
}
