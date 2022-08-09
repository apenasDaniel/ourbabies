package com.ourbabies.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ourbabies.springboot.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


	boolean existsByCpf(String cpf);
    Usuario findByCpfAndSenha (String cpf, String senha);
    
    
  
}
