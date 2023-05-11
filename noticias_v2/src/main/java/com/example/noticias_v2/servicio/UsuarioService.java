package com.example.noticias_v2.servicio;

import com.example.noticias_v2.entidad.Imagen;
import com.example.noticias_v2.entidad.Periodista;
import com.example.noticias_v2.enumeraciones.Rol;
import com.example.noticias_v2.entidad.Usuario;
import com.example.noticias_v2.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class  UsuarioService implements UserDetailsService {


    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    ImagenServicio imagenServicio;


    @Transactional
    public void registrarUsuario(String nombre, String email, String password, String password2, MultipartFile archivo){

        Usuario usuario = new Usuario();
        usuario.setUsername(nombre);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setEmail(email);
        usuario.setRol(Rol.USER);

        Imagen imagen = new Imagen();
        imagen = imagenServicio.crearImagen(archivo);
        usuario.setImagen(imagen);
        usuarioRepositorio.save(usuario);

    }

    @Transactional
    public void registrarPeriodista(String nombre, String email, String password, String password2, Integer sueldo){

        Periodista periodista = new Periodista();
        periodista.setUsername(nombre);
        periodista.setPassword(new BCryptPasswordEncoder().encode(password));
        periodista.setEmail(email);
        periodista.setRol(Rol.PERIODISTA);
        periodista.setSueldo(sueldo);
        usuarioRepositorio.save(periodista);

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);

        if(usuario != null){
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            System.out.println("El rol q cumple es el: " + usuario.getRol().toString());
            permisos.add(p);

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

            HttpSession session = attr.getRequest().getSession(true);

            session.setAttribute("usuariosession", usuario);

            return new User(usuario.getUsername(), usuario.getPassword(), permisos);
        }else {
            return null;
        }
    }

    @Transactional
    public Usuario getOne(String username) {

        Usuario usuario = new Usuario();
        usuario = usuarioRepositorio.buscarPorEmail(username);
        System.out.println("devuelve el usuario: " + usuario.getEmail());
        return usuario;
    }
}
