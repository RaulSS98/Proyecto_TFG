package com.example.proyecto_tfg.service;


import com.example.proyecto_tfg.models.Partido;
import com.example.proyecto_tfg.repository.PartidoRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PartidoServiceImpl extends BaseService<Partido, Integer, PartidoRepository>{

    @Autowired
    private PartidoRepository partidosRepository;

    public Partido addPartido(Partido partido){
        return partidosRepository.save(partido);
    }

    public Partido modifyPartido(Integer id , Partido partido) throws Exception {
        if(partidosRepository.findById(id) != null){
            partidosRepository.delete(partidosRepository.getById(id));
            return partidosRepository.save(partido);
        }
        else{
            throw new Exception("El ID del jugador que se desea modificar no existe");
        }
    }

    public String deletePartido(Integer id){
        if(partidosRepository.findById(id) != null){
            partidosRepository.deleteById(id);
            return "Partido borrado. ID: " + id;
        }
        return "El ID del partido que se desea borrar no existe";
    }

    public Partido getPartido(Integer id) throws Exception {
        if(partidosRepository.findById(id) != null){
            return partidosRepository.getById(id);
        }else{
            throw new Exception("El ID del partido que se desea buscar no existe");
        }
    }

    public Page<Partido> getAll(Pageable pageable, @SearchSpec Specification<Partido> specs){
        return partidosRepository.findAll(specs, pageable);
    }

}
