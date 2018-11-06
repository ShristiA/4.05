package com.example.demo;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return"index";
    }

    @RequestMapping("/login")
    public String login(){
        return"login";
    }

    @RequestMapping("/secure")
    public String secure(Principal principal, Model model){
        User myUser = ((CustomUserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
        model.addAttribute("myuser", myUser);
        return "secure";
    }
}
