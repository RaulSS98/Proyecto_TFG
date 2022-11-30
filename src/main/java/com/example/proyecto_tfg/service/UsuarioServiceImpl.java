package com.example.proyecto_tfg.service;

import com.example.proyecto_tfg.models.Usuario;
import com.example.proyecto_tfg.repository.UsuarioRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseService<Usuario, Integer, UsuarioRepository>{

    @Autowired
    private UsuarioRepository usuariosRepository;

    public Usuario addUsuario(Usuario usuario){
        return usuariosRepository.save(usuario);
    }

    public Usuario modifyUsuario(Integer id , Usuario usuario) throws Exception {
        if(usuariosRepository.findById(id) != null){
            usuariosRepository.delete(usuariosRepository.getById(id));
            return usuariosRepository.save(usuario);
        }
        else{
            throw new Exception("El ID del usuario que se desea modificar no existe");
        }
    }

    public String deleteUsuario(Integer id){
        if(usuariosRepository.findById(id) != null){
            usuariosRepository.deleteById(id);
            return "Usuario borrado. ID: " + id;
        }
        return "El ID del usuario que se desea borrar no existe";
    }

    public Usuario getUsuario(Integer id) throws Exception {
        if(usuariosRepository.findById(id) != null){
            return usuariosRepository.getById(id);
        }else{
            throw new Exception("El ID del usuario que se desea buscar no existe");
        }
    }

    public Page<Usuario> getAll(Pageable pageable, @SearchSpec Specification<Usuario> specs){
        return usuariosRepository.findAll(specs, pageable);
    }


}
