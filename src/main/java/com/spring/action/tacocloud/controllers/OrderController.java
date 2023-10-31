package com.spring.action.tacocloud.controllers;

import com.spring.action.tacocloud.domain.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(TacoOrder tacoOrder, SessionStatus sessionStatus) {
        log.info("Order submitted: {}", tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
