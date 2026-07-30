package com.example.api.contatos.model; // <-- MUDEI O PACKAGE PRA COMBINAR COM O SEU

public class Contato {
    private Long id; // troquei int pra Long que é melhor pra API
    private String nome;
    private String telefone;
    private String email; // adicionei email

    // Construtor vazio - Spring precisa
    public Contato() {}

    // Construtor cheio
    public Contato(Long id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters - Spring precisa pra ler e salvar
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}