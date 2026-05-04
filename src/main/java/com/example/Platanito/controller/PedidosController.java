package com.example.Platanito.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Platanito.entity.Pedido;
import com.example.Platanito.repository.PedidoRespository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidoRespository repo;

    @GetMapping
    public List<Pedido> listar() {
        return repo.findAll();

    } 
    
}
