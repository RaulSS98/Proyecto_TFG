package com.example.proyecto_tfg.controller;

import com.example.proyecto_tfg.models.Competicion;
import com.example.proyecto_tfg.service.CompeticionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import com.sipios.springsearch.anotation.SearchSpec;

@RestController
@RequestMapping("/competiciones")
@CrossOrigin(origins="*")
public class CompeticionesController {

    @Autowired
    CompeticionServiceImpl competicionesServiceImpl;


    @PostMapping("/add")
    public ResponseEntity<Competicion> addCompeticion(@RequestBody Competicion competicion) {
        Competicion competicionAdd = competicionesServiceImpl.addCompeticion(competicion);
        return new ResponseEntity<>(competicionAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<Competicion> editCompeticion(@PathVariable Integer id, @RequestBody Competicion newCompeticion) throws Exception {
        Competicion competicionMod = competicionesServiceImpl.modifyCompeticion(id,newCompeticion);
        return new ResponseEntity<>(competicionMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompeticion(@PathVariable Integer id){
        return competicionesServiceImpl.deleteCompeticion(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Competicion>> getAll(@PageableDefault(size = 5, page = 0)Pageable pageable,
                                                    @SearchSpec Specification<Competicion> specs){
        Page<Competicion> competicion = competicionesServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(competicion,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Competicion> getCliente(@PathVariable Integer id) throws Exception {
        Competicion competicion = competicionesServiceImpl.getCompeticion(id);
        return new ResponseEntity<>(competicion,HttpStatus.OK);
    }

}
