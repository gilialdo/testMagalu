package br.com.magalutest.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="idcliente")
    private Long idCliente;

    @NotNull
    @Column(name="nome")
    private String nome;

    @NotNull
    @Column(name="email")
    private String email;


    public Cliente() {
    }

    public Cliente(
        Long idCliente, 
        String nome, 
        String email) {

        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return this.idCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

}
