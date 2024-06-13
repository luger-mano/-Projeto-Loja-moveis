package com.v8tech.desafio_loja_moveis.domain;

import com.v8tech.desafio_loja_moveis.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Entity(name = "cliente")
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cpf;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String contact;
    private Boolean active;

    public Cliente(ClientDTO clientDTO) {
        this.cpf = clientDTO.cpf();
        this.name = clientDTO.name();
        this.contact = clientDTO.contact();
        this.active = true;
    }
}
