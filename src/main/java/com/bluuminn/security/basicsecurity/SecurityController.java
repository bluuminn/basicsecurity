package com.bluuminn.security.basicsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/login-page")
    public String loginPage() {
        return "login-page";
    }
}
