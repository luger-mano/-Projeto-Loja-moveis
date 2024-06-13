package com.v8tech.desafio_loja_moveis.entity;

import jakarta.persistence.*;

@Entity
public class City {

    @Id
    @Column(name = "cityId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private State state;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String codIbge;
}
