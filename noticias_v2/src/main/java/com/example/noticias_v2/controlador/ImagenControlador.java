package com.example.noticias_v2.controlador;

import com.example.noticias_v2.entidad.Usuario;
import com.example.noticias_v2.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagen")
public class ImagenControlador {


    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/perfil/{username}")
    public ResponseEntity<byte[]> imagenUsuario (@PathVariable String username){
        System.out.println("ENTRO EN IMAGEEEEEEEEEEEEEEEEEN CONTROLADOOOOOOOOOOOOOOOORRRRRRRR");
        System.out.println("mail: " + username);
        Usuario usuario = usuarioService.getOne(username);
        byte[] imagen = usuario.getImagen().getContenido();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imagen,headers, HttpStatus.OK);
    }


}
