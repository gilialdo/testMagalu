package br.com.magalutest.api.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ProdutoFavoritoFilter {

    private Long idCliente;

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return this.idCliente;
    }

}

