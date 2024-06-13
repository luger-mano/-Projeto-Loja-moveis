package com.v8tech.desafio_loja_moveis.service;

import com.v8tech.desafio_loja_moveis.dto.UserDTO;
import com.v8tech.desafio_loja_moveis.entity.User;
import com.v8tech.desafio_loja_moveis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO saveUsuario(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findByAtivo(true).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findByIdAndAtivo(id, true)
                .map(this::convertToDTO);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setNome(userDTO.getNome());
        user.setLogin(userDTO.getLogin());
        user.setSenha(userDTO.getSenha());
        user.setAtivo(userDTO.getAtivo());

        User updatedUser = userRepository.save(user);
        return convertToDTO(updatedUser);
    }

    public void deleteUser(Long id) {
        Optional<User> optionalUsuario = userRepository.findByIdAndAtivo(id, true);
        if (optionalUsuario.isPresent()) {
            User user = optionalUsuario.get();
            user.setAtivo(false);
            userRepository.save(user);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }




    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNome(user.getNome());
        userDTO.setLogin(user.getLogin());
        userDTO.setSenha(user.getSenha());
        userDTO.setAtivo(user.getAtivo());
        return userDTO;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setNome(userDTO.getNome());
        user.setLogin(userDTO.getLogin());
        user.setSenha(userDTO.getSenha());
        user.setAtivo(userDTO.getAtivo());
        return user;
    }
}
