package com.api.estoque.controller;

import com.api.estoque.entity.Produto;
import com.api.estoque.exceptions.ProdutoNotFoundException;
import com.api.estoque.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService ;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos(){
        List<Produto> produtos = produtoService.buscarProdutos();
        return ResponseEntity.ok(produtos);
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> buscarProdutoPor(@PathVariable String codigo) throws ProdutoNotFoundException {
        Produto produto = produtoService.buscaPor(codigo);
        return ResponseEntity.ok(produto);
    }
    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody @Valid Produto produto){
        return ResponseEntity.ok(produtoService.cadastrar(produto));
    }
}
