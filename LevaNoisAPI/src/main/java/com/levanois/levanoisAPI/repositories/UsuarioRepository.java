package com.levanois.levanoisAPI.repositories;

import com.levanois.levanoisAPI.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository// Indica que a classe é um repositório
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para buscar um usuário pelo email
    Optional<Usuario> findByEmailUsuario(String emailUsuario);
}
