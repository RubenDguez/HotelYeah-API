package com.revature.hotelbooking.hotelbooking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

@Controller
@CrossOrigin(
    allowCredentials = "true",
    origins = "http://localhost:3000", 
    allowedHeaders = {"Content-Type", "x-requested-with", "origin", "Access-Control-Allow-Origin"},  
    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}
)
public class LogOutController {
    
    @CrossOrigin
    @PostMapping(value="/logmeout")
    public void logoutPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            response.getWriter().append("You have been successfully logged out");
            response.setStatus(200);
        }
    }
    

}
