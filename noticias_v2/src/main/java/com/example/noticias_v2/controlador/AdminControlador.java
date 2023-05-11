package com.example.noticias_v2.controlador;


import com.example.noticias_v2.entidad.Noticia;
import com.example.noticias_v2.servicio.NoticiaServicio;
import com.example.noticias_v2.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@RequestMapping(value = {"/admin"}) //localhost:8080/

public class AdminControlador {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    NoticiaServicio noticiaServicio;


    @GetMapping("/inicio") //localhost:8080/noticia/registrar
    public String panelAdmin(){
        System.out.println("ingresa en la solapa admin inicio");
        return "admin_inicio.html";
    }



    @GetMapping("/registrar_periodista") //localhost:8080/noticia/registrar
    public String registrarPeriodista(){
        System.out.println("ingresa en la solapa admin registrar_periodista");
        return "registrar_periodista.html";
    }

    @PostMapping("/registroPeriodista")
    public String registroUsuario(@RequestParam String username , @RequestParam String email, @RequestParam String password, @RequestParam String password2,Integer sueldo, ModelMap modelo){
        System.out.println("entra acá!");
        usuarioService.registrarPeriodista(username,email, password, password2, sueldo);
        return "redirect:/admin/inicio";
    }

    @GetMapping("/ver_noticias") //localhost:8080/noticia/registrar
    public String verNoticias(ModelMap model){
        List<Noticia> noticia = noticiaServicio.listarNoticias();
        model.addAttribute("noticias", noticia);
        return "index.html";
    }

}
