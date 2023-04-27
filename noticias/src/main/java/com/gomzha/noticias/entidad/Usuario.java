//package com.gomzha.noticias.entidad;
//
//import com.gomzha.noticias.seguridad.Rol;
//import jakarta.persistence.*;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.GenericGenerators;
//
//import java.util.Date;
//
//@Entity
//public class Usuario {
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String id;
//
//    private String username;
//    private String password;
//    private String email;
//    private Date date;
//    private Boolean activo;
//
//    @Enumerated(EnumType.STRING)
//    private Rol rol;
//
//    public Usuario() {
//    }
//
//    public Boolean getActivo() {
//        return activo;
//    }
//
//    public void setActivo(Boolean activo) {
//        this.activo = activo;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Rol getRol() {
//        return rol;
//    }
//
//    public void setRol(Rol rol) {
//        this.rol = rol;
//    }
//}
