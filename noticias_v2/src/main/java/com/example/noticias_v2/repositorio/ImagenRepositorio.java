package com.example.noticias_v2.repositorio;

import com.example.noticias_v2.entidad.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepositorio extends JpaRepository<Imagen,String> {
}
