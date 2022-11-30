package com.example.proyecto_tfg.controller;

import com.example.proyecto_tfg.models.Usuario;
import com.example.proyecto_tfg.service.UsuarioServiceImpl;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuariosServiceImpl;


    @PostMapping("/add")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioAdd = usuariosServiceImpl.addUsuario(usuario);
        return new ResponseEntity<>(usuarioAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<Usuario> editUsuario(@PathVariable Integer id, @RequestBody Usuario newUsuario) throws Exception {
        Usuario usuarioMod = usuariosServiceImpl.modifyUsuario(id,newUsuario);
        return new ResponseEntity<>(usuarioMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable Integer id){
        return usuariosServiceImpl.deleteUsuario(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Usuario>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                @SearchSpec Specification<Usuario> specs){
        Page<Usuario> usuario = usuariosServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) throws Exception {
        Usuario usuario = usuariosServiceImpl.getUsuario(id);
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }

}
