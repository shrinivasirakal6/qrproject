package com.qrproject.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {

    @GetMapping("/my-links")
    public String showLinks(Model model) {
        model.addAttribute("youtube", "https://youtube.com");
        model.addAttribute("whatsapp", "https://wa.me/919999999999");
        model.addAttribute("instagram", "https://instagram.com");
        model.addAttribute("telegram", "https://t.me/yourchannel");
        return "links"; // This will load links.html
    }
}

