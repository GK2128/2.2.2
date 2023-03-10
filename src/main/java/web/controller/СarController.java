package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Optional;


@Controller
public class –°arController {
    private final CarService service;

    @Autowired
    public –°arController(CarService service) {
        this.service = service;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) Optional<Integer> count, Model model) {
        model.addAttribute("cars", service.getListCar(CarService.cars, count.orElse(5)));
        return "cars";
    }
}
