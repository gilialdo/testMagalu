package br.com.magalutest.api.model.abstracts;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.magalutest.api.model.Cliente;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class ClienteAbstractJPA {

  public static volatile SingularAttribute<Cliente, Long> idCliente;
  public static volatile SingularAttribute<Cliente, String> nome;
  public static volatile SingularAttribute<Cliente, String> email;

}

