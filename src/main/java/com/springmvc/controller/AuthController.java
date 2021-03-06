package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jitendra Singh.
 */
@Controller
public class AuthController {

    @RequestMapping("/signin")
    public String signIn() {
        return "signin";
    }

    @RequestMapping("/403")
    public String handle403() {
        return "error403";
    }
}
