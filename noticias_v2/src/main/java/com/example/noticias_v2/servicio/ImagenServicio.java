package com.example.noticias_v2.servicio;

import com.example.noticias_v2.entidad.Imagen;
import com.example.noticias_v2.repositorio.ImagenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@Service
public class ImagenServicio {


    @Autowired
    ImagenRepositorio imagenRepositorio;


    @Transactional
    public Imagen crearImagen(MultipartFile archivo) {

        if (archivo != null) {
            try {
                Imagen imagen = new Imagen();
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());
                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                System.err.println("Error a ingresar imagen: " + e.getMessage());
            }
        }
        return null;
    }

    @Transactional
    public void actualizarImagen(MultipartFile archivo, String idImagen){

        if(archivo != null){
            try{

                Imagen imagen = new Imagen();
                if(idImagen != null){
                    Optional<Imagen> respuesta = imagenRepositorio.findById(idImagen);
                    if (respuesta.isPresent()){
                        imagen= respuesta.get();
                    }
                }
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());

            }catch (Exception e){
                System.err.println("Error a ingresar imagen: " + e.getMessage());
            }

        }

    }

}
