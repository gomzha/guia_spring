package com.example.noticias_v2.entidad;

import com.example.noticias_v2.repositorio.NoticiaRepositorio;
import com.example.noticias_v2.repositorio.UsuarioRepositorio;
import com.example.noticias_v2.servicio.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;

public class Administrador extends Usuario{

    @Autowired
    NoticiaRepositorio noticiaRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    @Transactional
    public void crearNoticia(String titulo, String cuerpo) {
        Noticia noticia = new Noticia(titulo, cuerpo, true);
        noticiaRepositorio.save(noticia);
    }

    @Transactional
    public void bajaNoticia(Integer id){
        noticiaRepositorio.deleteById(id);
    }

    @Transactional
    public void modificarCuerpo(Integer id, String cuerpo) {

        Noticia noticia = noticiaRepositorio.findById(id).get();
        noticia.setCuerpo(cuerpo);
        noticiaRepositorio.save(noticia);
    }

    @Transactional
    public void asignarSueldo(String id, Integer sueldo) {


        Periodista periodista = (Periodista) usuarioRepositorio.findById(id).get();
        periodista.setSueldo(sueldo);
        usuarioRepositorio.save(periodista);
    }



}
