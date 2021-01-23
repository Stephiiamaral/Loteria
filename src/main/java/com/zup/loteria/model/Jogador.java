package com.zup.loteria.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email
    @NotBlank(message = "O e-mail é obrigatorio")
    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany
    private List<Jogo> jogos;

    public Jogador(){
    }

    public Jogador(Integer id, String email, List<Jogo> jogos) {
        this.id = id;
        this.email = email;
        this.jogos = jogos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
}
