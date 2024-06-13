package com.v8tech.desafio_loja_moveis.repository;

import com.v8tech.desafio_loja_moveis.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByActive(boolean active);
}
