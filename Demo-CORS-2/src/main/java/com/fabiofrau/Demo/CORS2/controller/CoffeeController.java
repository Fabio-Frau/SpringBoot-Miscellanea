package com.fabiofrau.Demo.CORS2.controller;

import com.fabiofrau.Demo.CORS2.model.Coffee;
import com.fabiofrau.Demo.CORS2.model.Size;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/coffee")
//@CrossOrigin(origins = "http://localhost:3000")
public class CoffeeController {

    private List<Coffee> coffeeList = new ArrayList<>();

    public CoffeeController() {
        coffeeList.add(new Coffee(1, "Caffè Americano", Size.GRANDE));
        coffeeList.add(new Coffee(2, "Caffè Latte", Size.VENTI));
        coffeeList.add(new Coffee(3, "Caffè Caramel Macchiato", Size.TALL));
    }

    //@CrossOrigin
    @GetMapping
    public List<Coffee> findAll() {
        return coffeeList;
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping
    public void delete(Integer id) {
        coffeeList.removeIf(coffee -> coffee.id().equals(id));
    }

}
