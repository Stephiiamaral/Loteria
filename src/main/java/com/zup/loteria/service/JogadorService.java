package com.zup.loteria.service;

import com.zup.loteria.model.Jogador;
import com.zup.loteria.model.Jogo;
import com.zup.loteria.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository repository;

    public ResponseEntity<List<Jogo>> buscarJogos(String email){
        Optional<Jogador> jogador = repository.findByEmail(email);
        if (jogador.isPresent()){
            return ResponseEntity.ok(jogador.get().getJogos());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Optional<Jogador> findByEmail(String email){
        return repository.findByEmail(email);
    }

    @Transactional
    public Jogador novoJogado(String email){
        Jogador jogador = new Jogador();
        jogador.setEmail(email);
        jogador.setJogos(new ArrayList<>());

        return repository.save(jogador);
    }
}
