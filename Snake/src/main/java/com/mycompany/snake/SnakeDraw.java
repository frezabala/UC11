/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import com.mycompany.snake.SnakeGame.Tile;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author FRELIANNYSISMELIALOP
 */
public class SnakeDraw extends JPanel {

    private SnakeGame snakeGame;

    SnakeDraw(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        for (int i = 0; i < snakeGame.boardWidht / snakeGame.tileSize; i++) {
            g.drawLine(i * snakeGame.tileSize, 0, i * snakeGame.tileSize, snakeGame.boardHeight);
            g.drawLine(0, i * snakeGame.tileSize, snakeGame.boardWidht, i * snakeGame.tileSize);
        }
        g.setColor(Color.red);

        g.fillRect(
                snakeGame.food.x * snakeGame.tileSize,
                snakeGame.food.y * snakeGame.tileSize,
                snakeGame.tileSize,
                snakeGame.tileSize
        );

        g.setColor(Color.green);

        g.fillRect(
                snakeGame.snakeHead.x * snakeGame.tileSize,
                snakeGame.snakeHead.y * snakeGame.tileSize,
                snakeGame.tileSize,
                snakeGame.tileSize
        );

        for (int i = 0; i < snakeGame.snakeBody.size(); i++) {
            Tile snakePart = snakeGame.snakeBody.get(i);

            g.fillRect(
                    snakePart.x * snakeGame.tileSize,
                    snakePart.y * snakeGame.tileSize,
                    snakeGame.tileSize,
                    snakeGame.tileSize
            );
        }
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        if (snakeGame.gameOver) {
            g.setColor(Color.red);
            g.drawString("Game Over! " + String.valueOf(snakeGame.snakeBody.size()),
                    snakeGame.tileSize - 16, snakeGame.tileSize);

        }

    }

}
