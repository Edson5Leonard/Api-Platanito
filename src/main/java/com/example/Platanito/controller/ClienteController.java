package com.example.Platanito.controller;

import com.example.Platanito.entity.Cliente; // Importación corregida
import com.example.Platanito.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repo;

    @GetMapping
    public List<Cliente> listar() {
        return repo.findAll(); 
    }

    @GetMapping("/buscar/{id}")
    public Cliente buscarPorId(@PathVariable Integer id){
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/{dni}") 
    public Cliente buscar(@PathVariable String dni) { 
        return repo.findByDni(dni); 
    }

    
    @PostMapping("/actualizar/{id}")
    public Cliente editar(@PathVariable int id, @RequestBody Cliente c) {
        c.setId(id);
        return repo.save(c);
    }

    
    @PostMapping("/auth/login")
    public String login(@RequestBody Cliente c){
        Cliente encontrado = repo.findByCorreoAndPassword(c.getCorreo(), c.getPassword());
        if (encontrado != null) {
            return "Bienvenido " + encontrado.getNombre();
        } else {
            return "Error: Credenciales inválidas";
        }
    }
}