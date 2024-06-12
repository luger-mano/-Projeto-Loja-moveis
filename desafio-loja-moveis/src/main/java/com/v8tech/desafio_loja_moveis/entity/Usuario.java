package com.v8tech.desafio_loja_moveis.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "endereco_fk")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "contato_fk")
    private Contato contato;

    private Boolean ativo;
}

