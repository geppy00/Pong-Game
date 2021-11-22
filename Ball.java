
package model;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle {
    
    //ATTRIBUTI
    protected Random random;
    protected float xVelocity;
    protected float yVelocity;
    protected float initialSpeed = 1.5F;
    
    //COSTRUTTORI
    public Ball() {
        
    }
    
    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.random= new Random();
        
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0) 
            randomXDirection--;
         setXDirection(randomXDirection * this.initialSpeed);
        
        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection * this.initialSpeed);
        
    }
    
    //METODI
    public void setXDirection(float randomXDirection) {
        this.xVelocity = randomXDirection;
    }
    
    public void setYDirection(float randomYDirection) {
        this.yVelocity = randomYDirection;
    }
    
    public void move() {
        this.x += this.xVelocity;
        this.y += this.yVelocity;
    }
    
    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(x, y, width, height);
    }
}
