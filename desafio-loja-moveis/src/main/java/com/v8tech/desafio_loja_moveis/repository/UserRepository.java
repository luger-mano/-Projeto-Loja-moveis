package com.v8tech.desafio_loja_moveis.repository;

import com.v8tech.desafio_loja_moveis.dto.UsuarioDTO;
import com.v8tech.desafio_loja_moveis.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByAtivo(boolean ativo);
    Optional<Usuario> findByIdAndAtivo(Long id, boolean ativo);
}
