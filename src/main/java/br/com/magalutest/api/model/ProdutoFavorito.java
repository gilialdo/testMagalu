package br.com.magalutest.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "produto_favorito")
public class ProdutoFavorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="idprodutofavorito")
    private Long idProdutoFavorito;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @NotNull
    @Column(name="idproduto")
    private String idProduto;


    public ProdutoFavorito() {
    }

    public ProdutoFavorito(
        Long idProdutoFavorito, 
        Cliente cliente, 
        String idProduto) {

        this.idProdutoFavorito = idProdutoFavorito;
        this.cliente = cliente;
        this.idProduto = idProduto;
    }

    public void setIdProdutoFavorito(Long idProdutoFavorito) {
        this.idProdutoFavorito = idProdutoFavorito;
    }

    public Long getIdProdutoFavorito() {
        return this.idProdutoFavorito;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getIdProduto() {
        return this.idProduto;
    }

}
