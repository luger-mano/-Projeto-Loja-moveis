package com.v8tech.desafio_loja_moveis.controller;

import com.v8tech.desafio_loja_moveis.dto.UserDTO;
import com.v8tech.desafio_loja_moveis.service.UserService;
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

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Teste");

        when(userService.saveUsuario(any(UserDTO.class))).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.createUsuario(userDTO);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Teste", Objects.requireNonNull(response.getBody()).getNome());
    }

    @Test
    void testGetAllUser() {
        List<UserDTO> userDTOList = List.of(new UserDTO(), new UserDTO());
        when(userService.getAllUsers()).thenReturn(userDTOList);

        List<UserDTO> response = userController.getAllUsers();
        assertEquals(2, response.size());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        when(userService.getUserById(1L)).thenReturn(Optional.of(userDTO));

        ResponseEntity<UserDTO> response = userController.getUserById(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, Objects.requireNonNull(response.getBody()).getId());
    }

    @Test
    void testUpdateUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setNome("Teste");

        when(userService.updateUser(eq(1L), any(UserDTO.class))).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = userController.updateUser(1L, userDTO);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Teste", Objects.requireNonNull(response.getBody()).getNome());
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userService).deleteUser(1L);

        ResponseEntity<Void> response = userController.deleteUser(1L);
        assertEquals(204, response.getStatusCodeValue());
    }
}
