package com.example.proyecto_tfg.controller;

import com.example.proyecto_tfg.models.Partido;
import com.example.proyecto_tfg.service.PartidoServiceImpl;
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
@RequestMapping("/partidos")
@CrossOrigin(origins="*")
public class PartidoController {

    @Autowired
    PartidoServiceImpl partidosServiceImpl;


    @PostMapping("/add")
    public ResponseEntity<Partido> addPartido(@RequestBody Partido partido) {
        Partido partidoAdd = partidosServiceImpl.addPartido(partido);
        return new ResponseEntity<>(partidoAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<Partido> editPartido(@PathVariable Integer id, @RequestBody Partido newPartido) throws Exception {
        Partido partidoMod = partidosServiceImpl.modifyPartido(id,newPartido);
        return new ResponseEntity<>(partidoMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePartido(@PathVariable Integer id){
        return partidosServiceImpl.deletePartido(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Partido>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                @SearchSpec Specification<Partido> specs){
        Page<Partido> partido = partidosServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(partido, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Partido> getPartido(@PathVariable Integer id) throws Exception {
        Partido partido = partidosServiceImpl.getPartido(id);
        return new ResponseEntity<>(partido,HttpStatus.OK);
    }

}
