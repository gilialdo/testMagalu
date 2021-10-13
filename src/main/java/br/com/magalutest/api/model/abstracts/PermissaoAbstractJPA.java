package br.com.magalutest.api.model.abstracts;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.magalutest.api.model.Permissao;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Permissao.class)
public abstract class PermissaoAbstractJPA {

  public static volatile SingularAttribute<Permissao, Long> idPermissao;
  public static volatile SingularAttribute<Permissao, String> descricao;

}

