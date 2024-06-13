package com.v8tech.desafio_loja_moveis.domain;

import ch.qos.logback.core.net.server.Client;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ClientRepository extends JpaRepository<Cliente, Long> {
}
