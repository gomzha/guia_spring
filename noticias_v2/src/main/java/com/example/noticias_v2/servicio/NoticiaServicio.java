package com.example.noticias_v2.servicio;

import com.example.noticias_v2.entidad.Noticia;
import com.example.noticias_v2.repositorio.NoticiaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticiaServicio {

    @Autowired
    NoticiaRepositorio noticiaRepositorio;

    @Transactional
    public void crearNoticia(String titulo, String cuerpo) {
        Noticia noticia = new Noticia(titulo, cuerpo, true);
        noticiaRepositorio.save(noticia);
    }

    @Transactional
    public void bajaNoticia(Integer id){
        noticiaRepositorio.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Noticia> listarNoticias() {

        List<Noticia> noticia = new ArrayList();

        noticia = noticiaRepositorio.findAll();

        return noticia;
    }


    @Transactional
    public Noticia mostrarCuerpo(Integer id) {
        return noticiaRepositorio.findById(id).get();
    }

    @Transactional
    public void modificarCuerpo(Integer id, String cuerpo) {

        Noticia noticia = noticiaRepositorio.findById(id).get();
        noticia.setCuerpo(cuerpo);
        noticiaRepositorio.save(noticia);
    }
}
