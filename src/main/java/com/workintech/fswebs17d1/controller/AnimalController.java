package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
public Map<Integer, Animal> animals;

@PostConstruct
public void LoadAll(){
    System.out.println("Çalıştı");
    this.animals=new HashMap<>();
    this.animals.put(1,new Animal(1,"maymun"));
}

    
@GetMapping
    public List<Animal> getAll(){
    return new ArrayList<>(animals.values());
}

@GetMapping("/{id}")
    public Animal getById(@PathVariable Integer id){
    if(!animals.containsKey(id)){
        throw new RuntimeException("Animal not found");
    }
    return animals.get(id);
}

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }
    @PutMapping("/{id}")
    public Animal update(@PathVariable Integer id, @RequestBody Animal animal) {
        if (!animals.containsKey(id)) {
            throw new RuntimeException("Animal bulunamadı! ID: " + id);
        }
        animals.put(id, animal);
        return animal;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        if (!animals.containsKey(id)) {
            throw new RuntimeException("Animal bulunamadı! ID: " + id);
        }
        animals.remove(id);
        return "Animal başarıyla silindi! ID: " + id;
    }





}
