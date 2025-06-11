
import com.mycompany.snake.Snake;
import com.mycompany.snake.SnakeGame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FRELIANNYSISMELIALOP
 */
public class testeSnakeGame {
   public SnakeGame sn;
   
    
  @BeforeEach
    public void setup() {
      sn = new SnakeGame(1000,  1000);
      
      
    }

    @Test
    public void testBoardSize() {
       assertEquals(1000, sn.boardWidht);
       assertEquals(1000, sn.boardHeight);
        
    }
    
    @Test
    public void testSnakeHeadPosition() {
        SnakeGame snakegame = new SnakeGame(600 ,600);
        int x = snakegame.snakeHead.x;
        int y = snakegame.snakeHead.y;
        
        assertEquals(5 , x);
         assertEquals(5, y);
      
    }

    @Test
    public void testFoodPosition() {
         SnakeGame sng = new SnakeGame(600 ,600);
         int foodx = sng.food.x;
         int foody = sng.food.y;
         
         assertEquals(10, foodx);
         assertEquals(10, foody);
         
        
        
        
    }
    
    @Test
    public void testGameOver(){
        assertEquals(sn.gameOver);
    
    
    
    }
    
    @Test 
    public void testPlaceFood(){
        SnakeGame gameSnake = new SnakeGame(600 ,600);
        
        
    
    
    
    
    }
    
    @Test
    public void testMove(){}
    
    @Test
    public void testKeyPressedUP(){}
    
    @Test
    public void testKeyPressedDown(){}
    
    @Test
    public void testKeyPressedLeft(){}
    
     @Test
    public void testKeyPressedRight(){}
    
     @Test
    public void testCollisionWithBody(){}
    
}
