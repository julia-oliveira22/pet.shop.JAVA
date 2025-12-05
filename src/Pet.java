package com.petshop;

import java.util.List;

public class Pet {
    private String nomePet;
    private String nomeDono;
    private String telefone;
    private String email;
    private List<String> servicos;
    private double preco;

    public Pet(String nomePet, String nomeDono, String telefone, String email, List<String> servicos, double preco) {
        this.nomePet = nomePet;
        this.nomeDono = nomeDono;
        this.telefone = telefone;
        this.email = email;
        this.servicos = servicos;
        this.preco = preco;
    }

    public String getNomePet() { return nomePet; }
    public String getNomeDono() { return nomeDono; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public List<String> getServicos() { return servicos; }
    public double getPreco() { return preco; }
}
