package com.v8tech.desafio_loja_moveis.controller;

import com.v8tech.desafio_loja_moveis.dto.UsuarioDTO;
import com.v8tech.desafio_loja_moveis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar-usuario")
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.saveUsuario(usuarioDTO));
    }

    @GetMapping
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.updateUsuario(id, usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
