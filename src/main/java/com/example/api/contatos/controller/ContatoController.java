package com.example.api.contatos.controller;

import com.example.api.contatos.model.Contato;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private List<Contato> contatos = new ArrayList<>();
    private AtomicLong contador = new AtomicLong();

    // GET - Listar todos
    @GetMapping
    public List<Contato> listar() {
        return contatos;
    }

    // POST - Criar novo
    @PostMapping
    public Contato criar(@RequestBody Contato contato) {
        contato.setId(contador.incrementAndGet());
        contatos.add(contato);
        return contato;
    }

    // PUT - Atualizar
    @PutMapping("/{id}")
    public Contato atualizar(@PathVariable Long id, @RequestBody Contato contatoAtualizado) {
        for (Contato c : contatos) {
            if (c.getId().equals(id)) {
                c.setNome(contatoAtualizado.getNome());
                c.setTelefone(contatoAtualizado.getTelefone());
                c.setEmail(contatoAtualizado.getEmail());
                return c;
            }
        }
        return null;
    }

    // DELETE - Deletar
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        contatos.removeIf(c -> c.getId().equals(id));
        return "Contato deletado com sucesso!";
    }
}