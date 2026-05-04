package com.example.Platanito.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Platanito.entity.Pedido;

@Repository
public interface PedidoRespository extends JpaRepository <Pedido, Integer>{

}
