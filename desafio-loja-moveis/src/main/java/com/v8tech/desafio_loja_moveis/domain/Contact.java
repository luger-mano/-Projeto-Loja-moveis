package com.v8tech.desafio_loja_moveis.domain;

import jakarta.persistence.*;

@Entity(name = "contato")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "telefone")
    private String telephone;
    @Column(name = "pessoa_contato")
    private String client;
    private String email;
}
