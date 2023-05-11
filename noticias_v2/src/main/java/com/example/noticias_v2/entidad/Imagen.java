package com.example.noticias_v2.entidad;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Imagen {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idImagen;

    private String mime; // nombre del formato de la imagen
    private String nombre; //nombre de la imagen
    @Lob @Basic(fetch = FetchType.LAZY) //definimos que es un archivo grande y que es lazy, q se carga cuando lo pidamos. cuando consultamos el objeto no carga el atributo, solo lo trae cuando se hace un get
    private byte[]  contenido; //contenido de la imagen, o sea, la imagen en si


    public Imagen() {
    }

    public String getId() {
        return idImagen;
    }

    public void setId(String id) {
        this.idImagen = id;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
}
