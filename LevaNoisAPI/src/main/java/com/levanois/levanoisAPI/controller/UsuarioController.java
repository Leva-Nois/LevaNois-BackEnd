package com.levanois.levanoisAPI.controller;

import com.levanois.levanoisAPI.models.usuario.Usuario;
import com.levanois.levanoisAPI.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    // Listar todos
    @CrossOrigin
    @GetMapping("/")
    public List<Usuario> listarUsuarios() {
        return dbConnection.findAll();
    }

    // Listar por ID
    @CrossOrigin
    @GetMapping("/id/{id}")
    public List<Usuario> listarUsuarioPorId(@PathVariable Long id) {
        return dbConnection.findAllById(Collections.singleton(id));
    }

    // Incluir
    @CrossOrigin
    @PostMapping("/")
    public void inserirUsuario(@RequestBody Usuario usuario){
        dbConnection.save(usuario);
    }

    // Alterar
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado){
        Optional<Usuario> usuarioExistente = dbConnection.findById(id);

        if(usuarioExistente.isPresent()){ // Verifica se o usuário existe
            Usuario usuario = usuarioExistente.get();

            usuario.setNomeUsuario(usuarioAtualizado.getNomeUsuario());
            usuario.setEmailUsuario(usuarioAtualizado.getEmailUsuario());
            usuario.setSenhaUsuario(usuarioAtualizado.getSenhaUsuario());
            usuario.setStatusUsuario(usuarioAtualizado.getStatusUsuario());


            dbConnection.save(usuarioExistente.get());
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        Optional<Usuario> usuario = dbConnection.findById(id);

        if(usuario.isPresent()){
            dbConnection.delete(usuario.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // TODO: Implementar os métodos de inserção, atualização e remoção de usuários (CRUD). E outros controllers necessários.
}
