package com.example.proyecto_tfg.service;


import com.example.proyecto_tfg.models.Equipo;
import com.example.proyecto_tfg.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import com.sipios.springsearch.anotation.SearchSpec;

@Service
public class EquipoServiceImpl extends BaseService<Equipo, Integer, EquipoRepository>{

    @Autowired
    private EquipoRepository equiposRepository;

    public Equipo addEquipo(Equipo competicion){
        return equiposRepository.save(competicion);
    }

    public Equipo modifyEquipo(Integer id , Equipo equipo) throws Exception {
        if(equiposRepository.findById(id) != null){
            equiposRepository.delete(equiposRepository.getById(id));
            return equiposRepository.save(equipo);
        }
        else{
            throw new Exception("El ID del equipo que se desea modificar no existe");
        }
    }

    public String deleteEquipo(Integer id){
        if(equiposRepository.findById(id) != null){
            equiposRepository.deleteById(id);
            return "Equipo borrado. ID: " + id;
        }
        return "El ID del equipo que se desea borrar no existe";
    }

    public Equipo getEquipo(Integer id) throws Exception {
        if(equiposRepository.findById(id) != null){
            return equiposRepository.getById(id);
        }else{
            throw new Exception("El ID del equipo que se desea buscar no existe");
        }
    }

    public Page<Equipo> getAll(Pageable pageable, @SearchSpec Specification<Equipo> specs){
        return equiposRepository.findAll(specs, pageable);
    }

}
