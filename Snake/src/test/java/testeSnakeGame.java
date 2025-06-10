
import com.mycompany.snake.Snake;
import com.mycompany.snake.SnakeGame;
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
   public SnakeGame snakeGame;
    private Snake snake;
    
    @BeforeEach	
    public void setUp(){
        snake = new Snake();
    }

    @Test
    public void testBoardSize(){
   //assertEquals(600,)
    }
    
    @Test
    public void testSnakeHeadPosition(){}
    
    @Test
    public void testFoodPosition(){}
    
    @Test
    public void testGameOver(){}
    
    @Test 
    public void testPlaceFood(){}
    
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
