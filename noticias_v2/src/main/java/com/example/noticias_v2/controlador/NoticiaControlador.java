package com.example.noticias_v2.controlador;


import com.example.noticias_v2.entidad.Noticia;
import com.example.noticias_v2.servicio.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN','ROLE_PERIODISTA')")
@RequestMapping("/noticia") //localhost:8080/Noticia

public class NoticiaControlador {

@Autowired
private NoticiaServicio noticiaServicio;


    @GetMapping("/registrar") //localhost:8080/noticia/registrar
    public String registrar(){
        System.out.println("ingresa acá");
        return "administrar_noticias_alta.html";
    }


    @PostMapping("/registro")
    public String registro(@RequestParam String titulo, @RequestParam String cuerpo, ModelMap modelo){

      //  try {
            noticiaServicio.crearNoticia(titulo,cuerpo);

      //      modelo.put("exito", "El Autor fue registrado correctamente!");
      //  } catch (MiException ex) {

      //      modelo.put("error", ex.getMessage());
      //      return "autor_form.html";
      //  }
        return "redirect:/entrada/home";
    }

    @GetMapping("/baja/{id}") //localhost:8080/noticia/baja
    public String baja(@PathVariable Integer id, ModelMap modelo){
        System.out.println("ingresa acá");

        noticiaServicio.bajaNoticia(id);
        List<Noticia> noticia = noticiaServicio.listarNoticias();

        modelo.addAttribute("noticias", noticia);
        return "redirect:/entrada/home";
    }

    @GetMapping("/ver/{id}")  //localhost:8080/noticia/ver
    public String ver(@PathVariable Integer id, ModelMap modelo) {

            System.out.println("ingresa a ver noticia");
            modelo.addAttribute("noticias", noticiaServicio.mostrarCuerpo(id));
            return "verNoticias.html";
        }

    @GetMapping("/modificar/{id}")  //localhost:8080/noticia/ver
    public String modificar(@PathVariable Integer id, ModelMap modelo) {

        modelo.addAttribute("noticiasId", id);
        return "modNoticias.html";
    }

    @PostMapping("/modificacion/{id}")
    public String modificacion(@RequestParam Integer id , @RequestParam String cuerpo,  ModelMap modelo){

        System.out.println("cuerpo: " + cuerpo);
        System.out.println("ID: " + id);

        //  try {
        noticiaServicio.modificarCuerpo(id,cuerpo);

        //      modelo.put("exito", "El Autor fue registrado correctamente!");
        //  } catch (MiException ex) {

        //      modelo.put("error", ex.getMessage());
        //      return "autor_form.html";
        //  }
        return "redirect:/entrada/home";
    }

}
