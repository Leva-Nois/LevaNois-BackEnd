package com.levanois.levanoisAPI.controller;

import com.levanois.levanoisAPI.models.usuario.Usuario;
import com.levanois.levanoisAPI.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController // Indica que a classe é um controller
@RequestMapping("/usuarios") // Indica o caminho para acessar o controller
public class UsuarioController {

    @Autowired// Injeção de dependência
//    UsuarioController dbConnection;
    UsuarioRepository dbConnection;

    @CrossOrigin
    @GetMapping("/")
    public List<Usuario> listarUsuarios() {
        return dbConnection.findAll();
    }

    @CrossOrigin
    @GetMapping("/id/{id}")
    public List<Usuario> listarUsuarioPorId(@PathVariable Long id) {
        return dbConnection.findAllById(Collections.singleton(id));
    }


    // TODO: Implementar os métodos de inserção, atualização e remoção de usuários (CRUD). E outros controllers necessários.
}
