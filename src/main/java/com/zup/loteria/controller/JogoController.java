package com.zup.loteria.controller;

import com.zup.loteria.model.Jogador;
import com.zup.loteria.model.Jogo;
import com.zup.loteria.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/loteria")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @PostMapping(path = "/nova-aposta")
    public ResponseEntity<Jogo> apostar(@Valid @RequestBody Jogador jogador){
        Jogo jogo = jogoService.novoJogo(jogador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(jogo.getId()).toUri();

        return ResponseEntity.created(uri).body(jogo);
    }
}
