package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void testProdutoEqual() {
        Produto produto1 = new Produto("Produto A", 10.0);
        Produto produto2 = new Produto("Produto A", 15.0);
        
        assertEquals(produto1, produto2, "Produtos com o mesmo nome devem ser considerados iguais");
    }

    @Test
    void testProdutoNotEqual() {
        Produto produto1 = new Produto("Produto A", 10.0);
        Produto produto2 = new Produto("Produto B", 10.0);
        
        assertNotEquals(produto1, produto2, "Produtos com nomes diferentes devem ser considerados diferentes");
    }

    @Test
    void testProdutoHashCode() {
        Produto produto1 = new Produto("Produto A", 10.0);
        Produto produto2 = new Produto("Produto A", 15.0);
        
        assertEquals(produto1.hashCode(), produto2.hashCode(), "Produtos com o mesmo nome devem ter o mesmo hashCode");
    }

    @Test
    void testProdutoCompareTo() {
        Produto produto1 = new Produto("Produto A", 10.0);
        Produto produto2 = new Produto("Produto B", 20.0);
        
        assertTrue(produto1.compareTo(produto2) < 0, "Produto com preço menor deve ser menor na comparação");
        assertTrue(produto2.compareTo(produto1) > 0, "Produto com preço maior deve ser maior na comparação");
    }

    @Test
    void testGetNome() {
        Produto produto = new Produto("Produto C", 30.0);
        assertEquals("Produto C", produto.getNome(), "Nome do produto deve estar correto");
    }

    @Test
    void testGetPreco() {
        Produto produto = new Produto("Produto C", 30.0);
        assertEquals(30.0, produto.getPreco(), "Preço do produto deve estar correto");
    }
}
