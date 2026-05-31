package com.harshita.carmatchmaker.controller;

import com.harshita.carmatchmaker.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/recommend")
    public String recommend(@RequestParam int maxBudget,
                            @RequestParam String topPriority,
                            Model model) {
        model.addAttribute("recommendedCars", carService.getRecommendations(maxBudget, topPriority));
        return "results";
    }
}
