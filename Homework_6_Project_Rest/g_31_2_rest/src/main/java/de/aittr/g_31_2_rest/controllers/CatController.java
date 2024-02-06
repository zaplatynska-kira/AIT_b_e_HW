package de.aittr.g_31_2_rest.controllers;

import de.aittr.g_31_2_rest.domain.Cat;
import de.aittr.g_31_2_rest.services.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    private CatService service;

    public CatController(CatService service) {
        this.service = service;
    }
    @GetMapping()
    //@GetMapping("/test") метод принимает Гет запрос на ендпоинт http: // 12-21.cats/test-
    public List<Cat>getAll(){
        return service.getAll();
    }

    // способ получение кота по ыд как подстроки
   /* @GetMapping("/{id}")
    public  Cat GetById( @PathVariable int id){
        return  service.getById(id);
    }

    */
    @GetMapping("/get")
    public Cat getById (@RequestParam int id){
        return service.getById(id);
    }
}
