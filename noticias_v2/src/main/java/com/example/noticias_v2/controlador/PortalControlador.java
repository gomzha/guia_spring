package com.example.noticias_v2.controlador;

import com.example.noticias_v2.entidad.Noticia;
import com.example.noticias_v2.entidad.Usuario;
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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN','ROLE_PERIODISTA')")
@RequestMapping(value = {"/index", "/entrada"}) //localhost:8080/

public class PortalControlador {

    @Autowired
    NoticiaServicio noticiaServicio;

    @Autowired
    UsuarioService usuarioService;
    @RequestMapping(value = {"/entrada"}) //"/", "/login",
    public String login(ModelMap model) {
        String nombre = "GONZALO";
        model.addAttribute("nombre", nombre);

//        List<Noticia> noticia = noticiaServicio.listarNoticias();
//
//        model.addAttribute("noticias", noticia);
        return "entrada.html";
    }

    @RequestMapping(value = {"/home", "/index"})
    public String home(HttpSession session, ModelMap model) {
        System.out.println("entra dps de loggearse");
        String nombre = "GONZALO";
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");

        if (logueado.getRol().toString().equals("ADMIN")){
            return "redirect:/admin/inicio";
        }else {
            model.addAttribute("nombre", nombre);
            List<Noticia> noticia = noticiaServicio.listarNoticias();
            model.addAttribute("noticias", noticia);
            return "index.html";
        }
    }

    @GetMapping("/registrar") //localhost:8080/noticia/registrar
    public String registrar(){
        return "administrar_noticias_alta.html";
    }


//
//    @GetMapping("/registrarUsuario")
//    public String registrarUsuario(){
//        return "registrarusuario.html";
//    }
//
//    @PostMapping("/registroUsuario")
//    public String registroUsuario(@RequestParam String username , @RequestParam String email, @RequestParam String password, @RequestParam String password2, ModelMap modelo){
//
//        usuarioService.registrarUsuario(username,email, password, password2);
//        return "entrada.html";
//    }
//
//    @GetMapping("/entrada/login")
//    public String login(){
//        return "login.html";
//    }

}
