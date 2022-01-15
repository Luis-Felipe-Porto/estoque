package com.api.estoque.exceptions;

public class ProdutoNotFoundException extends Throwable {
    public ProdutoNotFoundException(String mensagem) {
        super(mensagem);
    }
}
