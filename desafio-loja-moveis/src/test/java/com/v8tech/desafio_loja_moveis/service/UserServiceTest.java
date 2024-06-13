package com.v8tech.desafio_loja_moveis.service;

import com.v8tech.desafio_loja_moveis.dto.UserDTO;
import com.v8tech.desafio_loja_moveis.entity.User;
import com.v8tech.desafio_loja_moveis.repository.UserRepository;
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

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Teste");

        User user = new User();
        user.setNome("Teste");

        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO savedUserDTO = userService.saveUsuario(userDTO);
        assertEquals("Teste", savedUserDTO.getNome());
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User();
        User user2 = new User();
        List<User> userList = List.of(user1, user2);

        when(userRepository.findByAtivo(true)).thenReturn(userList);

        List<UserDTO> userDTOList = userService.getAllUsers();
        assertEquals(2, userDTOList.size());
        verify(userRepository, times(1)).findByAtivo(true);
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);

        when(userRepository.findByIdAndAtivo(1L, true)).thenReturn(Optional.of(user));

        Optional<UserDTO> foundUsuarioDTO = userService.getUserById(1L);
        assertTrue(foundUsuarioDTO.isPresent());
        assertEquals(1L, foundUsuarioDTO.get().getId());
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        user.setId(1L);
        user.setNome("Teste");

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setNome("Teste");

        when(userRepository.findByIdAndAtivo(1L, true)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserDTO updatedUserDTO = userService.updateUser(1L, userDTO);
        assertEquals("Teste", updatedUserDTO.getNome());
    }

    @Test
    void testDeleteUser() {
        User user = new User();
        user.setId(1L);

        when(userRepository.findByIdAndAtivo(1L, true)).thenReturn(Optional.of(user));

        userService.deleteUser(1L);
        verify(userRepository, times(1)).save(user);
    }
}
