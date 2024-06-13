package com.v8tech.desafio_loja_moveis.domain;

import jakarta.persistence.*;

@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false, unique = true)
    private String cep;
    @Column(nullable = false)
    private String neighborhood;
    @ManyToOne
    private City city;



}
