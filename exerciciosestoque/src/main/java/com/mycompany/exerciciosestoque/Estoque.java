/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.exerciciosestoque;

import java.util.ArrayList;

/**
 *
 * @author FRELIANNYSISMELIALOP
 */
public class Estoque {

    private ArrayList<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void AdicionarProduto(String nome, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getName().equalsIgnoreCase(nome)) {
                produto.adicionarQuantidade(quantidade);
                return;

            }
        }
        produtos.add(new Produto(nome, quantidade));
    } 

    public void removeProduto(String nome, int quantidade) {
        for (Produto prod : produtos) {
            if (prod.getName().equals(nome)) {
                prod.removerQuantidade(quantidade);
                if (prod.getQuantidade() == 0) {
                    produtos.remove(prod);
                }
                return;
            }
        }
        throw new IllegalArgumentException("Produto não encontrado.");
    }

    public int consultarQuantidade(String nome) {
        for (Produto produto : produtos) {
            if (produto.getName().equals(nome)) {
                return produto.getQuantidade();
            }
        }
        return 0; //Produto nao encontrado
    }

    public String produtoMaisEstocado() {
        if (produtos.isEmpty()) {
            return "estoque vazio";
        }
        Produto maisEstocado = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getQuantidade() > maisEstocado.getQuantidade()) {
                maisEstocado = produto;
            }
        }
        return maisEstocado.getName();
    }

    public void limparEstoque() {
        produtos.clear();
    }
    
   


}
