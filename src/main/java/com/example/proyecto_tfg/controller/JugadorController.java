package com.example.proyecto_tfg.controller;


import com.example.proyecto_tfg.models.Jugador;
import com.example.proyecto_tfg.service.JugadorServiceImpl;
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
@RequestMapping("/jugadores")
@CrossOrigin(origins="*")
public class JugadorController {

    @Autowired
    JugadorServiceImpl jugadoresServiceImpl;


    @PostMapping("/add")
    public ResponseEntity<Jugador> addJugador(@RequestBody Jugador jugador) {
        Jugador jugadorAdd = jugadoresServiceImpl.addJugador(jugador);
        return new ResponseEntity<>(jugadorAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<Jugador> editJugador(@PathVariable Integer id, @RequestBody Jugador newJugador) throws Exception {
        Jugador jugadorMod = jugadoresServiceImpl.modifyJugador(id,newJugador);
        return new ResponseEntity<>(jugadorMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteJugador(@PathVariable Integer id){
        return jugadoresServiceImpl.deleteJugador(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Jugador>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                @SearchSpec Specification<Jugador> specs){
        Page<Jugador> jugador = jugadoresServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(jugador, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Jugador> getJugador(@PathVariable Integer id) throws Exception {
        Jugador jugador = jugadoresServiceImpl.getJugador(id);
        return new ResponseEntity<>(jugador,HttpStatus.OK);
    }

}
