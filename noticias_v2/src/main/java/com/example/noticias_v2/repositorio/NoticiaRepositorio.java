package com.example.noticias_v2.repositorio;


import com.example.noticias_v2.entidad.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, Integer> {

}
