package com.ourbabies.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ourbabies.springboot.model.Doador;


@Repository
public interface DoadorRepository extends JpaRepository<Doador, Integer> {


	boolean existsByCpf(String cpf);
    Doador findByCpfAndSenha (String cpf, String senha);
    
    
  
}
