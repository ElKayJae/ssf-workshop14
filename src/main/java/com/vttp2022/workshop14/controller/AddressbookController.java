package com.vttp2022.workshop14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vttp2022.workshop14.model.Contact;
import com.vttp2022.workshop14.service.ContactsRedis;

@Controller
public class AddressbookController {

    @Autowired
    ContactsRedis service;

    @GetMapping("/")
    public String contactForm(Model model){
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @GetMapping ("/contact/{contactId}")
    public String getContact(Model model, @PathVariable(value="contactId") String contactId){
        Contact cc = service.findbyId(contactId);
        model.addAttribute("contact", cc);
        return "showContact";

    }
    
    @PostMapping ("/contact")
    public String submitContact (@ModelAttribute Contact contact, Model model){
        service.save(contact);
        model.addAttribute("contact", contact);
        return "showContact";
    }
    
}
