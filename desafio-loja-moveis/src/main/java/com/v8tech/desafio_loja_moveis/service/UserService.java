package com.v8tech.desafio_loja_moveis.service;

import com.v8tech.desafio_loja_moveis.dto.UsuarioDTO;
import com.v8tech.desafio_loja_moveis.entity.Usuario;
import com.v8tech.desafio_loja_moveis.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return convertToDTO(savedUsuario);
    }

    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findByAtivo(true).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> getUsuarioById(Long id) {
        return usuarioRepository.findByIdAndAtivo(id, true)
                .map(this::convertToDTO);
    }

    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(usuarioDTO.getNome());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setAtivo(usuarioDTO.getAtivo());

        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return convertToDTO(updatedUsuario);
    }

    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }



    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setLogin(usuario.getLogin());
        usuarioDTO.setSenha(usuario.getSenha());
        usuarioDTO.setAtivo(usuario.getAtivo());
        return usuarioDTO;
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setAtivo(usuarioDTO.getAtivo());
        return usuario;
    }
}
