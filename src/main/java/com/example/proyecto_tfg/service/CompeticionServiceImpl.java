package com.example.proyecto_tfg.service;

import com.example.proyecto_tfg.models.Competicion;
import com.example.proyecto_tfg.repository.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.sipios.springsearch.anotation.SearchSpec;


@Service
public class CompeticionServiceImpl extends BaseService<Competicion, Integer, CompeticionRepository>{

    @Autowired
    private CompeticionRepository competicionesRepository;

    public Competicion addCompeticion(Competicion competicion){
        return competicionesRepository.save(competicion);
    }


    public Competicion modifyCompeticion(Integer id , Competicion competicion) throws Exception {
        if(competicionesRepository.findById(id) != null){
            competicionesRepository.delete(competicionesRepository.getById(id));
            return competicionesRepository.save(competicion);
        }
        else{
            throw new Exception("El ID de la competicion que se desea modificar no existe");
        }
    }

    public String deleteCompeticion(Integer id){
        if(competicionesRepository.findById(id) != null){
            competicionesRepository.deleteById(id);
            return "Competicion borrada. ID: " + id;
        }
        return "El ID de la competicion que se desea borrar no existe";
    }

    public Competicion getCompeticion(Integer id) throws Exception {
        if(competicionesRepository.findById(id) != null){
            return competicionesRepository.getById(id);
        }else{
            throw new Exception("El ID de la competicion que se desea buscar no existe");
        }
    }

    public Page<Competicion> getAll(Pageable pageable, @SearchSpec Specification<Competicion> specs){
        return competicionesRepository.findAll(specs, pageable);
    }


}
