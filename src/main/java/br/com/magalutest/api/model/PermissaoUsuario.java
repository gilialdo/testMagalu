//package br.com.magalutest.api.model;
//
//import java.math.BigDecimal;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//
//@Entity
//@Table(name = "permissao_usuario")
//public class PermissaoUsuario {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
//    @Column(name="idpermissaousuario")
//    private Long idPermissaoUsuario;
//
//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "idusuario")
//    private Usuario usuario;
//
//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "idpermissao")
//    private Permissao permissao;
//
//
//    public PermissaoUsuario() {
//    }
//
//    public PermissaoUsuario(
//        Long idPermissaoUsuario, 
//        Usuario usuario, 
//        Permissao permissao) {
//
//        this.idPermissaoUsuario = idPermissaoUsuario;
//        this.usuario = usuario;
//        this.permissao = permissao;
//    }
//
//    public void setIdPermissaoUsuario(Long idPermissaoUsuario) {
//        this.idPermissaoUsuario = idPermissaoUsuario;
//    }
//
//    public Long getIdPermissaoUsuario() {
//        return this.idPermissaoUsuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//    public Usuario getUsuario() {
//        return this.usuario;
//    }
//
//    public void setPermissao(Permissao permissao) {
//        this.permissao = permissao;
//    }
//
//    public Permissao getPermissao() {
//        return this.permissao;
//    }
//
//}
