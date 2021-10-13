package br.com.magalutest.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="idpermissao")
    private Long idPermissao;

    @NotNull
    @Column(name="descricao")
    private String descricao;


    public Permissao() {
    }

    public Permissao(
        Long idPermissao, 
        String descricao) {

        this.idPermissao = idPermissao;
        this.descricao = descricao;
    }

    public void setIdPermissao(Long idPermissao) {
        this.idPermissao = idPermissao;
    }

    public Long getIdPermissao() {
        return this.idPermissao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
