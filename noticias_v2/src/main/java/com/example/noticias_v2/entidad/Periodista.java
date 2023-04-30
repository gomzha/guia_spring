package com.example.noticias_v2.entidad;


import com.example.noticias_v2.enumeraciones.Rol;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Periodista extends Usuario{
    private ArrayList<Noticia> misNoticias;
    private Integer sueldo;

    public Periodista() {
    }

    public Periodista(ArrayList<Noticia> misNoticias, Integer sueldo) {
        this.misNoticias = misNoticias;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Periodista{" +
                "misNoticias=" + misNoticias +
                ", sueldo=" + sueldo +
                '}';
    }

    public ArrayList<Noticia> getMisNoticias() {
        return misNoticias;
    }

    public void setMisNoticias(ArrayList<Noticia> misNoticias) {
        this.misNoticias = misNoticias;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }
}
