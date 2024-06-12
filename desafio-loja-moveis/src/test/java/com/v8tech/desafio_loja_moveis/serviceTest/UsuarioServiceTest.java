package com.v8tech.desafio_loja_moveis.serviceTest;

import com.v8tech.desafio_loja_moveis.entity.Usuario;
import com.v8tech.desafio_loja_moveis.repository.UsuarioRepository;
import com.v8tech.desafio_loja_moveis.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        assertEquals("Teste", savedUsuario.getNome());
    }

    @Test
    void testGetAllUsuarios() {
        usuarioService.getAllUsuarios();
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testGetUsuarioById() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> foundUsuario = usuarioService.getUsuarioById(1L);
        assertTrue(foundUsuario.isPresent());
        assertEquals(1L, foundUsuario.get().getId());
    }

    @Test
    void testUpdateUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Teste");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario updatedUsuario = usuarioService.updateUsuario(1L, usuario);
        assertEquals("Teste", updatedUsuario.getNome());
    }

    @Test
    void testDeleteUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        usuarioService.deleteUsuario(1L);
        verify(usuarioRepository, times(1)).delete(usuario);
    }
}
