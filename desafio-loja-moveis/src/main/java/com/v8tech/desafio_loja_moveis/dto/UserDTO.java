package com.v8tech.desafio_loja_moveis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private Boolean ativo;
}
