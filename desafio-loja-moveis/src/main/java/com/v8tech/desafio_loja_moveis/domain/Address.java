package com.v8tech.desafio_loja_moveis.domain;

import jakarta.persistence.*;

@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "logradouro")
    private String street;
    private String cep;
    @Column(name = "bairro")
    private String neighborhood;
    @Column(name = "cidade")
    private String city;
    @Enumerated(EnumType.STRING)
    private State UF;


}
