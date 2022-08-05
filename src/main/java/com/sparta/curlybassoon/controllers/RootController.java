package com.sparta.curlybassoon.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {
    @GetMapping("/signin")
    public String getSigninPage()
    {
        return "signin";
    }

    @GetMapping("/welcome")
    public String getWelcomePage()
    {
        return "welcome";
    }
}
