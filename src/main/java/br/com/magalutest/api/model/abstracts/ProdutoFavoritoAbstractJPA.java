package br.com.magalutest.api.model.abstracts;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.magalutest.api.model.ProdutoFavorito;
import br.com.magalutest.api.model.Cliente;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProdutoFavorito.class)
public abstract class ProdutoFavoritoAbstractJPA {

  public static volatile SingularAttribute<ProdutoFavorito, Long> idProdutoFavorito;
  public static volatile SingularAttribute<ProdutoFavorito, Cliente> idCliente;
  public static volatile SingularAttribute<ProdutoFavorito, String> idProduto;

}

