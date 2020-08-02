package com.avps.portfolio.api.controller;

import com.avps.portfolio.api.dto.TecnologiaDTO;
import com.avps.portfolio.api.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tecnologias")
public class TecnologiaController {

    @Autowired
    private TecnologiaService service;

    @GetMapping
    public ResponseEntity<List<TecnologiaDTO>> findTecnologias(@RequestParam(value = "nome", required = false) String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnologiaDTO> findById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TecnologiaDTO> save(@RequestBody TecnologiaDTO tecnologiaDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tecnologiaDTO));
    }

}
