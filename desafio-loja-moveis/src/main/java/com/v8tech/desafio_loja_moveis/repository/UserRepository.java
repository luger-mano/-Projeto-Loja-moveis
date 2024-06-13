package com.v8tech.desafio_loja_moveis.repository;

import com.v8tech.desafio_loja_moveis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAtivo(boolean ativo);
    Optional<User> findByIdAndAtivo(Long id, boolean ativo);
}
