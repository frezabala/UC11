/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exerciciosestoque;

/**
 *
 * @author FRELIANNYSISMELIALOP
 */
public class Produto {
    private String name;
    private int quantidade;

    public Produto(String Name, int Quantidade) {
        this.name = Name;
        this.quantidade = Quantidade;
    }

    public String getName() {
        return name;
    }

    public int getQuantidade() {
        return quantidade;
    }
        public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        if (quantidade > this.quantidade) {
            throw new IllegalArgumentException("Quantidade a remover é maior que a disponível.");
        }
        this.quantidade -= quantidade;
    }
}
    

