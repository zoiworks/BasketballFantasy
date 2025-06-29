package com.zoiworks.basketballfantasy.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String showIndex(Model model, Principal principal) {
        String email = principal.getName();
    
        // Ανάκτηση του πρώτου ρόλου του χρήστη από το SecurityContext
        String role = org.springframework.security.core.context.SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .findFirst()
                .map(auth -> auth.getAuthority().replace("ROLE_", ""))
                .orElse("UNKNOWN");
    
        model.addAttribute("email", email);
        model.addAttribute("role", role);
    
        return "index";
    }
    
}
