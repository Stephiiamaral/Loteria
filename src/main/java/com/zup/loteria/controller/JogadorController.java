package com.zup.loteria.controller;

import com.zup.loteria.model.Jogo;
import com.zup.loteria.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping(path = "/minhas-apostas")
    public ResponseEntity<List<Jogo>> listarMinhasApostas(@RequestParam String email){
        return jogadorService.buscarJogos(email);
    }
}
