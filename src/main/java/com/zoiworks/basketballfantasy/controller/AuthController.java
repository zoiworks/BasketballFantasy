package com.zoiworks.basketballfantasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Η κλάση είναι Controller του Spring MVC (χειρίζεται HTTP αιτήματα)
@Controller
public class AuthController {
    // Δηλώνει ότι όταν γίνει GET αίτημα στο /login, θα εκτελεστεί αυτή η μέθοδος
    @GetMapping("/login")
    // Επιστρέφει το όνομα του view "login.html" από τον φάκελο templates (Thymeleaf)
    public String login() {
        return "login"; // επιστρέφει login.html από templates
    }
}
