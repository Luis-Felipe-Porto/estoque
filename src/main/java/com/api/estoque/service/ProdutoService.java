package com.api.estoque.service;

import com.api.estoque.entity.Produto;
import com.api.estoque.exceptions.ProdutoNotFoundException;
import com.api.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

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
}
