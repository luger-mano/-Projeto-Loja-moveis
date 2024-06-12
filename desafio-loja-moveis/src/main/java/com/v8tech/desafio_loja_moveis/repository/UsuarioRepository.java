package com.v8tech.desafio_loja_moveis.repository;

import com.v8tech.desafio_loja_moveis.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
