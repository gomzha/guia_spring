package com.example.noticias_v2.controlador;

import com.example.noticias_v2.entidad.Noticia;
import com.example.noticias_v2.servicio.NoticiaServicio;
import com.example.noticias_v2.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
@RequestMapping(value = {"/inicio", "/"}) //localhost:8080/

public class InicioControlador {


    @Autowired
    NoticiaServicio noticiaServicio;

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = {"/inicio","/"}) //"/", "/login",
    public String login(ModelMap model) {
        String nombre = "GONZALO";
        model.addAttribute("nombre", nombre);
        System.out.println("public class InicioControlador | public String login(ModelMap model)");
//        List<Noticia> noticia = noticiaServicio.listarNoticias();
//
//        model.addAttribute("noticias", noticia);
        return "inicio.html";
    }

    @GetMapping("/registrarUsuario")
    public String registrarUsuario(){
        return "registrarusuario.html";
    }

    @PostMapping("/registroUsuario")
    public String registroUsuario(@RequestParam String username , @RequestParam String email, @RequestParam String password, @RequestParam String password2, MultipartFile archivo, ModelMap modelo){
        System.out.println("entra acá!");
        usuarioService.registrarUsuario(username,email, password, password2, archivo);
        return "inicio.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

}
