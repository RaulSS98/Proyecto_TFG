package com.example.proyecto_tfg.repository;

import com.example.proyecto_tfg.models.Competicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CompeticionRepository extends JpaRepository<Competicion,Integer>, JpaSpecificationExecutor<Competicion> {
}
