package com.v8tech.desafio_loja_moveis.domain;

import com.v8tech.desafio_loja_moveis.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity(name = "cliente")
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cpf;
    @Column(name = "nome")
    private String name;
    @Embedded
    @Column(name = "conato_id")
    private Contact contact;
    private Boolean active;

    public Cliente(ClientDTO clientDTO) {
        this.cpf = clientDTO.cpf();
        this.name = clientDTO.name();
        this.contact = clientDTO.contact();
        this.active = clientDTO.active();
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public Boolean getActive() {
        return active;
    }
}
