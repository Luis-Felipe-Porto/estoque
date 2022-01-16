package com.api.estoque.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @NotNull
    private String nome;
    @NotNull
    private Long quantidade;
    @NotNull
    private boolean disponivel;
    @NotNull
    private Double valor;
    @NotEmpty
    @NotNull
    private String descricao;
    @NotEmpty
    @NotNull
    @Size(min = 0)
    private String codigo;

    public Produto() {

    }

    public Produto(String nome, Long quantidade, boolean disponivel, Double valor, String descricao, String codigo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        this.valor = valor;
        this.descricao = descricao;
        this.codigo = codigo;
    }
    public boolean diminuirQuantidadeEmEstoque(Long quantidade){
        if(quantidade > 0) {
            this.quantidade -=quantidade;
            return true;
        } 
        return false;
    }
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
