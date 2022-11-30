package com.example.proyecto_tfg.repository;

import com.example.proyecto_tfg.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>, JpaSpecificationExecutor<Usuario> {

}
