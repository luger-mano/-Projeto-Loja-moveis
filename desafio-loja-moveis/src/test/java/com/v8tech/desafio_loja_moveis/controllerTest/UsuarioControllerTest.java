package com.v8tech.desafio_loja_moveis.controllerTest;


import com.v8tech.desafio_loja_moveis.controller.UsuarioController;
import com.v8tech.desafio_loja_moveis.entity.Usuario;
import com.v8tech.desafio_loja_moveis.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");

        when(usuarioService.saveUsuario(any(Usuario.class))).thenReturn(usuario);

        ResponseEntity<Usuario> response = usuarioController.createUsuario(usuario);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Teste", Objects.requireNonNull(response.getBody()).getNome());
    }

    @Test
    void testGetAllUsuarios() {
        usuarioController.getAllUsuarios();
        verify(usuarioService, times(1)).getAllUsuarios();
    }

    @Test
    void testGetUsuarioById() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        when(usuarioService.getUsuarioById(1L)).thenReturn(Optional.of(usuario));

        ResponseEntity<Usuario> response = usuarioController.getUsuarioById(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, Objects.requireNonNull(response.getBody()).getId());
    }

    @Test
    void testUpdateUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Teste");

        when(usuarioService.updateUsuario(eq(1L), any(Usuario.class))).thenReturn(usuario);

        ResponseEntity<Usuario> response = usuarioController.updateUsuario(1L, usuario);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Teste", Objects.requireNonNull(response.getBody()).getNome());
    }

    @Test
    void testDeleteUsuario() {
        doNothing().when(usuarioService).deleteUsuario(1L);

        ResponseEntity<Void> response = usuarioController.deleteUsuario(1L);
        assertEquals(204, response.getStatusCodeValue());
    }
}
