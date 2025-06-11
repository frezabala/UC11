/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.snake;

import javax.swing.JFrame;


public class Snake {

    public static void main(String[] args) {
        int boardWidth = 600; //controlar a largura da tela 
        int boardHeight = boardWidth; //controlar a altula da tela

        JFrame frame = new JFrame("Snake"); // criar jframe novo 
        frame.setVisible(true);
        frame.setSize(boardWidth + 16, boardHeight + 42); // definir o tamanho dele
        frame.setLocationRelativeTo(null); // faz que a tela fique no meio 
        frame.setResizable(false); //nao deixa aumentar\diminuir a tela 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);
        frame.add(snakeGame);

        snakeGame.requestFocus();

    }

   
}
