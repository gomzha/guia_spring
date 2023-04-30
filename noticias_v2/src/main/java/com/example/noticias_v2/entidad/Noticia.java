package com.example.noticias_v2.entidad;


import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.Temporal;

import java.sql.Date;

@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String cuerpo;
    private Boolean estado;
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "periodista_creador_id")
    private Periodista periodistaCreador;

    public Periodista getPeriodistaCreador() {
        return periodistaCreador;
    }

    public void setPeriodistaCreador(Periodista periodistaCreador) {
        this.periodistaCreador = periodistaCreador;
    }

    public Noticia() {
    }

    public Noticia(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Noticia(String titulo, String cuerpo, Boolean estado) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.estado = estado;
    }

    public Noticia(Integer id, String titulo, String cuerpo, Boolean estado, Date fecha) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.estado = estado;
        this.fecha = fecha;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", estado=" + estado +
                ", fecha=" + fecha +
                '}';
    }
}
