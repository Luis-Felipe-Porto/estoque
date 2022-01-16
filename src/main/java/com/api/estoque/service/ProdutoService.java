package com.api.estoque.service;

import com.api.estoque.dtos.Item;
import com.api.estoque.entity.Produto;
import com.api.estoque.exceptions.ProdutoNotFoundException;
import com.api.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ProdutoService(ProdutoRepository produtoRepository) {

    public Produto buscaPor(String codigo) throws ProdutoNotFoundException {
        return produtoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado"));
    }

    public Produto cadastrar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> buscarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto darBaixaEstoque(String codigo, Long quantidade) throws ProdutoNotFoundException {
            Produto produto = buscaPor(codigo);
            produto.diminuirQuantidadeEmEstoque(quantidade);
            produtoRepository.save(produto);
            return produto;
    }
    public List<Item> darBaixaEstoque(List<Item> produtos) throws ProdutoNotFoundException {
        for (Item produto:produtos) {
            darBaixaEstoque(produto.codigo(),produto.quantidade());
        }
        return produtos;
    }


}
