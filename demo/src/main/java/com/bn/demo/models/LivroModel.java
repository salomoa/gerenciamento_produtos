package com.bn.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_LIVRO")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "escritor")
    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    @Column(name = "ano_pub")
    public Long getAnoPublicacao() { return anoPublicacao; }

    public void setAnoPublicacao(Long anoPublicacao) { this.anoPublicacao = anoPublicacao; }
}
