package com.example.Platanito.controller;

import com.example.Platanito.entity.Producto;
import com.example.Platanito.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository repo;

    @GetMapping
    public List<Producto> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable int id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto p){
        return repo.save(p);
    }

    @PutMapping("/{id}") 
    public Producto actualizar(@PathVariable int id, @RequestBody Producto p){
        p.setId(id);
        return repo.save(p);
    }

    @DeleteMapping("/{id}") 
    public String eliminar(@PathVariable int id){
        if (repo.existsById(id)){ 
            repo.deleteById(id);
            return "Producto eliminado correctamente";
        }
        return "Error: El producto no existe";
    }
}