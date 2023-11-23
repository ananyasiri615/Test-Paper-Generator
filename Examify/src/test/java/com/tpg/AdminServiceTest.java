package com.tpg;

import com.tpg.entity.Admin;
import com.tpg.repository.AdminRepo;
import com.tpg.service.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {

    @Mock
    private AdminRepo adminRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AdminService adminService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAdmin() {
        // Create a sample admin
        Admin admin = new Admin();
        admin.setUsername("testAdmin");
        admin.setPassword("testPassword");

        // Mock the repository's save method
        when(adminRepo.save(admin)).thenReturn(admin);

        // Mock password encoding
        when(passwordEncoder.encode(admin.getPassword())).thenReturn("encodedPassword");

        // Call the service method
        Admin createdAdmin = adminService.createAdmin(admin);

        // Check if the created admin matches the expected admin
        assertNotNull(createdAdmin);
        assertEquals("testAdmin", createdAdmin.getUsername());
        assertEquals("encodedPassword", createdAdmin.getPassword());
    }

    @Test
    public void testGetAllAdmins() {
        // Create a list of admins for testing
        List<Admin> admins = new ArrayList<>();
        admins.add(new Admin());
        admins.add(new Admin());

        // Mock the repository's findAll method
        when(adminRepo.findAll()).thenReturn(admins);

        // Call the service method
        List<Admin> retrievedAdmins = adminService.getAllAdmins();

        // Check if the retrieved admins match the expected admins
        assertNotNull(retrievedAdmins);
        assertEquals(admins.size(), retrievedAdmins.size());
    }

    @Test
    public void testGetAdminById() {
        // Create a sample admin
        Admin admin = new Admin();
        admin.setId(1L);
        admin.setUsername("testAdmin");

        // Mock the repository's findById method
        when(adminRepo.findById(1L)).thenReturn(Optional.of(admin));

        // Call the service method
        Optional<Admin> retrievedAdmin = adminService.getAdminById(1L);

        // Check if the retrieved admin matches the expected admin
        assertNotNull(retrievedAdmin);
        assertEquals("testAdmin", retrievedAdmin.get().getUsername());
    }

    // You can write similar test methods for updateAdmin and deleteAdmin.
}
