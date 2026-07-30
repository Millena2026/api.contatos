package com.example.api.contatos.controller;

import com.example.api.contatos.model.Contato;
import com.example.api.contatos.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*") // <- ESSA LINHA SALVA A GENTE
@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @GetMapping
    public List<Contato> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Contato adicionar(@RequestBody Contato contato) {
        return repository.save(contato);
    }
}