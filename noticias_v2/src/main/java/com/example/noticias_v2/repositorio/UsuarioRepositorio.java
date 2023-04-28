package com.example.noticias_v2.repositorio;


import com.example.noticias_v2.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,String> {

    @Query("SELECT U FROM Usuario U WHERE U.email = :email")
    public Usuario buscarPorEmail(@Param("email")String email);


 }
