package com.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueTest {

    private Estoque estoque;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    void setUp() {
        estoque = new Estoque();
        produto1 = new Produto("Produto A", 10.0);
        produto2 = new Produto("Produto B", 20.0);
    }

    @Test
    void testAdicionarProduto() {
        assertTrue(estoque.adicionarProduto(produto1), "Produto deve ser adicionado ao estoque");
        assertTrue(estoque.listarProdutos().contains(produto1), "Produto deve estar presente no estoque");
    }

    @Test
    void testAdicionarProdutoDuplicado() {
        estoque.adicionarProduto(produto1);
        assertFalse(estoque.adicionarProduto(produto1), "Produto duplicado não deve ser adicionado ao estoque");
    }

    @Test
    void testRemoverProdutoExistente() {
        estoque.adicionarProduto(produto1);
        assertTrue(estoque.removerProduto("Produto A"), "Produto existente deve ser removido com sucesso");
        assertFalse(estoque.listarProdutos().contains(produto1), "Produto não deve mais estar no estoque");
    }

    @Test
    void testRemoverProdutoNaoExistente() {
        assertFalse(estoque.removerProduto("Produto Inexistente"), "Remover produto não existente deve retornar falso");
    }

    @Test
    void testBuscarProdutoExistente() {
        estoque.adicionarProduto(produto1);
        assertEquals(produto1, estoque.buscarProduto("Produto A"), "Produto existente deve ser encontrado");
    }

    @Test
    void testBuscarProdutoNaoExistente() {
        assertNull(estoque.buscarProduto("Produto Inexistente"), "Busca por produto inexistente deve retornar nulo");
    }

    @Test
    void testListarProdutos() {
        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);
        assertEquals(2, estoque.listarProdutos().size(), "Quantidade de produtos listados deve estar correta");
        assertTrue(estoque.listarProdutos().contains(produto1), "Lista deve conter o produto1");
        assertTrue(estoque.listarProdutos().contains(produto2), "Lista deve conter o produto2");
    }
}

