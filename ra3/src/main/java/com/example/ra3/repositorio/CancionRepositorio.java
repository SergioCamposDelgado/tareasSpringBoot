package com.example.ra3.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ra3.entidad.Cancion;

@Repository
public interface CancionRepositorio extends JpaRepository<Cancion, Integer>{

}
