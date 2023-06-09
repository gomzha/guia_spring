package com.gomzha.noticias.controlador;

import com.gomzha.noticias.entidad.Noticia;
import com.gomzha.noticias.servicio.NoticiaServicio;
//import com.gomzha.noticias.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/home", "/index"}) //localhost:8080/
public class PortalControlador {

    @Autowired
    NoticiaServicio noticiaServicio;

//    @Autowired
//    UsuarioService usuarioService;

    @RequestMapping(value = {"/", "/home", "/index"})
    public String home(ModelMap model) {
        String nombre = "GONZALO";
        model.addAttribute("nombre", nombre);

        List<Noticia> noticia = noticiaServicio.listarNoticias();

        model.addAttribute("noticias", noticia);
        return "index.html";
    }

    @GetMapping("/registrar") //localhost:8080/noticia/registrar
    public String registrar(){
        return "administrar_noticias_alta.html";
    }

    @GetMapping("/registrarUsuario")
    public String registrarUsuario(){
        return "registrarusuario.html";
    }

//    @PostMapping("/registroUsuario")
//    public String registroUsuario(@RequestParam String username , @RequestParam String email, @RequestParam String password, @RequestParam String password2,ModelMap modelo){
//
//        usuarioService.registrarUsuario(username,email, password, password2);
//        return "index.html";
//    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

}
