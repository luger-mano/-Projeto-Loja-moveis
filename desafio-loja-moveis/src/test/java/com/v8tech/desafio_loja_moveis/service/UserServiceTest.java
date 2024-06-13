package com.v8tech.desafio_loja_moveis.service;

import com.v8tech.desafio_loja_moveis.dto.UsuarioDTO;
import com.v8tech.desafio_loja_moveis.entity.Usuario;
import com.v8tech.desafio_loja_moveis.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome("Teste");

        Usuario usuario = new Usuario();
        usuario.setNome("Teste");

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        UsuarioDTO savedUsuarioDTO = usuarioService.saveUsuario(usuarioDTO);
        assertEquals("Teste", savedUsuarioDTO.getNome());
    }

    @Test
    void testGetAllUsuarios() {
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        List<Usuario> usuarioList = List.of(usuario1, usuario2);

        when(usuarioRepository.findByAtivo(true)).thenReturn(usuarioList);

        List<UsuarioDTO> usuarioDTOList = usuarioService.getAllUsuarios();
        assertEquals(2, usuarioDTOList.size());
        verify(usuarioRepository, times(1)).findByAtivo(true);
    }

    @Test
    void testGetUsuarioById() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        when(usuarioRepository.findByIdAndAtivo(1L, true)).thenReturn(Optional.of(usuario));

        Optional<UsuarioDTO> foundUsuarioDTO = usuarioService.getUsuarioById(1L);
        assertTrue(foundUsuarioDTO.isPresent());
        assertEquals(1L, foundUsuarioDTO.get().getId());
    }

    @Test
    void testUpdateUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Teste");

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setNome("Teste");

        when(usuarioRepository.findByIdAndAtivo(1L, true)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        UsuarioDTO updatedUsuarioDTO = usuarioService.updateUsuario(1L, usuarioDTO);
        assertEquals("Teste", updatedUsuarioDTO.getNome());
    }

    @Test
    void testDeleteUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        when(usuarioRepository.findByIdAndAtivo(1L, true)).thenReturn(Optional.of(usuario));

        usuarioService.deleteUsuario(1L);
        verify(usuarioRepository, times(1)).save(usuario);
    }
}
