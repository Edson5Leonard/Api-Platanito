package com.example.Platanito.controller;

import com.example.Platanito.entity.Categoria;
import com.example.Platanito.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repo;

    @GetMapping
    public List<Categoria> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria c) {
        return repo.save(c);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        repo.deleteById(id);
        return "Categoría eliminada";
    }
}