package com.zup.loteria.repository;

import com.zup.loteria.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
    Optional<Jogador> findByEmail(String email);
}
