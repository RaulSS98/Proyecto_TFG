package com.example.proyecto_tfg.service;


import com.example.proyecto_tfg.models.Jugador;
import com.example.proyecto_tfg.repository.JugadorRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class JugadorServiceImpl extends BaseService<Jugador, Integer, JugadorRepository>{

    @Autowired
    private JugadorRepository jugadoresRepository;

    public Jugador addJugador(Jugador jugador){
        return jugadoresRepository.save(jugador);
    }

    public Jugador modifyJugador(Integer id , Jugador jugador) throws Exception {
        if(jugadoresRepository.findById(id) != null){
            jugadoresRepository.delete(jugadoresRepository.getById(id));
            return jugadoresRepository.save(jugador);
        }
        else{
            throw new Exception("El ID del jugador que se desea modificar no existe");
        }
    }

    public String deleteJugador(Integer id){
        if(jugadoresRepository.findById(id) != null){
            jugadoresRepository.deleteById(id);
            return "Jugador borrado. ID: " + id;
        }
        return "El ID del jugador que se desea borrar no existe";
    }

    public Jugador getJugador(Integer id) throws Exception {
        if(jugadoresRepository.findById(id) != null){
            return jugadoresRepository.getById(id);
        }else{
            throw new Exception("El ID del jugador que se desea buscar no existe");
        }
    }

    public Page<Jugador> getAll(Pageable pageable, @SearchSpec Specification<Jugador> specs){
        return jugadoresRepository.findAll(specs, pageable);
    }

}
