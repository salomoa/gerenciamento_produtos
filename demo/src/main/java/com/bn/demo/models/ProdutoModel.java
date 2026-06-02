package com.bn.demo.models;

import com.bn.demo.Enum.UserRole;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity // para criar no banco
@Table(name = "TB_PRODUTO") // Nome da tabela no banco
public class ProdutoModel {

    @Id // Declaração do ID e como ele será gerado
    @GeneratedValue(strategy = GenerationType.IDENTITY) // metodo de geração do id
    private Long id;
    private String nome;
    @Column(name = "preco_do_produto") // nome da coluna na tabela
    private BigDecimal preco;
    @Column(name = "quant_estoque") // nome da coluna na tabela
    private Integer estoque;
    private String login;
    private String password;
    private UserRole role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPreco() { return preco; }

    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Integer getEstoque() { return estoque; }

    public void setEstoque(Integer estoque) { this.estoque = estoque; }
}
