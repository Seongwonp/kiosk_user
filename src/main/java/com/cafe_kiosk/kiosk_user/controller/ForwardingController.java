package com.cafe_kiosk.kiosk_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardingController {
    @RequestMapping(value = {"/success", "/fail"})
    public String forward() {
        return "forward:/index.html";
    }
}