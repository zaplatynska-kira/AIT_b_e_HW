package de.aittr.g_31_2_autos.controllers;

import de.aittr.g_31_2_autos.domain.Auto;
import de.aittr.g_31_2_autos.services.AutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auto")
public class AutoController {
    private AutoService service;

    public AutoController(AutoService service) {
        this.service = service;
    }
    @GetMapping
    public List<Auto>getAll() {
        return  service.getAll();
    }
    @DeleteMapping("/{model}")
    public void deleteByModel(@PathVariable String model){
        service.deleteByModel(model);
    }

    @GetMapping("/averageYear")
    public double getAverageYear() {
        return service.getAverageYear();
    }
}
