package com.example.Platanito.controller;

import com.example.Platanito.entity.Marca;
import com.example.Platanito.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaRepository repo;

    @GetMapping
    public List<Marca> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Marca crear(@RequestBody Marca m) {
        return repo.save(m);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        repo.deleteById(id);
        return "Marca eliminada";
    }
}