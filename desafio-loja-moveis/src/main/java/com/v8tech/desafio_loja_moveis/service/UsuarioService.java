package com.v8tech.desafio_loja_moveis.service;

import com.v8tech.desafio_loja_moveis.entity.Usuario;
import com.v8tech.desafio_loja_moveis.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(usuarioDetails.getNome());
        usuario.setCpf(usuarioDetails.getCpf());
        usuario.setEndereco(usuarioDetails.getEndereco());
        usuario.setContato(usuarioDetails.getContato());
        usuario.setAtivo(usuarioDetails.getAtivo());

        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioRepository.delete(usuario);
    }
}


