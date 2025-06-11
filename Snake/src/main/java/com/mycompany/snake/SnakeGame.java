/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


public class SnakeGame extends JPanel implements ActionListener, KeyListener {

    /**
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    public class Tile {

        int x;
        int y;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
   public int boardWidht;
   public int boardHeight;
   public int tileSize = 25;
   public Tile snakeHead;
   public ArrayList<Tile> snakeBody;
   public Random random;
   public Tile food;
   public int velocityX;
   public int velocityY;
   public Timer gameLoop;
   public boolean gameOver = false;
   

    MovementAndCollision movementAndCollision;
    SnakeDraw snakeDraw;

    SnakeGame(int boardWidht, int boardHeight) {
        
        this.boardWidht = boardWidht;
        this.boardHeight = boardHeight;

        setPreferredSize(new Dimension(this.boardWidht, this.boardHeight));
        setBackground(Color.black);

        // ----------------adicionar suporte para eventos do teclado----------------
        addKeyListener(this);

        setFocusable(true);

        //------------------------------------------------------------------------- 
        //---------------------Iniciar a cobra e a comida---------------------------
        snakeHead = new Tile(5, 5);
        snakeBody = new ArrayList<>();
        food = new Tile(10, 10);

        random = new Random();

       
        //--------------------------------------------------------------------------
        //-------------------------- definir a direcao e velocidade da cobra--------
        /*definir a direcion horizontal inicial da cobra para a direita
    velocidadede 1 pixel por segundo*/
        velocityX = 1;
        velocityY = 0;
        //-------------------------------------------------------------------------

        //------------------iniciar objetos auxiliares---------------------------
        movementAndCollision = new MovementAndCollision(this);
        snakeDraw = new SnakeDraw(this);
        
        placeFood();
        //-----------------------------------------------------------------
        //------------------inicializar loop principal do jogo---------------------
        gameLoop = new Timer(100, this);
        gameLoop.start();

    }

   public ArrayList<Tile> getAvailableTiles() {
        ArrayList<Tile> availableTiles = new ArrayList<>();
        for (int x = 0; x < boardWidht / tileSize; x++) {
            for (int y = 0; y < boardHeight / tileSize; y++) {
                Tile tile = new Tile(x, y);
                boolean isOccupied = false;
                for (Tile bodyPart : snakeBody) {
                    if (collision(tile, bodyPart)) {
                        isOccupied = true;
                        break;
                    }
                }
                if (collision(tile, snakeHead)) {
                    isOccupied = true;
                }
                if (!isOccupied) {
                    availableTiles.add(tile);
                }
            }
        }
        return availableTiles;
    }
    
    public void placeFood() {
        ArrayList<Tile> livre = getAvailableTiles();
        int pos = random.nextInt(livre.size());
        food = livre.get(pos);
    }
    public void move() {
        movementAndCollision.move();
    }

    public boolean collision(Tile tile1, Tile tile2) {
        return movementAndCollision.collision(tile1, tile2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            gameLoop.stop();
        }
    }
   
    public void keyPressend(KeyEvent tecla) {
        movementAndCollision.keyPressed(tecla);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snakeDraw.paintComponent(g);
        // se chama automaticamente para redesenhar o componente do jogo 

    }
}
