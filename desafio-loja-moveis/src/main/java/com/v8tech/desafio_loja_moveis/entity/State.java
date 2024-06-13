package com.v8tech.desafio_loja_moveis.entity;

import jakarta.persistence.*;

@Entity
public class State {

    @Id
    @Column(name = "stateId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String UF;
    @Column(nullable = false, unique = true)
    private String codIbge;
}
