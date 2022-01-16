package com.api.estoque.dtos;

public record Item(Long id,Long quantidade,String codigo,String nome,Double valor) {
}
