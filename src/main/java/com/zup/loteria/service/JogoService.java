package com.zup.loteria.service;

import com.zup.loteria.model.Jogador;
import com.zup.loteria.model.Jogo;
import com.zup.loteria.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repository;

    @Autowired
    private JogadorService jogadorService;

    @Transactional
    public Jogo novoJogo(Jogador jogadorInput) {
        Optional<Jogador> jogador = jogadorService.findByEmail(jogadorInput.getEmail());

        if (jogador.isEmpty()){
            jogador = Optional.of(jogadorService.novoJogado(jogadorInput.getEmail()));
        }

        Jogo jogo = criar();
        jogador.get().getJogos().add(jogo);

        return jogo;
    }

    @Transactional
    public Jogo criar() {
        Jogo jogo = new Jogo();
        jogo.setDataCriacao(LocalDate.now());
        gerarNumerosAleatorios(jogo);
        return repository.save(jogo);
    }

    private void gerarNumerosAleatorios(Jogo jogo){
        List<Integer> lista = getNovaListaDeNumerosAleatorios();

        if (jogo != null){
            jogo.setNumero1(lista.get(0));
            jogo.setNumero2(lista.get(1));
            jogo.setNumero3(lista.get(2));
            jogo.setNumero4(lista.get(3));
            jogo.setNumero5(lista.get(4));
            jogo.setNumero6(lista.get(5));
        }
    }

    private List<Integer> getNovaListaDeNumerosAleatorios(){
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();

        while (lista.size() < 6){
            Integer novoNumeroAleatorio = random.nextInt(60) + 1;
            if (!lista.contains(novoNumeroAleatorio)){
                lista.add(novoNumeroAleatorio);
            }
        }

        return lista;
    }

}
