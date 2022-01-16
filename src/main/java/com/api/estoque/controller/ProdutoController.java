package com.api.estoque.controller;

import com.api.estoque.dtos.Item;
import com.api.estoque.entity.Produto;
import com.api.estoque.exceptions.ProdutoNotFoundException;
import com.api.estoque.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("produtos")
public record ProdutoController(ProdutoService produtoService) {

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
    @GetMapping("baixa-estoque/{codigo}")
    public ResponseEntity<Produto> baixaDeEstoque(@PathVariable String codigo,@RequestParam Long quantidade) throws ProdutoNotFoundException {
        return  ResponseEntity.ok(produtoService.darBaixaEstoque(codigo,quantidade));
    }
    @PostMapping("baixa-estoque-produtos")
    public ResponseEntity<List<Item>> baixaDeEstoque(@RequestBody List<Item> produtos) throws ProdutoNotFoundException {
        return ResponseEntity.ok(produtoService.darBaixaEstoque(produtos));
    }

}
