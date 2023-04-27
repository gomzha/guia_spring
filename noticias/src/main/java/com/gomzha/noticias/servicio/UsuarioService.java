//package com.gomzha.noticias.servicio;
//
//
//import com.gomzha.noticias.seguridad.Rol;
//import com.gomzha.noticias.entidad.Usuario;
//import com.gomzha.noticias.repositorio.UsuarioRepositorio;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.core.GrantedAuthorityDefaults;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class  UsuarioService implements UserDetailsService {
//
//
//    @Autowired
//    private UsuarioRepositorio usuarioRepositorio;
//
//
//    @Transactional
//    public void registrarUsuario(String nombre, String email, String password, String password2){
//
//        Usuario usuario = new Usuario();
//        usuario.setUsername(nombre);
//        usuario.setPassword(password);
//        usuario.setEmail(email);
//        //usuario.setDate();
//        usuario.setActivo(true);
//        usuario.setRol(Rol.USER);
//
//        usuarioRepositorio.save(usuario);
//
//
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);
//
//        if(usuario != null){
//            List<GrantedAuthority> permisos = new ArrayList<>();
//            GrantedAuthority p = new SimpleGrantedAuthority("ROLE:" + usuario.getRol().toString());
//            permisos.add(p);
//            return new User(usuario.getUsername(), usuario.getPassword(), permisos);
//        }else {
//            return null;
//        }
//    }
//}
