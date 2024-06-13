package com.v8tech.desafio_loja_moveis.controller;

import com.v8tech.desafio_loja_moveis.dto.UsuarioDTO;
import com.v8tech.desafio_loja_moveis.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
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
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome("Teste");

        when(usuarioService.saveUsuario(any(UsuarioDTO.class))).thenReturn(usuarioDTO);

        ResponseEntity<UsuarioDTO> response = usuarioController.createUsuario(usuarioDTO);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Teste", Objects.requireNonNull(response.getBody()).getNome());
    }

    @Test
    void testGetAllUsuarios() {
        List<UsuarioDTO> usuarioDTOList = List.of(new UsuarioDTO(), new UsuarioDTO());
        when(usuarioService.getAllUsuarios()).thenReturn(usuarioDTOList);

        List<UsuarioDTO> response = usuarioController.getAllUsuarios();
        assertEquals(2, response.size());
        verify(usuarioService, times(1)).getAllUsuarios();
    }

    @Test
    void testGetUsuarioById() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);

        when(usuarioService.getUsuarioById(1L)).thenReturn(Optional.of(usuarioDTO));

        ResponseEntity<UsuarioDTO> response = usuarioController.getUsuarioById(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, Objects.requireNonNull(response.getBody()).getId());
    }

    @Test
    void testUpdateUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setNome("Teste");

        when(usuarioService.updateUsuario(eq(1L), any(UsuarioDTO.class))).thenReturn(usuarioDTO);

        ResponseEntity<UsuarioDTO> response = usuarioController.updateUsuario(1L, usuarioDTO);
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
