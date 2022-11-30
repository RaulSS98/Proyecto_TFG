package com.example.proyecto_tfg.controller;


import com.example.proyecto_tfg.models.Equipo;
import com.example.proyecto_tfg.service.EquipoServiceImpl;
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
@RequestMapping("/equipos")
@CrossOrigin(origins="*")
public class EquipoController {

    @Autowired
    EquipoServiceImpl equiposServiceImpl;


    @PostMapping("/add")
    public ResponseEntity<Equipo> addEquipo(@RequestBody Equipo equipo) {
        Equipo equipoAdd = equiposServiceImpl.addEquipo(equipo);
        return new ResponseEntity<>(equipoAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<Equipo> editEquipo(@PathVariable Integer id, @RequestBody Equipo newEquipo) throws Exception {
        Equipo equipoMod = equiposServiceImpl.modifyEquipo(id,newEquipo);
        return new ResponseEntity<>(equipoMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEquipo(@PathVariable Integer id){
        return equiposServiceImpl.deleteEquipo(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Equipo>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                               @SearchSpec Specification<Equipo> specs){
        Page<Equipo> equipo = equiposServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(equipo, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Equipo> getEquipo(@PathVariable Integer id) throws Exception {
        Equipo equipo = equiposServiceImpl.getEquipo(id);
        return new ResponseEntity<>(equipo,HttpStatus.OK);
    }

}
