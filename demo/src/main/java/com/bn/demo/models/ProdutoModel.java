package com.bn.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer estoque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "preco_do_produto")
    public BigDecimal getPreco() { return preco; }

    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    @Column(name = "quant_estoque")
    public Integer getEstoque() { return estoque; }

    public void setEstoque(Integer estoque) { this.estoque = estoque; }
}
