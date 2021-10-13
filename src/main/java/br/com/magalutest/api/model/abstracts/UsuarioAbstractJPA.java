package br.com.magalutest.api.model.abstracts;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.magalutest.api.model.Usuario;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class UsuarioAbstractJPA {

  public static volatile SingularAttribute<Usuario, Long> idUsuario;
  public static volatile SingularAttribute<Usuario, String> nome;
  public static volatile SingularAttribute<Usuario, String> email;
  public static volatile SingularAttribute<Usuario, String> senha;

}

