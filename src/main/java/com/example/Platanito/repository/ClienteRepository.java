package com.example.Platanito.repository;

import com.example.Platanito.entity.Cliente; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    Cliente findByCorreoAndPassword(String correo, String password);
    
    Cliente findByDni(String dni);
}