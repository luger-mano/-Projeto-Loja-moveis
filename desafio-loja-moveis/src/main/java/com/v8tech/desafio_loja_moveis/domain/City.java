package com.v8tech.desafio_loja_moveis.domain;

import jakarta.persistence.*;

@Entity
public class City {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ManyToOne
    private State state;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String codIbge;
}
