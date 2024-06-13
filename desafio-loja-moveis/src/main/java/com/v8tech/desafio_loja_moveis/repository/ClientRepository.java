package com.v8tech.desafio_loja_moveis.repository;

import com.v8tech.desafio_loja_moveis.entity.Cliente;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Cliente, Long> {
}
