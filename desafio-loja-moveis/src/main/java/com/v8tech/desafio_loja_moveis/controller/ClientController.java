package com.v8tech.desafio_loja_moveis.controller;

import com.v8tech.desafio_loja_moveis.repository.ClientRepository;
import com.v8tech.desafio_loja_moveis.entity.Client;
import com.v8tech.desafio_loja_moveis.dto.ClientDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid ClientDTO clientDTO) {

        //TODO verificar as regras de negócio e jogar sua lógica para ClienteService

        var client = new Client(clientDTO);
        clientRepository.save(client);

        return ResponseEntity.ok().body(clientDTO);
    }






}
