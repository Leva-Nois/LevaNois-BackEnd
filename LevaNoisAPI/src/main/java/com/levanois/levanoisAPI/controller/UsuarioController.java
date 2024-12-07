package com.levanois.levanoisAPI.controller;

import com.levanois.levanoisAPI.models.usuario.Usuario;
import com.levanois.levanoisAPI.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Optional<Usuario> encontrarUsuarioPorId(Long id) {
        return dbConnection.findById(id);
    }



    // TODO: Implementar os métodos de inserção, atualização e remoção de usuários (CRUD). E outros controllers necessários.
}
