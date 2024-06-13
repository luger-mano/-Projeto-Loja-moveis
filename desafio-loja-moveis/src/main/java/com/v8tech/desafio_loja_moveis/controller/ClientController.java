package com.v8tech.desafio_loja_moveis.controller;

import com.v8tech.desafio_loja_moveis.domain.ClientRepository;
import com.v8tech.desafio_loja_moveis.domain.Cliente;
import com.v8tech.desafio_loja_moveis.dto.ClientDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid ClientDTO data) {
        var client = new Cliente(data);
        repository.save(client);


        return ResponseEntity.ok().body(data);
    }






}
