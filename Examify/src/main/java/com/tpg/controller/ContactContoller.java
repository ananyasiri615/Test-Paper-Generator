package com.tpg.controller;

import com.tpg.entity.Candidate;
import com.tpg.entity.Contact;
import com.tpg.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/contact")
public class ContactContoller {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactContoller(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/submit")
    public String submitMessage(@RequestBody Contact contact) {
        try {
            // Save the message to the database
            contactRepository.save(contact);
            return "Message sent successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending message.";
        }
    }
    @GetMapping("/all")
    public List<Contact> getAllEnquires() {
        return contactRepository.findAll();
    }
}
