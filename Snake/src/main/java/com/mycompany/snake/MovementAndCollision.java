/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import com.mycompany.snake.SnakeGame.Tile;
import java.awt.event.KeyEvent;


public class MovementAndCollision {

    public SnakeGame snakeGame;

    MovementAndCollision(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
    }

    public void move() {
        if (snakeGame.collision(snakeGame.snakeHead, snakeGame.food)) {
            snakeGame.snakeBody.add(snakeGame.new Tile(snakeGame.food.x, snakeGame.food.y));
            snakeGame.placeFood();
        }
        for (int i = snakeGame.snakeBody.size() - 1; i >= 0; i--) {
            SnakeGame.Tile snakePart = snakeGame.snakeBody.get(i);

            if (i == 0) {
                snakePart.x = snakeGame.snakeHead.x;
                snakePart.y = snakeGame.snakeHead.y;
            } else {
                SnakeGame.Tile prevSnakePart = snakeGame.snakeBody.get(i - 1);

                snakePart.x = prevSnakePart.x;
                snakePart.y = prevSnakePart.y;
            }
        }
        snakeGame.snakeHead.x += snakeGame.velocityX;
        snakeGame.snakeHead.y += snakeGame.velocityY;

        for (int i = 0; i < snakeGame.snakeBody.size(); i++) {
            Tile snakePart = snakeGame.snakeBody.get(i);

            if (snakeGame.collision(snakeGame.snakeHead, snakePart)) {
                snakeGame.gameOver = true;
            }
        }

        if (snakeGame.snakeHead.x * snakeGame.tileSize < 0 || snakeGame.snakeHead.x * snakeGame.tileSize >= snakeGame.boardWidht
                || snakeGame.snakeHead.y * snakeGame.tileSize < 0 || snakeGame.snakeHead.y * snakeGame.tileSize > snakeGame.boardHeight) {
            snakeGame.gameOver = true;
        }
    }

    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }

    public void keyPressed(KeyEvent tecla) {
        switch (tecla.getKeyCode()) {

            case KeyEvent.VK_UP:
                if (snakeGame.velocityY != 1) {
                    snakeGame.velocityX = 0;
                    snakeGame.velocityY = -1;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (snakeGame.velocityY != -1) {
                    snakeGame.velocityX = 0;
                    snakeGame.velocityY = 1;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (snakeGame.velocityX != 1) {
                    snakeGame.velocityX = -1;
                    snakeGame.velocityY = 0;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (snakeGame.velocityX != -1) {
                    snakeGame.velocityX = 1;
                    snakeGame.velocityY = 0;
                }
                break;

        }
    }
}
