package com.example.ss9.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller

public class CartController {

    @GetMapping("/cart")
    public String index() {
        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") String productId, HttpSession session) {

        List<String> cart = (List<String>) session.getAttribute("myCart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(productId);
        session.setAttribute("myCart", cart);

        System.out.println("Đã thêm: " + productId + ". ID Session: " + session.getId());

        return "redirect:/checkout";
    }

    @GetMapping("/checkout")
    public String viewCheckout(HttpSession session, Model model) {
        List<String> cart = (List<String>) session.getAttribute("myCart");

        if (cart == null || cart.isEmpty()) {
            model.addAttribute("message", "Giỏ hàng của bạn đang trống!");
            model.addAttribute("items", new ArrayList<>());
        } else {
            model.addAttribute("message", "Danh sách giỏ hàng của bạn:");
            model.addAttribute("items", cart);
        }

        return "checkout-page";
    }
}