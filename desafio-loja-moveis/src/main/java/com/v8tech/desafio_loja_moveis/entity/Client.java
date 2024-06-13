package com.v8tech.desafio_loja_moveis.entity;

import com.v8tech.desafio_loja_moveis.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    private String cpf;
    @Column(nullable = false)
    private String name;


    //TODO alterar tipagem do atributo para receber um objeto contact
//    @OneToOne
//    @JoinColumn(name = "fkContact")
    private Long contact;
    private Boolean active;

    public Client(ClientDTO clientDTO) {
        this.cpf = clientDTO.cpf();
        this.name = clientDTO.name();
        this.contact = clientDTO.fkContact();
        this.active = true;
    }
}
