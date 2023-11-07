package com.spring.action.tacocloud.controllers;

import com.spring.action.tacocloud.domain.TacoOrder;
import com.spring.action.tacocloud.domain.User;
import com.spring.action.tacocloud.repository.OrderRepository;
import com.spring.action.tacocloud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepo;
    // private final UserRepository userRepository;

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    // [OP1] public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus, Principal principal) {
    // [OP2] public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus, Authentication authentication) {
    // [OP3] public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        // [OP1] User user = userRepository.findByUsername(principal.getName());
        // [OP2] User user = (User) authentication.getPrincipal();
        /* [OP3] Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                 User user = (User) authentication.getPrincipal(); */
        order.setUser(user);

        orderRepo.save(order);
        sessionStatus.setComplete();

        log.info("Order submitted: {}", order);

        return "redirect:/";
    }
}
